package com.efi.printsmith.migration;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import com.efi.printsmith.service.DataService;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ComLink;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.Job;

public class Utilities {
	protected static Logger log = Logger.getLogger(Utilities.class);
	
	@SuppressWarnings("static-access")
	static public long tokenMillisecondToHours(String token){
		long milliseconds = Long.parseLong(token);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliseconds);
		return (long)calendar.HOUR;
	}
	
	@SuppressWarnings("static-access")
	static public long tokenMillisecondToSeconds(String token){
		long milliseconds = Long.parseLong(token);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliseconds);
		return (long)calendar.SECOND;
	}
	
	@SuppressWarnings("static-access")
	static public long tokenMillisecondToMinutes(String token){
		long milliseconds = Long.parseLong(token);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliseconds);
		return (long)calendar.MINUTE;
	}

	static public boolean tokenToBooleanValue(String token) {
		if ("1".equals(token) || "TRUE".equals(token.toUpperCase()) || "YES".equals(token.toUpperCase())) {
			return true;
		}
		return false;
	}
	
	static public ComLink tokenToComLink(String token, String type) {
		ComLink comLink = new ComLink();
		comLink.setType(type);
		comLink.setValue(token);
		return comLink;
	}
	
	static public long tokenToLong(String token) throws NumberFormatException {
		long retVal = -1;
		retVal = Long.parseLong(token);
		return retVal;
	}
	
	static public int tokenToInt(String token) throws NumberFormatException {
		int retVal = 0;
		try {
			retVal = Integer.parseInt(token);
		}
		catch (RuntimeException e) {
			retVal = 0;
		}
		return retVal;
	}
	
	static public float tokenToFloat(String token) throws NumberFormatException {
		float retVal = -1;
		retVal = Float.parseFloat(token);
		return retVal;
	}
	
	static public double tokenToDouble(String token) throws NumberFormatException, ParseException {
		double retVal = -1;
		
		NumberFormat fmt = NumberFormat.getInstance();
		Number number = fmt.parse(token);
		retVal = number.doubleValue();

		return retVal;
	}
	
	static public Date tokenToDate(String token) throws ParseException {
		int dateShort = SimpleDateFormat.SHORT;
		DateFormat fmt = DateFormat.getDateInstance(dateShort);
		Date date = null;
		try {
			date = fmt.parse(token);
		} catch (Exception e) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			date = formatter.parse(token);
		}

		return date;
		
	}
	
	static public Date tokenToDateTime(String token) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		Date date = formatter.parse(token);
		return date;
		
	}
	
	@SuppressWarnings("unchecked")
	static public void setJobChargesFromRootRecord() throws Exception {
		DataService dataService = new DataService();
		List<Job> jobs = (List<Job>)dataService.getAllQuery("Job", " where rootChargeRecord <> ''");
		if (jobs.size() > 0) {
			for (int i=0;i<jobs.size();i++) {
				Charge charge = (Charge)dataService.getByPrevId("Charge", jobs.get(i).getRootChargeRecord());
				Job job = jobs.get(i);
				job.addCharges(charge);
				if (charge.getNextRecord().equals("") == false) {
					String nextRecord = charge.getNextRecord();
					while (nextRecord.equals("") == false) {
						charge = (Charge)dataService.getByPrevId("Charge", nextRecord);
						job.addCharges(charge);
						nextRecord = charge.getNextRecord();
					}
				}
				dataService.addUpdate(job);
			}
		}
	}
}

package com.efi.printsmith.migration;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ComLink;

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
		Date date = fmt.parse(token);

		return date;
		
	}
}

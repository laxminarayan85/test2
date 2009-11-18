package com.efi.printsmith.defaultdata;

import com.efi.printsmith.data.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import com.efi.printsmith.service.DataService;

public class DefaultDataFactory {

	protected static Logger log = Logger.getLogger(DataService.class);
	
	private DataService dataservice;
	private String currentPath;
	
	public DefaultDataFactory()
	{
		currentPath = this.getClass().getResource("DefaultDataFactory.class").getPath();
	}
	
	public void LoadDefaultData(DataService ds){
		//load states from file
		dataservice = ds;
		ProcessStateFile();
		ProcessAccessGroup();
		ProcessEmployee();
		ProcessCountryFile();
		ProcessUsers();
		ProcessCreditCards();
	}

	private void ProcessStateFile(){
		try {
			LoadStatesData(new String[]{currentPath});
		} catch (IOException e) {
			log.debug("** Exception: States file Load failed.");
		}
	}
	
	private void ProcessAccessGroup(){
		AccessGroup accessgroup = new AccessGroup();
		accessgroup.setName("System");
		try {
			dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
	}
	
	private void ProcessEmployee(){
		Employee employee = new Employee();
		employee.setFirstName("Efi");
		employee.setLastName("Printsmith");
		try {
			dataservice.addUpdate(employee);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
	}

	private void ProcessUsers(){
		Users users = new Users();
		users.setName("admin");
		users.setPassword("admin");
		try {
			dataservice.addUpdate(users);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
	}

	private void ProcessCountryFile(){
		try {
			LoadCountryData(new String[]{currentPath});
		} catch (IOException e) {
			log.debug("** Exception: Country file Load failed.");
		}
	}
	
	private void ProcessCreditCards(){
		PreferencesCreditCard creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("AMEX");
		creditcard.setCardType("American Express");
		creditcard.setCode("AM");
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("MC");
		creditcard.setCardType("Mastercard");
		creditcard.setCode("M");
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("VI");
		creditcard.setCardType("Visa");
		creditcard.setCode("V");
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("DIS");
		creditcard.setCardType("Discover");
		creditcard.setCode("D");
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
	}

	private void LoadStatesData(String[] args) throws IOException
	{
		if (args.length == 0) args = new String[]{".."};
		
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i <fileNames.length; i++)
		{
			if (fileNames[i].endsWith(".txt") == true && fileNames[i].toLowerCase().startsWith("state")==true)
			{
				File f = new File(pathName.getPath(),fileNames[i]);
				int result = doStatesFile(f);
				if (result < 0)
				{
					log.debug("** Exception: States file Load failed.");
				}
				break;
			}			
		}
	}
	
	private int doStatesFile(File file) throws java.io.IOException{
		
		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
	    java.io.BufferedReader br = new java.io.BufferedReader(ip);
	    String line = null;
	    int rv = -1;
	    while ((line = br.readLine()) != null){
	    	if (line.length() > 0)
	    	{
	    		State state = new State();
	    		state.setName(line.trim());
				try {
					dataservice.addUpdate(state);
				} catch (Exception e) {
					log.debug("** Exception: " + e.getMessage());
					break;
				}
	    	}
	    }
	    return rv;
	}

	private void LoadCountryData(String[] args) throws IOException
	{
		if (args.length == 0) args = new String[]{".."};
		
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i <fileNames.length; i++)
		{
			if (fileNames[i].endsWith(".txt") == true && fileNames[i].toLowerCase().startsWith("country")==true)
			{
				File f = new File(pathName.getPath(),fileNames[i]);
				int result = doCountryFile(f);
				if (result < 0)
				{
					log.debug("** Exception: States file Load failed.");
				}
				break;
			}			
		}
	}
	
	private int doCountryFile(File file) throws java.io.IOException{
		
		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
	    java.io.BufferedReader br = new java.io.BufferedReader(ip);
	    String line = null;
	    int rv = -1;
	    while ((line = br.readLine()) != null){
	    	if (line.length() > 0)
	    	{
	    		Country country = new Country();
	    		country.setName(line.trim());
				try {
					dataservice.addUpdate(country);
				} catch (Exception e) {
					log.debug("** Exception: " + e.getMessage());
					break;
				}
	    	}
	    }
	    return rv;
	}

}

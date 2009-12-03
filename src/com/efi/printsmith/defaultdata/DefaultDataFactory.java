package com.efi.printsmith.defaultdata;

import com.efi.printsmith.data.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
		ProcessSecurityCommands();
		ProcessAccessGroup();
		ProcessEmployee();
		ProcessCountryFile();
		ProcessUsers();
		ProcessCreditCards();
		ProcessComLinkType();
		ProcessShippingMethod();
		ProcessProductionLocations();
	}

	private void ProcessStateFile(){
		try {
			LoadStatesData(new String[]{currentPath});
		} catch (IOException e) {
			log.debug("** Exception: States file Load failed.");
		}
	}
	
	private void ProcessAccessGroup(){
		List<?> itemList = (List<?>) dataservice.getAll("AccessGroup");

		if (itemList.size() > 0) return ;

		AccessGroup accessgroup = new AccessGroup();
		accessgroup.setName("System");
		try {
			dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup);

		accessgroup = new AccessGroup();
		accessgroup.setName("Minimum");
		try {
			dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup);
		
		accessgroup = new AccessGroup();
		accessgroup.setName("Production");
		try {
			dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup);

		accessgroup = new AccessGroup();
		accessgroup.setName("Counter");
		try {
			dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup);

		accessgroup = new AccessGroup();
		accessgroup.setName("Manager");
		try {
			dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup);
	}
	
	private void AddSecuritySetup(AccessGroup accessGroup){
		List<?> itemList = (List<?>) dataservice.getAll("SecurityCommands");

		for (int i = 0; i < itemList.size(); i++)
		{
			SecuritySetup securitySetup = new SecuritySetup();
			securitySetup.setAccessGroup(accessGroup);
			securitySetup.setMenu(((SecurityCommands)itemList.get(i)).getMenu());
			securitySetup.setCommandName((((SecurityCommands)itemList.get(i)).getCommandName()));
			try {
				dataservice.addUpdate(securitySetup);
			} catch (Exception e) {
				log.debug("** Exception: " + e.getMessage());
			}
			
		}

	}
	
	private void ProcessEmployee(){
		List<?> itemList = (List<?>) dataservice.getAll("Employee");

		if (itemList.size() > 0) return ;

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
		List<?> itemList = (List<?>) dataservice.getAll("Users");

		if (itemList.size() > 0) return ;

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
	private void ProcessSecurityCommands(){
		
	}
	
	private void ProcessCreditCards(){
		
		List<?> creditcardList = (List<?>) dataservice.getAll("PreferencesCreditCard");

		if (creditcardList.size() > 0) return ;

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

	private void ProcessComLinkType(){
		List<?> comLinkTypeList = (List<?>) dataservice.getAll("ComLinkType");

		if (comLinkTypeList.size() > 0) return ;

		ComLinkType comLinkType = new ComLinkType();
		comLinkType.setType("Phone");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Cell");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Fax");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("E-Mail");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("IM");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("FaceBook");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Twitter");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("LinkedIn");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Web Site");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
	}
	
	private void ProcessShippingMethod(){
		List<?> shippingMethodList = (List<?>) dataservice.getAll("ShippingMethod");

		if (shippingMethodList.size() > 0) return ;

		ShippingMethod shippingMethod = new ShippingMethod();
		shippingMethod.setName("Will Call");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Call");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Deliver");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Ground");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("FexEx");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS Red");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS Blue");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("USPS");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("International");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}

	}

	private void ProcessProductionLocations(){
		try {
			LoadProductionLocationsData(new String[]{currentPath});
		} catch (IOException e) {
			log.debug("** Exception: States file Load failed.");
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

		List<?> stateList= (List<?>) dataservice.getAll("State");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
	    java.io.BufferedReader br = new java.io.BufferedReader(ip);
	    String line = null;
	    int rv = -1;
	    while ((line = br.readLine()) != null){
	    	if (line.length() > 0)
	    	{
	    		if (stateList.size() > 0){
	    			boolean found = false;
	    			for (int i = 0; i < stateList.size(); i++)
    	    		{
    	    			if (((State)stateList.get(i)).getName().trim().equals(line.trim()) == true){
    	    				found = true;
    	    				break;
    	    			}
	    			}
	    			if (found != true){
	    				State state = new State();
	    	    		state.setName(line.trim());
	    				try {
	    					dataservice.addUpdate(state);
	    				} catch (Exception e) {
	    					log.debug("** Exception: " + e.getMessage());
	    					break;
	    				}
	    			}
	    		}else{
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
		
		List<?> countryList= (List<?>) dataservice.getAll("Country");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
	    java.io.BufferedReader br = new java.io.BufferedReader(ip);
	    String line = null;
	    int rv = -1;
	    while ((line = br.readLine()) != null){
	    	if (line.length() > 0)
	    	{
	    		if (countryList.size() > 0){
	    			boolean found = false;
	    			for (int i = 0; i < countryList.size(); i++)
    	    		{
    	    			if (((Country)countryList.get(i)).getName().trim().equals(line.trim()) == true){
    	    				found = true;
    	    				break;
    	    			}
	    			}
	    			if (found != true){
	    				Country country = new Country();
	    				country.setName(line.trim());
	    				try {
	    					dataservice.addUpdate(country);
	    				} catch (Exception e) {
	    					log.debug("** Exception: " + e.getMessage());
	    					break;
	    				}
	    			}
	    		} else{
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
	    }
	    return rv;
	}

	private void LoadProductionLocationsData(String[] args) throws IOException
	{
		if (args.length == 0) args = new String[]{".."};
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i <fileNames.length; i++)
		{
			if (fileNames[i].endsWith(".txt") == true && fileNames[i].toLowerCase().startsWith("productionlocations")==true)
			{
				File f = new File(pathName.getPath(),fileNames[i]);
				int result = doProductionLocationsFile(f);
				if (result < 0)
				{
					log.debug("** Exception: ProductionLocations file Load failed.");
				}
				break;
			}			
		}
	}

	private int doProductionLocationsFile(File file) throws java.io.IOException{
		
		List<?> productionLocationsList= (List<?>) dataservice.getAll("ProductionLocations");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
	    java.io.BufferedReader br = new java.io.BufferedReader(ip);
	    String line = null;
	    int rv = -1;
	    while ((line = br.readLine()) != null){
	    	if (line.length() > 0)
	    	{
	    		if (productionLocationsList.size() > 0){
	    			boolean found = false;
	    			for (int i = 0; i < productionLocationsList.size(); i++)
    	    		{
    	    			if (((ProductionLocations)productionLocationsList.get(i)).getName().trim().equals(line.trim()) == true){
    	    				found = true;
    	    				break;
    	    			}
	    			}
	    			if (found != true){
	    				ProductionLocations productionLocations = new ProductionLocations();
	    				productionLocations.setName(line.trim());
	    				try {
	    					dataservice.addUpdate(productionLocations);
	    				} catch (Exception e) {
	    					log.debug("** Exception: " + e.getMessage());
	    					break;
	    				}
	    			}
	    		} else{
    				ProductionLocations productionLocations = new ProductionLocations();
    				productionLocations.setName(line.trim());
    				try {
    					dataservice.addUpdate(productionLocations);
    				} catch (Exception e) {
    					log.debug("** Exception: " + e.getMessage());
    					break;
    				}
	    		}
	    	}
	    }
	    return rv;
	}

	private void LoadSecurityCommandsData(String[] args) throws IOException
	{
		if (args.length == 0) args = new String[]{".."};
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i <fileNames.length; i++)
		{
			if (fileNames[i].endsWith(".txt") == true && fileNames[i].toLowerCase().startsWith("securitycommands")==true)
			{
				File f = new File(pathName.getPath(),fileNames[i]);
				int result = doSecurityCommandsFile(f);
				if (result < 0)
				{
					log.debug("** Exception: SecurityCommands file Load failed.");
				}
				break;
			}			
		}
	}

	private int doSecurityCommandsFile(File file) throws java.io.IOException{
		
		List<?> securityCommandsList= (List<?>) dataservice.getAll("SecurityCommands");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
	    java.io.BufferedReader br = new java.io.BufferedReader(ip);
	    String line = null;
	    int rv = -1;
	    while ((line = br.readLine()) != null){
	    	if (line.length() > 0)
	    	{
	    		if (securityCommandsList.size() > 0){
	    			boolean found = false;
	    			for (int i = 0; i < securityCommandsList.size(); i++)
    	    		{
	    			}
	    			if (found != true){
	    				SecurityCommands securityCommands = new SecurityCommands();
	    				
	    				securityCommands.setCommandName(line.substring(line.indexOf(",")+1));
	    				securityCommands.setMenu(line.substring(0, line.indexOf(",")-1));
	    				try {
	    					dataservice.addUpdate(securityCommands);
	    				} catch (Exception e) {
	    					log.debug("** Exception: " + e.getMessage());
	    					break;
	    				}
	    			}
	    		} else{
    				ProductionLocations productionLocations = new ProductionLocations();
    				productionLocations.setName(line.trim());
    				try {
    					dataservice.addUpdate(productionLocations);
    				} catch (Exception e) {
    					log.debug("** Exception: " + e.getMessage());
    					break;
    				}
	    		}
	    	}
	    }
	    return rv;
	}

}

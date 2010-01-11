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
		ProcessColumnNames();
		ProcessEstimatorTypes();
	}

	private void ProcessStateFile(){
		try {
			LoadStatesData(new String[]{currentPath});
		} catch (IOException e) {
			log.debug("** Exception: States file Load failed.");
		}
	}

	private void ProcessColumnNames(){
		try {
			LoadColumnNamesData(new String[]{currentPath});
		} catch (IOException e) {
			log.debug("** Exception: ColumnNames file Load failed.");
		}
	}

	private void ProcessEstimatorTypes(){
		try {
			LoadEstimatorTypesData(new String[]{currentPath});
		} catch (IOException e) {
			log.debug("** Exception: EstimatorTypes file Load failed.");
		}
	}

	private void ProcessAccessGroup(){
		List<?> itemList = (List<?>) dataservice.getAll("AccessGroup");

		if (itemList.size() > 0) return ;

		AccessGroup accessgroup = new AccessGroup();
		accessgroup.setName("System");
		try {
			accessgroup = (AccessGroup)dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup,true);

		accessgroup = new AccessGroup();
		accessgroup.setName("Minimum");
		try {
			accessgroup = (AccessGroup)dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup,false);
		
		accessgroup = new AccessGroup();
		accessgroup.setName("Production");
		try {
			accessgroup = (AccessGroup)dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup,false);

		accessgroup = new AccessGroup();
		accessgroup.setName("Counter");
		try {
			accessgroup = (AccessGroup)dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup,false);

		accessgroup = new AccessGroup();
		accessgroup.setName("Manager");
		try {
			accessgroup = (AccessGroup)dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + e.getMessage());
		}
		AddSecuritySetup(accessgroup,false);
	}
	
	private void AddSecuritySetup(AccessGroup accessGroup,Boolean enabledStatus){
		List<?> itemList = (List<?>) dataservice.getAll("SecurityCommands");

		for (int i = 0; i < itemList.size(); i++)
		{
			SecuritySetup securitySetup = new SecuritySetup();
			securitySetup.setAccessGroup(accessGroup);
			securitySetup.setMenu(((SecurityCommands)itemList.get(i)).getMenu());
			if (enabledStatus == true){
				securitySetup.setEnable(true);
			}
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
		try {
			LoadSecurityCommandsData(new String[]{currentPath});
		} catch (IOException e) {
			log.debug("** Exception: SecurityCommands file Load failed.");
		}

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
	
	private void LoadColumnNamesData(String[] args) throws IOException
	{
		if (args.length == 0) args = new String[]{".."};
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i <fileNames.length; i++)
		{
			if (fileNames[i].endsWith(".txt") == true && fileNames[i].toLowerCase().startsWith("columnnames")==true)
			{
				File f = new File(pathName.getPath(),fileNames[i]);
				int result = doColumnNames(f);
				if (result < 0)
				{
					log.debug("** Exception: ColumnNames file Load failed.");
				}
				break;
			}			
		}
	}

	private void LoadEstimatorTypesData(String[] args) throws IOException
	{
		if (args.length == 0) args = new String[]{".."};
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i <fileNames.length; i++)
		{
			if (fileNames[i].endsWith(".txt") == true && fileNames[i].toLowerCase().startsWith("estimatortypes")==true)
			{
				File f = new File(pathName.getPath(),fileNames[i]);
				int result = doEstimatorTypes(f);
				if (result < 0)
				{
					log.debug("** Exception: EstimatorTypes file Load failed.");
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

	private int doColumnNames(File file) throws java.io.IOException{

		List<?> columnNameList= (List<?>) dataservice.getAll("ColumnNames");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
	    java.io.BufferedReader br = new java.io.BufferedReader(ip);
	    String line = null;
	    int rv = -1;
	    while ((line = br.readLine()) != null){
	    	if (line.length() > 0)
	    	{
	    		if (columnNameList.size() > 0){
	    			boolean found = false;
	    			for (int i = 0; i < columnNameList.size(); i++)
    	    		{
    	    			if (((ColumnNames)columnNameList.get(i)).getName().trim().equals(line.trim()) == true){
    	    				found = true;
    	    				break;
    	    			}
	    			}
	    			if (found != true){
	    				ColumnNames columnnames = new ColumnNames();
	    	    		columnnames.setName(line.trim());
	    				try {
	    					dataservice.addUpdate(columnnames);
	    				} catch (Exception e) {
	    					log.debug("** Exception: " + e.getMessage());
	    					break;
	    				}
	    			}
	    		}else{
					ColumnNames columnnames = new ColumnNames();
		    		columnnames.setName(line.trim());
					try {
						dataservice.addUpdate(columnnames);
					} catch (Exception e) {
						log.debug("** Exception: " + e.getMessage());
						break;
					}
	    		}
	    	}
	    }
	    return rv;
	}

	private int doEstimatorTypes(File file) throws java.io.IOException{

		List<?> estimatorTypesList = (List<?>) dataservice.getAll("EstimatorTypes");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
	    java.io.BufferedReader br = new java.io.BufferedReader(ip);
	    String line = null;
	    int rv = -1;
	    while ((line = br.readLine()) != null){
	    	if (line.length() > 0)
	    	{
	    		if (estimatorTypesList.size() > 0){
	    			boolean found = false;
	    			for (int i = 0; i < estimatorTypesList.size(); i++)
    	    		{
    	    			if (((EstimatorTypes)estimatorTypesList.get(i)).getName().trim().equals(line.trim()) == true){
    	    				found = true;
    	    				break;
    	    			}
	    			}
	    			if (found != true){
	    				EstimatorTypes estimatortypes = new EstimatorTypes();
	    				estimatortypes.setName(line.trim());
	    				try {
	    					dataservice.addUpdate(estimatortypes);
	    				} catch (Exception e) {
	    					log.debug("** Exception: " + e.getMessage());
	    					break;
	    				}
	    			}
	    		}else{
	    			EstimatorTypes estimatortypes = new EstimatorTypes();
	    			estimatortypes.setName(line.trim());
					try {
						dataservice.addUpdate(estimatortypes);
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
    	    			if (((SecurityCommands)securityCommandsList.get(i)).getCommandName().trim().equals(line.substring(line.indexOf(",")+1)) == true && ((SecurityCommands)securityCommandsList.get(i)).getMenu().trim().equals(line.substring(0, line.indexOf(",")))){
    	    				found = true;
    	    				break;
    	    			}
	    			}
	    			if (found != true){
	    				SecurityCommands securityCommands = new SecurityCommands();
	    				
	    				securityCommands.setCommandName(line.substring(line.indexOf(",")+1));
	    				securityCommands.setMenu(line.substring(0, line.indexOf(",")));
	    				try {
	    					dataservice.addUpdate(securityCommands);
	    				} catch (Exception e) {
	    					log.debug("** Exception: " + e.getMessage());
	    					break;
	    				}
	    			}
	    		} else{
    				SecurityCommands securityCommands = new SecurityCommands();
    				
    				securityCommands.setCommandName(line.substring(line.indexOf(",")+1));
    				securityCommands.setMenu(line.substring(0, line.indexOf(",")));
    				try {
    					dataservice.addUpdate(securityCommands);
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

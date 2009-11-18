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
	}

	private void ProcessStateFile(){
		try {
			LoadStatesData(new String[]{currentPath});
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
			if (fileNames[i].endsWith(".txt") == true)
			{
				File f = new File(pathName.getPath(),fileNames[i]);
				int result = doStatesFile(f);
				if (result < 0)
				{
					log.debug("** Exception: States file Load failed.");
				}
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

}

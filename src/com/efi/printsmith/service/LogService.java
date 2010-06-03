package com.efi.printsmith.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.paramdata.LogFile;

public class LogService {
	public List GetLogFileList() throws Exception
	{
		String baseDirString = System.getProperty("catalina.base");
		File logDir = new File(baseDirString + "/logs");
		
		File[] files = logDir.listFiles();
		ArrayList<LogFile> resultList = new ArrayList<LogFile>();

		for (int i=0; i < files.length; i++) {
			LogFile item = new LogFile();
			item.name = files[i].getName();
			item.modified = new Date(files[i].lastModified());
			resultList.add(item);
		}
		return resultList;
	}

	public String GetLogFileContent(String fileName) throws Exception
	{
		String baseDirString = System.getProperty("catalina.base");
		return readFileAsString(baseDirString + "/logs/" + fileName);
	}
	
    private static String readFileAsString(String filePath)
    throws java.io.IOException{
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }
}

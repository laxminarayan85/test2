package com.efi.printsmith.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.efi.printsmith.properties.PropertiesHelper;

public abstract class RepositoryService extends SnowmassHibernateService {
	protected String defaultRepositoryName = "";
	protected String repositoryPropertyName = "";
	protected static Logger log = Logger.getLogger(RepositoryService.class);
	protected File repository = null;

	public File getFile(String fileName) {
		return new File(getDirectory().getAbsolutePath() + "/" + fileName);
	}

	public File defaultDirectory() {
		URL url = Thread.currentThread().getContextClassLoader().getResource(defaultRepositoryName);
		try {
			return new File(url.toURI());
		} catch(URISyntaxException e) {
			return new File(url.getPath());
		}
	}

	public String doUpload(byte[] bytes, String fileName) throws Exception {
		fileName = getDirectory() + fileName;
		File f = new File(fileName);
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(bytes);
		fos.close();
		return "success";
	}

	public List<String> getItemList() {
		File dir = getDirectory();
		String[] children = dir.list();
		List<String> dirList = new ArrayList<String>();
		if (children == null) {
			// Either dir does not exist or is not a directory  
		} else {
			for (int i = 0; i < children.length; i++) {
				// Get filename of file or directory  
				dirList.add(children[i]);
			}
		}
		return dirList;
	}

	public byte[] doDownload(String fileName) throws Exception {
		FileInputStream fis;
		byte[] data = null;
		FileChannel fc;

		try {
			fis = new FileInputStream(getDirectory() + "/" + fileName);
			fc = fis.getChannel();
			data = new byte[(int) (fc.size())];
			ByteBuffer bb = ByteBuffer.wrap(data);
			fc.read(bb);
		} catch (FileNotFoundException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}

		return data;
	}
	
	public File getDirectory() {
		if (repository == null) {
			String directoryName = PropertiesHelper.getProperty(repositoryPropertyName, null);
			if (directoryName == null) {
				repository = defaultDirectory();
			} else {
				repository = new File(directoryName);
				if (repository == null) {
					log.error("Repository directory not found: " + directoryName);
					repository = defaultDirectory();
				}
			}
		}
		return repository;
	}
}

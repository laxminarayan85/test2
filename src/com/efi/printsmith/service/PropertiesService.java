package com.efi.printsmith.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.efi.printsmith.properties.PropertiesHelper;
import com.efi.printsmith.properties.PropertiesManager;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

public class PropertiesService extends SnowmassHibernateService {
	static private PropertiesManager _propsManager = null;
	protected static Logger log = Logger.getLogger(PropertiesService.class);

	static {
		initService();
	}

	public PropertiesService() {
		super();
	}
	
	static protected void initService() {
		try {
			PropertiesHelper.init("propertiesManager.xml");
			_propsManager = PropertiesHelper.getPropertiesManager();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	public void init() throws Exception {
		if (log.isDebugEnabled()) {
			Iterator names = _propsManager.getPropertyNames();
			int count = 0;
			while (names.hasNext()) {
				String name = (String) names.next();
				String value = _propsManager.getProperty(name);
				String set = _propsManager.getSetNameForProperty(name);
				log.debug("name=\"" + name + "\" value=\"" + value
						+ "\" set=\"" + set + "\"");
				count++;
			}
			log.debug("------------------------------------------------");
			log.debug("Found " + count + " properties");
		}
	}

	public void cleanup() {
		try {
			_propsManager.saveProperties();
			_propsManager.clearCache();
		} catch (Exception ex) {
			log.warn("Properties not saved because of error", ex);
		}
	}

	public void setProperty(String name, String value) {
		_propsManager.setProperty(name, value);
	}

	public void savePropertiesToFile(String filename) throws IOException,
			FileNotFoundException {
		_propsManager.savePropertiesToFile(filename);
	}

	public void saveProperties() throws IOException {
		_propsManager.saveProperties();
	}

	public String getProperty(String name) {

		return _propsManager.getProperty(name);
	}

	public String getProperty(String setName, String name,
			boolean doSubstitution) {
		return _propsManager.getProperty(setName, name, null, doSubstitution);
	}

	public String getProperty(String name, boolean doSubstitution) {
		return _propsManager.getProperty(null, name, null, doSubstitution);
	}

	public Iterator getPropertyNames() {
		return _propsManager.getPropertyNames();
	}

	public Iterator getPropertyNames(String name) {

		return _propsManager.getPropertyNames(name);
	}

	public void pushPropertiesToSystem() {
		_propsManager.pushPropertiesToSystem();
	}

	public void pushPropertiesToCache() {
		_propsManager.pushPropertiesToCache();
	}

	public void clearCache() {
		_propsManager.clearCache();
	}

	public void reloadPropertySet(String setName) throws Exception {
		_propsManager.reloadPropertySet(setName);
	}

	public void reloadAllPropertySets() throws Exception {
		_propsManager.reloadAllPropertySets();
	}
}

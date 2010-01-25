package com.efi.printsmith.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.efi.printsmith.security.SecurityElement;
import com.efi.printsmith.security.ApplicationCommandId;

public class SecurityService {
	protected static final String PERSISTENCE_UNIT = "printsmith_db";
	
	protected static Logger log = Logger.getLogger(SecurityService.class);
	
	protected static EntityManagerFactory entityManagerFactory = null;
	
	public SecurityService() {
		super();
		try {
			if (entityManagerFactory == null) {
				entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			}
		} catch (RuntimeException e) {
			log.error(e);
		}
	}
	
	public boolean checkCommandPermissions(SecurityElement element) {
		boolean retVal = false;
		
		/* validate command against current user */
		return retVal;
	}
}
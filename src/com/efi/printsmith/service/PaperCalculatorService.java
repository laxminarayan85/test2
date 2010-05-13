package com.efi.printsmith.service;

import java.util.Date;

import javax.persistence.EntityManagerFactory;

import com.efi.printsmith.data.*;
import org.apache.log4j.Logger;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.efi.printsmith.data.Invoice;

public class PaperCalculatorService extends SnowmassHibernateService {
	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(EstimatorService.class);
	
	protected static EntityManagerFactory entityManagerFactory = null;

	public int CalcOut(JobBase job) {
		int out= 0;
		log.info("how many sheets can be gotten	out of a given parent sheet. " );
		
		
		
		
		
		log.info("Completed sheets can be gotten	out of a given parent sheet");
		return out;
	}
	
	

}

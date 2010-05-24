package com.efi.printsmith.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.efi.printsmith.data.*;
import org.apache.log4j.Logger;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.Constants;

public class PaperCalculatorService extends SnowmassHibernateService {
	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(EstimatorService.class);
	
	protected static EntityManagerFactory entityManagerFactory = null;

	public List CalcOut(JobBase job) throws Exception {
		int out= 0;
		ArrayList results = new ArrayList();
		
		if (job == null) {
			throw new InvalidParameterException("Null job passed to CalcOut");
		}
		log.info("CalcOut called with job: " + job.getId());
		
//		/* Just for illustration: */
//		if (job.getPaperCal() != null) {
//			if (job.getPaperCal().getFolioEdge().equals(Constants.PAPER_CALCULATOR_FOLIO_LEFT)) {
//				out = 1;
//			} else if (job.getPaperCal().getFolioEdge().equals(Constants.PAPER_CALCULATOR_FOLIO_TOP)) {
//				out = 2;
//			} else {
//				throw new InvalidParameterException("Invalid value in Paper Calculator's FolioEdge");
//			}
//		}
		
		log.info("CalcOut returned: " + out);
		
		results.add(out);
		results.add("Value Two");
		results.add(new Double(5.0));
		
		return results;
	}
	
	

}

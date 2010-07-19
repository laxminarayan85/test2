package com.efi.printsmith.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.efi.printsmith.messaging.MessageServiceAdapter;
import com.efi.printsmith.data.CashRegister;

public class TaxService extends SnowmassHibernateService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(TaxService.class);
	
	//protected static EntityManagerFactory entityManagerFactory = null;
	public TaxService() {

	}
	
	public CashRegister calculateTax(CashRegister cashRegister) {
		BigDecimal tax= new BigDecimal(0) ;
		
		if ( cashRegister.getSubtotal().compareTo(cashRegister.getTaxTable().getMinAmount()) < 0 ){
			tax.equals(new BigDecimal(0));
		}
		else{
			tax = cashRegister.getSubtotal().multiply(cashRegister.getTaxTable().getEffectiveTaxRate());
		}
		cashRegister.setTaxamount(tax);
		return cashRegister;
	}
}
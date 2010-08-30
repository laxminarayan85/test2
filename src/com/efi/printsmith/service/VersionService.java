package com.efi.printsmith.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.efi.printsmith.Constants;
import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.CopierPricingMethod;

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
import com.efi.printsmith.pricing.charge.PriceChargeEngine;
import com.efi.printsmith.pricing.copier.CopiesPerOriginalPricingMethod;
import com.efi.printsmith.pricing.copier.CopiesPlusOriginalsPricingMethod;
import com.efi.printsmith.pricing.copier.CostPlusPricingMethod;
import com.efi.printsmith.pricing.copier.FlatRatePricingMethod;
import com.efi.printsmith.pricing.job.PriceJobEngine;

public class VersionService {
	protected static Logger log = Logger.getLogger(VersionService.class);
	
//	protected static EntityManagerFactory entityManagerFactory = null;
	
	public VersionService() {
	}
	
	public String getServerVersion() {
		String versionString = System.getProperty(Constants.SERVER_VERSION_PROPERTY, Constants.SERVER_VERSION_DEFAULT_VALUE);
		return versionString;
	}
}
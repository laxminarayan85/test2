package com.efi.printsmith.service;

import java.util.Date;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.pricing.charge.ChargeUtilities;
import com.efi.printsmith.pricing.charge.PriceChargeEngine;
import com.efi.printsmith.pricing.job.PriceJobEngine;

public class JobService extends HibernateService {
	protected static Logger log = Logger.getLogger(JobService.class);

	public JobService() {
		
	}
	
	public Job assignStockToJob(Job job, StockDefinition stock) {
		if (stock == null || job == null) {
			log.error("Stock or Job null value passed to assignStockToJob");
			return job;
		}
		
		job.setStock(stock);
		
		// TODO: Following code needs to be moved to common area
		if (stock.getCharges() != null) {
			for (int i=0; i < stock.getCharges().size(); i++) {
				Charge charge = ChargeUtilities.createChargeFromChargeDefinition(stock.getCharges().get(i));
				charge.setParentJob(job);
				job.addCharges(charge);
			}
		}
		PriceJobEngine.priceJob(job);

		if (job.getCharges() != null) {
			for (int i=0; i < job.getCharges().size(); i++) {
				PriceChargeEngine.priceCharge(job.getCharges().get(i));
				
				job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice() + job.getCharges().get(i).getPrice());
			}
		}
		return job;
	}
	
	public Job assignPricingCopierToJob(Job job, CopierDefinition copier) {
		if (copier == null || job == null) {
			log.error("Copier or Job null value passed to assignPricingCopierToJob");
			return job;
		}
		
		job.setPricingCopier(copier);
		
		for (int i=0; i < copier.getCharges().size(); i++) {
			Charge charge = ChargeUtilities.createChargeFromChargeDefinition(copier.getCharges().get(i));
			charge.setParentJob(job);
			job.addCharges(charge);
		}
		
		PriceJobEngine.priceJob(job);

		if (job.getCharges() != null) {
			for (int i=0; i < job.getCharges().size(); i++) {
				PriceChargeEngine.priceCharge(job.getCharges().get(i));
				
				job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice() + job.getCharges().get(i).getPrice());
			}
		}
		return job;
	}

	public Object load(Class clazz, long id)
	{
       Session session = null;
       Object result;

       try
       {
           session = DataService.getSession();
           long tStart = new Date().getTime();
           result = session.get(clazz, id);
           long tEnd = new Date().getTime();
           log.debug("{load()}" +(tEnd-tStart) +"ms  class=" +clazz.getName() );
           
       }
       catch (HibernateException ex)
       {
           HibernateUtil.rollbackTransaction();
           ex.printStackTrace();
           throw ex;
       }
       catch (RuntimeException ex)
       {
           HibernateUtil.rollbackTransaction();
           ex.printStackTrace();
           throw ex;
       } finally {
    	   session.close();
       }

       return result;
	}

}

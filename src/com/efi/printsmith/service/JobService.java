package com.efi.printsmith.service;

import java.util.Date;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.efi.printsmith.Constants;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.CostingRecord;
import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.PaperCalculator;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.pricing.charge.ChargeUtilities;
import com.efi.printsmith.pricing.charge.PriceChargeEngine;
import com.efi.printsmith.pricing.job.PriceJobEngine;

public class JobService extends SnowmassHibernateService {
	protected static Logger log = Logger.getLogger(JobService.class);

	public JobService() {
		
	}
	
	public Job createJob(InvoiceBase parentInvoice, PreferencesPricingMethod pricingMethod) {
		Job job = new Job();
		
		job.setCostingRecord(new CostingRecord());
		PaperCalculator paperCalculator = new PaperCalculator();
		paperCalculator.setWhichStartSize(Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
		paperCalculator.setRunToFinishGrain(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_NEITHER);
		paperCalculator.setGripLocation(Constants.PAPER_CALCULATOR_GRIPPER_TOP);
		paperCalculator.setFolioLocation(Constants.PAPER_CALCULATOR_FOLIO_TOP);
		paperCalculator.setdAcross(0);
		paperCalculator.setdDown(0);
		job.setPaperCal(new PaperCalculator());

		PricingRecord pricingRecord = new PricingRecord();
		pricingRecord.setUnitPriceOverride(false);
		pricingRecord.setTotalPriceOverride(false);
		job.setPricingRecord(new PricingRecord());
		
		job.setPricingMethod(pricingMethod);
		job.setParentInvoice(parentInvoice);

//		if (job.getParentSize() != null)
//			job.parentSize.name = "";
//		
//		if (job.runSize != null)
//			job.runSize.name = "";
//		if (job.finishSize != null)
//			job.finishSize.name = "";
//		if (job.foldedSize != null)
//			job.foldedSize.name = "";
		job.setFrontColors(1);
		job.setFrontPasses(1);
		job.setInSetsOf(1L);
		job.setSheets(1L);
		job.setNumOn(1L);
		job.setNumUp(1L);
		job.setSingleSided(true);
		job.setDoubleSided(false);
		
		return job;
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
				
				job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice().doubleValue() + job.getCharges().get(i).getPrice().doubleValue());
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
				
				job.getPricingRecord().setTotalPrice(job.getPricingRecord().getTotalPrice().doubleValue() + job.getCharges().get(i).getPrice().doubleValue());
			}
		}
		return job;
	}
}

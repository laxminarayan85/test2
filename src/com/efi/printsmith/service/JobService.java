package com.efi.printsmith.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.efi.printsmith.Constants;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.CostingRecord;
import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PaperCalculator;
import com.efi.printsmith.data.PreferencesEstimating;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.enums.RunMethod;
import com.efi.printsmith.pricing.charge.ChargeUtilities;
import com.efi.printsmith.pricing.charge.PriceChargeEngine;
import com.efi.printsmith.pricing.job.PriceJobEngine;

public class JobService extends SnowmassHibernateService {
	protected static Logger log = Logger.getLogger(JobService.class);

	public JobService() {
		
	}
	
	public Job createJob(InvoiceBase parentInvoice, PreferencesPricingMethod pricingMethod) {
		Job job = new Job();
		
		//Commented by Madhu as it was creating a blank object which doesn't have reference in DB 
		//job.setCostingRecord(new CostingRecord());

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
		job.setRunMethod(RunMethod.Sheetwise.name());
		DataService dataService = new DataService();
		PaperCalculator paperCalculator = new PaperCalculator();

		List<PreferencesEstimating> preferencesArray = (List<PreferencesEstimating>) dataService.getAll("PreferencesEstimating");
		if (preferencesArray != null && preferencesArray.size() > 0) {
			PreferencesEstimating estimatingPreferences = preferencesArray.get(0);
		
			paperCalculator.setWhichStartSize(Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
			paperCalculator.setRunToFinishGrain(estimatingPreferences.getRunToFinishGrain());
			paperCalculator.setGripLocation(estimatingPreferences.getGripLocation());
			paperCalculator.setFolioLocation(estimatingPreferences.getFolioLocation());
			paperCalculator.setdAcross(0);
			paperCalculator.setdDown(0);
		
		
			paperCalculator.setUseGripEdgeGap(estimatingPreferences.getUseGripEdgeGap());
			paperCalculator.setGripEdgeGap(estimatingPreferences.getGripEdgeGap());
			paperCalculator.setUseFolioEdge(estimatingPreferences.getUseFolioEdge());
			paperCalculator.setFolioEdge(estimatingPreferences.getFolioEdge());
			paperCalculator.setUseColorBar(estimatingPreferences.getUseColorBar());
			paperCalculator.setColorBar(estimatingPreferences.getColorBar());
			paperCalculator.setUseWhiteSpace(estimatingPreferences.getUseWhiteSpace());
			paperCalculator.setWhiteSpaceLeft(estimatingPreferences.getWhiteSpace());
			paperCalculator.setWhiteSpaceBottom(estimatingPreferences.getWhiteSpaceBottom());
			paperCalculator.setWhiteSpaceRight(estimatingPreferences.getWhiteSpaceRight());
			paperCalculator.setWhiteSpaceTop(estimatingPreferences.getWhiteSpaceTop());
			paperCalculator.setUseGutter(estimatingPreferences.getUseGutter());
			paperCalculator.setGutter(estimatingPreferences.getGutter());
			paperCalculator.setGutterHorizontal(estimatingPreferences.getGutterHorizontal());
			paperCalculator.setUseBleed(estimatingPreferences.getUseBleed());
			paperCalculator.setBleedLeft(estimatingPreferences.getBleed());
			paperCalculator.setBleedBottom(estimatingPreferences.getBleedBottom());
			paperCalculator.setBleedRight(estimatingPreferences.getBleedRight());
			paperCalculator.setBleedTop(estimatingPreferences.getBleedTop());
			paperCalculator.setBackTrimParent(estimatingPreferences.getBackTrimParent());
			paperCalculator.setTrimFourSides(estimatingPreferences.getTrimFourSides());
			paperCalculator.setWorkAndTumble(estimatingPreferences.getWorkandTumble());
			paperCalculator.setPrintParentToFinishSection(estimatingPreferences.getPrintParentToFinishSection());
			paperCalculator.setPrintParentToRunSection(estimatingPreferences.getPrintParentToRunSection());
			paperCalculator.setPrintRunToFinishSection(estimatingPreferences.getPrintRunToFinishSection());
			paperCalculator.setAttachToJobTicket(estimatingPreferences.getAttachToJobTicket());
		} else {
			log.error("No EstimatingPreferences found. Unable to complete creation of PaperCalculator in Job");
		}
		
		job.setPaperCal(paperCalculator);
				
		
		
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
	
	public Job assignPricingCopierToJob(Job job, CopierDefinition copier) throws Exception {
		if (copier == null || job == null) {
			log.error("Copier or Job null value passed to assignPricingCopierToJob");
			return job;
		}
		
		// Get the latest for this copier
		DataService dataService = new DataService();
		copier = dataService.getCopierDefinition(copier.getId());
		
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

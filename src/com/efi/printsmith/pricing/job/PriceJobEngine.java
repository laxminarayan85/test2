package com.efi.printsmith.pricing.job;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.pricing.blank.BlankPricingMethodFactory;
import com.efi.printsmith.pricing.copier.CopierPricingMethod;
import com.efi.printsmith.pricing.copier.CopierPricingMethodFactory;
import com.efi.printsmith.pricing.print.PrintPricingMethod;
import com.efi.printsmith.pricing.print.PrintPricingMethodFactory;
import com.efi.printsmith.pricing.largeformat.LargeFormatPricingMethod;
import com.efi.printsmith.pricing.largeformat.LargeFormatPricingMethodFactory;
import com.efi.printsmith.pricing.mailing.MailingPricingMethodFactory;
import com.efi.printsmith.service.PricingService;
import com.efi.printsmith.pricing.mailing.MailingPricingMethod;
import com.efi.printsmith.pricing.blank.BlankPricingMethod;
import com.efi.printsmith.pricing.linesandinches.LinesAndInchesPricingMethod;
import com.efi.printsmith.pricing.linesandinches.LinesAndInchesPricingMethodFactory;
import com.efi.printsmith.pricing.list.ListPricingMethod;
import com.efi.printsmith.pricing.list.ListPricingMethodFactory;

public class PriceJobEngine {
	protected static Logger log = Logger.getLogger(PriceJobEngine.class);
	static public Job priceJob(Job job) {
		PreferencesPricingMethod pricingMethod = job.getPricingMethod();
		
		/* TODO: Estimator types should be hard-coded in the system, not a table - come back and fix this once that is done so that we can compare them to constants instead of string literals */
//		if (pricingMethod.getEstimator().getName().equals("Copier Definitions")) {
//			CopierPricingMethod copierPricingMethod = CopierPricingMethodFactory.createCopierPricingMethod(job.getPricingMethod().getTitle());
//			copierPricingMethod.priceCopierJob(job);
//		} else if (pricingMethod.getEstimator().getName().equals("Press Definitions")) {
//			
//		} else if (pricingMethod.getEstimator().getName().equals("Charges Only")) {
//			
//		} else if (pricingMethod.getEstimator().getName().equals("Blank Stock")) {
//			
//		} else if (pricingMethod.getEstimator().getName().equals("General Merchandise")) {
//			
//		} else if (pricingMethod.getEstimator().getName().equals("Lines and Inches")) {
//			
//		} else if (pricingMethod.getEstimator().getName().equals("List Price")) {
//			
//		} else if (pricingMethod.getEstimator().getName().equals("Multiple Parts")) {
//			
//		} else if (pricingMethod.getEstimator().getName().equals("Outside Services")) {
//			
//		}
		if (pricingMethod.getTitle().equals("B&W")) {
			CopierPricingMethod copierPricingMethod = CopierPricingMethodFactory.createCopierPricingMethod(job.getPricingCopier().getMethod());
			if (copierPricingMethod == null) {
				log.error("No pricing Method found for Copier");
			} else {
				copierPricingMethod.priceCopierJob(job);
			}
		} else if (pricingMethod.getTitle().equals("Color")) {
			CopierPricingMethod copierPricingMethod = CopierPricingMethodFactory.createCopierPricingMethod(job.getPricingCopier().getMethod());
			if (copierPricingMethod == null) {
				log.error("No pricing Method found for Copier");
			} else {
				copierPricingMethod.priceCopierJob(job);
			}
		} else if (pricingMethod.getTitle().equals("Printing")) {
			PrintPricingMethod printPricingMethod = PrintPricingMethodFactory.createPrintPricingMethod();
			if (printPricingMethod == null) {
				log.error("No pricing Method found for Printing");
			} else {
				printPricingMethod.pricePrintJob(job);
			}
		} else if (pricingMethod.getTitle().equals("Roll-Fed")) {
			
		} else if (pricingMethod.getTitle().equals("Large Format")) {
			LargeFormatPricingMethod largeFormatPricingMethod = LargeFormatPricingMethodFactory.createLargeFormatPricingMethod(job.getPricingCopier().getMethod());			
			if (largeFormatPricingMethod == null) {
				log.error("No pricing Method found for Copier");
			} else {
				largeFormatPricingMethod.priceLargeFormatJob(job);
			}
		} else if (pricingMethod.getTitle().equals("Blank")) {
			BlankPricingMethod blankPricingMethod = BlankPricingMethodFactory.createBlankPricingMethod();
			if (blankPricingMethod == null) {
				log.error("No pricing Method found for Blank");
			} else {
				blankPricingMethod.priceBlankJob(job);
			}	
		} else if (pricingMethod.getTitle().equals("List")) {
			ListPricingMethod listPricingMethod = ListPricingMethodFactory.createListPricingMethod();
			if (listPricingMethod == null) {
				log.error("No pricing method found for List");
			} else {
				listPricingMethod.priceListJob(job);
			}
		} else if (pricingMethod.getTitle().equals("Charges Only")) {
			
		} else if (pricingMethod.getTitle().equals("Outside Services")) {
			MailingPricingMethod mailingPricingMethod = MailingPricingMethodFactory.createMailingPricingMethod();
			if (mailingPricingMethod == null) {
				log.error("No pricing Method found for Merchandise");
			} else {
				mailingPricingMethod.priceMailingJob(job);
			}
		} else if (pricingMethod.getTitle().equals("Merchandise")) {
			MailingPricingMethod mailingPricingMethod = MailingPricingMethodFactory.createMailingPricingMethod();
			if (mailingPricingMethod == null) {
				log.error("No pricing Method found for Merchandise");
			} else {
				mailingPricingMethod.priceMailingJob(job);
			}
		} else if (pricingMethod.getTitle().equals("Lines & Inches")) {
			LinesAndInchesPricingMethod linesAndInchesPricingMethod = LinesAndInchesPricingMethodFactory.createLinesAndInchesPricingMethod();
			if (linesAndInchesPricingMethod == null) {
				log.error("No pricing Method found for Lines & Inches");
			} else {
				linesAndInchesPricingMethod.priceLinesAndInchesJob(job);
			}
			
		} else if (pricingMethod.getTitle().equals("Mailing")) {
			MailingPricingMethod mailingPricingMethod = MailingPricingMethodFactory.createMailingPricingMethod();
			if (mailingPricingMethod == null) {
				log.error("No pricing Method found for Mailing");
			} else {
				mailingPricingMethod.priceMailingJob(job);
			}
		}
		return job;
	}
}

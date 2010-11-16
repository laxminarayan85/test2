package com.efi.printsmith.pricing.utilities;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.data.enums.RunMethod;

public class JobUtilities {
	static public void calculateBinderyWaste(Job job) {
		long binderyWaste = 0;
		
		if (!job.getBinderyWasteOverride()) {
			if (job.getCharges() != null) {
				for (int i=0; i < job.getCharges().size(); i++) {
					Charge charge = job.getCharges().get(i);
					
					if (charge.getChargeDefinition() != null && charge.getChargeDefinition().getWasteChart() != null) {
						WasteChart wasteChart = charge.getChargeDefinition().getWasteChart();
						
						double wastePercentage = PriceListUtilities.getWastePercentage(wasteChart, job.getPressQty());
						
						binderyWaste = (long)(wastePercentage * job.getPressQty());
					}
				}
			}
		}
		job.setBinderyWaste(binderyWaste);
	}
	
	static public void calculateSignatures(Job job) {
		double runs;
		long iup, ion, iorigs, ordered, press, xpress, xorig, xup;
		long iruns, divisor;
		
		if (job.getNumUp() < 1) {
			job.setNumUp(1L);
		}
		if (job.getSheets() < 1) {
			job.setSheets(1L);
		}
		if (job.getNumOn() < 1) {
			job.setNumOn(1L);
		}
		if (job.getNumOn() > job.getSheets()) {
			job.setNumOn(job.getSheets());
		}
		if (job.getNumOn() > job.getNumUp()) {
			job.setNumOn(job.getNumUp());
		}
		
		if (job.getRunMethod().equals(RunMethod.WorkAndTumble) ||
				job.getRunMethod().equals(RunMethod.WorkAndTurn)) {
			if ((job.getNumOn() * 2) <= job.getNumUp()) {
				if (job.getNumUp() < (job.getSheets()/2)) {
					job.setNumOn(job.getNumUp());
				} else {
					job.setNumOn(job.getSheets()/2);
				}
				if (job.getNumOn() < 1) {
					job.setNumOn(1L);
				}
			}
		}
		
		ion = job.getNumOn();
		iup = job.getNumUp();
		iorigs = job.getSheets();
		
		iruns = iorigs/ion;
		if (iruns < 1) iruns = 1;
		
		divisor = iup/ion;
		ordered = job.getQtyOrdered() * job.getInSetsOf();
		
		if (iorigs%ion != 0) {
			xorig = iorigs - (iruns * ion);
			press = ordered/divisor;
			if ((press*divisor) < ordered) press++;
			xup = iup/xorig;
			xpress = ordered/xup;
			if ((xpress*xup) < ordered) press++; 
		
			if (press != 0) 
				runs = iruns + (xpress/press);
			else 
				runs = iruns;
			iruns++;
		} else {
			press = ordered/divisor;
			if ((press * divisor) < ordered) press++;
			runs = iruns;
		}
		
		if (job.getRunMethod().equals(RunMethod.WorkAndTumble)) {
			press += press;
		}
		
		//job.setAdditionalRunCount(runs - floor(runs));
		
		//job.setRunSize((runs * job.getFrontPasses() + job.getBackPasses());
		
		job.setSignatures(iruns);
		
		job.setPressQty(press);
		
//		
//		long sheets = job.getSheets();  
//		long up = job.getNumUp();
//		long on = job.getNumOn();
//		long runs = 0;
//		long ordered = job.getQtyOrdered();
//		if (up < 1) up = 1;
//		if (sheets < 1) sheets = 1;
//		if (on < 1) on = 1;
//		if (on > up) on = up;
//		
//		if (sheets/on < 1) {
//			runs = 1;
//		} else {
//			runs = sheets/on;
//			
//		}
//		
//		ordered *= job.getInSetsOf();
//		
//		long divisor = up/on;
//		long press, tmpPress;
//		long tmpRuns;
//
//		if (sheets %on != 0) {
//			long tmpSheets, tmpUp;
//			
//			tmpSheets = sheets - (runs*on);
//			press = ordered / divisor;
//			if ((press * divisor) < ordered)
//				press++;
//			tmpUp = up/tmpSheets;
//			tmpPress = ordered/tmpUp;
//			if ((tmpPress*tmpUp) < ordered)
//				tmpPress++;
//			if (press != 0) {
//				tmpRuns = runs + (tmpPress/press); 
//			} else {
//				tmpRuns = runs;
//			}
//			runs++;
//		} else {
//			press = ordered/divisor;
//			if (press *divisor < ordered) press++;
//			tmpRuns = runs;
//		}
//		
//		job.setSignatures(tmpRuns);
	}
}

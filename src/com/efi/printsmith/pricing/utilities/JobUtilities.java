package com.efi.printsmith.pricing.utilities;

import java.text.ParseException;
import java.util.List;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.PriceListBase;
import com.efi.printsmith.data.PriceListElement;
import com.efi.printsmith.data.SpeedTable;
import com.efi.printsmith.data.Dimension;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.enums.RunMethod;
import com.efi.printsmith.migration.Utilities;

public class JobUtilities {
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

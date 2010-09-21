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
import com.efi.printsmith.migration.Utilities;

public class JobUtilities {
	static public void calculateSignatures(Job job) {
		long sheets = job.getSheets();  
		long up = job.getNumUp();
		long on = job.getNumOn();
		long runs = 0;
		long ordered = job.getQtyOrdered();
		if (up < 1) up = 1;
		if (sheets < 1) sheets = 1;
		if (on < 1) on = 1;
		if (on > up) on = up;
		
		if (sheets/on < 1) {
			runs = 1;
		} else {
			runs = sheets/on;
			
		}
		
		ordered *= job.getInSetsOf();
		
		long divisor = up/on;
		long press, tmpPress;
		long tmpRuns;

		if (sheets %on != 0) {
			long tmpSheets, tmpUp;
			
			tmpSheets = sheets - (runs*on);
			press = ordered / divisor;
			if ((press * divisor) < ordered)
				press++;
			tmpUp = up/tmpSheets;
			tmpPress = ordered/tmpUp;
			if ((tmpPress*tmpUp) < ordered)
				tmpPress++;
			if (press != 0) {
				tmpRuns = runs + (tmpPress/press); 
			} else {
				tmpRuns = runs;
			}
			runs++;
		} else {
			press = ordered/divisor;
			if (press *divisor < ordered) press++;
			tmpRuns = runs;
		}
		
		job.setSignatures(tmpRuns);
	}
}

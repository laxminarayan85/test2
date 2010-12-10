package com.efi.printsmith.pricing.copier;

import java.util.List;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.pricing.utilities.JobUtilities;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.pricing.stock.StockCostEngine;

public abstract class CopierPricingMethod {
	public Job priceCopierJob(Job job) throws Exception {
		DataService dataService = new DataService();
		StockCostEngine stockCost = new StockCostEngine();
		if (job.getPricingCopier() != null)  // Ensure we have the latest copier data.
			job.setPricingCopier(dataService.getCopierDefinition(job.getPricingCopier().getId()));
		calculateTotalCopies(job);
		calculateStockQty(job);
		calculateLaborCost(job);
		calculateCopierRuntime(job);
		job = stockCost.calculateStockCost(job);
		if (job.getCopyMinutesOverride() == false)
			job.setCopyMinutes(job.getPricingCopier().getCopyMinutes());
		return job;
	}
	
	private void calculateLaborCost(Job job) throws Exception {
		job.getPricingRecord().setLaborCost(job.getTotalCopies().doubleValue() * job.getPricingCopier().getMachineCostPerCopy().doubleValue());
	}
	
	private void calculateTotalCopies(Job job) {
		float	runs;	/* used to hold partial run value */
		long	iup,ion,iorigs,ordered,press,xpress,xorig,xup;
		long	iruns,divisor;
		Boolean	results = true;	/* change this to false to use the old way of calculating sigs */
		
		if (job.getNumUp() < 1)	/* up must always be at least 1 */
			job.setNumUp(new Long(1));
		if (job.getSheets() < 1)	/* same for originals */
			job.setSheets(new Long(1));
		if (job.getNumOn() < 1)	/* on must also be at least 1 */
			job.setNumOn(new Long(1));
		if (job.getNumOn() > job.getSheets())				/* max value of on is number of originals */
			job.setNumOn(job.getSheets());
		if (job.getNumOn() > job.getNumUp())				/* and can't be more than the number up either */
			job.setNumOn(job.getNumUp());
		
		ion = job.getNumOn();
		iup = job.getNumUp();
		iorigs = job.getSheets();
		
		if (iorigs / ion < 1)
			iruns = 1;
		else
			iruns = iorigs / ion;
		divisor = iup / ion;
		
		if (job.getNumCopiesOverride()) {
			job.setQtyOrdered(job.getNumCopies() * job.getNumUp());
			job.setNumCopiesOverride(false);
		}
		
		ordered = job.getQtyOrdered() * job.getInSetsOf();
		if (iorigs % ion != 0) {	/* got partial runs */
			xorig = iorigs - (iruns * ion);	/* remaining originals to handle */
			press = ordered / divisor;	/* press count for main run */
			if ((press * divisor) < ordered)
				press++;
			xup = iup / xorig;	/* divisor for partial press run */
			xpress = ordered / xup;
			if ((xpress * xup) < ordered)
				xpress++;
			if (press != 0)
				runs = iruns + ((float)xpress / (float)press);	/* 5.0b15d2 - calculate the number of runs including partials */
			else
				runs = iruns;		//¥¥DR 7.1.3
			iruns++;	/* count partial as full run for signatures */
		} else {
			press = (ordered / divisor);	/* press count for main run */
			if ((press * divisor) < ordered)
				press++;
			runs = iruns;	/* set value to store in job */
		}
		
		double oddRunCount = (runs - Math.floor(runs));
		long oddRunQty = (long)(job.getQtyOrdered() * oddRunCount);
		job.setNumCopies(press);
		calculateEstWaste(job);
		calculateBinderyWaste(job);
		long wasteSheets = job.getBinderyWaste() + job.getEstWaste();
		wasteSheets *= job.getSheets();
		double dup = new Double(iup);
		double don = new Double(ion);
		double dondup = dup / don;
		long lonlup = (long)Math.ceil(dup / don);
		if ((ordered / (iup / ion)) < 1)
			job.setTotalCopies(iruns + ((wasteSheets * (iup / ion)) * iruns) + oddRunQty);
		else {
			double dOrdered = new Double(ordered);
			double dWasteSheets = new Double(wasteSheets);
			job.setTotalCopies(((long)Math.ceil((dOrdered / (dup / don))) * iruns) + (long)Math.ceil(((dWasteSheets * dondup * iruns)) + oddRunQty));
		}
		//if (oddRunQty == 0 && iorigs > iup)
			//job.setTotalCopies(job.getTotalCopies() * (iorigs / iup));
		if (job.getDoubleSided()) {
			job.setTotalCopies(job.getTotalCopies() * 2);
		}
		if (job.getTotalCopies() < 1 && job.getQtyOrdered() > 0)
			job.setTotalCopies(new Long(1));
		if (job.getQtyOrdered() == 0)
			job.setTotalCopies(new Long(0));
	}
	
	private void calculateEstWaste(Job job) {
		if (job.getEstWasteOverride())
			return;
		CopierDefinition copierDefinition = job.getPricingCopier();
		if (copierDefinition != null) {
			double estWaste = 0.0;
			DataService dataService = new DataService();
			WasteChart wasteChart = copierDefinition.getWasteChart();
			try {
				if (wasteChart != null) {
					wasteChart = (WasteChart)dataService.getWasteChart(wasteChart.getId());
					if (wasteChart != null) {
						double wastePct = PriceListUtilities.lookupPrice(wasteChart, job.getNumCopies());
						estWaste = (job.getNumCopies() * wastePct);
					}
				}
				job.setEstWaste(new Double(estWaste).longValue());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void calculateBinderyWaste(Job job)
	{
		List<Charge> charges = job.getCharges();
		if (charges != null)
		{
			for(int i = 0;i<charges.size();i++)
			{
				Charge charge = charges.get(i);
				ChargeDefinition chargeDefinition = charge.getChargeDefinition();
				double binderyWaste = chargeDefinition.getFixedWaste();
				WasteChart wasteChart = chargeDefinition.getWasteChart();
				if (wasteChart != null)
				{
					double wastePct = PriceListUtilities.lookupPrice(wasteChart, job.getNumCopies());
					binderyWaste = binderyWaste + (job.getNumCopies() * wastePct);
				}
				job.setBinderyWaste(new Double(binderyWaste).longValue());
			}
		}
	}
	
	private void calculateStockQty(Job job) {
	}
		
	private void calculateCopierJobWeight(Job job) {
		StockDefinition stockDefinition = job.getStock();
		
		if (stockDefinition != null) {
			double weight = stockDefinition.getMweight();
			
			job.setWeight(job.getNumCopies()*weight/1000);
		}
	}
	
	private void calculateCopierRuntime(Job job) {
		CopierDefinition copierDefinition = job.getPricingCopier();
		
		if (copierDefinition == null) return;
		if (copierDefinition != null && job.getOrRuntime() == false) {
			if (job.getPricingMethod().getMethod() == "Large Format") {
				long area = 0;
				try {
					if (copierDefinition.getSquareAreaType().equals("AreaFinishSize"))
						area = PriceListUtilities.getAreaFromSizeString(job
								.getFinishSize());
					else
						area = new Double(job.getRollWidth() * job.getCutOff())
								.longValue();
				} catch (Exception e) {

				}
				area = area * job.getTotalCopies();
				job.setRunTime(new Double(area / copierDefinition.getCopyMinutes()).longValue());
			}
			else
				job.setRunTime(new Double(job.getTotalCopies().doubleValue() / copierDefinition.getCopyMinutes()).longValue());
		}
	}
	
}

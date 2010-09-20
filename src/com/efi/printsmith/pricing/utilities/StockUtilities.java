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

public class StockUtilities {
	static public void calculateJobWeight(JobBase job) {
		double finish;
		double parent;
		double shipWeight = 0.0;
		double mWeight;

		StockDefinition stock = job.getStock();

		if (stock != null) {
			if (stock.getStockunit() == 2) { // TODO: 2 is equivalent to ROLL -
												// why are we using integers?
				mWeight = calculateRollStockMWeight(stock, job.getParentSize()
						.getWidth(), job.getRunSize().getHeight());
			} else {
				mWeight = stock.getMweight();
			}

			if (mWeight > 0.0) {
				finish = job.getFinishSize().getWidth()
						* job.getFinishSize().getHeight();

				parent = job.getParentSize().getWidth()
						* job.getParentSize().getHeight();
				if (parent > 0.0) {
					shipWeight = ((finish / parent) * mWeight) / 1000.0;
					shipWeight *= (job.getQtyOrdered() * job.getInSetsOf() * job
							.getSheets());
				}
			}
		}
		job.setWeight(shipWeight);
	}

	static private double calculateRollStockMWeight(StockDefinition stock,
			double width, double cutoff) {
		double parent;
		double basic;
		double weight = 0.0;
		
		parent = width * cutoff;
		basic = stock.getParentsize().getWidth() * stock.getParentsize().getHeight();
		
		if (parent == 0.0 || basic == 0.0 || stock.getWeight() == 0.0) {
			weight = 0.0;
		} else {
			if (stock.getIsMetric()) {
				weight = (parent * stock.getWeight())/basic;
			} else {
				weight = (parent/basic) * stock.getWeight();
				weight *= 2;
			}
		}
		
		return weight;
	}
}

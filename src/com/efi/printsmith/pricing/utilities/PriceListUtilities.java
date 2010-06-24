package com.efi.printsmith.pricing.utilities;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.PriceListBase;
import com.efi.printsmith.data.PriceListElement;
import com.efi.printsmith.data.SpeedTable;
import com.efi.printsmith.data.Dimension;
import com.efi.printsmith.migration.Utilities;

public class PriceListUtilities {
	static public double calculatePriceListPrice(long qty, PriceList priceList, double chargePrice, Job job) {
		double retVal = 0.0;
		double rate = 0.0;
		
		rate = PriceListUtilities.lookupPrice(priceList, qty);
		
		if (priceList.getIsRate() && priceList.getIsPercentage()) {
			retVal = chargePrice * rate;
		} else if (priceList.getIsRate()) {
			retVal = qty * rate;
		} else if (priceList.getIsPercentage()) {
			retVal = chargePrice * rate;
		} else if (priceList.getIsDiscount()) {
			if (job != null) {
				retVal = job.getPricingRecord().getTotalPrice().doubleValue() * rate;
			}
		} else {
			retVal = rate;
		}
		return retVal;
	}
	
	static public double lookupPaperPrice(PriceListBase priceList, long copies, long colors, long side) {
		double retVal = 0.0;
		
		if (priceList == null) return retVal;
		
		List<PriceListElement> elements = priceList.getElements();

		if (elements.size() <= 0) return retVal;
		
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getQuantity() >= copies  && elements.get(i).getColor() == colors && elements.get(i).getSide() == side) {
				retVal = elements.get(i).getAmount().doubleValue();
				break;
			}
		}
		
		return retVal;
	}
	
	static public double lookupPrice(PriceListBase priceList, long qty) {
		double retVal = 0.0;
		long lookupQty = qty;
		int i = 0;
		int base = 0;
		int last = 0;
		
		boolean doAdditional = priceList.getLastItemIsPriceAdditionalQty();
		
		if (priceList == null) return retVal;
		
		if (priceList.getIsRate()) {
			doAdditional = false;
		}

		List<PriceListElement> elements = priceList.getElements();

		if (elements.size() <= 0) return retVal;
		
		if (lookupQty <= elements.get(0).getQuantity()) {
			retVal = elements.get(0).getAmount().doubleValue();
		} else {
			int lastElementIndex = 0;
			boolean found = false;
			for (i = 0; i < elements.size(); i++) {
				// Find the actual last element
				if (elements.get(i).getQuantity() == 0) {
					found = true;
					lastElementIndex = i-1;
					break;
				}
			}
			
			if (found == false)
				lastElementIndex = i-1;
			
			for (i = lastElementIndex; i >= 0; i--) {
				// Search backwards for matching element
				if (elements.get(i).getQuantity() <= lookupQty) {
					base = i;
					break;
				}
			}
			
			if (base < lastElementIndex) {
				if (elements.get(base).getQuantity() == lookupQty) {
					// Found exact item
					last = base;
				} else {
					last = base + 1;
				}
			} else {
				last = base;
			}
			
			if (doAdditional && elements.get(elements.size()-1).getQuantity()==0) {
				doAdditional = false; // There's no additional value
			} else if (doAdditional) {
				if (elements.get(last).getQuantity() >= lookupQty) {
					doAdditional = false;
				}
			}
			
			if (doAdditional) {
				retVal = elements.get(base).getAmount().doubleValue();
				lookupQty = lookupQty - elements.get(base).getQuantity();
				
				if (priceList.getIsRate()) {
					// Rates treat last element as the actual rate
					retVal = elements.get(elements.size()-1).getQuantity();
				} else {
					qty = lookupQty;
					
					if (priceList.getInterpolate()) {
						retVal += (elements.get(elements.size()).getAmount().doubleValue() / elements.get(elements.size()).getQuantity()) * qty;
					} else {
						if ((lookupQty%elements.get(elements.size()).getQuantity()) != 0) {
							lookupQty = lookupQty + (elements.get(elements.size()).getQuantity() - (lookupQty&elements.get(elements.size()).getQuantity()));
						}
						retVal = retVal + ((lookupQty / elements.get(elements.size()).getQuantity()) * elements.get(elements.size()).getAmount().doubleValue());
					}
				}
			} else if (priceList.getInterpolate()) {
				retVal = elements.get(base).getAmount().doubleValue();
				qty = lookupQty - elements.get(base).getQuantity();
				
				if (qty!= 0) {
					long qtyRange = elements.get(base).getQuantity() - elements.get(last).getQuantity();
					long lookupRange = qty - elements.get(last).getQuantity();
					double priceRange = elements.get(last).getAmount().doubleValue() - retVal;
					retVal = ((lookupRange * priceRange) / qtyRange) + elements.get(last).getAmount().doubleValue();
				}
			} else {
				retVal = elements.get(last).getAmount().doubleValue();
			}
		}
		return retVal;
	}

	static public double getTimePerSheetFromSpeedTable(SpeedTable speedTable, long qty) {
		double retVal = 0.0;
		
		if (speedTable != null) {
			List <PriceListElement> speedTableElements = speedTable.getElements();
			PriceListElement elementToUse = null;
			if(speedTableElements != null && speedTableElements.size() > 0) {
				elementToUse = speedTableElements.get(0);
				for (int i=1; i < speedTableElements.size(); i++) {
					PriceListElement curElement = speedTableElements.get(i);
					if (curElement.getQuantity() > qty) {
						elementToUse = speedTableElements.get(i-1);
						break;
					}
				}
				if (elementToUse.getQuantity() > 0) {
					retVal = 3600/elementToUse.getAmount().doubleValue();
				}
			}
		}
		return retVal;
	}
	
	static public double getSpeedFromSpeedTable(SpeedTable speedTable, long qty) {
		double retVal = 0;
		
		if (speedTable != null) {
			List <PriceListElement> speedTableElements = speedTable.getElements();
			PriceListElement elementToUse = null;
			if(speedTableElements != null && speedTableElements.size() > 0) {
				elementToUse = speedTableElements.get(0);
				for (int i=1; i < speedTableElements.size(); i++) {
					PriceListElement curElement = speedTableElements.get(i);
					if (curElement.getQuantity() > qty) {
						elementToUse = speedTableElements.get(i-1);
						break;
					}
				}
				if (elementToUse.getQuantity() > 0) {
					retVal = elementToUse.getAmount().doubleValue();
				}
			}
		}
		return retVal;
	}
	
	static public long getAreaFromSizeString(Dimension size) throws NumberFormatException, ParseException {
		// TODO: Need to be much more flexible in string handling here (A4, B4, different lengths of dimensions)
		long retVal = 0;
		
		int i = size.getName().indexOf("x");
		if (i > -1) {
			String lengthString = size.getName().substring(0, i - 1);
			String widthString = size.getName().substring(i + 2);
			float length = Utilities.tokenToFloat(lengthString);
			float width = Utilities.tokenToFloat(widthString);
			retVal = (long) (length * width);
		}
		
		return retVal;
	}
	
	static public float getLengthFromSizeString(Dimension size) throws NumberFormatException, ParseException {
		// TODO: Need to be much more flexible in string handling here
		String lengthString = "0";
		
		int i = size.getName().indexOf("x");
		if (i > -1) {
			lengthString = size.getName().substring(0, i - 1);
		}
		
		return Float.parseFloat(lengthString);
	}
	
	static public float getWidthFromSizeString(Dimension size) throws NumberFormatException, ParseException {
		// TODO: Need to be much more flexible in string handling here
		String widthString = "0";
		
		int i = size.getName().indexOf("x");
		if (i > -1) {
			widthString = size.getName().substring(i + 2);
		}
		
		return Float.parseFloat(widthString);
	}
}

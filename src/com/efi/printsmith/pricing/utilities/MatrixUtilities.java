package com.efi.printsmith.pricing.utilities;

import java.util.List;

import com.efi.printsmith.data.StampSchedule;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;

public class MatrixUtilities {
	static public MatrixElement lookupMatrixElement(Matrix matrix, long lookup) {
		if (matrix == null) return null;
		
		List<MatrixElement> elements = matrix.getElements();
		
		int i = 0;
		
		for (i = 0; i < elements.size(); i++) {
			if (elements.get(i).getQty() > lookup) {
				break;
			}
		}
		//if (i > 0) i--;
		
		return elements.get(i);
	}
	
	
	static public double calculateStepPriceSideOne(Matrix matrix, long qty) {
		if (matrix == null) return 0.0;
		
		List<MatrixElement> elements = matrix.getElements();
		
		int i = 0;
		double runningTotal = 0.0;
		long prevQty = 0;
		for (i = 0; i < elements.size(); i++) {
			MatrixElement element = elements.get(i);
			if (element.getQty() < qty) {
				runningTotal += (element.getQty()-prevQty) * element.getPrice1();
				prevQty = element.getQty();
			} else {
				runningTotal += (qty-prevQty) * element.getPrice1();
				break;
			}
		}
		return (runningTotal/qty);
	}
	
	static public double calculateStepPriceSideTwo(Matrix matrix, long qty) {
		if (matrix == null) return 0.0;
		
		List<MatrixElement> elements = matrix.getElements();
		
		int i = 0;
		double runningTotal = 0.0;
		long prevQty = 0;
		for (i = 0; i < elements.size(); i++) {
			MatrixElement element = elements.get(i);
			if (element.getQty() < qty) {
				runningTotal += (element.getQty()-prevQty) * element.getPrice1();
				prevQty = element.getQty();
			} else {
				runningTotal += (qty-prevQty) * element.getPrice1();
				break;
			}
		}
		return (runningTotal/qty);
	}
	
	static public double getStampScheduleCost(StampSchedule stampSchedule, long inches, long lines) {
		return getCost(stampSchedule,inches,lines);
	}
	
	static public double getCost(Matrix matrix, long xLookup, long yLookup) {
		long element = 0;
		double cost = 0.0;
		if (matrix != null) {
			for (int i = 1; i <= 10; i++) {
				if (i == 1 && (xLookup <= matrix.getHeader1())) {
					element = i;
				} else if (i == 2 && (xLookup <= matrix.getHeader2())) {
					element = i;
				}else if (i == 3 && (xLookup <= matrix.getHeader3())) {
					element = i;
				}else if (i == 4 && (xLookup <= matrix.getHeader4())) {
					element = i;
				}else if (i == 5 && (xLookup <= matrix.getHeader5())) {
					element = i;
				}else if (i == 6 && (xLookup <= matrix.getHeader6())) {
					element = i;
				}else if (i == 7 && (xLookup <= matrix.getHeader7())) {
					element = i;
				}else if (i == 8 && (xLookup <= matrix.getHeader8())) {
					element = i;
				}else if (i == 9 && (xLookup <= matrix.getHeader9())) {
					element = i;
				}else {
					element = i;
				}
			}
			
			List<MatrixElement> elements = matrix.getElements();
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getQty() <= yLookup) {
					if (element == 1)
						cost = elements.get(i).getPrice1();
					if (element == 2)
						cost = elements.get(i).getPrice2();
					if (element == 3)
						cost = elements.get(i).getPrice3();
					if (element == 4)
						cost = elements.get(i).getPrice4();
					if (element == 5)
						cost = elements.get(i).getPrice5();
					if (element == 6)
						cost = elements.get(i).getPrice6();
					if (element == 7)
						cost = elements.get(i).getPrice7();
					if (element == 8)
						cost = elements.get(i).getPrice8();
					if (element == 9)
						cost = elements.get(i).getPrice9();
					if (element == 10)
						cost = elements.get(i).getPrice10();
					break;
				}
			}
		}
		return cost;
	}
	
	static public double calculateInterpolation(Matrix matrix, long lookup) {
		double retVal = 0.0;
		
		if (matrix == null) return retVal;
		
		List<MatrixElement> elements = matrix.getElements();
		
		int i = 0;
		long lastQty = 0;
		double lastPrice = 0.0;
		for (i = 0; i < elements.size(); i++) {
			if (elements.get(i).getQty() >= lookup) {
				break;
			}
			lastQty = elements.get(i).getQty();
			lastPrice = elements.get(i).getPrice1();
		}
		if (lastQty > 0) {
			long qtyRange = elements.get(i).getQty() - lastQty;
			long lookupRange = lookup - lastQty;
			double priceRange = (elements.get(i).getPrice1() - lastPrice);
			retVal = ((lookupRange * priceRange) / qtyRange) + lastPrice;
		} else {
			retVal = elements.get(i).getPrice1();
		}
		return retVal;
	}
}

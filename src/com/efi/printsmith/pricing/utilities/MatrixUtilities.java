package com.efi.printsmith.pricing.utilities;

import java.util.List;

import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;

public class MatrixUtilities {
	static public MatrixElement lookupMatrixElement(Matrix matrix, long lookup) {
		List<MatrixElement> elements = matrix.getElements();
		
		int i = 0;
		
		for (i = 0; i < elements.size(); i++) {
			if (elements.get(i).getQty() > lookup) {
				break;
			}
		}
		if (i > 0) i--;
		
		return elements.get(i);
	}
	
	static public double calculateStepPriceSideOne(Matrix matrix, long qty) {
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
		List<MatrixElement> elements = matrix.getElements();
		
		int i = 0;
		double runningTotal = 0.0;
		long prevQty = 0;
		for (i = 0; i < elements.size(); i++) {
			MatrixElement element = elements.get(i);
			if (element.getQty() < qty) {
				runningTotal += (element.getQty()-prevQty) * element.getPrice2();
				prevQty = element.getQty();
			} else {
				runningTotal += (qty-prevQty) * element.getPrice2();
				break;
			}
		}
		return (runningTotal/qty);
	}
}

package com.efi.printsmith.pricing.utilities;

import java.util.List;

import com.efi.printsmith.data.StampSchedule;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.comparator.MatrixElementComparator;

import edu.emory.mathcs.backport.java.util.Collections;

public class MatrixUtilities {
	static public MatrixElement lookupMatrixElement(Matrix matrix, long lookup) {
		if (matrix == null)
			return null;

		List<MatrixElement> elements = matrix.getElements();
		Collections.sort(elements, new MatrixElementComparator());
		int i = 0;

		for (i = 0; i < elements.size(); i++) {
			if (elements.get(i).getLastLine() == false
					&& elements.get(i).getQty() > 0
					&& elements.get(i).getQty() >= lookup) {
				break;
			}
		}
		// if (i >= elements.size()) i = i - 1;
		// Get last line element if nothing found
		if (i >= elements.size()) {
			for (i = 0; i < elements.size(); i++) {
				if (elements.get(i).getLastLine())
					break;
			}
		}

		return elements.get(i);
	}

	static public double calculateStepPriceSideOne(Matrix matrix, long qty) {
		if (matrix == null || qty == 0)
			return 0.0;

		List<MatrixElement> elements = matrix.getElements();
		Collections.sort(elements, new MatrixElementComparator());
		int i = 0;
		int lastLineIndex = 0;
		boolean found = false;
		double runningTotal = 0.0;
		long prevQty = 0;
		for (i = 0; i < elements.size(); i++) {
			MatrixElement element = elements.get(i);
			if (element.getLastLine() == false) {
				if (element.getQty() < qty) {
					runningTotal += (element.getQty() - prevQty)
							* element.getPrice1().doubleValue();
					prevQty = element.getQty();
				} else {
					runningTotal += (qty - prevQty)
							* element.getPrice1().doubleValue();
					found = true;
					break;
				}
			} else
				lastLineIndex = i;
		}
		if (!found)
			runningTotal += (qty - prevQty)
					* elements.get(lastLineIndex).getPrice1().doubleValue();
		return (runningTotal / qty);
	}

	static public double calculateStepPriceSideTwo(Matrix matrix, long qty) {
		if (matrix == null)
			return 0.0;

		List<MatrixElement> elements = matrix.getElements();
		Collections.sort(elements, new MatrixElementComparator());
		int i = 0;
		int lastLineIndex = 0;
		boolean found = false;
		double runningTotal = 0.0;
		long prevQty = 0;
		for (i = 0; i < elements.size(); i++) {
			MatrixElement element = elements.get(i);
			if (element.getLastLine() == false) {
				if (element.getQty() < qty) {
					runningTotal += (element.getQty() - prevQty)
							* element.getPrice2().doubleValue();
					prevQty = element.getQty();
				} else {
					runningTotal += (qty - prevQty)
							* element.getPrice2().doubleValue();
					found = true;
					break;
				}
			} else
				lastLineIndex = i;
		}
		if (!found)
			runningTotal += (qty - prevQty)
					* elements.get(lastLineIndex).getPrice2().doubleValue();
		return (runningTotal / qty);
	}

	static public double getStampScheduleCost(StampSchedule matrix,
			long inches, long lines) {
		long element = 0;
		double cost = 0.0;
		double lastLineCost = 0.0;
		double lastInchCost = 0.0;
		double lastLineLastInchCost = 0.0;
		Long lastInch = 0L;
		if (matrix != null) {
			for (int i = 1; i <= 9; i++) {
				if (i == 1 && (inches <= matrix.getHeader1())) {
					element = i;
					break;
				} else if (i == 2 && (inches <= matrix.getHeader2())) {
					element = i;
					break;
				} else if (i == 3 && (inches <= matrix.getHeader3())) {
					element = i;
					break;
				} else if (i == 4 && (inches <= matrix.getHeader4())) {
					element = i;
					break;
				} else if (i == 5 && (inches <= matrix.getHeader5())) {
					element = i;
					break;
				} else if (i == 6 && (inches <= matrix.getHeader6())) {
					element = i;
					break;
				} else if (i == 7 && (inches <= matrix.getHeader7())) {
					element = i;
					break;
				} else if (i == 8 && (inches <= matrix.getHeader8())) {
					element = i;
					break;
				} else {
					element = 9;
					lastInch = matrix.getHeader8();
				}
			}

			List<MatrixElement> elements = matrix.getElements();
			Collections.sort(elements, new MatrixElementComparator());
			Boolean costFound = false;
			Integer qty = 0;
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getLastLine()) {
					if (element == 1)
						lastLineCost = elements.get(i).getPrice1()
								.doubleValue();
					if (element == 2)
						if (elements.get(i).getPrice2() != null)
							lastLineCost = elements.get(i).getPrice2()
									.doubleValue();
						else
							lastLineCost = elements.get(i).getPrice1()
									.doubleValue();
					if (element == 3)
						if (elements.get(i).getPrice3() != null)
							lastLineCost = elements.get(i).getPrice3()
									.doubleValue();
					if (element == 4)
						if (elements.get(i).getPrice4() != null)
							lastLineCost = elements.get(i).getPrice4()
									.doubleValue();
						else
							lastLineCost = elements.get(i).getPrice1()
									.doubleValue();
					if (element == 5)
						if (elements.get(i).getPrice5() != null)
							lastLineCost = elements.get(i).getPrice5()
									.doubleValue();
						else
							lastLineCost = elements.get(i).getPrice1()
									.doubleValue();
					if (element == 6)
						if (elements.get(i).getPrice6() != null)
							lastLineCost = elements.get(i).getPrice6()
									.doubleValue();
						else
							lastLineCost = elements.get(i).getPrice1()
									.doubleValue();
					if (element == 7)
						if (elements.get(i).getPrice7() != null)
							lastLineCost = elements.get(i).getPrice7()
									.doubleValue();
						else
							lastLineCost = elements.get(i).getPrice1()
									.doubleValue();
					if (element == 8)
						if (elements.get(i).getPrice8() != null)
							lastLineCost = elements.get(i).getPrice8()
									.doubleValue();
						else
							lastLineCost = elements.get(i).getPrice1()
									.doubleValue();
					if (element == 9) {
						if (elements.get(i).getPrice9() != null)
							lastLineLastInchCost = elements.get(i).getPrice9()
									.doubleValue();
						else
							lastLineLastInchCost = elements.get(i).getPrice1()
									.doubleValue();
						if (elements.get(i).getPrice8() != null)
							lastLineCost = elements.get(i).getPrice8()
									.doubleValue();
						else
							lastLineCost = elements.get(i).getPrice1()
									.doubleValue();
					}
				} else {
					qty = elements.get(i).getQty();
					if (element == 1)
						cost = elements.get(i).getPrice1().doubleValue();
					if (element == 2)
						if (elements.get(i).getPrice2() != null)
							cost = elements.get(i).getPrice2().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 3)
						if (elements.get(i).getPrice3() != null)
							cost = elements.get(i).getPrice3().doubleValue();
					if (element == 4)
						if (elements.get(i).getPrice4() != null)
							cost = elements.get(i).getPrice4().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 5)
						if (elements.get(i).getPrice5() != null)
							cost = elements.get(i).getPrice5().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 6)
						if (elements.get(i).getPrice6() != null)
							cost = elements.get(i).getPrice6().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 7)
						if (elements.get(i).getPrice7() != null)
							cost = elements.get(i).getPrice7().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 8)
						if (elements.get(i).getPrice8() != null)
							cost = elements.get(i).getPrice8().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 9) {
						if (elements.get(i).getPrice9() != null)
							lastInchCost = elements.get(i).getPrice9().doubleValue();
						else
							lastInchCost = elements.get(i).getPrice1().doubleValue();
						if (elements.get(i).getPrice8() != null)
							cost = elements.get(i).getPrice8().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					}
					if (elements.get(i).getQty() >= lines) {
						costFound = true;
						break;
					}
				}
			}
			if (costFound == false) {
				long overQty = (lines - qty);
				cost += lastLineCost * overQty;
			}
			if (element == 9) {
				long overInches = (inches - lastInch);
				cost += lastInchCost * overInches;
			}
		}
		return cost;
	}

	static public double getCost(Matrix matrix, long xLookup, long yLookup) {
		long element = 0;
		double cost = 0.0;
		if (matrix != null) {
			for (int i = 1; i <= 10; i++) {
				if (i == 1 && (xLookup >= matrix.getHeader1())) {
					element = i;
				} else if (i == 2 && (xLookup >= matrix.getHeader2())) {
					element = i;
				} else if (i == 3 && (xLookup >= matrix.getHeader3())) {
					element = i;
				} else if (i == 4 && (xLookup >= matrix.getHeader4())) {
					element = i;
				} else if (i == 5 && (xLookup >= matrix.getHeader5())) {
					element = i;
				} else if (i == 6 && (xLookup >= matrix.getHeader6())) {
					element = i;
				} else if (i == 7 && (xLookup >= matrix.getHeader7())) {
					element = i;
				} else if (i == 8 && (xLookup >= matrix.getHeader8())) {
					element = i;
				} else if (i == 9 && (xLookup >= matrix.getHeader9())) {
					element = i;
				} else if (i == 10 && (xLookup >= matrix.getHeader10())) {
					element = i;
				}
			}

			List<MatrixElement> elements = matrix.getElements();
			Collections.sort(elements, new MatrixElementComparator());
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getQty() >= yLookup
						&& elements.get(i).getLastLine() == false) {
					if (element == 1)
						cost = elements.get(i).getPrice1().doubleValue();
					if (element == 2)
						if (elements.get(i).getPrice2() != null)
							cost = elements.get(i).getPrice2().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 3)
						if (elements.get(i).getPrice3() != null)
							cost = elements.get(i).getPrice3().doubleValue();
					if (element == 4)
						if (elements.get(i).getPrice4() != null)
							cost = elements.get(i).getPrice4().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 5)
						if (elements.get(i).getPrice5() != null)
							cost = elements.get(i).getPrice5().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 6)
						if (elements.get(i).getPrice6() != null)
							cost = elements.get(i).getPrice6().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 7)
						if (elements.get(i).getPrice7() != null)
							cost = elements.get(i).getPrice7().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 8)
						if (elements.get(i).getPrice8() != null)
							cost = elements.get(i).getPrice8().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 9)
						if (elements.get(i).getPrice9() != null)
							cost = elements.get(i).getPrice9().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					if (element == 10)
						if (elements.get(i).getPrice10() != null)
							cost = elements.get(i).getPrice10().doubleValue();
						else
							cost = elements.get(i).getPrice1().doubleValue();
					break;
				}
			}
		}
		return cost;
	}

	static public double getPaperPrice(Matrix matrix, long xLookup,
			long yLookup, boolean isFront) {
		long element = 0;
		double cost = 0.0;
		if (matrix != null) {
			for (int i = 1; i <= 5; i++) {
				if (i == 1 && (xLookup >= matrix.getHeader1())) {
					element = i;
				} else if (i == 2 && (xLookup >= matrix.getHeader2())) {
					element = i;
				} else if (i == 3 && (xLookup >= matrix.getHeader3())) {
					element = i;
				} else if (i == 4 && (xLookup >= matrix.getHeader4())) {
					element = i;
				} else if (i == 5 && (xLookup >= matrix.getHeader5())) {
					element = i;
				} else {
					element = element;
				}
			}

			List<MatrixElement> elements = matrix.getElements();
			Collections.sort(elements, new MatrixElementComparator());
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getQty() >= yLookup
						&& elements.get(i).getLastLine() == false) {
					if (element == 1)
						if (isFront)
							cost = elements.get(i).getPrice1().doubleValue();
						else
							cost = elements.get(i).getPrice11().doubleValue();
					if (element == 2)
						if (isFront)
							cost = elements.get(i).getPrice2().doubleValue();
						else
							cost = elements.get(i).getPrice12().doubleValue();
					if (element == 3)
						if (isFront)
							cost = elements.get(i).getPrice3().doubleValue();
						else
							cost = elements.get(i).getPrice13().doubleValue();
					if (element == 4)
						if (isFront)
							cost = elements.get(i).getPrice4().doubleValue();
						else
							cost = elements.get(i).getPrice14().doubleValue();
					if (element == 5)
						if (isFront)
							cost = elements.get(i).getPrice5().doubleValue();
						else
							cost = elements.get(i).getPrice15().doubleValue();
					break;
				}
			}
		}
		return cost;
	}

	static public double getPassPrice(Matrix matrix, long xLookup, long yLookup) {
		long element = 0;
		double cost = 0.0;
		if (matrix != null) {
			for (int i = 1; i <= 5; i++) {
				if (i == 1 && (xLookup >= matrix.getHeader1())) {
					element = i;
				} else if (i == 2 && (xLookup >= matrix.getHeader2())) {
					element = i;
				} else if (i == 3 && (xLookup >= matrix.getHeader3())) {
					element = i;
				} else if (i == 4 && (xLookup >= matrix.getHeader4())) {
					element = i;
				} else if (i == 5 && (xLookup >= matrix.getHeader5())) {
					element = i;
				} else {
					element = element;
				}
			}

			List<MatrixElement> elements = matrix.getElements();
			Collections.sort(elements, new MatrixElementComparator());
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getQty() >= yLookup
						&& elements.get(i).getLastLine() == false) {
					if (element == 1)
						cost = elements.get(i).getPrice1().doubleValue();
					if (element == 2)
						cost = elements.get(i).getPrice2().doubleValue();
					if (element == 3)
						cost = elements.get(i).getPrice3().doubleValue();
					if (element == 4)
						cost = elements.get(i).getPrice4().doubleValue();
					if (element == 5)
						cost = elements.get(i).getPrice5().doubleValue();
					break;
				}
			}
		}
		return cost;
	}

	static public double calculateInterpolation(Matrix matrix, long lookup) {
		double retVal = 0.0;

		if (matrix == null)
			return retVal;

		List<MatrixElement> elements = matrix.getElements();
		Collections.sort(elements, new MatrixElementComparator());
		int i = 0;
		long lastQty = 0;
		double lastPrice = 0.0;
		for (i = 0; i < elements.size(); i++) {
			if (i > 0) {
				lastQty = elements.get(i - 1).getQty();
				lastPrice = elements.get(i - 1).getPrice1().doubleValue();
			} else {
				lastQty = 0;
				lastPrice = 0.0;
			}
			if (elements.get(i).getQty() > 0
					&& elements.get(i).getQty() >= lookup) {
				break;
			}
		}
		if (i >= elements.size())
			i = i - 1;
		if (lastQty > 0 && i > 0 && elements.get(i).getLastLine() != null
				&& elements.get(i).getLastLine() == false) {
			long qtyRange = elements.get(i).getQty() - lastQty;
			long lookupRange = lookup - lastQty;
			double priceRange = (elements.get(i).getPrice1().doubleValue() - lastPrice);
			retVal = ((lookupRange * priceRange) / qtyRange) + lastPrice;
		} else {
			retVal = elements.get(i).getPrice1().doubleValue();
		}
		return retVal;
	}
}

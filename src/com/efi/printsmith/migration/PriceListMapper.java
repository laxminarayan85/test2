package com.efi.printsmith.migration;

import java.io.File;
import java.util.ArrayList;

import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.PriceListBase;
import com.efi.printsmith.data.PriceListElement;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.SpeedTable;
import com.efi.printsmith.data.WasteChart;

public class PriceListMapper extends ImportMapper {
	public void importFile(File uploadedFile) throws Exception {
		
	}
	@SuppressWarnings("null")
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens)
			throws Exception {
		PriceList priceList = null;
		SpeedTable speedTable = null;
		WasteChart wasteChart = null;
		String recNo = "";
		String rType = "";
		for (int x = 1; x <= 15; x++) {
			PriceListElement priceListElement = null;
			for (int i = 0; i < fieldTokens.length; i++) {
				String currentImportToken = importTokens[i];
				String currentFieldToken = fieldTokens[i];
				if ("recno".equals(currentFieldToken) && x == 1) {
					recNo = currentImportToken;
				} else if ("rtype".equals(currentFieldToken) && x == 1) {
					if (currentImportToken.equals("S")) {
						speedTable = new SpeedTable();
						speedTable.setPrevId(recNo);
					}
					else if (currentImportToken.equals("W")) {
						wasteChart = new WasteChart();
						wasteChart.setPrevId(recNo);
					}
					else if (currentImportToken.equals("P")) {
						priceList = new PriceList();
						priceList.setPrevId(recNo);
					}
					rType = currentImportToken;
				} else if ("title".equals(currentFieldToken) && x == 1) {
					if (rType.equals("P"))
						priceList.setName(currentImportToken);
					else if (rType.equals("S"))
						speedTable.setName(currentImportToken);
					else if (rType.equals("W"))
						wasteChart.setName(currentImportToken);
				} else if ("quantity[1]".equals(currentFieldToken) && x == 1) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[2]".equals(currentFieldToken) && x == 2) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[3]".equals(currentFieldToken) && x == 3) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[4]".equals(currentFieldToken) && x == 4) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[5]".equals(currentFieldToken) && x == 5) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[6]".equals(currentFieldToken) && x == 6) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[7]".equals(currentFieldToken) && x == 7) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[8]".equals(currentFieldToken) && x == 8) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[9]".equals(currentFieldToken) && x == 9) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[10]".equals(currentFieldToken) && x == 10) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[11]".equals(currentFieldToken) && x == 11) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[12]".equals(currentFieldToken) && x == 12) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[13]".equals(currentFieldToken) && x == 13) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[14]".equals(currentFieldToken) && x == 14) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("quantity[15]".equals(currentFieldToken) && x == 15) {
					if (currentImportToken.equals("") == false) {
						priceListElement = new PriceListElement();
						priceListElement.setQuantity(Utilities
								.tokenToLong(currentImportToken));
					}
				} else if ("amount[1]".equals(currentFieldToken) && x == 1) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[2]".equals(currentFieldToken) && x == 2) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[3]".equals(currentFieldToken) && x == 3) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[4]".equals(currentFieldToken) && x == 4) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[5]".equals(currentFieldToken) && x == 5) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[6]".equals(currentFieldToken) && x == 6) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[7]".equals(currentFieldToken) && x == 7) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[8]".equals(currentFieldToken) && x == 8) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[9]".equals(currentFieldToken) && x == 9) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[10]".equals(currentFieldToken) && x == 10) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[11]".equals(currentFieldToken) && x == 11) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[12]".equals(currentFieldToken) && x == 12) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[13]".equals(currentFieldToken) && x == 13) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[14]".equals(currentFieldToken) && x == 14) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("amount[15]".equals(currentFieldToken) && x == 15) {
					if (currentImportToken.equals("") == false) {
						priceListElement.setAmount(Utilities
								.tokenToDouble(currentImportToken));
					}
				} else if ("doAddl".equals(currentFieldToken)) {
					/* TODO */
				} else if ("is Pct".equals(currentFieldToken) && x == 1) {
					if (rType.equals("W"))
						wasteChart.setIsPercentage(Utilities
							.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("S"))
						speedTable.setIsPercentage(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("P"))
						priceList.setIsPercentage(Utilities
								.tokenToBooleanValue(currentImportToken));
				} else if ("is dollar".equals(currentFieldToken) && x == 1) {
					if (rType.equals("P"))
						priceList.setIsDollar(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("W"))
						wasteChart.setIsDollar(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("S"))
						speedTable.setIsDollar(Utilities
								.tokenToBooleanValue(currentImportToken));
				} else if ("interpolate".equals(currentFieldToken) && x == 1) {
					if (rType.equals("P"))
						priceList.setInterpolate(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("W"))
						wasteChart.setInterpolate(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("S"))
						speedTable.setInterpolate(Utilities
								.tokenToBooleanValue(currentImportToken));
				} else if ("is rate".equals(currentFieldToken) && x == 1) {
					if (rType.equals("P"))
						priceList.setIsRate(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("W"))
						wasteChart.setIsRate(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("S"))
						speedTable.setIsRate(Utilities
								.tokenToBooleanValue(currentImportToken));
				} else if ("isDiscount".equals(currentFieldToken) && x == 1) {
					if (rType.equals("P"))
						priceList.setIsDiscount(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("W"))
						wasteChart.setIsDiscount(Utilities
								.tokenToBooleanValue(currentImportToken));
					else if (rType.equals("S"))
						speedTable.setIsDiscount(Utilities
								.tokenToBooleanValue(currentImportToken));
				} else if ("special".equals(currentFieldToken)) {
					/* TODO */
				} else if ("rstatus".equals(currentFieldToken)) {
					/* TODO */
				}
			}
			if (priceListElement != null) {
				if (rType.equals("P"))
					priceList.addElements(priceListElement);
				else if (rType.equals("W"))
					wasteChart.addElements(priceListElement);
				else if (rType.equals("S"))
					speedTable.addElements(priceListElement);
			}
		}
		ModelBase returnObject = null;
		if (rType.equals("P"))
			returnObject = priceList;
		if (rType.equals("W"))
			returnObject = wasteChart;
		if (rType.equals("S"))
			returnObject = speedTable;
		
		return returnObject;
	}
}

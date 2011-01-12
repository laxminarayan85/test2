package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PaperPrice;
import com.efi.printsmith.data.PriceListElement;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

public class PriceScheduleMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(PriceScheduleMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens)
			throws Exception {
		log.info("Entering PriceScheduleMapper->importTokens");
		PaperPrice paperPrice = new PaperPrice();
		long qty = 0;
		int sides1 = 1;
		int sides2 = 1;
		for (int x = 1; x <= 15; x++) {
			PriceListElement priceListElement = null;
			for (int i = 0; i < fieldTokens.length; i++) {
				String currentImportToken = importTokens[i];
				String currentFieldToken = fieldTokens[i];
				String qtyString = "qty[" + Integer.toString(x) + "]";
				String sides1String = "side1[" + Integer.toString(sides1) + "]";
				String sides2String = "side2[" + Integer.toString(sides2) + "]";
				if ("recno".equals(currentFieldToken)) {
					/* TODO */
				} else if ("rtype".equals(currentFieldToken)) {
					/* TODO */
				} else if ("ID".equals(currentFieldToken)) {
					paperPrice.setPrevId(currentImportToken);
				} else if ("name".equals(currentFieldToken)) {
					//paperPrice.setName(currentImportToken);
				} else if (qtyString.equals(currentFieldToken)) {
					qty = Utilities.tokenToInt(currentImportToken);
				} else if (sides1String.equals(currentFieldToken) && qty > 0) {
					priceListElement = new PriceListElement();
					priceListElement.setQuantity(qty);
					priceListElement.setSide(1);
					int color = 0;
					if (x > 0 && x <= 5)
						color = x;
					else
						color = sides1 - ((x - 1) * 5);
					priceListElement.setColor(color);
					priceListElement.setAmount(Utilities.tokenToDouble(currentImportToken));
					//paperPrice.addElements(priceListElement);
					sides1++;
				} else if (sides2String.equals(currentFieldToken) && qty > 0) {
					priceListElement = new PriceListElement();
					priceListElement.setQuantity(qty);
					priceListElement.setSide(2);
					int color = 0;
					if (x > 0 && x <= 5)
						color = x;
					else
						color = sides2 - ((x - 1) * 5);
					priceListElement.setColor(color);
					priceListElement.setAmount(Utilities.tokenToDouble(currentImportToken));
					//paperPrice.addElements(priceListElement);
					sides2++;
				}
			}
		}
		log.info("Leaving PriceScheduleMapper->importTokens");
		return paperPrice;
	}
}
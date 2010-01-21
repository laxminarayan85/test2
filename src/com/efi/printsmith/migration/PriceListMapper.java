package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PriceList;

public class PriceListMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		PriceList priceList = new PriceList();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("title".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("doAddl".equals(currentImportToken)) {
				/* TODO */
			} else if ("is Pct".equals(currentImportToken)) {
				/* TODO */
			} else if ("is dollar".equals(currentImportToken)) {
				/* TODO */
			} else if ("interpolate".equals(currentImportToken)) {
				/* TODO */
			} else if ("is rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("isDiscount".equals(currentImportToken)) {
				/* TODO */
			} else if ("special".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			}
		}
		return priceList;
	}
}

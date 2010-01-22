package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PriceList;

public class PriceListMapper extends ImportMapper {
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		PriceList priceList = new PriceList();
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			                                       
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("title".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("doAddl".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is Pct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is dollar".equals(currentFieldToken)) {
				/* TODO */
			} else if ("interpolate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("isDiscount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		return priceList;
	}
}

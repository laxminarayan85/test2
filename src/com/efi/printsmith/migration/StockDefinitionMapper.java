package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.GenericColors;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.StockColors;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.StockFinish;
import com.efi.printsmith.data.StockGrade;
import com.efi.printsmith.data.Vendor;

public class StockDefinitionMapper extends ImportMapper {
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		StockDefinition stockDefinition = new StockDefinition();
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			System.out.println(currentFieldToken + ": " + currentImportToken);
			if ("recno".equals(currentFieldToken)) {
				stockDefinition.setPrevId(currentImportToken);
			} else if ("group".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("class".equals(currentFieldToken)) {
				stockDefinition.setStkclass(currentImportToken);
			}  else if ("name".equals(currentFieldToken)) {
				stockDefinition.setName(currentImportToken);
			}  else if ("color".equals(currentFieldToken)) {
				/* TODO - don't create one every time...use existing if it exists. */
				StockColors stockColor = new StockColors();
				
				stockColor.setName(currentImportToken);
				stockDefinition.setColor(stockColor);
				
			}  else if ("vendor".equals(currentFieldToken)) {
				/* TODO - don't create one every time...use existing if it exists. */
				Vendor vendor = new Vendor();
				
				vendor.setName(currentImportToken);
				stockDefinition.setVendor(vendor);
			}  else if ("sets".equals(currentFieldToken)) {
				stockDefinition.setSheetsPerSet(Utilities.tokenToInt(currentImportToken));
			}  else if ("id".equals(currentFieldToken)) {
				stockDefinition.setStockId(currentImportToken);
			}  else if ("unit".equals(currentFieldToken)) {
				stockDefinition.setUom(currentImportToken);
			}  else if ("parent size".equals(currentFieldToken)) {
				stockDefinition.setParentsize(currentImportToken);
			}  else if ("run size".equals(currentFieldToken)) {
				stockDefinition.setNormalRunSize(currentImportToken);
			}  else if ("vendor stock no".equals(currentFieldToken)) {
				stockDefinition.setStocknumber(currentImportToken);
			}  else if ("parentx".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("parenty".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("runx".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("runy".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s1cost".equals(currentFieldToken)) {
				stockDefinition.setCost1(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s1addm".equals(currentFieldToken)) {
				stockDefinition.setAdditional1(currentImportToken);
			}  else if ("s1markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup1(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s1limit".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s2cost".equals(currentFieldToken)) {
				stockDefinition.setCost2(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s2addm".equals(currentFieldToken)) {
				stockDefinition.setAdditional2(currentImportToken);
			}  else if ("s2markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup2(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s2limit".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s3cost".equals(currentFieldToken)) {
				stockDefinition.setCost3(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s3addm".equals(currentFieldToken)) {
				stockDefinition.setAdditional3(currentImportToken);
			}  else if ("s3markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup3(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s3limit".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("blank units[1]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetqty1(Utilities.tokenToInt(currentImportToken));
			}  else if ("blank units[2]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetqty2(Utilities.tokenToInt(currentImportToken));
			}  else if ("blank units[3]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetqty3(Utilities.tokenToInt(currentImportToken));
			}  else if ("blank cost[1]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetPrice1(Utilities.tokenToDouble(currentImportToken));
			}  else if ("blank cost[2]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetPrice2(Utilities.tokenToDouble(currentImportToken));
			}  else if ("blank cost[3]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetPrice3(Utilities.tokenToDouble(currentImportToken));
			}  else if ("schedule".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("press id".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("copyID".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("copyID2".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("copier[1]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("copier[2]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("press name".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("cut rate".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("minimum cut".equals(currentFieldToken)) {
				stockDefinition.setMinCutCharge(Utilities.tokenToDouble(currentImportToken));
			}  else if ("charges[1]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[2]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[3]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[4]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[5]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[6]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[7]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[8]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[9]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("charges[10]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("omarkup".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("oCopy2".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("oCopy1".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("autoCalc".equals(currentFieldToken)) {
				stockDefinition.setAutoCalculateBlank(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("special".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("min level".equals(currentFieldToken)) {
				stockDefinition.setReOrderPoint(Utilities.tokenToInt(currentImportToken));
			}  else if ("min order".equals(currentFieldToken)) {
				stockDefinition.setMinorder(Utilities.tokenToInt(currentImportToken));
			}  else if ("weight".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("price expires".equals(currentFieldToken)) {
				if (currentImportToken != null && currentImportToken.length() > 0) {
					stockDefinition.setPriceExpires(Utilities.tokenToDate(currentImportToken));
				}
			}  else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("not used byte".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("vendor id".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("group name".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("coat".equals(currentFieldToken)) {
				stockDefinition.setCoated(currentImportToken);
			}  else if ("type".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("generic color id".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("generic color name".equals(currentFieldToken)) {
				GenericColors genericColor = new GenericColors();
				
				genericColor.setName(currentImportToken);
				stockDefinition.setGenericColor(genericColor);
			}  else if ("generic finish id".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("generic finish name".equals(currentFieldToken)) {
				StockFinish finish = new StockFinish();
				finish.setName(currentImportToken);
				stockDefinition.setFinish(finish);
			}  else if ("grade id".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("grade name".equals(currentFieldToken)) {
				StockGrade grade = new StockGrade();
				grade.setName(currentImportToken);
				stockDefinition.setGrade(grade);
			}  else if ("mill".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("mWeight".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("caliper".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("lot count".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("carton count".equals(currentFieldToken)) {
				stockDefinition.setSheetspercarton(Utilities.tokenToInt(currentImportToken));
			}  else if ("carton weight".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("sheets per skid".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("weight per skid".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("basic size x".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("basic size".equals(currentFieldToken)) {
				stockDefinition.setBasicsize(currentImportToken);
			}  else if ("basic size y".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s1cwt".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s2cwt".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s3cwt".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s4cost".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s4cwt".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s4addm".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s4markup".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s4limit".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s5cost".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s5cwt".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s5addm".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s5markup".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s5limit".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s6cost".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s6cwt".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s6addm".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s6markup".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s6limit".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("blank units[4]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("blank units[5]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("blank units[6]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("blank cost[4]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("blank cost[5]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("blank cost[6]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("copyID3".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("copier[3]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("price changed date".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("last modification date".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("comment".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("measure".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("thickness type".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("markup flags".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("pcw recycle percent".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("forest managment ID".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("coc expand 1".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("coc expand 2".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("fsc certified".equals(currentFieldToken)) {
				stockDefinition.setFscCertified(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("sfi certified".equals(currentFieldToken)) {
				stockDefinition.setSfiCertified(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("green seal certified".equals(currentFieldToken)) {
				stockDefinition.setGreenSealCertified(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("coc expand 4".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("coc expand 5".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("coc expand 6".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("coc expand 7".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("coc expand 8".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("coc expand 9".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("priced in sets".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("short grain".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("no broken carton".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("envelope".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("imported".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("is inventory shell".equals(currentFieldToken)) {
				stockDefinition.setShellItem(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("allow negative inventory".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("isMetric".equals(currentFieldToken)) {
				stockDefinition.setIsMetric(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("roll stock".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[1]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[2]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[3]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[4]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[5]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[6]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[7]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[8]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[9]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory change log[10]".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory shell acct".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("inventory shell acct title".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		return stockDefinition;
	}
}

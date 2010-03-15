package com.efi.printsmith.migration;

import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.GenericColors;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.StockColors;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.StockFinish;
import com.efi.printsmith.data.StockGrade;
import com.efi.printsmith.data.StockGroup;
import com.efi.printsmith.data.StockClass;
import com.efi.printsmith.data.StockType;
import com.efi.printsmith.data.Vendor;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.PaperPrice;
import java.io.File;

public class StockDefinitionMapper extends ImportMapper {
	public void importFile(File uploadedFile) throws Exception {
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		StockDefinition stockDefinition = new StockDefinition();
		DataService dataService = new DataService();
		double weight = 0;
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			System.out.println(currentFieldToken + ": " + currentImportToken);
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("group".equals(currentFieldToken)) {
				
			}  else if ("class".equals(currentFieldToken)) {
				if (currentImportToken != "")
				{
					StockClass stockClass = dataService.getByStockClassName(currentImportToken);
					if (stockClass == null)
					{
						stockClass = new StockClass();
						stockClass.setName(currentImportToken);
					}
					stockDefinition.setStkclass(stockClass);
				}
				
			}  else if ("name".equals(currentFieldToken)) {
				stockDefinition.setName(currentImportToken);
			}  else if ("color".equals(currentFieldToken)) {
				if (currentImportToken != "")
				{
					StockColors stockColor = dataService.getByStockColorName(currentImportToken);
					if (stockColor == null)
					{
						stockColor = new StockColors();
						stockColor.setName(currentImportToken);
					}
					stockDefinition.setColor(stockColor);
				}
			}  else if ("vendor".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					Vendor vendor = (Vendor) dataService.getByName("Vendor", currentImportToken);
					if (vendor != null) {
						vendor.setName(currentImportToken);
						
					}
					else{
						 vendor = new  Vendor();
						 vendor.setName(currentImportToken);
					}
					stockDefinition.setVendor(vendor);	 
				}
			}  else if ("sets".equals(currentFieldToken)) {
				stockDefinition.setSheetsPerSet(Utilities.tokenToInt(currentImportToken));
			}  else if ("id".equals(currentFieldToken)) {
				stockDefinition.setStockId(currentImportToken);
				stockDefinition.setPrevId(currentImportToken);
			}  else if ("unit".equals(currentFieldToken)) {
				stockDefinition.setCostunits(Utilities.tokenToInt(currentImportToken));
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
				stockDefinition.setListPerM1(Utilities.tokenToInt(currentImportToken));
			}  else if ("s1markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup1(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s1limit".equals(currentFieldToken)) {
				stockDefinition.setQtybreak1(Utilities.tokenToInt(currentImportToken));
			}  else if ("s2cost".equals(currentFieldToken)) {
				stockDefinition.setCost2(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s2addm".equals(currentFieldToken)) {
				stockDefinition.setListPerM2(Utilities.tokenToInt(currentImportToken));
			}  else if ("s2markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup2(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s2limit".equals(currentFieldToken)) {
				stockDefinition.setQtybreak2(Utilities.tokenToInt(currentImportToken));
			}  else if ("s3cost".equals(currentFieldToken)) {
				stockDefinition.setCost3(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s3addm".equals(currentFieldToken)) {
				stockDefinition.setListPerM3(Utilities.tokenToInt(currentImportToken));
			}  else if ("s3markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup3(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s3limit".equals(currentFieldToken)) {
				stockDefinition.setQtybreak3(Utilities.tokenToInt(currentImportToken));
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
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("PaperPrice",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						PaperPrice paperPrice = (PaperPrice)dataService.getById("PaperPrice", id);
						stockDefinition.setDefaultPriceList(paperPrice);
					}
				}
			}  else if ("press id".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					PressDefinition pressDefinition = (PressDefinition) dataService.getByPrevId("PressDefinition",currentImportToken);
					if (pressDefinition != null)
						stockDefinition.setDefaultPress(pressDefinition);
				}
			}  else if ("copyID".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					CopierDefinition copyDefinition = (CopierDefinition) dataService.getByPrevId("CopierDefinition",currentImportToken);
					if (copyDefinition != null)
						stockDefinition.setDefaultBWCopier(copyDefinition);
				}
			}  else if ("copyID2".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					CopierDefinition copyDefinition = (CopierDefinition) dataService.getByPrevId("CopierDefinition",currentImportToken);
					if (copyDefinition != null)
						stockDefinition.setDefaultColorCopier(copyDefinition);
				}
			}  else if ("copier[1]".equals(currentFieldToken)) {
				stockDefinition.setCopier1PricePerSheet(Utilities.tokenToDouble(currentImportToken));
			}  else if ("copier[2]".equals(currentFieldToken)) {
				stockDefinition.setCopier2PricePerSheet(Utilities.tokenToDouble(currentImportToken));
			}  else if ("press name".equals(currentFieldToken)) {
				/* Done above */
			}  else if ("cut rate".equals(currentFieldToken)) {
				stockDefinition.setCutsPer100(Utilities.tokenToInt(currentImportToken));
			}  else if ("minimum cut".equals(currentFieldToken)) {
				stockDefinition.setMinCutCharge(Utilities.tokenToDouble(currentImportToken));
			}  else if ("charges[1]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[2]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[3]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[4]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[5]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[6]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[7]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[8]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[9]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
			}  else if ("charges[10]".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
						stockDefinition.addCharges(chargeDefinition);
					}
				}
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
				stockDefinition.setWeight(Utilities.tokenToDouble(currentImportToken));
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
				/* done */
			}  else if ("group name".equals(currentFieldToken)) {
				if (currentImportToken != "")
				{
					StockGroup stockGroup = dataService.getByStockGroupName(currentImportToken);
					if (stockGroup == null)
					{
						stockGroup = new StockGroup();
						stockGroup.setName(currentImportToken);
					}
					stockDefinition.setStkgroup(stockGroup);
				}
			}  else if ("coat".equals(currentFieldToken)) {
				stockDefinition.setCoated(currentImportToken);
			}  else if ("type".equals(currentFieldToken)) {
				if (currentImportToken != "")
				{
					StockType stocktype = dataService.getByStockTypeID(currentImportToken);
					if (stocktype == null)
					{
						stocktype = new StockType();
						stocktype.setName(currentImportToken);
					}
					stockDefinition.setStktype(stocktype);
				}
			}  else if ("generic color id".equals(currentFieldToken)) {
				/* done */
			}  else if ("generic color name".equals(currentFieldToken)) {
				if (currentImportToken != "")
				{
					GenericColors genericColors = dataService.getByGenericColorsName(currentImportToken);
					if (genericColors == null)
					{
						genericColors = new GenericColors();
						genericColors.setName(currentImportToken);
					}
					stockDefinition.setGenericColor(genericColors);
				}
			}  else if ("generic finish id".equals(currentFieldToken)) {
				/* done */
			}  else if ("generic finish name".equals(currentFieldToken)) {
				if (currentImportToken != "")
				{
					StockFinish stockFinish = dataService.getByStockFinishName(currentImportToken);
					if (stockFinish == null)
					{
						stockFinish = new StockFinish();
						stockFinish.setName(currentImportToken);
					}
					stockDefinition.setFinish(stockFinish);
				}
			}  else if ("grade id".equals(currentFieldToken)) {
				/* done */
			}  else if ("grade name".equals(currentFieldToken)) {
				if (currentImportToken != "")
				{
					StockGrade stockGrade = dataService.getByStockGradeName(currentImportToken);
					if (stockGrade == null)
					{
						stockGrade = new StockGrade();
						stockGrade.setName(currentImportToken);
					}
					stockDefinition.setGrade(stockGrade);
				}
			}  else if ("mill".equals(currentFieldToken)) {
				stockDefinition.setMill(Utilities.tokenToInt(currentImportToken));
			}  else if ("mWeight".equals(currentFieldToken)) {
				weight = Utilities.tokenToDouble(currentImportToken);
				
			}  else if ("caliper".equals(currentFieldToken)) {
				stockDefinition.setThickness(Utilities.tokenToDouble(currentImportToken));
			}  else if ("lot count".equals(currentFieldToken)) {
				stockDefinition.setLotcount(Utilities.tokenToInt(currentImportToken));
			}  else if ("carton count".equals(currentFieldToken)) {
				stockDefinition.setSheetspercarton(Utilities.tokenToInt(currentImportToken));
			}  else if ("carton weight".equals(currentFieldToken)) {
				stockDefinition.setCartonWeight(Utilities.tokenToDouble(currentImportToken));
			}  else if ("sheets per skid".equals(currentFieldToken)) {
				stockDefinition.setSheetperSkid(Utilities.tokenToInt(currentImportToken));
			}  else if ("weight per skid".equals(currentFieldToken)) {
				stockDefinition.setWeightperSkid(Utilities.tokenToDouble(currentImportToken));
			}  else if ("basic size x".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("basic size".equals(currentFieldToken)) {
				stockDefinition.setBasicsize(currentImportToken);
			}  else if ("basic size y".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("s1cwt".equals(currentFieldToken)) {
				stockDefinition.setCwt1(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s2cwt".equals(currentFieldToken)) {
				stockDefinition.setCwt2(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s3cwt".equals(currentFieldToken)) {
				stockDefinition.setCwt3(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s4cost".equals(currentFieldToken)) {
				stockDefinition.setCost4(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s4cwt".equals(currentFieldToken)) {
				stockDefinition.setCwt4(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s4addm".equals(currentFieldToken)) {
				stockDefinition.setListPerM4(Utilities.tokenToInt(currentImportToken));
			}  else if ("s4markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup4(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s4limit".equals(currentFieldToken)) {
				stockDefinition.setQtybreak4(Utilities.tokenToInt(currentImportToken));
			}  else if ("s5cost".equals(currentFieldToken)) {
				stockDefinition.setCost5(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s5cwt".equals(currentFieldToken)) {
				stockDefinition.setCwt5(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s5addm".equals(currentFieldToken)) {
				stockDefinition.setListPerM5(Utilities.tokenToInt(currentImportToken));
			}  else if ("s5markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup5(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s5limit".equals(currentFieldToken)) {
				stockDefinition.setQtybreak5(Utilities.tokenToInt(currentImportToken));
			}  else if ("s6cost".equals(currentFieldToken)) {
				stockDefinition.setCost6(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s6cwt".equals(currentFieldToken)) {
				stockDefinition.setCwt6(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s6addm".equals(currentFieldToken)) {
				stockDefinition.setListPerM6(Utilities.tokenToInt(currentImportToken));
			}  else if ("s6markup".equals(currentFieldToken)) {
				stockDefinition.setMarkup6(Utilities.tokenToDouble(currentImportToken));
			}  else if ("s6limit".equals(currentFieldToken)) {
				stockDefinition.setQtybreak6(Utilities.tokenToInt(currentImportToken));
			}  else if ("blank units[4]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetqty4(Utilities.tokenToInt(currentImportToken));
			}  else if ("blank units[5]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetqty5(Utilities.tokenToInt(currentImportToken));
			}  else if ("blank units[6]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetqty6(Utilities.tokenToInt(currentImportToken));
			}  else if ("blank cost[4]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetPrice4(Utilities.tokenToDouble(currentImportToken));
			}  else if ("blank cost[5]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetPrice5(Utilities.tokenToDouble(currentImportToken));
			}  else if ("blank cost[6]".equals(currentFieldToken)) {
				stockDefinition.setBlankSheetPrice6(Utilities.tokenToDouble(currentImportToken));
			}  else if ("copyID3".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					CopierDefinition copyDefinition = (CopierDefinition) dataService.getByPrevId("CopierDefinition",currentImportToken);
					if (copyDefinition != null)
						stockDefinition.setDefaultLargeCopier(copyDefinition);
				}
			}  else if ("copier[3]".equals(currentFieldToken)) {
				stockDefinition.setCopier3PricePerSheet(Utilities.tokenToDouble(currentImportToken));
			}  else if ("price changed date".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("last modification date".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("comment".equals(currentFieldToken)) {
				stockDefinition.setComments(currentImportToken);
			}  else if ("measure".equals(currentFieldToken)) {
				stockDefinition.setMeasure(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("thickness type".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == true)
					stockDefinition.setUom("Caliper");
				if (currentImportToken.equals("1") == true)
					stockDefinition.setUom("Microns");
				if (currentImportToken.equals("2") == true)
					stockDefinition.setUom("Points");
				if (currentImportToken.equals("3") == true)
					stockDefinition.setUom("Mils");
				if (currentImportToken.equals("4") == true)
					stockDefinition.setUom("Thous");
				if (currentImportToken.equals("5") == true)
					stockDefinition.setUom("Plies");
				if (currentImportToken.equals("6") == true)
					stockDefinition.setUom("Millimeters");
			}  else if ("markup flags".equals(currentFieldToken)) {
				/* TODO */
			}  else if ("pcw recycle percent".equals(currentFieldToken)) {
				stockDefinition.setPcwRecycledPercent(Utilities.tokenToDouble(currentImportToken));
			}  else if ("forest managment ID".equals(currentFieldToken)) {
				stockDefinition.setForestManagement(currentImportToken);
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
				stockDefinition.setPricedinSets(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("short grain".equals(currentFieldToken)) {
				stockDefinition.setShortgain(Utilities.tokenToInt(currentImportToken));
			}  else if ("no broken carton".equals(currentFieldToken)) {
				stockDefinition.setNoBrokenCarton(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("envelope".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true)
					stockDefinition.setStockunit(0);
			}  else if ("imported".equals(currentFieldToken)) {
				stockDefinition.setImported(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("is inventory shell".equals(currentFieldToken)) {
				stockDefinition.setShellItem(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("allow negative inventory".equals(currentFieldToken)) {
				stockDefinition.setAllownegative(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("isMetric".equals(currentFieldToken)) {
				stockDefinition.setIsMetric(Utilities.tokenToBooleanValue(currentImportToken));
			}  else if ("roll stock".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true)
					stockDefinition.setStockunit(2);
				else
					stockDefinition.setStockunit(1);
				
					
			}  else if ("inventory change log[1]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[2]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[3]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[4]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[5]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[6]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[7]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[8]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[9]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory change log[10]".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					/* done */
				}
			}  else if ("inventory shell acct".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					Account account = (Account) dataService.getByAccountId(currentImportToken);
					if (account != null)
						stockDefinition.setAccount(account);
				}
			}  else if ("inventory shell acct title".equals(currentFieldToken)) {
				/* TODO */
			}
			else if ("on hand".equals(currentFieldToken)) {
				stockDefinition.setOnHand(Utilities.tokenToInt(currentImportToken));
			}
			else if ("committed".equals(currentFieldToken)) {
				stockDefinition.setCommitted(Utilities.tokenToInt(currentImportToken));
			}
			else if ("target level".equals(currentFieldToken)) {
				stockDefinition.setTargetLevel(Utilities.tokenToInt(currentImportToken));
			}
			else if ("on order".equals(currentFieldToken)) {
				stockDefinition.setOnOrder(Utilities.tokenToInt(currentImportToken));
			}
			else if ("rigid substrate".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true)
					stockDefinition.setStockunit(4);

			}
			else if ("large format".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true)
					stockDefinition.setStockunit(3);

			}
			else if ("bin location".equals(currentFieldToken)) {
				stockDefinition.setBinLocation(currentImportToken);
			}
			else if ("inHouse".equals(currentFieldToken)) {
				stockDefinition.setStandardItem(Utilities.tokenToBooleanValue(currentImportToken));
			}
			else if ("inventoryminNotEven".equals(currentFieldToken)) {
				stockDefinition.setEvenIncrements(Utilities.tokenToBooleanValue(currentImportToken));
			}
			
		}
		stockDefinition.setAvailable(stockDefinition.getOnHand() - stockDefinition.getCommitted())  ;
		if (stockDefinition.getStockunit() == 2)
			stockDefinition.setRollWeight(weight);
		else
			stockDefinition.setMweight(weight);
		return stockDefinition;
	}
}

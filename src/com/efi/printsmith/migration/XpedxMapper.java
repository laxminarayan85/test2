package com.efi.printsmith.migration;

import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.GenericColors;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PreferencesSequenceValues;
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
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
import java.io.File;

import org.apache.log4j.Logger;

public class XpedxMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(StockDefinitionMapper.class);
	public void importFile(File uploadedFile) throws Exception {
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) throws Exception {
		log.info("Entering XpedxMapper->importTokens");
		DataService dataService = new DataService();
		StockDefinition stockDefinition = null;
		StockType stockType = null;
		double caliper = 0.0;
		for (int i=0; i < importTokens.length; i++) {
			String currentImportToken = importTokens[i];
			switch(i) {
			case 0:
				stockDefinition = dataService.getByStockId(currentImportToken);
				if (stockDefinition == null && importParams.getImportAll() == true)
					stockDefinition = new StockDefinition();
				else
					return null;
				stockDefinition.setStockId(currentImportToken);
				stockDefinition.setStocknumber(currentImportToken);
				break;
			case 1:
				if (importParams.getFullUpdate())
					stockDefinition.setParentsize(currentImportToken);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				if (importParams.getFullUpdate())
					stockDefinition.setName(currentImportToken);
				break;
			case 5:
				break;
			case 6:
				if (importParams.getFullUpdate()) {
					stockDefinition.setUom(currentImportToken);
					if (currentImportToken.equals("SH"))
						stockDefinition.setStockunit(1);
					else if (currentImportToken.equals("EN"))
						stockDefinition.setStockunit(0);
					else if (currentImportToken.equals("CT"))
						stockDefinition.setStockunit(2);
					else
						stockDefinition.setStockunit(1);
				}
				break;
			case 7:
				if (importParams.getFullUpdate() && importParams.getNoBrokenCartons())
					stockDefinition.setMinOrderQty(Utilities.tokenToInt(currentImportToken));
				break;
			case 8:
				if (importParams.getFullUpdate())
					stockDefinition.setSheetspercarton(Utilities.tokenToInt(currentImportToken));
				break;
			case 9:
				if (importParams.getFullUpdate()) {
					if (currentImportToken.equals("M"))
						stockDefinition.setCostunits(1000);
					else if (currentImportToken.equals("C"))
						stockDefinition.setCostunits(100);
					else if (currentImportToken.equals("B"))
						stockDefinition.setCostunits(100);
					else
						stockDefinition.setCostunits(1000);
				}
				break;
			case 10:
				break;
			case 11:
				if (importParams.getFullUpdate())
					stockDefinition.setCartonWeight(Utilities.tokenToDouble(currentImportToken));
				break;
			case 12:
				if (importParams.getFullUpdate())
					stockDefinition.setWeight(Utilities.tokenToDouble(currentImportToken));
				break;
			case 13:
				if (importParams.getFullUpdate())
					caliper = Utilities.tokenToDouble(currentImportToken);
				break;
			case 14:
				break;
			case 15:
				break;
			case 16:
				if (importParams.getUpdatePrice5()) {
					if (importParams.getUpdateType() == 1)
						stockDefinition.setCost5(Utilities.tokenToDouble(currentImportToken) + Utilities.tokenToDouble(currentImportToken) * importParams.getAdjustValue5());
					else
						stockDefinition.setCost5(Utilities.tokenToDouble(currentImportToken) + importParams.getAdjustValue5());
				}
				break;
			case 17:
				if (importParams.getUpdatePrice4()) {
					if (importParams.getUpdateType() == 1)
						stockDefinition.setCost4(Utilities.tokenToDouble(currentImportToken) + Utilities.tokenToDouble(currentImportToken) * importParams.getAdjustValue4());
					else
						stockDefinition.setCost4(Utilities.tokenToDouble(currentImportToken) + importParams.getAdjustValue4());
				}
				break;
			case 18:
				if (importParams.getUpdatePrice3()) {
					if (importParams.getUpdateType() == 1)
						stockDefinition.setCost3(Utilities.tokenToDouble(currentImportToken) + Utilities.tokenToDouble(currentImportToken) * importParams.getAdjustValue3());
					else
						stockDefinition.setCost3(Utilities.tokenToDouble(currentImportToken) + importParams.getAdjustValue3());
				}
				break;
			case 19:
				if (importParams.getUpdatePrice2()) {
					if (importParams.getUpdateType() == 1)
						stockDefinition.setCost2(Utilities.tokenToDouble(currentImportToken) + Utilities.tokenToDouble(currentImportToken) * importParams.getAdjustValue2());
					else
						stockDefinition.setCost2(Utilities.tokenToDouble(currentImportToken) + importParams.getAdjustValue2());
				}
				break;
			case 20:
				if (importParams.getUpdatePrice1()) {
					if (importParams.getUpdateType() == 1)
						stockDefinition.setCost1(Utilities.tokenToDouble(currentImportToken) + Utilities.tokenToDouble(currentImportToken) * importParams.getAdjustValue1());
					else
						stockDefinition.setCost1(Utilities.tokenToDouble(currentImportToken) + importParams.getAdjustValue1());
				}
				break;
			case 21:
				break;
			case 22:
				break;
			case 23:
				break;
			case 24:
				break;
			case 25:
				break;
			case 26:
				stockDefinition.setQtybreak1(Utilities.tokenToInt(currentImportToken));
				break;
			case 27:
				stockDefinition.setQtybreak2(Utilities.tokenToInt(currentImportToken));
				break;
			case 28:
				stockDefinition.setQtybreak3(Utilities.tokenToInt(currentImportToken));
				break;
			case 29:
				stockDefinition.setQtybreak4(Utilities.tokenToInt(currentImportToken));
				break;
			case 30:
				stockDefinition.setQtybreak5(Utilities.tokenToInt(currentImportToken));
				break;
			case 31:
				break;
			case 32:
				break;
			case 33:
				break;
			case 34:
				break;
			case 35:
				break;
			case 36:
				break;
			case 37:
				if (importParams.getFullUpdate()) {
					Integer section = Utilities.tokenToInt(currentImportToken);
					switch (section) {
					case 1:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 2");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						stockDefinition.setCoated("2");
						break;
					case 2:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 3");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						stockDefinition.setCoated("2");
						break;
					case 3:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 2");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						break;
					case 4:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 3");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						break;
					case 5:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 2");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						break;
					case 6:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 3");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						break;
					case 7:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 1");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						break;
					case 99:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 1");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						break;
					default:
						stockType = (StockType)dataService.getQuery("StockType", " where viewableid = 1");
						if (stockType != null)
							stockDefinition.setStktype(stockType);
						break;
					}
				}
				break;
			case 38:
				if (importParams.getFullUpdate()) {
					StockGroup stockGroup = dataService.getByStockGroupName(currentImportToken);
					if (stockGroup == null) {
						stockGroup = new StockGroup();
						stockGroup.setName(currentImportToken);
						stockGroup = (StockGroup)dataService.addUpdate(stockGroup);
						stockGroup.setId(stockGroup.getId());
					}
					stockDefinition.setStkgroup(stockGroup);
				}
				break;
			case 39:
				if (importParams.getFullUpdate()) {
					StockColors stockColor = dataService.getByStockColorName(currentImportToken);
					if (stockColor == null) {
						stockColor = new StockColors();
						stockColor.setName(currentImportToken);
						stockColor = (StockColors)dataService.addUpdate(stockColor);
						stockColor.setId(stockColor.getId());
					}
					stockDefinition.setColor(stockColor);
					GenericColors genericColor = dataService.getByGenericColorsName(currentImportToken);
					if (genericColor == null) {
						genericColor = new GenericColors();
						genericColor.setName(currentImportToken);
						genericColor = (GenericColors)dataService.addUpdate(genericColor);
						genericColor.setId(stockColor.getId());
					}
					stockDefinition.setGenericColor(genericColor);
				}
				break;
			case 40:
				if (importParams.getFullUpdate()) {
					StockFinish stockFinish = dataService.getByStockFinishName(currentImportToken);
					if (stockFinish == null) {
						stockFinish = new StockFinish();
						stockFinish.setName(currentImportToken);
						stockFinish = (StockFinish)dataService.addUpdate(stockFinish);
						stockFinish.setId(stockFinish.getId());
					}
					stockDefinition.setFinish(stockFinish);
				}
				break;
			case 41:
				break;
			case 42:
				if (importParams.getFullUpdate())
					stockDefinition.setPcwRecycledPercent(Utilities.tokenToDouble(currentImportToken));
				break;
			case 43:
				if (importParams.getFullUpdate())
					stockDefinition.setForestManagement(currentImportToken);
				break;
			case 44:
				if (importParams.getFullUpdate())
					stockDefinition.setFscCertified(Utilities.tokenToBooleanValue(currentImportToken));
				break;
			case 45:
				if (importParams.getFullUpdate())
					stockDefinition.setSfiCertified(Utilities.tokenToBooleanValue(currentImportToken));
				break;
			case 46:
				if (importParams.getFullUpdate())
					stockDefinition.setGreenSealCertified(Utilities.tokenToBooleanValue(currentImportToken));
				break;
			}
		}
		if (importParams.getFullUpdate()) {
			if (importParams.getSelectMetric())
				stockDefinition.setIsMetric(true);
			if (caliper * 1000 == stockDefinition.getWeight()) {
				stockDefinition.setThickness(1.0);
			} else {
				stockDefinition.setThickness(caliper);
			}
			stockDefinition.setAutoCalculateBlank(true);
			StockGrade stockGrade = dataService.getByStockGradeName("");
			if (stockGrade == null) {
				stockGrade = new StockGrade();
				stockGrade.setName("");
				stockGrade = (StockGrade)dataService.addUpdate(stockGrade);
				stockGrade.setId(stockGrade.getId());
			}
			stockDefinition.setGrade(stockGrade);
			Vendor vendor = (Vendor)dataService.getByName("Vendor","xpdex");
			if (vendor == null) {
				vendor = new Vendor();
				vendor.setName("xpedx");
				vendor = (Vendor)dataService.addUpdate(vendor);
				vendor.setId(vendor.getId());
			}
			stockDefinition.setVendor(vendor);
		}
		return stockDefinition;
	}
}
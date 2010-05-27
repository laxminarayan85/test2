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
import java.io.File;

import org.apache.log4j.Logger;

public class XpedxMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(StockDefinitionMapper.class);
	public void importFile(File uploadedFile) throws Exception {
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering XpedxMapper->importTokens");
		DataService dataService = new DataService();
		StockDefinition stockDefinition = null;
		for (int i=0; i < importTokens.length; i++) {
			String currentImportToken = importTokens[i];
			switch(i) {
			case 0:
				stockDefinition = dataService.getByStockId(currentImportToken);
				if (stockDefinition == null)
					stockDefinition = new StockDefinition();
				stockDefinition.setStockId(currentImportToken);
				break;
			case 1:
				stockDefinition.setParentsize(currentImportToken);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				stockDefinition.setName(currentImportToken);
				break;
			case 5:
				break;
			case 6:
				stockDefinition.setUom(currentImportToken);
				if (currentImportToken.equals("SH"))
					stockDefinition.setStockunit(1);
				else if (currentImportToken.equals("EN"))
					stockDefinition.setStockunit(0);
				else if (currentImportToken.equals("CT"))
					stockDefinition.setStockunit(2);
				else
					stockDefinition.setStockunit(1);
				break;
			case 7:
				stockDefinition.setMinOrderQty(Utilities.tokenToInt(currentImportToken));
				break;
			case 8:
				stockDefinition.setSheetspercarton(Utilities.tokenToInt(currentImportToken));
				break;
			case 9:
				if (currentImportToken.equals("M"))
					stockDefinition.setCostunits(1000);
				else if (currentImportToken.equals("C"))
					stockDefinition.setCostunits(100);
				else if (currentImportToken.equals("B"))
					stockDefinition.setCostunits(100);
				else
					stockDefinition.setCostunits(1000);
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				stockDefinition.setWeight(Utilities.tokenToDouble(currentImportToken));
				break;
			case 13:
				break;
			case 14:
				break;
			case 15:
				break;
			case 16:
				stockDefinition.setCost5(Utilities.tokenToDouble(currentImportToken));
				break;
			case 17:
				stockDefinition.setCost4(Utilities.tokenToDouble(currentImportToken));
				break;
			case 18:
				stockDefinition.setCost3(Utilities.tokenToDouble(currentImportToken));
				break;
			case 19:
				stockDefinition.setCost2(Utilities.tokenToDouble(currentImportToken));
				break;
			case 20:
				stockDefinition.setCost1(Utilities.tokenToDouble(currentImportToken));
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
				break;
			case 38:
				StockGroup stockGroup = dataService.getByStockGroupName(currentImportToken);
				if (stockGroup == null) {
					stockGroup = new StockGroup();
					stockGroup.setName(currentImportToken);
					stockGroup = (StockGroup)dataService.addUpdate(stockGroup);
					stockGroup.setId(stockGroup.getId());
				}
				stockDefinition.setStkgroup(stockGroup);
				break;
			case 39:
				StockColors stockColor = dataService.getByStockColorName(currentImportToken);
				if (stockColor == null) {
					stockColor = new StockColors();
					stockColor.setName(currentImportToken);
					stockColor = (StockColors)dataService.addUpdate(stockColor);
					stockColor.setId(stockColor.getId());
				}
				stockDefinition.setColor(stockColor);
				break;
			case 40:
				StockFinish stockFinish = dataService.getByStockFinishName(currentImportToken);
				if (stockFinish == null) {
					stockFinish = new StockFinish();
					stockFinish.setName(currentImportToken);
					stockFinish = (StockFinish)dataService.addUpdate(stockFinish);
					stockFinish.setId(stockFinish.getId());
				}
				stockDefinition.setFinish(stockFinish);
				break;
			case 41:
				break;
			case 42:
				stockDefinition.setPcwRecycledPercent(Utilities.tokenToDouble(currentImportToken));
				break;
			case 43:
				stockDefinition.setForestManagement(currentImportToken);
				break;
			case 44:
				stockDefinition.setFscCertified(Utilities.tokenToBooleanValue(currentImportToken));
				break;
			case 45:
				stockDefinition.setSfiCertified(Utilities.tokenToBooleanValue(currentImportToken));
				break;
			case 46:
				stockDefinition.setGreenSealCertified(Utilities.tokenToBooleanValue(currentImportToken));
				break;
			}
		}
		Vendor vendor = (Vendor)dataService.getByName("Vendor","xpdex");
		if (vendor == null) {
			vendor = new Vendor();
			vendor.setName("xpedx");
			vendor = (Vendor)dataService.addUpdate(vendor);
			vendor.setId(vendor.getId());
		}
		stockDefinition.setVendor(vendor);
		return stockDefinition;
	}
}
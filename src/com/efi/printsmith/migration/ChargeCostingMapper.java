package com.efi.printsmith.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.ChargeCost;
import com.efi.printsmith.data.CostCenter;
import com.efi.printsmith.data.Location;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.ShippingMethod;
import com.efi.printsmith.data.SpeedTable;
import com.efi.printsmith.data.Substrate;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeCommand;
import com.efi.printsmith.data.ChargeCategory;
import com.efi.printsmith.data.SalesCategory;

public class ChargeCostingMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(ChargeDefinitionMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering ChargeCostingMapper->importFile");
		DataService dataService = new DataService();
		ChargeCost chargeCost = new ChargeCost();
				
			for (int i = 0; i < fieldTokens.length; i++) {
				String currentImportToken = importTokens[i];
				String currentFieldToken = fieldTokens[i];
				if ("recno".equals(currentFieldToken)) {
					/* TODO */
				} else if ("rtype".equals(currentFieldToken)) {
					/* TODO */
				} else if ("charge ID".equals(currentFieldToken)) {
					ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
					if (modelBase != null) {
						long id = modelBase.getId();
						ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					}
							
				} else if ("costing method".equals(currentFieldToken)) {
					
				} else if ("setup cost".equals(currentFieldToken)) {
					chargeCost.setSetupCost(Utilities.tokenToDouble(currentImportToken));
				} else if ("unit cost".equals(currentFieldToken)) {
					chargeCost.setUnitCost(Utilities.tokenToDouble(currentImportToken));				
				}  else if ("price list ID".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						PriceList priceList = (PriceList)dataService.getByPrevId("PriceList", currentImportToken);
						if (priceList != null)
							chargeCost.setRateTable(priceList);
					}
				} else if ("setup time&mat cost".equals(currentFieldToken)) {
					chargeCost.setFixedMaterials(Utilities.tokenToDouble(currentImportToken));
				} else if ("unit time&mat cost".equals(currentFieldToken)) {
					chargeCost.setUnitMaterials(Utilities.tokenToDouble(currentImportToken));
				} else if ("labor time&mat cost".equals(currentFieldToken)) {
					chargeCost.setLaborRate(Utilities.tokenToDouble(currentImportToken));
				} else if ("setup time minutes".equals(currentFieldToken)) {
					chargeCost.setSetupMinutes(Utilities.tokenToDouble(currentImportToken));
				} else if ("speed table id".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						SpeedTable speedTable = (SpeedTable)dataService.getByPrevId("SpeedTable", currentImportToken);
						if (speedTable != null)
							chargeCost.setSpeedTable(speedTable);
					}
				} else if ("avg impressions".equals(currentFieldToken)) {
						chargeCost.setPiecesPerHour(Utilities.tokenToDouble(currentImportToken));
				} else if ("created date".equals(currentFieldToken)) {
					 chargeCost.setCreated(Utilities.tokenToDate(currentImportToken));
				} else if ("updated date".equals(currentFieldToken)) {
					
				} else if ("disabled date".equals(currentFieldToken)) {
					/* TODO */
				} 
			}
			
		return chargeCost;
	}
}
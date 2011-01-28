package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CostCenter;
import com.efi.printsmith.data.PreferencesSequenceValues;
import com.efi.printsmith.data.ProductionLocations;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.data.SpeedTable;
import com.efi.printsmith.data.PreferencesDefaultPresses;
import com.efi.printsmith.data.ProductionPress;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
public class PressDefinitionMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(PressDefinitionMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering PressDefinitionMapper->importTokens");
		PressDefinition pressDefinition = new PressDefinition();
		DataService dataService = new DataService();
		String minSize = "";
		String maxSize = "";
		boolean defaultSheetfed = false;
		boolean defaultRollfed = false;
		String machineNameId = "";
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if ("recno".equals(currentFieldToken)) {
				pressDefinition.setPrevId(currentImportToken);
			} else if ("name".equals(currentFieldToken)) {
				pressDefinition.setName(currentImportToken);
			} else if ("id".equals(currentFieldToken)) {
				pressDefinition.setPressId(currentImportToken);
			} else if ("machine id".equals(currentFieldToken)) {
				pressDefinition.setMachineID(Utilities.tokenToLong(currentImportToken));
			} else if ("heads".equals(currentFieldToken)) {
				pressDefinition.setNumberHeads(Utilities.tokenToLong(currentImportToken));
			} else if ("sales cat".equals(currentFieldToken)) {
					SalesCategory salesCategory = (SalesCategory)dataService.getByPrevId("SalesCategory", currentImportToken);
					if (salesCategory != null)
						pressDefinition.setSalesCat(salesCategory);
					
			} else if ("setup time".equals(currentFieldToken)) {
				pressDefinition.setSetupMin(Utilities.tokenToDouble(currentImportToken));
			} else if ("addl head".equals(currentFieldToken)) {
				pressDefinition.setSetupAddHead(Utilities.tokenToLong(currentImportToken));
			} else if ("addl run".equals(currentFieldToken)) {
				pressDefinition.setSetupAddRun(Utilities.tokenToLong(currentImportToken));
			} else if ("press speed".equals(currentFieldToken)) {
				pressDefinition.setAvgImpressPerHour(Utilities.tokenToDouble(currentImportToken));
			} else if ("fixed spoilage".equals(currentFieldToken)) {
				pressDefinition.setFixedWaste(Utilities.tokenToDouble(currentImportToken));
			} else if ("labor rate".equals(currentFieldToken)) {
				pressDefinition.setLaborRate(Utilities.tokenToDouble(currentImportToken));
			} else if ("labor markup".equals(currentFieldToken)) {
				pressDefinition.setLaborMarkup(Utilities.tokenToDouble(currentImportToken));
			} else if ("minimum time".equals(currentFieldToken)) {
				pressDefinition.setMinLabor(Utilities.tokenToDouble(currentImportToken));
			} else if ("plate charge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("wash rate".equals(currentFieldToken)) {
				pressDefinition.setWashupFee(Utilities.tokenToDouble(currentImportToken));
			} else if ("maxX".equals(currentFieldToken)) {
				/* TODO */
			} else if ("max stock size".equals(currentFieldToken)) {
				maxSize = currentImportToken;
			} else if ("min stock size".equals(currentFieldToken)) {
				minSize = currentImportToken;
			} else if ("maxY".equals(currentFieldToken)) {
				/* TODO */
			} else if ("isWeb".equals(currentFieldToken)) {
				pressDefinition.setPerfector(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("variable speed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use waste".equals(currentFieldToken)) {
				/* TODO */
			} else if ("charges[1]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[2]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[3]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[4]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[5]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[6]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[7]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[8]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[9]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("charges[10]".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					pressDefinition.addCharges(chargeDefinition);
				}
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("speed table ptr".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					SpeedTable speedTable = (SpeedTable)dataService.getByPrevId("SpeedTable", currentImportToken);
					if (speedTable != null)
						pressDefinition.setSpeedTable(speedTable);
				}
			} else if ("waste table ptr".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					WasteChart wasteChart = (WasteChart)dataService.getByPrevId("WasteChart", currentImportToken);
					if (wasteChart != null)
						pressDefinition.setWasteChart(wasteChart);
				}
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("not used".equals(currentFieldToken)) {
				/* TODO */
			} else if ("device ID".equals(currentFieldToken)) {
				pressDefinition.setOemDeviceID(currentImportToken);
			} else if ("output desc".equals(currentFieldToken)) {
				pressDefinition.setOutputDescrip(currentImportToken);
			} else if ("paperStyle".equals(currentFieldToken)) {
				if ("0".equals(currentImportToken)) {
					pressDefinition.setSheetFed(true);
					pressDefinition.setRollFed(false);
				} else if ("1".equals(currentImportToken)) {
					pressDefinition.setRollFed(true);
					pressDefinition.setSheetFed(false);
				}
			} else if ("is costing definition".equals(currentFieldToken)) {
				pressDefinition.setCostingPress(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("exp3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp6".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp7".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp8".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl setup 1".equals(currentFieldToken)) {
				pressDefinition.setWorkTurnSetup(Utilities.tokenToDouble(currentImportToken));
			} else if ("addl setup 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl sigs".equals(currentFieldToken)) {
				pressDefinition.setSetupAddSig(Utilities.tokenToLong(currentImportToken));
			} else if ("addl sigs per head".equals(currentFieldToken)) {
				pressDefinition.setAddSigAddHead(Utilities.tokenToLong(currentImportToken));
			} else if ("sequence".equals(currentFieldToken)) {
				/* TODO */
			} else if ("gripper edge".equals(currentFieldToken)) {
				pressDefinition.setGripEdge(Utilities.tokenToDouble(currentImportToken));
			} else if ("production location ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("production location".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					ProductionLocations prodLocation = dataService
							.getByLocationName(currentImportToken);
					if (prodLocation == null){
						prodLocation = new ProductionLocations();
						prodLocation.setName(currentImportToken);
						prodLocation = (ProductionLocations)dataService.addUpdate(prodLocation);
					}
					pressDefinition.setProductionLocation(prodLocation.getName());	
				}
			} else if ("cost center ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cost center".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					CostCenter costCenter = dataService
							.getByCostCenterName(currentImportToken);
					if (costCenter == null) {
						costCenter = new CostCenter();
						costCenter.setName(currentImportToken);
						costCenter = (CostCenter)dataService.addUpdate(costCenter);
					}
					pressDefinition.setCostCenter(currentImportToken);
				}
						
			} else if ("machine name ID".equals(currentFieldToken)) {
				machineNameId = currentImportToken;
			} else if ("machine name".equals(currentFieldToken)) {
				pressDefinition.setMachineName(currentImportToken);
				if (machineNameId.equals("") == false) {
					ProductionPress productionPress = (ProductionPress)dataService.getByPrevId("ProductionPress", machineNameId);
					if (productionPress == null) {
						productionPress = new ProductionPress();
						productionPress.setPrevId(machineNameId);
						productionPress.setName(currentImportToken);
						dataService.addUpdate(productionPress);
					}
				}
			} else if ("wash minutes".equals(currentFieldToken)) {
				pressDefinition.setWashupMin(Utilities.tokenToLong(currentImportToken));
			} else if ("wash fountain".equals(currentFieldToken)) {
				pressDefinition.setWashupPerFountain(Utilities.tokenToDouble(currentImportToken));
			} else if ("minX".equals(currentFieldToken)) {
				/* TODO */
			} else if ("minY".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rollFedCutoffLength".equals(currentFieldToken)) {
				pressDefinition.setCutoffLength(Utilities.tokenToDouble(currentImportToken));
			} else if ("defaultSheetFed".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true) {
					defaultSheetfed = true;
				}
			} else if ("digital integration".equals(currentFieldToken)) {
				pressDefinition.setIntegratedDevice(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("time in seconds".equals(currentFieldToken)) {
				/* TODO */
			} else if ("perfector".equals(currentFieldToken)) {
			// not used see defect	703 pressDefinition.setPerfector(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("defaultRollFed".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true) {
					defaultRollfed = true;
				}
			} else if ("TargetPriceTableVersion".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_interpolate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ignoreCharges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_disabled".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_usePressCnt".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_skipWashup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_skipStock".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_filler1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_filler2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_filler3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_notused".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_laborMarkup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyCount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_passesFront".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_passesBack".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_minMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_maxMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_avgMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_passesFront".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_passesBack".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_minMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_maxMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_avgMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_passesFront".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_passesBack".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_minMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_maxMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_avgMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_passesFront".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_passesBack".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_minMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_maxMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_avgMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_passesFront".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_passesBack".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_minMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_maxMargin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_avgMargin".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		if (pressDefinition.getSheetFed() == true) {
			pressDefinition.setMaxPaperSize(maxSize);
			pressDefinition.setMinPaperSize(minSize);
		}
		else {
			pressDefinition.setMaxRollWidth(maxSize);
			pressDefinition.setMinRollWidth(minSize);
		}
		pressDefinition = (PressDefinition)dataService.addUpdate(pressDefinition);
		pressDefinition.setId(pressDefinition.getId());
		if (defaultSheetfed == true) {
			PreferencesDefaultPresses defaultCopier = (PreferencesDefaultPresses)dataService.getSingle("PreferencesDefaultPresses");
			if (defaultCopier == null) {
				defaultCopier = new PreferencesDefaultPresses();
			}
			defaultCopier.setDefaultSheetFedPress(pressDefinition);
			dataService.addUpdate(defaultCopier);
		}
		if (defaultRollfed == true) {
			PreferencesDefaultPresses defaultCopier = (PreferencesDefaultPresses)dataService.getSingle("PreferencesDefaultPresses");
			if (defaultCopier == null) {
				defaultCopier = new PreferencesDefaultPresses();
			}
			defaultCopier.setDefaultRollFedPress(pressDefinition);
			dataService.addUpdate(defaultCopier);
		}
		if (pressDefinition.getPressId() != null
				&& pressDefinition.getPressId().length() > 0) {
			PreferencesSequenceValues sequenceValues = dataService.getSequenceValues();
			sequenceValues.setPressDefinition(Long.parseLong(pressDefinition.getPressId()));
			dataService.addUpdate(sequenceValues);
		}
		log.info("Leaving PressDefinitionMapper->importTokens");
		return pressDefinition;
	}
}

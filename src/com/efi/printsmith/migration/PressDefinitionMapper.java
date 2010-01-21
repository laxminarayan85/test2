package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.StockDefinition;

public class PressDefinitionMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		PressDefinition pressDefinition = new PressDefinition();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("name".equals(currentImportToken)) {
				/* TODO */
			} else if ("id".equals(currentImportToken)) {
				/* TODO */
			} else if ("machine id".equals(currentImportToken)) {
				/* TODO */
			} else if ("heads".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales cat".equals(currentImportToken)) {
				/* TODO */
			} else if ("setup time".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl head".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl run".equals(currentImportToken)) {
				/* TODO */
			} else if ("press speed".equals(currentImportToken)) {
				/* TODO */
			} else if ("fixed spoilage".equals(currentImportToken)) {
				/* TODO */
			} else if ("labor rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("labor markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("minimum time".equals(currentImportToken)) {
				/* TODO */
			} else if ("plate charge".equals(currentImportToken)) {
				/* TODO */
			} else if ("wash rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("maxX".equals(currentImportToken)) {
				/* TODO */
			} else if ("max stock size".equals(currentImportToken)) {
				/* TODO */
			} else if ("maxY".equals(currentImportToken)) {
				/* TODO */
			} else if ("isWeb".equals(currentImportToken)) {
				/* TODO */
			} else if ("variable speed".equals(currentImportToken)) {
				/* TODO */
			} else if ("use waste".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("special".equals(currentImportToken)) {
				/* TODO */
			} else if ("speed table ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("waste table ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("not used".equals(currentImportToken)) {
				/* TODO */
			} else if ("device ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("output desc".equals(currentImportToken)) {
				/* TODO */
			} else if ("paperStyle".equals(currentImportToken)) {
				/* TODO */
			} else if ("is costing definition".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp3".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp4".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp5".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp6".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp7".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp8".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl setup 1".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl setup 2".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl sigs".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl sigs per head".equals(currentImportToken)) {
				/* TODO */
			} else if ("sequence".equals(currentImportToken)) {
				/* TODO */
			} else if ("gripper edge".equals(currentImportToken)) {
				/* TODO */
			} else if ("production location ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("production location".equals(currentImportToken)) {
				/* TODO */
			} else if ("cost center ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("cost center".equals(currentImportToken)) {
				/* TODO */
			} else if ("machine name ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("machine name".equals(currentImportToken)) {
				/* TODO */
			} else if ("wash minutes".equals(currentImportToken)) {
				/* TODO */
			} else if ("wash fountain".equals(currentImportToken)) {
				/* TODO */
			} else if ("minX".equals(currentImportToken)) {
				/* TODO */
			} else if ("minY".equals(currentImportToken)) {
				/* TODO */
			} else if ("rollFedCutoffLength".equals(currentImportToken)) {
				/* TODO */
			} else if ("defaultSheetFed".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital integration".equals(currentImportToken)) {
				/* TODO */
			} else if ("time in seconds".equals(currentImportToken)) {
				/* TODO */
			} else if ("perfector".equals(currentImportToken)) {
				/* TODO */
			} else if ("defaultRollFed".equals(currentImportToken)) {
				/* TODO */
			} else if ("TargetPriceTableVersion".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_interpolate".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ignoreCharges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_disabled".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_usePressCnt".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_skipWashup".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_skipStock".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_filler1".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_filler2".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_filler3".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_notused".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_laborMarkup".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyCount".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_qtyElements[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_passesFront".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_passesBack".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_minMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_maxMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData1_Cell_avgMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_passesFront".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_passesBack".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_minMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_maxMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData2_Cell_avgMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_passesFront".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_passesBack".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_minMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_maxMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData3_Cell_avgMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_passesFront".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_passesBack".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_minMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_maxMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData4_Cell_avgMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_passesFront".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_passesBack".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_labor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_chargeTota".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_Charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_stdPrice".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_targetPric".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_h".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_var_v".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_inited".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_filler".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_minMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_maxMargin".equals(currentImportToken)) {
				/* TODO */
			} else if ("TPT_ColumnData5_Cell_avgMargin".equals(currentImportToken)) {
				/* TODO */
			}
		}
		return pressDefinition;
	}
}

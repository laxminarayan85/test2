package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.StockDefinition;

public class ChargeDefinitionMapper extends ImportMapper {
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		ChargeDefinition chargeDefinition = new ChargeDefinition();
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("importedChargeID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("description".equals(currentFieldToken)) {
				/* TODO */
			} else if ("notes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("list ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("charge ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales cat".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales cat name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rate qty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("mat qty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("number of sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("material sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("start".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stop".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shownotes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finished".equals(currentFieldToken)) {
				/* TODO */
			} else if ("brokered".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxable".equals(currentFieldToken)) {
				/* TODO */
			} else if ("displayqty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("oprice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("orqty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("omqty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("method".equals(currentFieldToken)) {
				/* TODO */
			} else if ("qty type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("markup type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job qty type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hidden".equals(currentFieldToken)) {
				/* TODO */
			} else if ("no overrrides".equals(currentFieldToken)) {
				/* TODO */
			} else if ("adjust sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("enter rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("enter material".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use material".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use rate sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use material sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use setup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use minimum".equals(currentFieldToken)) {
				/* TODO */
			} else if ("bindery operation".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use colors".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use orig".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use sigs".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rate set count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("material rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("minimum".equals(currentFieldToken)) {
				/* TODO */
			} else if ("xNotUsed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sku".equals(currentFieldToken)) {
				/* TODO */
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("xdesc".equals(currentFieldToken)) {
				/* TODO */
			} else if ("category id".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labels".equals(currentFieldToken)) {
				/* TODO */
			} else if ("description custom".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expandedShort".equals(currentFieldToken)) {
				/* TODO */
			} else if ("obs_tax rate ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("not used byte".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table".equals(currentFieldToken)) {
				/* TODO */
			} else if ("customer charge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("press charge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("deleted preset".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ignore cuts".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock charge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o Cut qty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("version".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sequence".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship method".equals(currentFieldToken)) {
				/* TODO */
			} else if ("adjust up count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("extra long".equals(currentFieldToken)) {
				/* TODO */
			} else if ("has link charge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("need link charge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("has shipped".equals(currentFieldToken)) {
				/* TODO */
			} else if ("should ship".equals(currentFieldToken)) {
				/* TODO */
			} else if ("reserve bit 5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hide price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ignore price adj".equals(currentFieldToken)) {
				/* TODO */
			} else if ("costing press charge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("linear x1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("linear x2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("linear y1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("linear y2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("override rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pricing type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink coverage type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use sides".equals(currentFieldToken)) {
				/* TODO */
			} else if ("noDiscount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("no m quant".equals(currentFieldToken)) {
				/* TODO */
			} else if ("mat set count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("markup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price list".equals(currentFieldToken)) {
				/* TODO */
			} else if ("waste chart".equals(currentFieldToken)) {
				/* TODO */
			} else if ("fixed waste".equals(currentFieldToken)) {
				/* TODO */
			} else if ("waste percent".equals(currentFieldToken)) {
				/* TODO */
			} else if ("base linear number".equals(currentFieldToken)) {
				/* TODO */
			} else if ("production location ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("production location".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cost center ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cost center".equals(currentFieldToken)) {
				/* TODO */
			} else if ("substrate ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("plate substrate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("min time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("plate size X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("plate size".equals(currentFieldToken)) {
				/* TODO */
			} else if ("plate size Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("plate thickness".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exclude from production".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pre production".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use min time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use divide up count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use multiply up count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("adjust up".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cuts are prepress".equals(currentFieldToken)) {
				/* TODO */
			} else if ("integrated CTP".equals(currentFieldToken)) {
				/* TODO */
			} else if ("new from import".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		return chargeDefinition;
	}
}

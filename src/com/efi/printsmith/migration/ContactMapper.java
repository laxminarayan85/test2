package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.ModelBase;

public class ContactMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		Contact contact = new Contact();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);

			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("importedChargeID".equals(currentImportToken)) {
				/* TODO */
			} else if ("description".equals(currentImportToken)) {
				/* TODO */
			} else if ("notes".equals(currentImportToken)) {
				/* TODO */
			} else if ("list ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("charge ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales cat".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales cat name".equals(currentImportToken)) {
				/* TODO */
			} else if ("rate qty".equals(currentImportToken)) {
				/* TODO */
			} else if ("mat qty".equals(currentImportToken)) {
				/* TODO */
			} else if ("number of sets".equals(currentImportToken)) {
				/* TODO */
			} else if ("material sets".equals(currentImportToken)) {
				/* TODO */
			} else if ("price".equals(currentImportToken)) {
				/* TODO */
			} else if ("start".equals(currentImportToken)) {
				/* TODO */
			} else if ("stop".equals(currentImportToken)) {
				/* TODO */
			} else if ("shownotes".equals(currentImportToken)) {
				/* TODO */
			} else if ("finished".equals(currentImportToken)) {
				/* TODO */
			} else if ("brokered".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxable".equals(currentImportToken)) {
				/* TODO */
			} else if ("displayqty".equals(currentImportToken)) {
				/* TODO */
			} else if ("oprice".equals(currentImportToken)) {
				/* TODO */
			} else if ("orqty".equals(currentImportToken)) {
				/* TODO */
			} else if ("omqty".equals(currentImportToken)) {
				/* TODO */
			} else if ("method".equals(currentImportToken)) {
				/* TODO */
			} else if ("qty type".equals(currentImportToken)) {
				/* TODO */
			} else if ("markup type".equals(currentImportToken)) {
				/* TODO */
			} else if ("job qty type".equals(currentImportToken)) {
				/* TODO */
			} else if ("hidden".equals(currentImportToken)) {
				/* TODO */
			} else if ("no overrrides".equals(currentImportToken)) {
				/* TODO */
			} else if ("adjust sets".equals(currentImportToken)) {
				/* TODO */
			} else if ("enter rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("enter material".equals(currentImportToken)) {
				/* TODO */
			} else if ("use material".equals(currentImportToken)) {
				/* TODO */
			} else if ("use rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("use rate sets".equals(currentImportToken)) {
				/* TODO */
			} else if ("use material sets".equals(currentImportToken)) {
				/* TODO */
			} else if ("use setup".equals(currentImportToken)) {
				/* TODO */
			} else if ("use minimum".equals(currentImportToken)) {
				/* TODO */
			} else if ("bindery operation".equals(currentImportToken)) {
				/* TODO */
			} else if ("use colors".equals(currentImportToken)) {
				/* TODO */
			} else if ("use orig".equals(currentImportToken)) {
				/* TODO */
			} else if ("use sigs".equals(currentImportToken)) {
				/* TODO */
			} else if ("rate set count".equals(currentImportToken)) {
				/* TODO */
			} else if ("rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("material rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("minimum".equals(currentImportToken)) {
				/* TODO */
			} else if ("xNotUsed".equals(currentImportToken)) {
				/* TODO */
			} else if ("sku".equals(currentImportToken)) {
				/* TODO */
			} else if ("special".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("xdesc".equals(currentImportToken)) {
				/* TODO */
			} else if ("category id".equals(currentImportToken)) {
				/* TODO */
			} else if ("labels".equals(currentImportToken)) {
				/* TODO */
			} else if ("description custom".equals(currentImportToken)) {
				/* TODO */
			} else if ("expandedShort".equals(currentImportToken)) {
				/* TODO */
			} else if ("obs_tax rate ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("not used byte".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table".equals(currentImportToken)) {
				/* TODO */
			} else if ("customer charge".equals(currentImportToken)) {
				/* TODO */
			} else if ("press charge".equals(currentImportToken)) {
				/* TODO */
			} else if ("deleted preset".equals(currentImportToken)) {
				/* TODO */
			} else if ("ignore cuts".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock charge".equals(currentImportToken)) {
				/* TODO */
			} else if ("o Cut qty".equals(currentImportToken)) {
				/* TODO */
			} else if ("version".equals(currentImportToken)) {
				/* TODO */
			} else if ("sequence".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship method".equals(currentImportToken)) {
				/* TODO */
			} else if ("adjust up count".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra long".equals(currentImportToken)) {
				/* TODO */
			} else if ("has link charge".equals(currentImportToken)) {
				/* TODO */
			} else if ("need link charge".equals(currentImportToken)) {
				/* TODO */
			} else if ("has shipped".equals(currentImportToken)) {
				/* TODO */
			} else if ("should ship".equals(currentImportToken)) {
				/* TODO */
			} else if ("reserve bit 5".equals(currentImportToken)) {
				/* TODO */
			} else if ("hide price".equals(currentImportToken)) {
				/* TODO */
			} else if ("ignore price adj".equals(currentImportToken)) {
				/* TODO */
			} else if ("costing press charge".equals(currentImportToken)) {
				/* TODO */
			} else if ("linear x1".equals(currentImportToken)) {
				/* TODO */
			} else if ("linear x2".equals(currentImportToken)) {
				/* TODO */
			} else if ("linear y1".equals(currentImportToken)) {
				/* TODO */
			} else if ("linear y2".equals(currentImportToken)) {
				/* TODO */
			} else if ("override rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("pricing type".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink coverage type".equals(currentImportToken)) {
				/* TODO */
			} else if ("use sides".equals(currentImportToken)) {
				/* TODO */
			} else if ("noDiscount".equals(currentImportToken)) {
				/* TODO */
			} else if ("no m quant".equals(currentImportToken)) {
				/* TODO */
			} else if ("mat set count".equals(currentImportToken)) {
				/* TODO */
			} else if ("markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("price list".equals(currentImportToken)) {
				/* TODO */
			} else if ("waste chart".equals(currentImportToken)) {
				/* TODO */
			} else if ("fixed waste".equals(currentImportToken)) {
				/* TODO */
			} else if ("waste percent".equals(currentImportToken)) {
				/* TODO */
			} else if ("base linear number".equals(currentImportToken)) {
				/* TODO */
			} else if ("production location ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("production location".equals(currentImportToken)) {
				/* TODO */
			} else if ("cost center ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("cost center".equals(currentImportToken)) {
				/* TODO */
			} else if ("substrate ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("plate substrate".equals(currentImportToken)) {
				/* TODO */
			} else if ("min time".equals(currentImportToken)) {
				/* TODO */
			} else if ("plate size X".equals(currentImportToken)) {
				/* TODO */
			} else if ("plate size".equals(currentImportToken)) {
				/* TODO */
			} else if ("plate size Y".equals(currentImportToken)) {
				/* TODO */
			} else if ("plate thickness".equals(currentImportToken)) {
				/* TODO */
			} else if ("exclude from production".equals(currentImportToken)) {
				/* TODO */
			} else if ("pre production".equals(currentImportToken)) {
				/* TODO */
			} else if ("use min time".equals(currentImportToken)) {
				/* TODO */
			} else if ("use divide up count".equals(currentImportToken)) {
				/* TODO */
			} else if ("use multiply up count".equals(currentImportToken)) {
				/* TODO */
			} else if ("adjust up".equals(currentImportToken)) {
				/* TODO */
			} else if ("cuts are prepress".equals(currentImportToken)) {
				/* TODO */
			} else if ("integrated CTP".equals(currentImportToken)) {
				/* TODO */
			} else if ("new from import".equals(currentImportToken)) {
				/* TODO */
			}
		}
		return contact;
	}
}

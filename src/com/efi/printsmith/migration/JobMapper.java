package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.ModelBase;

public class JobMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		Job job = new Job();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("doc type".equals(currentImportToken)) {
				/* TODO */
			} else if ("order number".equals(currentImportToken)) {
				/* TODO */
			} else if ("job number".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales cat name".equals(currentImportToken)) {
				/* TODO */
			} else if ("press ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("press name".equals(currentImportToken)) {
				/* TODO */
			} else if ("job ticket notes".equals(currentImportToken)) {
				/* TODO */
			} else if ("order qty".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl qty[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl qty[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl qty[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("product code".equals(currentImportToken)) {
				/* TODO */
			} else if ("book id".equals(currentImportToken)) {
				/* TODO */
			} else if ("press".equals(currentImportToken)) {
				/* TODO */
			} else if ("runs".equals(currentImportToken)) {
				/* TODO */
			} else if ("originals".equals(currentImportToken)) {
				/* TODO */
			} else if ("signatures".equals(currentImportToken)) {
				/* TODO */
			} else if ("sets".equals(currentImportToken)) {
				/* TODO */
			} else if ("up".equals(currentImportToken)) {
				/* TODO */
			} else if ("on".equals(currentImportToken)) {
				/* TODO */
			} else if ("runout".equals(currentImportToken)) {
				/* TODO */
			} else if ("pricing method".equals(currentImportToken)) {
				/* TODO */
			} else if ("colors front".equals(currentImportToken)) {
				/* TODO */
			} else if ("colors back".equals(currentImportToken)) {
				/* TODO */
			} else if ("passes front".equals(currentImportToken)) {
				/* TODO */
			} else if ("passes back".equals(currentImportToken)) {
				/* TODO */
			} else if ("wash front".equals(currentImportToken)) {
				/* TODO */
			} else if ("wash back".equals(currentImportToken)) {
				/* TODO */
			} else if ("sheets".equals(currentImportToken)) {
				/* TODO */
			} else if ("waste".equals(currentImportToken)) {
				/* TODO */
			} else if ("impressions".equals(currentImportToken)) {
				/* TODO */
			} else if ("total impressions".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock id".equals(currentImportToken)) {
				/* TODO */
			} else if ("parent X".equals(currentImportToken)) {
				/* TODO */
			} else if ("parent size".equals(currentImportToken)) {
				/* TODO */
			} else if ("parent Y".equals(currentImportToken)) {
				/* TODO */
			} else if ("run X".equals(currentImportToken)) {
				/* TODO */
			} else if ("run size".equals(currentImportToken)) {
				/* TODO */
			} else if ("run Y".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish X".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish size".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish Y".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock cost".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock units".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("material cost".equals(currentImportToken)) {
				/* TODO */
			} else if ("material markup amt".equals(currentImportToken)) {
				/* TODO */
			} else if ("press speed".equals(currentImportToken)) {
				/* TODO */
			} else if ("labor rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("labor markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("setup time".equals(currentImportToken)) {
				/* TODO */
			} else if ("run time".equals(currentImportToken)) {
				/* TODO */
			} else if ("labor cost".equals(currentImportToken)) {
				/* TODO */
			} else if ("labor markup amt".equals(currentImportToken)) {
				/* TODO */
			} else if ("o sets".equals(currentImportToken)) {
				/* TODO */
			} else if ("o overprice".equals(currentImportToken)) {
				/* TODO */
			} else if ("o overunitprice".equals(currentImportToken)) {
				/* TODO */
			} else if ("o runtime".equals(currentImportToken)) {
				/* TODO */
			} else if ("o Setuptime".equals(currentImportToken)) {
				/* TODO */
			} else if ("o stockUnits".equals(currentImportToken)) {
				/* TODO */
			} else if ("o stockMarkup".equals(currentImportToken)) {
				/* TODO */
			} else if ("o stockCost".equals(currentImportToken)) {
				/* TODO */
			} else if ("o Waste".equals(currentImportToken)) {
				/* TODO */
			} else if ("o Prod".equals(currentImportToken)) {
				/* TODO */
			} else if ("o unit".equals(currentImportToken)) {
				/* TODO */
			} else if ("o price".equals(currentImportToken)) {
				/* TODO */
			} else if ("o runout".equals(currentImportToken)) {
				/* TODO */
			} else if ("o labor markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("o labor rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("o aimp".equals(currentImportToken)) {
				/* TODO */
			} else if ("isWeb".equals(currentImportToken)) {
				/* TODO */
			} else if ("workNturn".equals(currentImportToken)) {
				/* TODO */
			} else if ("dutch".equals(currentImportToken)) {
				/* TODO */
			} else if ("grain".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock ordered".equals(currentImportToken)) {
				/* TODO */
			} else if ("tickets printed".equals(currentImportToken)) {
				/* TODO */
			} else if ("finished".equals(currentImportToken)) {
				/* TODO */
			} else if ("brokered".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxable".equals(currentImportToken)) {
				/* TODO */
			} else if ("o pass front".equals(currentImportToken)) {
				/* TODO */
			} else if ("o pass back".equals(currentImportToken)) {
				/* TODO */
			} else if ("noPages".equals(currentImportToken)) {
				/* TODO */
			} else if ("hasCover".equals(currentImportToken)) {
				/* TODO */
			} else if ("hidden".equals(currentImportToken)) {
				/* TODO */
			} else if ("overs".equals(currentImportToken)) {
				/* TODO */
			} else if ("overs unit price".equals(currentImportToken)) {
				/* TODO */
			} else if ("overs price".equals(currentImportToken)) {
				/* TODO */
			} else if ("prep price".equals(currentImportToken)) {
				/* TODO */
			} else if ("prod price".equals(currentImportToken)) {
				/* TODO */
			} else if ("bind price".equals(currentImportToken)) {
				/* TODO */
			} else if ("markup total".equals(currentImportToken)) {
				/* TODO */
			} else if ("prod charge total".equals(currentImportToken)) {
				/* TODO */
			} else if ("add M".equals(currentImportToken)) {
				/* TODO */
			} else if ("unit price".equals(currentImportToken)) {
				/* TODO */
			} else if ("price".equals(currentImportToken)) {
				/* TODO */
			} else if ("total price".equals(currentImportToken)) {
				/* TODO */
			} else if ("description".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock name".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock color".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink front".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink back".equals(currentImportToken)) {
				/* TODO */
			} else if ("notes".equals(currentImportToken)) {
				/* TODO */
			} else if ("location".equals(currentImportToken)) {
				/* TODO */
			} else if ("special".equals(currentImportToken)) {
				/* TODO */
			} else if ("base sets".equals(currentImportToken)) {
				/* TODO */
			} else if ("gripper edge".equals(currentImportToken)) {
				/* TODO */
			} else if ("grip side".equals(currentImportToken)) {
				/* TODO */
			} else if ("folio edge".equals(currentImportToken)) {
				/* TODO */
			} else if ("folio side".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish bleed[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish bleed[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish bleed[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish bleed[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish gutter[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish gutter[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("parent out".equals(currentImportToken)) {
				/* TODO */
			} else if ("cuts run".equals(currentImportToken)) {
				/* TODO */
			} else if ("cuts finish".equals(currentImportToken)) {
				/* TODO */
			} else if ("use grip".equals(currentImportToken)) {
				/* TODO */
			} else if ("use folio".equals(currentImportToken)) {
				/* TODO */
			} else if ("use finish bleed".equals(currentImportToken)) {
				/* TODO */
			} else if ("use finish gutter".equals(currentImportToken)) {
				/* TODO */
			} else if ("use color bar".equals(currentImportToken)) {
				/* TODO */
			} else if ("o run cuts".equals(currentImportToken)) {
				/* TODO */
			} else if ("o finish cuts".equals(currentImportToken)) {
				/* TODO */
			} else if ("o up".equals(currentImportToken)) {
				/* TODO */
			} else if ("o parent out".equals(currentImportToken)) {
				/* TODO */
			} else if ("product code name".equals(currentImportToken)) {
				/* TODO */
			} else if ("costing press id".equals(currentImportToken)) {
				/* TODO */
			} else if ("costing press name".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink front 1".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital que ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("job comment".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink front 2".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink front 3".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink front 4".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink front 5".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink front 6".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink front 7".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink back 2".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink back 3".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink back 4".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink back 5".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink back 6".equals(currentImportToken)) {
				/* TODO */
			} else if ("ink back 7".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital asset 1".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital asset 2".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital asset 3".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital asset 4".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital asset 5".equals(currentImportToken)) {
				/* TODO */
			} else if ("fiery workflow".equals(currentImportToken)) {
				/* TODO */
			} else if ("web notes rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("web notes".equals(currentImportToken)) {
				/* TODO */
			} else if ("cost rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("paper template ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("paper template name".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker route rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker route def".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker total time".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker total time text".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker priority ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock committed".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock consumed".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker location ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker location".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock ordered date".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock ordered time".equals(currentImportToken)) {
				/* TODO */
			} else if ("web component ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking date[16]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracking time[16]".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital submit date".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital submit time".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital start by date".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital start by time".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital run by date".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital run by time".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital completed date".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital completed time".equals(currentImportToken)) {
				/* TODO */
			} else if ("percent complete".equals(currentImportToken)) {
				/* TODO */
			} else if ("jdf submit status".equals(currentImportToken)) {
				/* TODO */
			} else if ("not used byte".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra stock".equals(currentImportToken)) {
				/* TODO */
			} else if ("odd run count".equals(currentImportToken)) {
				/* TODO */
			} else if ("odd sig per run".equals(currentImportToken)) {
				/* TODO */
			} else if ("folded X".equals(currentImportToken)) {
				/* TODO */
			} else if ("folded size".equals(currentImportToken)) {
				/* TODO */
			} else if ("folded Y".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock lot count".equals(currentImportToken)) {
				/* TODO */
			} else if ("run size area".equals(currentImportToken)) {
				/* TODO */
			} else if ("white space[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("white space[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("white space[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("white space[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("across".equals(currentImportToken)) {
				/* TODO */
			} else if ("down".equals(currentImportToken)) {
				/* TODO */
			} else if ("dAcross".equals(currentImportToken)) {
				/* TODO */
			} else if ("dDown".equals(currentImportToken)) {
				/* TODO */
			} else if ("r margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("b margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("t margin".equals(currentImportToken)) {
				/* TODO */
			} else if ("used area".equals(currentImportToken)) {
				/* TODO */
			} else if ("parent area".equals(currentImportToken)) {
				/* TODO */
			} else if ("washup time".equals(currentImportToken)) {
				/* TODO */
			} else if ("pick stock group".equals(currentImportToken)) {
				/* TODO */
			} else if ("pick stock type".equals(currentImportToken)) {
				/* TODO */
			} else if ("pick stock coat".equals(currentImportToken)) {
				/* TODO */
			} else if ("pick stock grade".equals(currentImportToken)) {
				/* TODO */
			} else if ("pick stock generic finish".equals(currentImportToken)) {
				/* TODO */
			} else if ("pick stock generic color".equals(currentImportToken)) {
				/* TODO */
			} else if ("pick stock vendor ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("vender name".equals(currentImportToken)) {
				/* TODO */
			} else if ("pick stock weight".equals(currentImportToken)) {
				/* TODO */
			} else if ("shipping weight".equals(currentImportToken)) {
				/* TODO */
			} else if ("run weight".equals(currentImportToken)) {
				/* TODO */
			} else if ("mQuant".equals(currentImportToken)) {
				/* TODO */
			} else if ("use paper calc up".equals(currentImportToken)) {
				/* TODO */
			} else if ("completed".equals(currentImportToken)) {
				/* TODO */
			} else if ("show notes".equals(currentImportToken)) {
				/* TODO */
			} else if ("oParentSize".equals(currentImportToken)) {
				/* TODO */
			} else if ("price locked".equals(currentImportToken)) {
				/* TODO */
			} else if ("o bind waste".equals(currentImportToken)) {
				/* TODO */
			} else if ("copier side adjust".equals(currentImportToken)) {
				/* TODO */
			} else if ("use white space".equals(currentImportToken)) {
				/* TODO */
			} else if ("is crouser".equals(currentImportToken)) {
				/* TODO */
			} else if ("run & tumble".equals(currentImportToken)) {
				/* TODO */
			} else if ("obs_tax in price".equals(currentImportToken)) {
				/* TODO */
			} else if ("dutch bottom".equals(currentImportToken)) {
				/* TODO */
			} else if ("finish".equals(currentImportToken)) {
				/* TODO */
			} else if ("back trim parent".equals(currentImportToken)) {
				/* TODO */
			} else if ("back trim run".equals(currentImportToken)) {
				/* TODO */
			} else if ("diagram on job".equals(currentImportToken)) {
				/* TODO */
			} else if ("digital submitted".equals(currentImportToken)) {
				/* TODO */
			} else if ("work & turn new".equals(currentImportToken)) {
				/* TODO */
			} else if ("override washup time".equals(currentImportToken)) {
				/* TODO */
			} else if ("production release".equals(currentImportToken)) {
				/* TODO */
			} else if ("attach routing list".equals(currentImportToken)) {
				/* TODO */
			} else if ("use booklet total clicks".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock is inventoried".equals(currentImportToken)) {
				/* TODO */
			} else if ("inventory consumed by Tracker".equals(currentImportToken)) {
				/* TODO */
			} else if ("web adjusted price".equals(currentImportToken)) {
				/* TODO */
			} else if ("o Qty Ordered".equals(currentImportToken)) {
				/* TODO */
			} else if ("is Print Job".equals(currentImportToken)) {
				/* TODO */
			} else if ("is Copy Job".equals(currentImportToken)) {
				/* TODO */
			} else if ("is large format".equals(currentImportToken)) {
				/* TODO */
			} else if ("is Roll Job".equals(currentImportToken)) {
				/* TODO */
			} else if ("est has mult qty".equals(currentImportToken)) {
				/* TODO */
			} else if ("est selected multi qty version".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table name".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax code ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax code name".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax code".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity".equals(currentImportToken)) {
				/* TODO */
			} else if ("price".equals(currentImportToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity".equals(currentImportToken)) {
				/* TODO */
			} else if ("price".equals(currentImportToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentImportToken)) {
				/* TODO */
			} else if ("quantity".equals(currentImportToken)) {
				/* TODO */
			} else if ("price".equals(currentImportToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentImportToken)) {
				/* TODO */
			} else if ("target price".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl price[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl price[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl price[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl tax[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl tax[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl tax[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax sub".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax".equals(currentImportToken)) {
				/* TODO */
			}
		}
		return job;
	}
}

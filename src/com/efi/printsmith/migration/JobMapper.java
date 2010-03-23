package com.efi.printsmith.migration;

import java.io.File;

import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.Location;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.service.DataService;

public class JobMapper extends ImportMapper {
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		DataService dataService = new DataService();
		Job job = new Job();
		SalesCategory salesCategory = null;
		boolean addSalesCategory = false;
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			
			if ("recno".equals(currentFieldToken)) {
				job.setPrevId(currentImportToken);
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("doc type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order number".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job number".equals(currentFieldToken)) {
				job.setJobNumber(currentImportToken);
			} else if ("sales category".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					salesCategory = (SalesCategory)dataService.getByPrevId("SalesCategory", currentImportToken);
					if (salesCategory != null)
						job.setSalesCategory(salesCategory);
					else {
						salesCategory = new SalesCategory();
						salesCategory.setPrevId(currentImportToken);
						addSalesCategory = true;
					}
				}	
			} else if ("sales cat name".equals(currentFieldToken)) {
				if (addSalesCategory == true) {
					salesCategory.setName(currentImportToken);
					salesCategory = (SalesCategory)dataService.addUpdate(salesCategory);
					salesCategory.setId(salesCategory.getId());
					job.setSalesCategory(salesCategory);
				}
			} else if ("press ID".equals(currentFieldToken)) {
				PressDefinition pressDefinition = (PressDefinition) dataService.getByPressId(currentImportToken);
				if (pressDefinition != null)
					job.setPress(pressDefinition);
			} else if ("press name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job ticket notes".equals(currentFieldToken)) {
				job.setJobTicketNotes(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("order qty".equals(currentFieldToken)) {
				job.setQtyOrdered(Utilities.tokenToLong(currentImportToken));
			} else if ("addl qty[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl qty[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl qty[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("product code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("book id".equals(currentFieldToken)) {
				/* TODO */
			} else if ("press".equals(currentFieldToken)) {
				/* TODO */
			} else if ("runs".equals(currentFieldToken)) {
				/* TODO */
			} else if ("originals".equals(currentFieldToken)) {
				/* TODO */
			} else if ("signatures".equals(currentFieldToken)) {
				job.setSignatures(Utilities.tokenToLong(currentImportToken));
			} else if ("sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("up".equals(currentFieldToken)) {
				job.setNumUp(Utilities.tokenToLong(currentImportToken));
			} else if ("on".equals(currentFieldToken)) {
				job.setNumOn(Utilities.tokenToLong(currentImportToken));
			} else if ("runout".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pricing method".equals(currentFieldToken)) {
				/* TODO */
			} else if ("colors front".equals(currentFieldToken)) {
				job.setFrontColors(Utilities.tokenToInt(currentImportToken));
			} else if ("colors back".equals(currentFieldToken)) {
				job.setBackColors(Utilities.tokenToInt(currentImportToken));
			} else if ("passes front".equals(currentFieldToken)) {
				job.setFrontPasses(Utilities.tokenToInt(currentImportToken));
			} else if ("passes back".equals(currentFieldToken)) {
				job.setBackPasses(Utilities.tokenToInt(currentImportToken));
			} else if ("wash front".equals(currentFieldToken)) {
				job.setFrontWashes(Utilities.tokenToInt(currentImportToken));
			} else if ("wash back".equals(currentFieldToken)) {
				job.setBackWashes(Utilities.tokenToInt(currentImportToken));
			} else if ("sheets".equals(currentFieldToken)) {
				job.setSheets(Utilities.tokenToLong(currentImportToken));
			} else if ("waste".equals(currentFieldToken)) {
				/* TODO */
			} else if ("impressions".equals(currentFieldToken)) {
				/* TODO */
			} else if ("total impressions".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock id".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false && currentImportToken.equals("0") == false) {
					StockDefinition stockDefinition = dataService.getByStockId(currentImportToken);
					if (stockDefinition != null) {
						job.setStock(stockDefinition);
					}
				}
			} else if ("parent X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("parent size".equals(currentFieldToken)) {
				job.setParentSize(currentImportToken);
			} else if ("parent Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run size".equals(currentFieldToken)) {
				job.setRunSize(currentImportToken);
			} else if ("run Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish size".equals(currentFieldToken)) {
				job.setFinishSize(currentImportToken);
			} else if ("finish Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock cost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock units".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock markup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("material cost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("material markup amt".equals(currentFieldToken)) {
				/* TODO */
			} else if ("press speed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labor rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labor markup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("setup time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labor cost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labor markup amt".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o overprice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o overunitprice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o runtime".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o Setuptime".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o stockUnits".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o stockMarkup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o stockCost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o Waste".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o Prod".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o unit".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o runout".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o labor markup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o labor rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o aimp".equals(currentFieldToken)) {
				/* TODO */
			} else if ("isWeb".equals(currentFieldToken)) {
				/* TODO */
			} else if ("workNturn".equals(currentFieldToken)) {
				/* TODO */
			} else if ("dutch".equals(currentFieldToken)) {
				/* TODO */
			} else if ("grain".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock ordered".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tickets printed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finished".equals(currentFieldToken)) {
				job.setFinished(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("brokered".equals(currentFieldToken)) {
				job.setBrokered(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("taxable".equals(currentFieldToken)) {
				job.setTaxable(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o pass front".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o pass back".equals(currentFieldToken)) {
				/* TODO */
			} else if ("noPages".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hasCover".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hidden".equals(currentFieldToken)) {
				/* TODO */
			} else if ("overs".equals(currentFieldToken)) {
				job.setOversUnders(Utilities.tokenToLong(currentImportToken));
			} else if ("overs unit price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("overs price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("prep price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("prod price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("bind price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("markup total".equals(currentFieldToken)) {
				/* TODO */
			} else if ("prod charge total".equals(currentFieldToken)) {
				/* TODO */
			} else if ("add M".equals(currentFieldToken)) {
				/* TODO */
			} else if ("unit price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("total price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("description".equals(currentFieldToken)) {
				job.setDescription(currentImportToken);
			} else if ("stock name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock color".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back".equals(currentFieldToken)) {
				/* TODO */
			} else if ("notes".equals(currentFieldToken)) {
				job.setJobNotes(currentImportToken);
			} else if ("location".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					Location location = dataService
							.getByLocationName(currentImportToken);
					if (location == null) {
						location = new Location();
						location.setName(currentImportToken);
						location = (Location)dataService.addUpdate(location);
						location.setId(location.getId());
					}
					job.setLocation(location);
				}
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("base sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("gripper edge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("grip side".equals(currentFieldToken)) {
				/* TODO */
			} else if ("folio edge".equals(currentFieldToken)) {
				/* TODO */
			} else if ("folio side".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish bleed[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish bleed[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish bleed[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish bleed[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish gutter[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish gutter[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("parent out".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cuts run".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cuts finish".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use grip".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use folio".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use finish bleed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use finish gutter".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use color bar".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o run cuts".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o finish cuts".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o up".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o parent out".equals(currentFieldToken)) {
				/* TODO */
			} else if ("product code name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("costing press id".equals(currentFieldToken)) {
				/* TODO */
			} else if ("costing press name".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					PressDefinition pressDefinition = dataService.getByPressId(currentImportToken);
					if (pressDefinition != null)
						job.setCostingPress(pressDefinition);
				}
			} else if ("ink front 1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital que ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job comment".equals(currentFieldToken)) {
				job.setComment(currentImportToken);
			} else if ("ink front 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 6".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 7".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 6".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 7".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("fiery workflow".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web notes rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web notes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cost rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("paper template ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("paper template name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker route rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker route def".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker total time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker total time text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker priority ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock committed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock consumed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker location ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker location".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock ordered date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock ordered time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web component ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[16]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[16]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital submit date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital submit time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital start by date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital start by time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital run by date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital run by time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital completed date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital completed time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("percent complete".equals(currentFieldToken)) {
				/* TODO */
			} else if ("jdf submit status".equals(currentFieldToken)) {
				/* TODO */
			} else if ("not used byte".equals(currentFieldToken)) {
				/* TODO */
			} else if ("extra stock".equals(currentFieldToken)) {
				/* TODO */
			} else if ("odd run count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("odd sig per run".equals(currentFieldToken)) {
				/* TODO */
			} else if ("folded X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("folded size".equals(currentFieldToken)) {
				/* TODO */
			} else if ("folded Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock lot count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run size area".equals(currentFieldToken)) {
				/* TODO */
			} else if ("white space[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("white space[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("white space[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("white space[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("across".equals(currentFieldToken)) {
				/* TODO */
			} else if ("down".equals(currentFieldToken)) {
				/* TODO */
			} else if ("dAcross".equals(currentFieldToken)) {
				/* TODO */
			} else if ("dDown".equals(currentFieldToken)) {
				/* TODO */
			} else if ("r margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("b margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("t margin".equals(currentFieldToken)) {
				/* TODO */
			} else if ("used area".equals(currentFieldToken)) {
				/* TODO */
			} else if ("parent area".equals(currentFieldToken)) {
				/* TODO */
			} else if ("washup time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock group".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock coat".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock grade".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock generic finish".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock generic color".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock vendor ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("vender name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock weight".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shipping weight".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run weight".equals(currentFieldToken)) {
				/* TODO */
			} else if ("mQuant".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use paper calc up".equals(currentFieldToken)) {
				/* TODO */
			} else if ("completed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("show notes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("oParentSize".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price locked".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o bind waste".equals(currentFieldToken)) {
				/* TODO */
			} else if ("copier side adjust".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use white space".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is crouser".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run & tumble".equals(currentFieldToken)) {
				/* TODO */
			} else if ("obs_tax in price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("dutch bottom".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish".equals(currentFieldToken)) {
				/* TODO */
			} else if ("back trim parent".equals(currentFieldToken)) {
				/* TODO */
			} else if ("back trim run".equals(currentFieldToken)) {
				/* TODO */
			} else if ("diagram on job".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital submitted".equals(currentFieldToken)) {
				/* TODO */
			} else if ("work & turn new".equals(currentFieldToken)) {
				/* TODO */
			} else if ("override washup time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("production release".equals(currentFieldToken)) {
				/* TODO */
			} else if ("attach routing list".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use booklet total clicks".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock is inventoried".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inventory consumed by Tracker".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web adjusted price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o Qty Ordered".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is Print Job".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is Copy Job".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is large format".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is Roll Job".equals(currentFieldToken)) {
				/* TODO */
			} else if ("est has mult qty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("est selected multi qty version".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("target price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl price[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl price[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl price[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax sub".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		return job;
	}
}

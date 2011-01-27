package com.efi.printsmith.migration;


import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.StockChange;
import com.efi.printsmith.service.DataService;

import java.io.File;

import org.apache.log4j.Logger;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
public class StockChangeMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(StockChangeMapper.class);
	public void importFile(File uploadedFile) throws Exception {
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering StockChangeMapper->importTokens");
		StockChange stockChanges = new StockChange();
		DataService dataService = new DataService();
		StockDefinition stocktemp = null;
		StockDefinition stockDefinition = null;
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			System.out.println(currentFieldToken + ": " + currentImportToken);
			
			if (currentFieldToken.equals("recno") == true) {
				stockChanges.setPrevId(currentImportToken);
			} else if (currentFieldToken.equals("user name") == true) {
				stockChanges.setPSUser(currentImportToken);
			} else if (currentFieldToken.equals("date stamp") == true) {
				stockChanges.setStockChangeDate(Utilities.tokenToDate(currentImportToken));
			} else if (currentFieldToken.equals("stock id") == true) {
				stocktemp = (StockDefinition)dataService.getByPrevId("StockDefinition", currentImportToken);
				if (stocktemp != null)
					stockDefinition= (StockDefinition)dataService.getStockDefinition(stocktemp.getId());
				if ( stockDefinition != null)
					stockChanges.setStockDefinition(stockDefinition);
			} else if (currentFieldToken.equals("reason code") == true) {
				if (currentImportToken.equals("1") == true)
					stockChanges.setHowChanged("Consumed");
				else if (currentImportToken.equals("2") == true)
					stockChanges.setHowChanged("Stock Committed");
				else if (currentImportToken.equals("3") == true)
					stockChanges.setHowChanged("Replenished");
				else if (currentImportToken.equals("4") == true)
					stockChanges.setHowChanged("Manually Changed");
				else if (currentImportToken.equals("5") == true)
					stockChanges.setHowChanged("Stock changed on job");
				else if (currentImportToken.equals("6") == true)
					stockChanges.setHowChanged("Invoice cancelled");
				else if (currentImportToken.equals("7") == true)
					stockChanges.setHowChanged("Job deleted");
				else if (currentImportToken.equals("8") == true)
					stockChanges.setHowChanged("Revert committed amount");
				else if (currentImportToken.equals("9") == true)
					stockChanges.setHowChanged("Stock consumed - step completed");
				else if (currentImportToken.equals("10") == true)
					stockChanges.setHowChanged("Order recieved");
				else if (currentImportToken.equals("11") == true)
					stockChanges.setHowChanged("Stock ordered");
				else if (currentImportToken.equals("12") == true)
					stockChanges.setHowChanged("Order deleted");
				else if (currentImportToken.equals("13") == true)
					stockChanges.setHowChanged("Order changed");
				else if (currentImportToken.equals("14") == true)
					stockChanges.setHowChanged("Job picked up");
				else if (currentImportToken.equals("15") == true)
					stockChanges.setHowChanged("Transaction voided on tape");
			} else if (currentFieldToken.equals("qty change") == true) {
				stockChanges.setQuantity(Utilities.tokenToInt(currentImportToken));
			} else if (currentFieldToken.equals("document number") == true) {
				/* TODO */
			} else if (currentFieldToken.equals("document type") == true) {
				/* TODO */
			} else if (currentFieldToken.equals("filler") == true) {
				/* TODO */
			} else if (currentFieldToken.equals("expand long") == true) {
				/* TODO */
			} else if (currentFieldToken.equals("expand short") == true) {
				/* TODO */
			}
		}
		stockChanges = (StockChange)dataService.addUpdate(stockChanges);
		stockChanges.setId(stockChanges.getId());
		if (stockDefinition != null) {
			stockDefinition.addStockChanges(stockChanges);
			dataService.addUpdate(stockDefinition);
		}
		log.info("Entering StockChangeMapper->importTokens");
		return null;
	}
}
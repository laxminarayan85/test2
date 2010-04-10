package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CustomerLog;
import com.efi.printsmith.data.ModelBase;

public class CustomerLogMapper extends ImportMapper{
	protected static Logger log = Logger.getLogger(CustomerLogMapper.class);

	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering CustomerLogMapper->importTokens");
		CustomerLog customerLog = new CustomerLog();
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("acct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("account name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user".equals(currentFieldToken)) {
				/* TODO */
			} else if ("data".equals(currentFieldToken)) {
				/* TODO */		
			}
		}
		log.info("Leaving CustomerLogMapper->importTokens");
		return customerLog;
	}
}

package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.CustomerLog;
import com.efi.printsmith.data.ModelBase;

public class CustomerLogMapper extends ImportMapper{
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		CustomerLog customerLog = new CustomerLog();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("acct".equals(currentImportToken)) {
				/* TODO */
			} else if ("account name".equals(currentImportToken)) {
				/* TODO */
			} else if ("date".equals(currentImportToken)) {
				/* TODO */
			} else if ("user".equals(currentImportToken)) {
				/* TODO */
			} else if ("data".equals(currentImportToken)) {
				/* TODO */		
			}
		}
		return customerLog;
	}
}

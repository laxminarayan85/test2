package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.CustomerLog;
import com.efi.printsmith.data.ModelBase;

public class CustomerLogMapper extends ImportMapper{
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
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
		return customerLog;
	}
}

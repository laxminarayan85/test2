package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

public class EstimateHistoryMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(EstimateHistoryMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering EstimateHistoryMapper->importTokens");
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("title".equals(currentImportToken)) {
				/* TODO */
			} else if ("custno".equals(currentImportToken)) {
				/* TODO */
			} else if ("account name".equals(currentImportToken)) {
				/* TODO */
			} else if ("ordno".equals(currentImportToken)) {
				/* TODO */
			} else if ("order display no".equals(currentImportToken)) {
				/* TODO */
			} else if ("notes pointer".equals(currentImportToken)) {
				/* TODO */
			} else if ("notes text".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand1 ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand2 ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand3 ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("inv won ordno".equals(currentImportToken)) {
				/* TODO */
			} else if ("date est created".equals(currentImportToken)) {
				/* TODO */
			} else if ("date removed".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand1 date".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand2 date".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand3 date".equals(currentImportToken)) {
				/* TODO */
			} else if ("inv won date".equals(currentImportToken)) {
				/* TODO */
			} else if ("total".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand double".equals(currentImportToken)) {
				/* TODO */
			} else if ("won".equals(currentImportToken)) {
				/* TODO */
			} else if ("lost".equals(currentImportToken)) {
				/* TODO */
			} else if ("converted".equals(currentImportToken)) {
				/* TODO */
			} else if ("voided".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp3".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp4".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp5".equals(currentImportToken)) {
				/* TODO */
			} else if ("exp6".equals(currentImportToken)) {
				/* TODO */
			} else if ("flags".equals(currentImportToken)) {
				/* TODO */
			} else if ("user name".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand string".equals(currentImportToken)) {
				/* TODO */
			}
		}
		log.info("Leaving EstimateHistoryMapper->importTokens");
		return null; /*TODO: FIX THIS!!! */
	}
}

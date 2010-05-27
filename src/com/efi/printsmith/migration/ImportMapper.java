package com.efi.printsmith.migration;

import java.io.File;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

abstract class ImportMapper {
	abstract public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception;
	abstract public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) throws Exception;
	abstract public void importFile(File file) throws Exception;
}

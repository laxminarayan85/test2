package com.efi.printsmith.migration;

import java.io.File;
import com.efi.printsmith.data.ModelBase;

abstract class ImportMapper {
	abstract public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception;
	abstract public void importFile(File file) throws Exception;
}

package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.ModelBase;

abstract class ImportMapper {
	abstract public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception;
}

package com.efi.printsmith.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

	public static String getExceptionStackTraceAsString(Exception exception) {
		StringWriter sw = new StringWriter();
		exception.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

}

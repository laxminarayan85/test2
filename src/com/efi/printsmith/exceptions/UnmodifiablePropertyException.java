package com.efi.printsmith.exceptions;

import com.efi.printsmith.data.ModelBase;

public class UnmodifiablePropertyException extends PropertyException {

	private static final long serialVersionUID = -659999858625789726L;

	public UnmodifiablePropertyException(Class<? extends ModelBase> parentClass, String property) {
		super(parentClass, property);
	}
}

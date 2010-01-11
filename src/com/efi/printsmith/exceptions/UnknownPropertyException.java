package com.efi.printsmith.exceptions;

import com.efi.printsmith.data.ModelBase;

public class UnknownPropertyException extends PropertyException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownPropertyException(Class<? extends ModelBase> parentClass, String property) {
		super(parentClass, property); 
	}
	
	@Override
	public String toString() {
		return "Unknown property, " + getProperty() + ", in class " + getParentClass();
	}
}
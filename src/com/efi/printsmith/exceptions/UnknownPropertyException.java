package com.efi.printsmith.exceptions;

import com.efi.printsmith.data.ModelBase;

public class UnknownPropertyException extends PropertyException {
	
	public UnknownPropertyException(Class<? extends ModelBase> parentClass, String property) {
		super(parentClass, property); 
	}
	
	@Override
	public String toString() {
		return "Unknown property, " + getProperty() + ", in class " + getParentClass();
	}
}
package com.efi.printsmith.exceptions;

import com.efi.printsmith.data.ModelBase;

public abstract class PropertyException extends Exception {
	
	public PropertyException(Class<? extends ModelBase> parentClass, String property) {
		this.parentClass = parentClass;
		this.property = property;
	}

	protected Class<? extends ModelBase> parentClass;
	public Class<? extends ModelBase> getParentClass() {
		return parentClass;
	}

	protected String property;
	public String getProperty() {
		return property;
	}

}
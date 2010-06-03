package com.efi.printsmith.data.paramdata;

import java.util.Date;

public class LogFile {
	public String name = "";
	public Date modified;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
}
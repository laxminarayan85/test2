package com.efi.printsmith.data;

import java.util.List;

public class PickerObject {
	String title;
	Long id;
	List<PickerObject> children;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<PickerObject> getChildren() {
		return children;
	}
	public void setChildren(List<PickerObject> children) {
		this.children = children;
	}
	public PickerObject(String title, Long id) {
		super();
		this.title = title;
		this.id = id;
	}
}

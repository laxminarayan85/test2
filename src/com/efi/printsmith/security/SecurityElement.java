package com.efi.printsmith.security;

public class SecurityElement {
	CommandId commandId = null;
	ElementType elementType = null;
	
	public CommandId getCommandId() {
		return commandId;
	}
	public void setCommandId(CommandId commandId) {
		this.commandId = commandId;
	}
	public ElementType getElementType() {
		return elementType;
	}
	public void setElementType(ElementType elementType) {
		this.elementType = elementType;
	}
}

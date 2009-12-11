package com.efi.printsmith.messaging;

import com.efi.printsmith.data.ModelBase;

public class MessageBody {
	String id;
	String messageType;
	String payloadType;
	Object payload;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getPayloadType() {
		return payloadType;
	}
	public void setPayloadType(String payloadType) {
		this.payloadType = payloadType;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
}

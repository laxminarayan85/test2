package com.efi.printsmith.messaging;

import flex.messaging.MessageBroker;
import flex.messaging.messages.AsyncMessage; 
import flex.messaging.messages.Message; 
import flex.messaging.services.MessageService; 
import flex.messaging.services.ServiceAdapter; 
import flex.messaging.util.UUIDUtils;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.messaging.MessageBody;

public class MessageServiceAdapter extends ServiceAdapter {
	static public void sendNotification(String messageType, String payloadType, Object body) {
		MessageBroker messageBroker = MessageBroker.getMessageBroker(null);
		if (messageBroker == null) return;
		AsyncMessage msg = new AsyncMessage();
		msg.setDestination("notifications");
		msg.setClientId(UUIDUtils.createUUID());
		msg.setMessageId(UUIDUtils.createUUID());
		
		MessageBody messageBody = new MessageBody();
		
		messageBody.setId("0");
		messageBody.setMessageType(messageType);
		messageBody.setPayloadType(payloadType); 
		messageBody.setPayload(body);
		msg.setBody(messageBody);
		messageBroker.routeMessageToService(msg, null);
	}
	
	public Object invoke(Message message) {
		 AsyncMessage newMessage = (AsyncMessage) message; 
		 MessageService msgService = (MessageService) getDestination().getService(); 
		 msgService.pushMessageToClients(newMessage, false); 
		 return null; 
	} 

}

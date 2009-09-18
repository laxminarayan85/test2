package com.efi.printsmith.messaging;

import flex.messaging.MessageBroker;
import flex.messaging.messages.AsyncMessage; 
import flex.messaging.messages.Message; 
import flex.messaging.services.MessageService; 
import flex.messaging.services.ServiceAdapter; 
import flex.messaging.util.UUIDUtils;

import com.efi.printsmith.messaging.MessageBody;

public class MessageServiceAdapter extends ServiceAdapter {
	static public void sendNotification(String message) {
		MessageBroker messageBroker = MessageBroker.getMessageBroker(null);
		AsyncMessage msg = new AsyncMessage();
		msg.setDestination("notifications");
		msg.setClientId(UUIDUtils.createUUID());
		msg.setMessageId(UUIDUtils.createUUID());
//		MessageBody messageBody = new MessageBody();
//		
//		messageBody.setId("12345");
//		messageBody.setMessageType("MessageType");
//		messageBody.setPayload(message);
		msg.setBody("12345");
		messageBroker.routeMessageToService(msg, null);
	}
	
	 public Object invoke(Message message) {
		 AsyncMessage newMessage = (AsyncMessage) message; 
		 newMessage.setBody(" "); 
		 MessageService msgService = (MessageService) getDestination().getService(); 
		 msgService.pushMessageToClients(newMessage, false); 
		 return null; 
	} 

}

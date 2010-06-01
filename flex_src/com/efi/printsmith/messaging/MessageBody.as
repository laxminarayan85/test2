package com.efi.printsmith.messaging
{
	[RemoteClass(alias="com.efi.printsmith.messaging.MessageBody")]
	public class MessageBody
	{
		public function MessageBody()
		{
		}
		public var id:String;
		public var messageType:String;
		public var payloadType:String;
		public var payload:Object;
	}
}
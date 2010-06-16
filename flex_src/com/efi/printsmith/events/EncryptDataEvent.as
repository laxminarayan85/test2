package com.efi.printsmith.events
{
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class EncryptDataEvent extends EventBase
	{
		public static const ENCRYPTDATA:String = "EncryptData";
		public static const DECRYPTDATA:String = "DecryptData";
		public var encryptionData:String;
		public var encryptionStyle:String;
		
		public function EncryptDataEvent(type:String, encryptionData:String, encryptionStyle:String, callbacks:IResponder=null)
		{
			super(type, callbacks);
			this.encryptionData = encryptionData;
			this.encryptionStyle = encryptionStyle;
		}
		
		override public function clone():Event {
			return new EncryptDataEvent(type, encryptionData, encryptionStyle, callbacks);
		}
	}
}
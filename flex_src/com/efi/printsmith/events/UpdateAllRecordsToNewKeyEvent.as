package com.efi.printsmith.events
{	
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class UpdateAllRecordsToNewKeyEvent extends EventBase
	{
		public static const UPDATEALLRECORDSTONEWKEY:String = "UpdateAllRecordsToNewKey";
		public static const PURGEENCRYPTEDDATAFIELDS:String = "PurgeEncryptedDataFields";
				
		public function UpdateAllRecordsToNewKeyEvent(type:String, callbacks:IResponder=null)
		{
			super(type, callbacks);
		}
		
		override public function clone():Event {
			return new UpdateAllRecordsToNewKeyEvent(type, callbacks);
		}
	}
}
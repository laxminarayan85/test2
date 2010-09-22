package com.efi.printsmith.events
{
	import com.efi.printsmith.data.CreditCardTransactions;
	
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class EncryptCCTransEvent extends EventBase
	{
		public static const ENCRYPTCCTRANS:String = "EncryptCCTransaction";
		public static const DECRYPTCCTRANS:String = "DecryptCCTransaction";
		
		public var cct:CreditCardTransactions;
		
		public function EncryptCCTransEvent(type:String, cct:CreditCardTransactions, callbacks:IResponder=null)
		{
			super(type, callbacks);
			this.cct = cct;
		}
		
		override public function clone():Event {
			return new EncryptCCTransEvent(type, cct, callbacks);
		}
	}
}
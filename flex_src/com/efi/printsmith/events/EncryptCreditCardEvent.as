package com.efi.printsmith.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;

	public class EncryptCreditCardEvent extends EventBase
	{
		public static const ENCRYPTCC:String = "EncryptCC";
		public var cardNumber:String;
		
		public function EncryptCreditCardEvent(cardNumber:String, callbacks:IResponder=null)
		{
			super(ENCRYPTCC, callbacks);
			this.cardNumber = cardNumber;
		}
		
		override public function clone():Event {
			return new EncryptCreditCardEvent(cardNumber, callbacks);
		}
	}
}
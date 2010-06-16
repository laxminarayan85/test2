package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.EncryptCreditCardDelegate;
	import com.efi.printsmith.events.EncryptCreditCardEvent;
	import com.efi.printsmith.model.ModelLocator;
	
	import mx.rpc.IResponder;
	
	public class EncryptCreditCardCommand implements ICommand {
		public var modelLocator:ModelLocator = ModelLocator.getInstance();

		public function EncryptCreditCardCommand() {
		}

		public function execute(event:CairngormEvent):void{
			var encryptEvent:EncryptCreditCardEvent = event as EncryptCreditCardEvent;
			var delegate:EncryptCreditCardDelegate = new EncryptCreditCardDelegate(encryptEvent.callbacks);
			delegate.encryptCreditCard(encryptEvent.cardNumber);
		}
	}
}

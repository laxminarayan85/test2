package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.EncryptDataDelegate;
	import com.efi.printsmith.events.EncryptDataEvent;
	import com.efi.printsmith.model.ModelLocator;
	
	import mx.rpc.IResponder;
	
	public class EncryptDataCommand implements ICommand {
		public var modelLocator:ModelLocator = ModelLocator.getInstance();

		public function EncryptDataCommand() {
		}

		public function execute(event:CairngormEvent):void{
			var encryptEvent:EncryptDataEvent = event as EncryptDataEvent;
			var delegate:EncryptDataDelegate = new EncryptDataDelegate(encryptEvent.callbacks);
			if (encryptEvent.type == EncryptDataEvent.ENCRYPTDATA) {
				delegate.encryptData(encryptEvent.encryptionData, encryptEvent.encryptionStyle);
			} else if (encryptEvent.type == EncryptDataEvent.DECRYPTDATA) {
				delegate.decryptData(encryptEvent.encryptionData, encryptEvent.encryptionStyle);
			}
		}
	}
}

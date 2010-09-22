package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.EncryptCCTDelegate;
	import com.efi.printsmith.events.EncryptCCTransEvent;
	import com.efi.printsmith.model.ModelLocator;
	
	import mx.rpc.IResponder;
	
	public class EncryptCCTCommand implements ICommand {
		public var modelLocator:ModelLocator = ModelLocator.getInstance();

		public function EncryptCCTCommand() {
		}

		public function execute(event:CairngormEvent):void{
			var encryptEvent:EncryptCCTransEvent = event as EncryptCCTransEvent;
			var delegate:EncryptCCTDelegate = new EncryptCCTDelegate(encryptEvent.callbacks);
			
			if (encryptEvent.type == EncryptCCTransEvent.ENCRYPTCCTRANS) {
				delegate.encryptCCT(encryptEvent.cct);
			} else if (encryptEvent.type == EncryptCCTransEvent.DECRYPTCCTRANS) {
				delegate.decryptCCT(encryptEvent.cct);
			}
		}
	}
}

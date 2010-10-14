package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.UpdateAllRecordsToNewKeyDelegate;
	import com.efi.printsmith.events.UpdateAllRecordsToNewKeyEvent;
	import com.efi.printsmith.model.ModelLocator;
	
	import mx.rpc.IResponder;
	
	public class UpdateAllRecordsToNewKeyCommand implements ICommand {
		public var modelLocator:ModelLocator = ModelLocator.getInstance();

		public function UpdateAllRecordsToNewKeyCommand() {
		}

		public function execute(event:CairngormEvent):void{
			var encryptEvent:UpdateAllRecordsToNewKeyEvent = event as UpdateAllRecordsToNewKeyEvent;
			var delegate:UpdateAllRecordsToNewKeyDelegate = new UpdateAllRecordsToNewKeyDelegate(encryptEvent.callbacks);
			
			if (encryptEvent.type == UpdateAllRecordsToNewKeyEvent.UPDATEALLRECORDSTONEWKEY) {
				delegate.UpdateAllRecordsToNewKey();
			} else if (encryptEvent.type == UpdateAllRecordsToNewKeyEvent.PURGEENCRYPTEDDATAFIELDS) {
				delegate.PurgeEncryptedDataFields();
			}
		}
	}
}

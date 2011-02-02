package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.VerifyRecievedBalanceEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.VerifyRecievedBalanceDelegate;
	
	public class VerifyRecievedBalanceCommand implements ICommand
	{
		public function VerifyRecievedBalanceCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var eventTemp:VerifyRecievedBalanceEvent = event as VerifyRecievedBalanceEvent;
			var delegate:VerifyRecievedBalanceDelegate = new VerifyRecievedBalanceDelegate(eventTemp.callbacks);
			
			delegate.handleUIEvent(eventTemp);
		}
		
	}
}
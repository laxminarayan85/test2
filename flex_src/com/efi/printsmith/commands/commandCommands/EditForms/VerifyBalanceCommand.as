package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.VerifyBalanceEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.VerifyBalanceDelegate;
	
	public class VerifyBalanceCommand implements ICommand
	{
		public function VerifyBalanceCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var eventTemp:VerifyBalanceEvent = event as VerifyBalanceEvent;
			var delegate:VerifyBalanceDelegate = new VerifyBalanceDelegate(eventTemp.callbacks);
			
			delegate.handleUIEvent(eventTemp);
		}
		
	}
}
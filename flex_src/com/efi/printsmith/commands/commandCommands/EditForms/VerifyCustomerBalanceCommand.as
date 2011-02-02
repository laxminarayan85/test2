package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.VerifyCustomerBalanceEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.VerifyCustomerBalanceDelegate;
	
	public class VerifyCustomerBalanceCommand implements ICommand
	{
		public function VerifyCustomerBalanceCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var eventTemp:VerifyCustomerBalanceEvent = event as VerifyCustomerBalanceEvent;
			var delegate:VerifyCustomerBalanceDelegate = new VerifyCustomerBalanceDelegate(eventTemp.callbacks);
			
			delegate.handleUIEvent(eventTemp);
		}
		
	}
}
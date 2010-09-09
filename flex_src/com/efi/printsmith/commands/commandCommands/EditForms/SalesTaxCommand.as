package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.SalesTaxEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.SalesTaxDelegate;
	
	public class SalesTaxCommand implements ICommand
	{
		public function SalesTaxCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var salesTaxEvent:SalesTaxEvent = event as SalesTaxEvent;
			var delegate:SalesTaxDelegate = new SalesTaxDelegate(salesTaxEvent.callbacks);
			
			delegate.handleUIEvent(salesTaxEvent);
		}
		
	}
}
package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.OrderStockEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.OrderStockDelegate;
	
	public class OrderStockCommand implements ICommand
	{
		public function OrderStockCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var orderStockEvent:OrderStockEvent = event as OrderStockEvent;
			var delegate:OrderStockDelegate = new OrderStockDelegate(orderStockEvent.callbacks);
			
			delegate.handleUIEvent(orderStockEvent);
		}
		
	}
}
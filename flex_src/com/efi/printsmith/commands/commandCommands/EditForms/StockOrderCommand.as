package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.StockOrderEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.StockOrderDelegate;
	
	public class StockOrderCommand implements ICommand
	{
		public function StockOrderCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var stockOrderEvent:StockOrderEvent = event as StockOrderEvent;
			var delegate:StockOrderDelegate = new StockOrderDelegate(stockOrderEvent.callbacks);
			
			delegate.handleUIEvent(stockOrderEvent);
		}
		
	}
}
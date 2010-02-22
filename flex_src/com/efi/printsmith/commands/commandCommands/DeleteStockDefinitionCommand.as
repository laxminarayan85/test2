package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.DeleteStockDefinitionEvent;
	import com.efi.printsmith.business.commandDelegates.DeleteStockDefinitionDelegate;
	
	public class DeleteStockDefinitionCommand implements ICommand
	{
		public function DeleteStockDefinitionCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:DeleteStockDefinitionEvent = event as DeleteStockDefinitionEvent;
			var delegate:DeleteStockDefinitionDelegate = new DeleteStockDefinitionDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}
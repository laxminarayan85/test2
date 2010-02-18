package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditStockDefinitionEvent;
	import com.efi.printsmith.business.commandDelegates.EditStockDefinitionDelegate;
	
	public class EditStockDefinitionCommand implements ICommand
	{
		public function EditStockDefinitionCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editStockDefinitionEvent:EditStockDefinitionEvent = event as EditStockDefinitionEvent;
			var delegate:EditStockDefinitionDelegate = new EditStockDefinitionDelegate(editStockDefinitionEvent.callbacks);
			
			delegate.handleUIEvent(editStockDefinitionEvent);
		}
		
	}
}
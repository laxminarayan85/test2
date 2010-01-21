package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelDeleteItemEvent;
	import com.efi.printsmith.business.ModelDeleteItemDelegate;
	
	public class ModelDeleteItemCommand implements ICommand
	{
		public function ModelDeleteItemCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var deleteItemEvent:ModelDeleteItemEvent = event as ModelDeleteItemEvent;
			var delegate:ModelDeleteItemDelegate = new ModelDeleteItemDelegate(deleteItemEvent.callbacks);
			delegate.deleteItem(deleteItemEvent.item);
		}
		
	}
}
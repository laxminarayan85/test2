package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelAddUpdateEvent;
	import com.efi.printsmith.business.ModelAddUpdateDelegate;
	
	public class ModelAddUpdateCommand implements ICommand
	{
		public function ModelAddUpdateCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var addUpdateEvent:ModelAddUpdateEvent = event as ModelAddUpdateEvent;
			var delegate:ModelAddUpdateDelegate = new ModelAddUpdateDelegate(addUpdateEvent.callbacks);
			delegate.addUpdate(addUpdateEvent.item);
		}
		
	}
}
package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.business.ModelGetAllDelegate;

	public class ModelGetAllCommand implements ICommand
	{
		public function ModelGetAllCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var getAllEvent:ModelGetAllEvent = event as ModelGetAllEvent;
			var delegate:ModelGetAllDelegate = new ModelGetAllDelegate(getAllEvent.callbacks);
			delegate.getAll(getAllEvent.modelType);
		}
		
	}
}
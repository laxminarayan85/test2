package com.efi.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.events.ModelGetAllEvent;
	import com.efi.business.ModelGetAllDelegate;

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
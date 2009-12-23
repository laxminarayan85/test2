package com.efi.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.events.ModelGetSingleEvent;
	import com.efi.business.ModelGetSingleDelegate;

	public class ModelGetSingleCommand implements ICommand
	{
		public function ModelGetSingleCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var getSingleEvent:ModelGetSingleEvent = event as ModelGetSingleEvent;
			var delegate:ModelGetSingleDelegate = new ModelGetSingleDelegate(getSingleEvent.callbacks);
			delegate.getSingle(getSingleEvent.modelType);
		}
		
	}
}
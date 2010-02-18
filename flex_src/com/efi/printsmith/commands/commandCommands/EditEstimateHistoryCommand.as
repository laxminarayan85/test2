package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditEstimateHistoryEvent;
	import com.efi.printsmith.business.commandDelegates.EditEstimateHistoryDelegate;
	
	public class EditEstimateHistoryCommand implements ICommand
	{
		public function EditEstimateHistoryCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editEstimateHistoryEvent:EditEstimateHistoryEvent = event as EditEstimateHistoryEvent;
			var delegate:EditEstimateHistoryDelegate = new EditEstimateHistoryDelegate(editEstimateHistoryEvent.callbacks);
			
			delegate.handleUIEvent(editEstimateHistoryEvent);
		}
		
	}
}
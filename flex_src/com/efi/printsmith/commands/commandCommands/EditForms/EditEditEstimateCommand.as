package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditEditEstimateEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditEditEstimateDelegate;
	
	public class EditEditEstimateCommand implements ICommand
	{
		public function EditEditEstimateCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editEditEstimateEvent:EditEditEstimateEvent = event as EditEditEstimateEvent;
			var delegate:EditEditEstimateDelegate = new EditEditEstimateDelegate(editEditEstimateEvent.callbacks);
			
			delegate.handleUIEvent(editEditEstimateEvent);
		}
		
	}
}
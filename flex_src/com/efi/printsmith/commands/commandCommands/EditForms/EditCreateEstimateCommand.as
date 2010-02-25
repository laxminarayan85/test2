package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditCreateEstimateEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditCreateEstimateDelegate;
	
	public class EditCreateEstimateCommand implements ICommand
	{
		public function EditCreateEstimateCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editCreateEstimateEvent:EditCreateEstimateEvent = event as EditCreateEstimateEvent;
			var delegate:EditCreateEstimateDelegate = new EditCreateEstimateDelegate(editCreateEstimateEvent.callbacks);
			
			delegate.handleUIEvent(editCreateEstimateEvent);
		}
		
	}
}
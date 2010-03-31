package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditWorkInProgressEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditWorkInProgressDelegate;
	
	public class EditWorkInProgressCommand implements ICommand
	{
		public function EditWorkInProgressCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editWorkInProgressEvent:EditWorkInProgressEvent = event as EditWorkInProgressEvent;
			var delegate:EditWorkInProgressDelegate = new EditWorkInProgressDelegate(editWorkInProgressEvent.callbacks);
			
			delegate.handleUIEvent(editWorkInProgressEvent);
		}
		
	}
}
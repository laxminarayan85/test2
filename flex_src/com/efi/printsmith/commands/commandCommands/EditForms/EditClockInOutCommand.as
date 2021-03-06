package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditClockInOutEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditClockInOutDelegate;
	
	public class EditClockInOutCommand implements ICommand
	{
		public function EditClockInOutCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editClockInOutEvent:EditClockInOutEvent = event as EditClockInOutEvent;
			var delegate:EditClockInOutDelegate = new EditClockInOutDelegate(editClockInOutEvent.callbacks);
			
			delegate.handleUIEvent(editClockInOutEvent);
		}
		
	}
}
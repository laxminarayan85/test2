package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditPendingListEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditPendingListDelegate;
	
	public class EditPendingListCommand implements ICommand
	{
		public function EditPendingListCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editPendingListEvent:EditPendingListEvent = event as EditPendingListEvent;
			var delegate:EditPendingListDelegate = new EditPendingListDelegate(editPendingListEvent.callbacks);
			
			delegate.handleUIEvent(editPendingListEvent);
		}
		
	}
}
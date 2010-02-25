package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditAccountHistoryEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditAccountHistoryDelegate;
	
	public class EditAccountHistoryCommand implements ICommand
	{
		public function EditAccountHistoryCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editAccountHistoryEvent:EditAccountHistoryEvent = event as EditAccountHistoryEvent;
			var delegate:EditAccountHistoryDelegate = new EditAccountHistoryDelegate(editAccountHistoryEvent.callbacks);
			
			delegate.handleUIEvent(editAccountHistoryEvent);
		}
		
	}
}
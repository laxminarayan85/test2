package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.JournalEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.JournalDelegate;
	
	public class JournalCommand implements ICommand
	{
		public function JournalCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var journalEvent:JournalEvent = event as JournalEvent;
			var delegate:JournalDelegate = new JournalDelegate(journalEvent.callbacks);
			
			delegate.handleUIEvent(journalEvent);
		}
		
	}
}
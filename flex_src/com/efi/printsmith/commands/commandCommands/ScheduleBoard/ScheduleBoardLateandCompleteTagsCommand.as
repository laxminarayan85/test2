package com.efi.printsmith.commands.commandCommands.ScheduleBoard
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.ScheduleBoardLateandCompleteTagsEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.ScheduleBoardLateandCompleteTagsDelegate;
	
	public class ScheduleBoardLateandCompleteTagsCommand implements ICommand
	{
		public function ScheduleBoardLateandCompleteTagsCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:ScheduleBoardLateandCompleteTagsEvent = event as ScheduleBoardLateandCompleteTagsEvent;
			var delegate:ScheduleBoardLateandCompleteTagsDelegate = new ScheduleBoardLateandCompleteTagsDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}
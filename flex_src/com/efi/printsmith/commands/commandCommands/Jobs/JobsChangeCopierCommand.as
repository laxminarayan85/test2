package com.efi.printsmith.commands.commandCommands.Jobs
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.JobsChangeCopierEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.JobsChangeCopierDelegate;
	
	public class JobsChangeCopierCommand implements ICommand
	{
		public function JobsChangeCopierCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:JobsChangeCopierEvent = event as JobsChangeCopierEvent;
			var delegate:JobsChangeCopierDelegate = new JobsChangeCopierDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}
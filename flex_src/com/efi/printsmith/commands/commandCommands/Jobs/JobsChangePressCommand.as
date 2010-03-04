package com.efi.printsmith.commands.commandCommands.Jobs
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Invoice.JobsChangePressEvent;
	import com.efi.printsmith.business.commandDelegates.Invoice.JobsChangePressDelegate;
	
	public class JobsChangePressCommand implements ICommand
	{
		public function JobsChangePressCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:JobsChangePressEvent = event as JobsChangePressEvent;
			var delegate:JobsChangePressDelegate = new JobsChangePressDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}
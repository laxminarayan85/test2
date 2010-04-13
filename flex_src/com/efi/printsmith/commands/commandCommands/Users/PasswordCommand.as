// ActionScript file
package com.efi.printsmith.commands.commandCommands.Users
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.Users.PasswordEvent;
	import com.efi.printsmith.business.commandDelegates.Users.PasswordDelegate;
	
	public class PasswordCommand implements ICommand
	{
		public function PasswordCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var evtEvent:PasswordEvent = event as PasswordEvent;
			var delegate:PasswordDelegate = new PasswordDelegate(evtEvent.callbacks);
			
			delegate.handleUIEvent(evtEvent);
		}
		
	}
}
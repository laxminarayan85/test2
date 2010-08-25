package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.ChangePasswordEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.ChangePasswordDelegate;
	
	public class ChangePasswordCommand implements ICommand
	{
		public function ChangePasswordCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var changePasswordEvent:ChangePasswordEvent = event as ChangePasswordEvent;
			var delegate:ChangePasswordDelegate = new ChangePasswordDelegate(changePasswordEvent.callbacks);
			
			delegate.handleUIEvent(changePasswordEvent);
		}
		
	}
}
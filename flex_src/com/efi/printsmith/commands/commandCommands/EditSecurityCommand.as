package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditSecurityEvent;
	import com.efi.printsmith.business.commandDelegates.EditSecurityDelegate;
	
	public class EditSecurityCommand implements ICommand
	{
		public function EditSecurityCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editSecurityEvent:EditSecurityEvent = event as EditSecurityEvent;
			var delegate:EditSecurityDelegate = new EditSecurityDelegate(editSecurityEvent.callbacks);
			
			delegate.handleUIEvent(editSecurityEvent);
		}
		
	}
}
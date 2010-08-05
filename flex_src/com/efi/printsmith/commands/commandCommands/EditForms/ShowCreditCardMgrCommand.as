package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.ShowCreditCardMgrEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.ShowCreditCardMgrDelegate;
	
	public class ShowCreditCardMgrCommand implements ICommand
	{
		public function ShowCreditCardMgrCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var showCreditCardMgrEvent:ShowCreditCardMgrEvent = event as ShowCreditCardMgrEvent;
			var delegate:ShowCreditCardMgrDelegate = new ShowCreditCardMgrDelegate(showCreditCardMgrEvent.callbacks);
			
			delegate.handleUIEvent(showCreditCardMgrEvent);
		}
		
	}
}
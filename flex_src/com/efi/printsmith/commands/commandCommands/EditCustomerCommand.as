package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditCustomerEvent;
	import com.efi.printsmith.business.commandDelegates.EditCustomerDelegate;
	
	public class EditCustomerCommand implements ICommand
	{
		public function EditCustomerCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editCustomerEvent:EditCustomerEvent = event as EditCustomerEvent;
			var delegate:EditCustomerDelegate = new EditCustomerDelegate(editCustomerEvent.callbacks);
			
			delegate.handleUIEvent(editCustomerEvent);
		}
		
	}
}
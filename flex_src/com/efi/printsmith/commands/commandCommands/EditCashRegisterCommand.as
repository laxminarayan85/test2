package com.efi.printsmith.commands.commandCommands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditCashRegisterEvent;
	import com.efi.printsmith.business.commandDelegates.EditCashRegisterDelegate;
	
	public class EditCashRegisterCommand implements ICommand
	{
		public function EditCashRegisterCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editCashRegisterEvent:EditCashRegisterEvent = event as EditCashRegisterEvent;
			var delegate:EditCashRegisterDelegate = new EditCashRegisterDelegate(editCashRegisterEvent.callbacks);
			
			delegate.handleUIEvent(editCashRegisterEvent);
		}
		
	}
}
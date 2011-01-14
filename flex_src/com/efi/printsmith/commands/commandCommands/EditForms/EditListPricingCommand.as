package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.EditListPricingEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.EditListPricingDelegate;
	
	public class EditListPricingCommand implements ICommand
	{
		public function EditListPricingCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var editListPricingEvent:EditListPricingEvent = event as EditListPricingEvent;
			var delegate:EditListPricingDelegate = new EditListPricingDelegate(editListPricingEvent.callbacks);
			
			delegate.handleUIEvent(editListPricingEvent);
		}
		
	}
}
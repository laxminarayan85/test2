package com.efi.printsmith.commands.commandCommands.EditForms
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.events.ModelGetAllEvent;
	import com.efi.printsmith.events.commandEvents.EditForms.TapeCashDrawerStatusEvent;
	import com.efi.printsmith.business.commandDelegates.EditForms.TapeCashDrawerStatusDelegate;
	
	public class TapeCashDrawerStatusCommand implements ICommand
	{
		public function TapeCashDrawerStatusCommand()
		{
			
		}

		public function execute(event:CairngormEvent):void
		{
			var tapeCashDrawerStatusCommandEvent:TapeCashDrawerStatusEvent = event as TapeCashDrawerStatusEvent;
			var delegate:TapeCashDrawerStatusDelegate = new TapeCashDrawerStatusDelegate(tapeCashDrawerStatusCommandEvent.callbacks);
			
			delegate.handleUIEvent(tapeCashDrawerStatusCommandEvent);
		}
		
	}
}
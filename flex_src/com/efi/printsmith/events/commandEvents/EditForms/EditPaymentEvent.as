package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	
public class EditPaymentEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Payment";
		
		public function EditPaymentEvent(callbacks:IResponder=null)
		{
			super(EditPaymentEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditPaymentEvent(callbacks);
		}
	}
}

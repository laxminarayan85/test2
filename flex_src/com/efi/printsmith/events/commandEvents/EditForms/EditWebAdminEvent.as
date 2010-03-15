package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;

	public class EditWebAdminEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Web_Administration";
		
		public function EditWebAdminEvent(callbacks:IResponder=null)
		{
			super(EditWebAdminEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditWebAdminEvent(callbacks);
		}
	}
}
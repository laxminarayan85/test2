package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;

	public class EditTapeEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_EditTape";
		
		public function EditTapeEvent(callbacks:IResponder=null)
		{
			super(EditTapeEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditTapeEvent(callbacks);
		}
	}
}
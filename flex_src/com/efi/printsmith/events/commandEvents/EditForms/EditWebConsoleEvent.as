package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	
	public class EditWebConsoleEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_EditWebConsole";
		
		public function EditWebConsoleEvent(callbacks:IResponder=null)
		{
			super(EditWebConsoleEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditWebConsoleEvent(callbacks);
		}
	}
}
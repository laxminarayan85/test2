package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class JournalEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Journal";
		public var object:Users;
		
		public function JournalEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(JournalEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new JournalEvent(object, callbacks);
		}
	}
}
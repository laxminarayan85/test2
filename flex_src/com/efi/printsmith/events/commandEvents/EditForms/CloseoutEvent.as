package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class CloseoutEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Closeout";
		public var object:Users;
		
		public function CloseoutEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(CloseoutEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new CloseoutEvent(object, callbacks);
		}
	}
}
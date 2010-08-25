package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class ChangePasswordEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_ChangePassword";
		public var object:Users;
		
		public function ChangePasswordEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(ChangePasswordEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ChangePasswordEvent(object, callbacks);
		}
	}
}
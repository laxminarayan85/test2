// ActionScript file
package com.efi.printsmith.events.commandEvents.Users
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.rpc.IResponder;

	public class PasswordEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Set_Password";

		public function PasswordEvent(callbacks:IResponder=null)
		{
			super(PasswordEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new PasswordEvent(callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class EditUserEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Users";
		public var object:Users;
		
		public function EditUserEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditUserEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditUserEvent(object, callbacks);
		}
	}
}
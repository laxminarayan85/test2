package com.efi.printsmith.events.commandEvents.EditForms
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.Users;

	public class GenerateStatmentEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_GenerateStatment";
		public var object:Users;
		
		public function GenerateStatmentEvent(object:Users, callbacks:IResponder=null)
		{
			this.object = object;
			super(GenerateStatmentEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new GenerateStatmentEvent(object, callbacks);
		}
	}
}
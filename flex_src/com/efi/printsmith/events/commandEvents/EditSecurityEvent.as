package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.SecuritySetup;

	public class EditSecurityEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Security";
		public var object:SecuritySetup;
		
		public function EditSecurityEvent(object:SecuritySetup, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditSecurityEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditSecurityEvent(object, callbacks);
		}
	}
}
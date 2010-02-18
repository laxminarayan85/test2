package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.Contact;

	public class EditContactEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Contact";
		public var object:Contact;
		
		public function EditContactEvent(object:Contact, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditContactEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditContactEvent(object, callbacks);
		}
	}
}
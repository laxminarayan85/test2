package com.efi.printsmith.events.commandEvents.Contacts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class ContactsAddressPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Contact_AddressPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function ContactsAddressPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(ContactsAddressPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ContactsAddressPanelEvent(panel, callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.Contacts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class ContactsCreditInfoPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Contact_CreditInfoPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function ContactsCreditInfoPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(ContactsCreditInfoPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ContactsCreditInfoPanelEvent(panel, callbacks);
		}
	}
}
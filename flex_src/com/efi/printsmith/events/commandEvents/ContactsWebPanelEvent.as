package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class ContactsWebPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Contact_WEBPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function ContactsWebPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(ContactsWebPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ContactsWebPanelEvent(panel, callbacks);
		}
	}
}
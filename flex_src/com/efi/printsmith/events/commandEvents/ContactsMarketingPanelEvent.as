package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class ContactsMarketingPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Contact_MarketingPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function ContactsMarketingPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(ContactsMarketingPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ContactsMarketingPanelEvent(panel, callbacks);
		}
	}
}
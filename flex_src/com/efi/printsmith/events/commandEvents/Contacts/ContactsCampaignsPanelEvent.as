package com.efi.printsmith.events.commandEvents.Contacts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class ContactsCampaignsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Contact_CampaignsPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function ContactsCampaignsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(ContactsCampaignsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new ContactsCampaignsPanelEvent(panel, callbacks);
		}
	}
}
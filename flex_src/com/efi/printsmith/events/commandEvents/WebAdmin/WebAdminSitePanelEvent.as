package com.efi.printsmith.events.commandEvents.WebAdmin
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class WebAdminSitePanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WebSite_Panel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function WebAdminSitePanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(WebAdminSitePanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new WebAdminSitePanelEvent(panel, callbacks);
		}
	}
}
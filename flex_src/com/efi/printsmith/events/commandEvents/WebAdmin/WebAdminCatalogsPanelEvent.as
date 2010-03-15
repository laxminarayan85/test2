package com.efi.printsmith.events.commandEvents.WebAdmin
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class WebAdminCatalogsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WebCatalogs_Panel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function WebAdminCatalogsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(WebAdminCatalogsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new WebAdminCatalogsPanelEvent(panel, callbacks);
		}
	}
}
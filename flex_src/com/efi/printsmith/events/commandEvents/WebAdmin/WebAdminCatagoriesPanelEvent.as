package com.efi.printsmith.events.commandEvents.WebAdmin
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class WebAdminCatagoriesPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WebCatagories_Panel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function WebAdminCatagoriesPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(WebAdminCatagoriesPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new WebAdminCatagoriesPanelEvent(panel, callbacks);
		}
	}
}
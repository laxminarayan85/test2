package com.efi.printsmith.events.commandEvents.WebAdmin
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class WebAdminGraphicsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WebGraphics_Panel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function WebAdminGraphicsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(WebAdminGraphicsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new WebAdminGraphicsPanelEvent(panel, callbacks);
		}
	}
}
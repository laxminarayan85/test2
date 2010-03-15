package com.efi.printsmith.events.commandEvents.WebAdmin
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class WebAdminProductsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WebProducts_Panel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function WebAdminProductsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(WebAdminProductsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new WebAdminProductsPanelEvent(panel, callbacks);
		}
	}
}
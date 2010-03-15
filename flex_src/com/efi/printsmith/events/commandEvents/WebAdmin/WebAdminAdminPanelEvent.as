package com.efi.printsmith.events.commandEvents.WebAdmin
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class WebAdminAdminPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WebAdmin_Panel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function WebAdminAdminPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(WebAdminAdminPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new WebAdminAdminPanelEvent(panel, callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.WebAdmin
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class WebAdminQuestionsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_WebQuestions_Panel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function WebAdminQuestionsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(WebAdminQuestionsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new WebAdminQuestionsPanelEvent(panel, callbacks);
		}
	}
}
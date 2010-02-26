package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesJobTicketPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_JobTicket";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesJobTicketPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesJobTicketPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesJobTicketPanelEvent(panel, callbacks);
		}
	}
}
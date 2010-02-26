package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesBusinessCalendarPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_BusinessCalendar";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesBusinessCalendarPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesBusinessCalendarPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesBusinessCalendarPanelEvent(panel, callbacks);
		}
	}
}
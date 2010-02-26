package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesMarkupsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_Markups";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesMarkupsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesMarkupsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesMarkupsPanelEvent(panel, callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesInternationalPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_International";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesInternationalPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesInternationalPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesInternationalPanelEvent(panel, callbacks);
		}
	}
}
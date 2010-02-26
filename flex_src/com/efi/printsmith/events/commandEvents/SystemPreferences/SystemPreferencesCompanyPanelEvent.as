package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesCompanyPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_Company";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesCompanyPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesCompanyPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesCompanyPanelEvent(panel, callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesGLProfilesPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_GLProfiles";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesGLProfilesPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesGLProfilesPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesGLProfilesPanelEvent(panel, callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesBehaviorPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_Behavior";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesBehaviorPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesBehaviorPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesBehaviorPanelEvent(panel, callbacks);
		}
	}
}
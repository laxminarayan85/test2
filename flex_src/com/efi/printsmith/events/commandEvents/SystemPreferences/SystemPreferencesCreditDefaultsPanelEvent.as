package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesCreditDefaultsPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_CreditDefaults";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesCreditDefaultsPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesCreditDefaultsPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesCreditDefaultsPanelEvent(panel, callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesPaperCalculatorPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_PaperCalculator";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesPaperCalculatorPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesPaperCalculatorPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesPaperCalculatorPanelEvent(panel, callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesEstimatorPrintingPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_EstimatorPrinting";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesEstimatorPrintingPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesEstimatorPrintingPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesEstimatorPrintingPanelEvent(panel, callbacks);
		}
	}
}
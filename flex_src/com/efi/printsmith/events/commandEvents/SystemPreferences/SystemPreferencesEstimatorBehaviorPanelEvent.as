package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesEstimatorBehaviorPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_EstimatorBehavior";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesEstimatorBehaviorPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesEstimatorBehaviorPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesEstimatorBehaviorPanelEvent(panel, callbacks);
		}
	}
}
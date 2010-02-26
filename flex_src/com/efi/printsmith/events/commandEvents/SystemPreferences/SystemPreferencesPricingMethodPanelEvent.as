package com.efi.printsmith.events.commandEvents.SystemPreferences
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class SystemPreferencesPricingMethodPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Preferences_PricingMethod";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function SystemPreferencesPricingMethodPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(SystemPreferencesPricingMethodPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new SystemPreferencesPricingMethodPanelEvent(panel, callbacks);
		}
	}
}
package com.efi.printsmith.events.commandEvents.Help
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.controls.LinkButton;
	import mx.rpc.IResponder;

	public class AboutEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_AboutPrintSmith";

		public var button:LinkButton;
		public var enabled:Boolean;

		public function AboutEvent(item:LinkButton, callbacks:IResponder=null)
		{
			this.button = item;
			super(AboutEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AboutEvent(button, callbacks);
		}
	}
}
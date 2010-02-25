package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class AccountsCreditControlPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_CreditControlPanel";

		public var panel:Canvas;
		public var enabled:Boolean;

		public function AccountsCreditControlPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(AccountsCreditControlPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AccountsCreditControlPanelEvent(panel, callbacks);
		}
	}
}
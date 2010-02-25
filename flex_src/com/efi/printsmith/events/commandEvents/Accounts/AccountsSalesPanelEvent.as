package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class AccountsSalesPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_SalesPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function AccountsSalesPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(AccountsSalesPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AccountsSalesPanelEvent(panel, callbacks);
		}
	}
}
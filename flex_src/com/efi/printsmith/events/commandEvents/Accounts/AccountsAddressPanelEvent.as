package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import com.efi.printsmith.events.commandEvents.*;
	import mx.containers.Canvas;
	import mx.rpc.IResponder;

	public class AccountsAddressPanelEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_AddressPanel";

		public var panel:Canvas;
		public var enabled:Boolean;
		
		public function AccountsAddressPanelEvent(item:Canvas, callbacks:IResponder=null)
		{
			this.panel = item;
			super(AccountsAddressPanelEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new AccountsAddressPanelEvent(panel, callbacks);
		}
	}
}
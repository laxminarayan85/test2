package com.efi.printsmith.events.commandEvents.Accounts
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.Account;

	public class DeleteAccountEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Account_Delete";
		public var account:Account;
		
		public function DeleteAccountEvent(item:Account, callbacks:IResponder=null)
		{
			this.account = item;
			super(DeleteAccountEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new DeleteAccountEvent(account, callbacks);
		}
	}
}
package com.efi.events
{
	import com.efi.vo.Account;
	
	import flash.events.Event;
	
	public class AccountPickerSelectEvent extends Event
	{
		public static const SELECTACCOUNT:String = "SelectAccount";
		public static const SELECTNEWACCOUNT:String = "SelectNewAccount";
		public static const CANCELSELECTACCOUNT:String = "CancelSelectAccount";
		
		public var account:Account;
		
		public function AccountPickerSelectEvent(type:String, account:Account)
		{
			super(type, true);
			this.account = account;
		}

		override public function clone():Event {
			return new AccountPickerSelectEvent(type, account);
		}
	}
}
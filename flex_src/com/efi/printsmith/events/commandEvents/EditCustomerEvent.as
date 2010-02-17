package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.Account;
	
	public class EditCustomerEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_EditCustomer";
		public var customer:Account;
		
		public function EditCustomerEvent(customer:Account, callbacks:IResponder=null)
		{
			this.customer = customer;
			super(EditCustomerEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditCustomerEvent(customer, callbacks);
		}
	}
}
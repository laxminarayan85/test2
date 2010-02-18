package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.CashRegister;

	public class EditCashRegisterEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_CashRegister";
		public var object:CashRegister;
		
		public function EditCashRegisterEvent(object:CashRegister, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditCashRegisterEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditCashRegisterEvent(object, callbacks);
		}
	}
}
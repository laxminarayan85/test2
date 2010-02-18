package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.Employee;

	public class EditEmployeeEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_Employee";
		public var object:Employee;
		
		public function EditEmployeeEvent(object:Employee, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditEmployeeEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditEmployeeEvent(object, callbacks);
		}
	}
}
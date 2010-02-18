package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.InvoiceBase;

	public class EditPendingListEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_PendingList";
		public var object:InvoiceBase;
		
		public function EditPendingListEvent(object:InvoiceBase, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditPendingListEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditPendingListEvent(object, callbacks);
		}
	}
}
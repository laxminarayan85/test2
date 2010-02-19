package com.efi.printsmith.events.commandEvents
{
	import com.efi.printsmith.data.Estimate;
	
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class EditCreateEstimateEvent extends CommandEventBase
	{
		public static const COMMANDID:String = "CMD_CreateEstimate";
		public var object:Estimate;
		
		public function EditCreateEstimateEvent(object:Estimate, callbacks:IResponder=null)
		{
			this.object = object;
			super(EditCreateEstimateEvent.COMMANDID, callbacks);
		}
		
		override public function clone():Event {
			return new EditCreateEstimateEvent(object, callbacks);
		}
	}
}
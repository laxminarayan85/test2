package com.efi.printsmith.events.commandEvents
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	import com.efi.printsmith.data.Job;
	import com.efi.printsmith.events.EventBase;
	
	public class CommandEventBase extends EventBase
	{
		public static const COMMANDID:String = "UNASSIGNED";
		
		public function CommandEventBase(type:String, callbacks:IResponder=null) {
			super(type,callbacks);
		} 
	}
}
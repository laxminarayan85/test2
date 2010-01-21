package com.efi.printsmith.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;
	import com.efi.printsmith.data.ModelBase;
	
	public class ModelAddUpdateEvent extends EventBase
	{
		public static const ADDUPDATE:String = "ModelAddUpdate";
		public var item:ModelBase;
		
		public function ModelAddUpdateEvent(item:ModelBase, callbacks:IResponder=null)
		{
			this.item = item;
			super(ADDUPDATE, callbacks);
		}
		
		override public function clone():Event {
			return new ModelAddUpdateEvent(item, callbacks);
		}
	}
}
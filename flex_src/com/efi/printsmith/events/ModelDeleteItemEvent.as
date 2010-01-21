package com.efi.printsmith.events
{
	import com.efi.printsmith.data.ModelBase;
	
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class ModelDeleteItemEvent extends EventBase
	{
		public static const DELETE:String = "ModelDelete";
		public var item:ModelBase;
		
		public function ModelDeleteItemEvent(item:ModelBase, callbacks:IResponder=null)
		{
			this.item = item;
			super(DELETE, callbacks);
		}
		
		override public function clone():Event {
			return new ModelDeleteItemEvent(item, callbacks);
		}
	}
}
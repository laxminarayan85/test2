package com.efi.events
{
	import com.adobe.cairngorm.control.CairngormEvent;
	
	import mx.rpc.IResponder;
	
	public class EventBase extends CairngormEvent
	{
		public var callbacks:IResponder = null;
		
		public function EventBase(type:String, callbacks:IResponder=null) {
			this.callbacks = callbacks;
			super(type);
		}

	}
}
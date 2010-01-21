package com.efi.printsmith.events
{
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class ModelGetSingleEvent extends EventBase
	{
		public static const GETSINGLE:String = "ModelGetSingle";
		public var modelType:String;
		
		public function ModelGetSingleEvent(modelType:String, callbacks:IResponder=null)
		{
			this.modelType = modelType;
			super(GETSINGLE, callbacks);
		}
		
		override public function clone():Event {
			return new ModelGetSingleEvent(modelType, callbacks);
		}
	}
}
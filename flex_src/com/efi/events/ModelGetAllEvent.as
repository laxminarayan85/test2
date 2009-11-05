package com.efi.events
{
	import flash.events.Event;
	
	import mx.rpc.IResponder;

	public class ModelGetAllEvent extends EventBase
	{
		public static const GETALL:String = "ModelGetAll";
		public var modelType:String;
		
		public function ModelGetAllEvent(modelType:String, callbacks:IResponder=null)
		{
			this.modelType = modelType;
			super(GETALL, callbacks);
		}
		
		override public function clone():Event {
			return new ModelGetAllEvent(modelType, callbacks);
		}
	}
}
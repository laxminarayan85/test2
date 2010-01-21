package com.efi.printsmith.events
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.IResponder;

	public class ModelQueryByCriteriaEvent extends EventBase
	{
		public static const QUERYBYCRITERIA:String = "ModelQueryByCriteria";
		public var modelType:String;
		public var criteria:ArrayCollection;
		
		public function ModelQueryByCriteriaEvent(modelType:String, criteria:ArrayCollection, callbacks:IResponder=null)
		{
			this.modelType = modelType;
			this.criteria=criteria;
			super(QUERYBYCRITERIA, callbacks);
		}
		
		override public function clone():Event {
			return new ModelQueryByCriteriaEvent(modelType, criteria, callbacks);
		}
	}
}
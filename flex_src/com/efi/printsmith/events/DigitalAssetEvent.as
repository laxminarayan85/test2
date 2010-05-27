// ActionScript file
package com.efi.printsmith.events
{
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;

	public class DigitalAssetEvent extends Event
	{
		public var assetArray: ArrayCollection;
		public static const Cancel:String = "DigitalAssetCancel";
		public static const OK:String = "DigitalAssetOK";
		
		public function DigitalAssetEvent(type:String, assetArray:ArrayCollection)
		{
			super(type);
			this.assetArray = assetArray;
		}
		
		override public function clone():Event {
			return new DigitalAssetEvent(type, assetArray);
		}
	}
}
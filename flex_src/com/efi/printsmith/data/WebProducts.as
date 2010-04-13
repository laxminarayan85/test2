package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebProducts")]

	public class WebProducts extends ModelBase
	{

		public function WebProducts() {
			remoteObjectName = "com.efi.printsmith.data.WebProducts";
		}
				
		public var name:String = "";
		public var status:String = "";
		public var sku:JobBase;
		public var thumbnail:WebGraphics;
		public var details:WebGraphics;
		public var globalProduct:Boolean = false;
		public var checkoutType:WebCheckoutTypes;
		public var allowUserEnteredQty:Boolean = false;
		public var description:String = "";
		public var calculatePrices:PreferencesPricingMethod;
		public var questions:ArrayCollection;
	
	}
}
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
		public var status:WebStatus;
		public var sku:JobBase;
		public var thumbnail:WebGraphics;
		public var details:String = "";
		public var globalProduct:Boolean = true;
		public var checkoutType:WebCheckoutTypes;
		public var allowUserEnteredQty:Boolean = true;
		public var description:String = "";
		public var calculatePrices:PreferencesPricingMethod;
	
	}
}
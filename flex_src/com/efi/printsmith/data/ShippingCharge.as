package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ShippingCharge")]
	[Managed]
	
	public dynamic class ShippingCharge extends Charge
	{

		public function ShippingCharge() {
			remoteObjectName = "com.efi.printsmith.data.ShippingCharge";
		}
		public override var isDeleted:Boolean=false;
				
		public var shipVia:String = "";
		public var shipTo:Address;
		public var totalWeight:Number = 0;
	
	}
}
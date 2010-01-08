package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PriceListElement")]

	public class PriceListElement extends ModelBase
	{

		public function PriceListElement() {
			remoteObjectName = "com.efi.printsmith.data.PriceListElement";
		}
				
		public var quantity:Number = 0;
		public var amount:Number = 0;
	
	}
}
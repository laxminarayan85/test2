package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PriceListElement")]
	[Managed]
	public class PriceListElement extends ModelBase
	{

		public function PriceListElement() {
			remoteObjectName = "com.efi.printsmith.data.PriceListElement";
		}
				
		public var quantity:Number = 0;
		public var amount:Number = 0;
		public var side:int = 0;
		public var color:int = 0;
	
	}
}
package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.TaxCodes")]

	public class TaxCodes extends ModelBase
	{

		public function TaxCodes() {
			remoteObjectName = "com.efi.printsmith.data.TaxCodes";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}
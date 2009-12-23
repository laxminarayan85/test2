package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
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
package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Vendor")]

	public class Vendor extends ModelBase
	{

		public function Vendor() {
			remoteObjectName = "com.efi.printsmith.data.Vendor";
		}
				
		public var name:String = "";
	
	}
}
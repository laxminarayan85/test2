package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Address")]

	public class Address extends ModelBase
	{

		public function Address() {
			remoteObjectName = "com.efi.printsmith.data.Address";
		}
				
		public var name:String = "";
		public var street1:String = "";
		public var street2:String = "";
		public var city:String = "";
		public var state:String = "";
		public var zip:String = "";
		public var country:String = "";
		public var zone:String = "";
	
	}
}
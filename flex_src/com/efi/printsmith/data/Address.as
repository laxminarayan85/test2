package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Address")]
	[Managed]
	
	public dynamic class Address extends ModelBase
	{

		public function Address() {
			remoteObjectName = "com.efi.printsmith.data.Address";
		}
		public var isDeleted:Boolean=false;
				
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
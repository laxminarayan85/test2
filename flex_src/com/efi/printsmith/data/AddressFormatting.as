package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.AddressFormatting")]
	[Managed]
	
	public dynamic class AddressFormatting extends ModelBase
	{

		public function AddressFormatting() {
			remoteObjectName = "com.efi.printsmith.data.AddressFormatting";
		}
		public var isDeleted:Boolean=false;
				
		public var country:Country;
		public var street1Position:int = 0;
		public var street2Position:int = 0;
		public var cityPosition:int = 0;
		public var statePosition:int = 0;
		public var countryPosition:int = 0;
		public var zipPosition:int = 0;
	
	}
}
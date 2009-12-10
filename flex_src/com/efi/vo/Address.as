package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Address")]

	public class Address extends ModelBase
	{

		public function Address() {
		
		}
		public var name:String = "";
		public var street1:String = "";
		public var street2:String = "";
		public var city:City;
		public var state:State;
		public var zip:Zip;
		public var country:Country;
		public var zone:String = "";
	
	}
}
package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Party")]

	public class Party extends ModelBase
	{

		public function Party() {
			remoteObjectName = "com.efi.printsmith.data.Party";
		}
				
		public var address:Address;
		public var lastName:String = "";
		public var firstName:String = "";
		public var comLinks:ArrayCollection;
	
	}
}
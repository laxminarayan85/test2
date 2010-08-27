package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Party")]
	[Managed]
	
	public dynamic class Party extends ModelBase
	{

		public function Party() {
			remoteObjectName = "com.efi.printsmith.data.Party";
		}
		public var isDeleted:Boolean=false;
				
		public var prefix:String = "";
		public var suffix:String = "";
		public var salutation:String = "";
		public var jobTitle:JobTitle;
		public var address:Address;
		public var lastName:String = "";
		public var firstName:String = "";
		public var comLinks:ArrayCollection;
	
	}
}
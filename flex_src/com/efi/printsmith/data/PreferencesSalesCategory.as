package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesSalesCategory")]
	[Managed]
	
	public dynamic class PreferencesSalesCategory extends ModelBase
	{

		public function PreferencesSalesCategory() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesSalesCategory";
		}
		public var isDeleted:Boolean=false;
				
		public var category:SalesCategory;
		public var accountNumber:String = "";
	
	}
}
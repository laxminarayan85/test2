package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebSubCatagories")]
	[Managed]
	
	public dynamic class WebSubCatagories extends WebCatagories
	{

		public function WebSubCatagories() {
			remoteObjectName = "com.efi.printsmith.data.WebSubCatagories";
		}
		public override var isDeleted:Boolean=false;
				
		public var products:ArrayCollection;
	
	}
}
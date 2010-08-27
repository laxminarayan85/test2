package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebCatagories")]
	[Managed]
	
	public dynamic class WebCatagories extends ModelBase
	{

		public function WebCatagories() {
			remoteObjectName = "com.efi.printsmith.data.WebCatagories";
		}
		public var isDeleted:Boolean=false;
				
		public var status:String = "";
		public var image:WebGraphics;
		public var name:String = "";
		public var children:ArrayCollection;
	
	}
}
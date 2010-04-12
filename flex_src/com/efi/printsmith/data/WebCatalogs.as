package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebCatalogs")]
	[Managed]
	public class WebCatalogs extends ModelBase
	{

		public function WebCatalogs() {
			remoteObjectName = "com.efi.printsmith.data.WebCatalogs";
		}
				
		public var rollId:int = 0;
		public var status:String = "";
		public var name:String = "";
		public var description:String = "";
		public var path:String = "";
		public var catagories:ArrayCollection;
	
	}
}
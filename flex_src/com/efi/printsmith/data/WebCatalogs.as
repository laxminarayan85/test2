package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebCatalogs")]

	public class WebCatalogs extends ModelBase
	{

		public function WebCatalogs() {
			remoteObjectName = "com.efi.printsmith.data.WebCatalogs";
		}
				
		public var roleId:int = 0;
		public var status:WebStatus;
		public var name:String = "";
		public var description:String = "";
		public var path:String = "";
		public var catagories:ArrayCollection;
	
	}
}
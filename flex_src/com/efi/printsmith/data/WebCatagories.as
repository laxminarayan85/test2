package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebCatagories")]
	[Managed]
	public class WebCatagories extends ModelBase
	{

		public function WebCatagories() {
			remoteObjectName = "com.efi.printsmith.data.WebCatagories";
		}
				
		public var status:String = "";
		public var image:WebGraphics;
		public var name:String = "";
		public var children:ArrayCollection;
	
	}
}
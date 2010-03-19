package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebGraphics")]

	public class WebGraphics extends ModelBase
	{

		public function WebGraphics() {
			remoteObjectName = "com.efi.printsmith.data.WebGraphics";
		}
				
		public var name:String = "";
		public var status:String = "";
		public var description:String = "";
		public var pathUrl:String = "";
	
	}
}
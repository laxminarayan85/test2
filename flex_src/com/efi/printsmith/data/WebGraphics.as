package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebGraphics")]
	[Managed]
	
	public dynamic class WebGraphics extends ModelBase
	{

		public function WebGraphics() {
			remoteObjectName = "com.efi.printsmith.data.WebGraphics";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var status:String = "";
		public var description:String = "";
		public var pathUrl:String = "";
	
	}
}
package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.BasicSize")]

	public class BasicSize extends ModelBase
	{

		public function BasicSize() {
			remoteObjectName = "com.efi.printsmith.data.BasicSize";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}
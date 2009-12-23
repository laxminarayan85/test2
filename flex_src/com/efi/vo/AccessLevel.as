package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.AccessLevel")]

	public class AccessLevel extends ModelBase
	{

		public function AccessLevel() {
			remoteObjectName = "com.efi.printsmith.data.AccessLevel";
		}
				
		public var name:String = "";
	
	}
}
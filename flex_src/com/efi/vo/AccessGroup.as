package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.AccessGroup")]

	public class AccessGroup extends ModelBase
	{

		public function AccessGroup() {
			remoteObjectName = "com.efi.printsmith.data.AccessGroup";
		}
				
		public var name:String = "";
	
	}
}
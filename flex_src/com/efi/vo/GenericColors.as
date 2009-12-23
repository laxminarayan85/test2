package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.GenericColors")]

	public class GenericColors extends ModelBase
	{

		public function GenericColors() {
			remoteObjectName = "com.efi.printsmith.data.GenericColors";
		}
				
		public var name:String = "";
	
	}
}
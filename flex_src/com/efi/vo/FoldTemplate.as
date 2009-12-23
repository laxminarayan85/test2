package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.FoldTemplate")]

	public class FoldTemplate extends ModelBase
	{

		public function FoldTemplate() {
			remoteObjectName = "com.efi.printsmith.data.FoldTemplate";
		}
				
		public var name:String = "";
	
	}
}
package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ComLinkType")]

	public class ComLinkType extends ModelBase
	{

		public function ComLinkType() {
			remoteObjectName = "com.efi.printsmith.data.ComLinkType";
		}
				
		public var type:String = "";
	
	}
}
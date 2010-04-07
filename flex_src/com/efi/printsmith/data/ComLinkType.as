package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ComLinkType")]
	[Managed]
	public class ComLinkType extends ModelBase
	{

		public function ComLinkType() {
			remoteObjectName = "com.efi.printsmith.data.ComLinkType";
		}
				
		public var type:String = "";
	
	}
}
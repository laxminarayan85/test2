package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ComLink")]

	public class ComLink extends ModelBase
	{

		public function ComLink() {
			remoteObjectName = "com.efi.printsmith.data.ComLink";
		}
				
		public var type:String = "";
		public var value:String = "";
	
	}
}
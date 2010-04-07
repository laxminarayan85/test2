package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Substrate")]
	[Managed]
	public class Substrate extends ModelBase
	{

		public function Substrate() {
			remoteObjectName = "com.efi.printsmith.data.Substrate";
		}
				
		public var name:String = "";
	
	}
}
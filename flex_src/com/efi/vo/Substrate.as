package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Substrate")]

	public class Substrate extends ModelBase
	{

		public function Substrate() {
			remoteObjectName = "com.efi.printsmith.data.Substrate";
		}
				
		public var name:String = "";
	
	}
}
package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.State")]

	public class State extends ModelBase
	{

		public function State() {
		
		}
		public var name:String = "";
	
	}
}
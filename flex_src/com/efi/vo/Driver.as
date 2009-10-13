package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Driver")]

	public class Driver extends ModelBase
	{

		public function Driver() {
		
		}
		public var name:String = "";
		public var key:String = "";
	
	}
}
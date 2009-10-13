package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Location")]

	public class Location extends ModelBase
	{

		public function Location() {
		
		}
		public var name:String = "";
	
	}
}
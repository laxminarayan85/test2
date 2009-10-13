package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.City")]

	public class City extends ModelBase
	{

		public function City() {
		
		}
		public var name:String = "";
	
	}
}
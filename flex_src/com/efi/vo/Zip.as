package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Zip")]

	public class Zip extends ModelBase
	{

		public function Zip() {
		
		}
		public var name:String = "";
	
	}
}
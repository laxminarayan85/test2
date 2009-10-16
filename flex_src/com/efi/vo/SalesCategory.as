package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SalesCategory")]

	public class SalesCategory extends ModelBase
	{

		public function SalesCategory() {
		
		}
		public var name:String = "";
	
	}
}
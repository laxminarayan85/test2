package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.BusinessType")]

	public class BusinessType extends ModelBase
	{

		public function BusinessType() {
		
		}
		public var name:String = "";
		public var key:String = "";
	
	}
}
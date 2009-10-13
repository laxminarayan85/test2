package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PhoneTags")]

	public class PhoneTags extends ModelBase
	{

		public function PhoneTags() {
		
		}
		public var name:String = "";
	
	}
}
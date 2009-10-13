package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SizeUS")]

	public class SizeUS extends ModelBase
	{

		public function SizeUS() {
		
		}
		public var name:String = "";
		public var size:String = "";
	
	}
}
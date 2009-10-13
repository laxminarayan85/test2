package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ComLink")]

	public class ComLink extends ModelBase
	{

		public function ComLink() {
		
		}
		public var type:String = "";
		public var value:String = "";
	
	}
}
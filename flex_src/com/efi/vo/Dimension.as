package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Dimension")]

	public class Dimension extends ModelBase
	{

		public function Dimension() {
		
		}
		public var type:String = "";
		public var name:String = "";
		public var width:Number = 0;
		public var height:Number = 0;
	
	}
}
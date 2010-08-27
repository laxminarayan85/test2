package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Dimension")]
	[Managed]
	
	public dynamic class Dimension extends ModelBase
	{

		public function Dimension() {
			remoteObjectName = "com.efi.printsmith.data.Dimension";
		}
		public var isDeleted:Boolean=false;
				
		public var type:String = "";
		public var name:String = "";
		public var width:Number = 0;
		public var height:Number = 0;
	
	}
}
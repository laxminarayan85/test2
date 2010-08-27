package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PriceLogEntry")]
	[Managed]
	
	public dynamic class PriceLogEntry extends ModelBase
	{

		public function PriceLogEntry() {
			remoteObjectName = "com.efi.printsmith.data.PriceLogEntry";
		}
		public var isDeleted:Boolean=false;
				
		public var version:int = 0;
		public var description:String = "";
		public var method:String = "";
		public var value:Number = 0;
		public var date:Date = new Date();
		public var children:ArrayCollection;
	
	}
}
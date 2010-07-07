package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Period")]
	[Managed]
	
	public dynamic class Period extends ModelBase
	{

		public function Period() {
			remoteObjectName = "com.efi.printsmith.data.Period";
		}
				
		public var customtoDate:Date = new Date();
		public var customfromDate:Date = new Date();
		public var fromDate:Date = new Date();
		public var toDate:Date = new Date();
		public var day:String = "";
		public var type:String = "";
		public var periodNumber:int = 0;
		public var periodClosed:Boolean = false;
	
	}
}
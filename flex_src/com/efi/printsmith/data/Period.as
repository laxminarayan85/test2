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
		public var isDeleted:Boolean=false;
				
		public var customtoDate:Date = null;
		public var customfromDate:Date = null;
		public var fromDate:Date = null;
		public var toDate:Date = null;
		public var day:String = "";
		public var type:String = "";
		public var periodNumber:int = 0;
		public var periodClosed:Boolean = false;
	
	}
}
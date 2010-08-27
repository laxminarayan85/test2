package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ReportCategories")]
	[Managed]
	
	public dynamic class ReportCategories extends ModelBase
	{

		public function ReportCategories() {
			remoteObjectName = "com.efi.printsmith.data.ReportCategories";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var key:String = "";
	
	}
}
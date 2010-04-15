package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ReportCategories")]
	[Managed]
	
	public class ReportCategories extends ModelBase
	{

		public function ReportCategories() {
			remoteObjectName = "com.efi.printsmith.data.ReportCategories";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}
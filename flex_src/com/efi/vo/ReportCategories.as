package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ReportCategories")]

	public class ReportCategories extends ModelBase
	{

		public function ReportCategories() {
			remoteObjectName = "com.efi.printsmith.data.ReportCategories";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}
package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ReportCategories")]

	public class ReportCategories extends ModelBase
	{

		public function ReportCategories() {
		
		}
		public var name:String = "";
		public var key:String = "";
	
	}
}
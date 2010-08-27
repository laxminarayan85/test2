package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesCashRegister")]
	[Managed]
	
	public dynamic class PreferencesCashRegister extends ModelBase
	{

		public function PreferencesCashRegister() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesCashRegister";
		}
		public var isDeleted:Boolean=false;
				
		public var tax:Boolean = false;
		public var title:String = "";
		public var category:SalesCategory;
		public var rate:Number = 0;
		public var taxTable:TaxTable;
		public var taxCodes:TaxCodes;
	
	}
}
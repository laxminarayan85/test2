package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesCashRegister")]

	public class PreferencesCashRegister extends ModelBase
	{

		public function PreferencesCashRegister() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesCashRegister";
		}
				
		public var tax:Boolean = true;
		public var title:String = "";
		public var category:SalesCategory;
		public var rate:Number = 0;
		public var taxTable:TaxTable;
		public var taxCodes:TaxCodes;
	
	}
}
package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesCashRegister")]

	public class PreferencesCashRegister extends ModelBase
	{

		public function PreferencesCashRegister() {
		
		}
		public var tax:Boolean = true;
		public var title:String = "";
		public var category:SalesCategory = new SalesCategory();
		public var rate:Number = 0;
		public var taxTable:TaxTable = new TaxTable();
		public var taxCodes:TaxCodes = new TaxCodes();
	
	}
}
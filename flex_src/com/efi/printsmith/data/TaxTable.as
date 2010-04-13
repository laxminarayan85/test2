package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.TaxTable")]

	public class TaxTable extends ModelBase
	{

		public function TaxTable() {
			remoteObjectName = "com.efi.printsmith.data.TaxTable";
		}
				
		public var effectiveTaxRate:Number = 0;
		public var taxElements:ArrayCollection;
		public var taxTableIsCurrent:Boolean = false;
		public var taxShipping:Boolean = false;
		public var taxOnTax:Boolean = false;
		public var roundTaxUp:Boolean = false;
		public var taxInPrice:Boolean = false;
		public var doDetail:Boolean = false;
		public var dontRoundShownTaxElements:int = 0;
		public var name:String = "";
	
	}
}
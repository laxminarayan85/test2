package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.TaxTable")]

	public class TaxTable extends ModelBase
	{

		public function TaxTable() {
			remoteObjectName = "com.efi.printsmith.data.TaxTable";
		}
				
		public var effectiveTaxRate:Number = 0;
		public var taxElements:ArrayCollection;
		public var taxTableIsCurrent:Boolean = true;
		public var taxShipping:Boolean = true;
		public var taxOnTax:Boolean = true;
		public var roundTaxUp:Boolean = true;
		public var taxInPrice:Boolean = true;
		public var doDetail:Boolean = true;
		public var dontRoundShownTaxElements:int = 0;
		public var name:String = "";
	
	}
}
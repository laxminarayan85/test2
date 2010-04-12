package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TaxTable")]
	[Managed]
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
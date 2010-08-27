package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TaxTable")]
	[Managed]
	
	public dynamic class TaxTable extends ModelBase
	{

		public function TaxTable() {
			remoteObjectName = "com.efi.printsmith.data.TaxTable";
		}
		public var isDeleted:Boolean=false;
				
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
		public var abbr:String = "";
		public var tableCreateDateTime:Date = new Date();
		public var tableCreateLocalDateTime:Date = new Date();
		public var minAmount:Number = 0;
		public var defaultTable:Boolean = false;
		public var separateShipping:Boolean = false;
		public var disableTable:Boolean = false;
	
	}
}
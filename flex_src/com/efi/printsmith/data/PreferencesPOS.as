package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesPOS")]
	[Managed]
	
	public dynamic class PreferencesPOS extends ModelBase
	{

		public function PreferencesPOS() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesPOS";
		}
				
		public var receiptHeader:String = "";
		public var receiptFooter:String = "";
		public var receiptStartNumber:Boolean = false;
		public var startingNumber:int = 0;
		public var hideTaxLines:Boolean = false;
		public var receiptPrinterStatus:String = "";
		public var defaultPrinter:String = "";
		public var enableCashDrawer:Boolean = false;
		public var useMasterDrawer:Boolean = false;
		public var printReceipts:Boolean = false;
		public var print2forCreditCards:Boolean = false;
		public var print2forCash:Boolean = false;
		public var keepLocalSettings:Boolean = false;
		public var printInvoices:Boolean = false;
		public var lockSettings:Boolean = false;
		public var asciiCodeOpenDrawer:int = 0;
		public var blankLinesBeforeReceipt:int = 0;
		public var blankLinesAfterReceipt:int = 0;
		public var receiptStartCode:String = "";
		public var receiptEndCode:String = "";
		public var baudRate:String = "";
		public var stopBits:String = "";
		public var parity:String = "";
		public var dataSize:String = "";
	
	}
}
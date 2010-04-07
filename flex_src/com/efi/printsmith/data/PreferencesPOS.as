package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesPOS")]
	[Managed]
	public class PreferencesPOS extends ModelBase
	{

		public function PreferencesPOS() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesPOS";
		}
				
		public var receiptHeader:String = "";
		public var receiptFooter:String = "";
		public var receiptStartNumber:Boolean = true;
		public var startingNumber:int = 0;
		public var hideTaxLines:Boolean = true;
		public var receiptPrinterStatus:String = "";
		public var defaultPrinter:String = "";
		public var enableCashDrawer:Boolean = true;
		public var useMasterDrawer:Boolean = true;
		public var printReceipts:Boolean = true;
		public var print2forCreditCards:Boolean = true;
		public var print2forCash:Boolean = true;
		public var keepLocalSettings:Boolean = true;
		public var printInvoices:Boolean = true;
		public var lockSettings:Boolean = true;
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
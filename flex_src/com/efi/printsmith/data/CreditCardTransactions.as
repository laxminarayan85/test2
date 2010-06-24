package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CreditCardTransactions")]
	[Managed]
	
	public class CreditCardTransactions extends ModelBase
	{

		public function CreditCardTransactions() {
			remoteObjectName = "com.efi.printsmith.data.CreditCardTransactions";
		}
				
		public var transactionDate:Date = new Date();
		public var cardType:String = "";
		public var transactionType:String = "";
		public var transactionStatus:String = "";
		public var transactionResults:String = "";
		public var encryption:String = "";
		public var address:Address;
		public var cCHolderName:String = "";
		public var cCNumber:String = "";
		public var cCNumberDisplay:String = "";
		public var amount:Number = 0;
		public var taxInAmount:Boolean = false;
		public var invoice:Invoice;
		public var account:Account;
		public var contact:Contact;
		public var poNumber:String = "";
		public var referenceNumber:String = "";
		public var approvalCode:String = "";
		public var approvalDate:Date = new Date();
		public var message:String = "";
		public var permanent:Boolean = false;
		public var manualCode:String = "";
		public var failedAVS:Boolean = false;
		public var hasCVVdata:Boolean = false;
		public var trackDataUsed:Boolean = false;
		public var taxExempt:Boolean = false;
		public var tax:Number = 0;
		public var taxCode:TaxCodes;
		public var taxTable:TaxTable;
		public var user:String = "";
	
	}
}
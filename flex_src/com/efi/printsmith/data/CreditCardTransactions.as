package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	import com.efi.printsmith.Constants;
	
	[RemoteClass(alias="com.efi.printsmith.data.CreditCardTransactions")]
	[Managed]
	
	public dynamic class CreditCardTransactions extends ModelBase
	{

		public function CreditCardTransactions() {
			remoteObjectName = "com.efi.printsmith.data.CreditCardTransactions";
		}
		public var isDeleted:Boolean=false;
				
		public var transactionDate:Date = new Date();
		public var transactionType:int = Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeUnknown;
		public var transactionStatus:int = Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusUnknown;
		public var transactionResults:int = Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsUnknown;
		public var amount:Number = 0;
		public var taxInAmount:Boolean = false;
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
		public var userName:String = "";
		public var trackOne:String = "";
		public var trackTwo:String = "";
		public var tempCVV2:String = "";
		public var creditCard:CreditCard;
		public var account:Account;
		public var contact:Contact;
		public var wsId:int = 0;
		public var isCurrentTransaction:int = 0;
		public var orderName:String = "";
		public var orderNumber:String = "";
		public var verbalAuthCode:String = "";
		public var verbalAuthDate:Date = new Date();
		public var firstNumberPrefix:Number = 0;
		public var activeAccepted:Boolean = false;
	
	}
}
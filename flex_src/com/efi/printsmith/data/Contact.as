package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Contact")]
	[Managed]
	public class Contact extends Party
	{

		public function Contact() {
			remoteObjectName = "com.efi.printsmith.data.Contact";
		}
				
		public var shipToAddress:Address;
		public var parentAccount:Account;
		public var webAcctNameIncomplete:Boolean = true;
		public var webCatalogChange:Boolean = true;
		public var webStateChange:Boolean = true;
		public var transmitted:Boolean = true;
		public var useContactAddress:Boolean = true;
		public var isIndividual:Boolean = true;
		public var defaultSalesRep:SalesRep;
		public var mailerCampaigns:Boolean = true;
		public var creditCard:CreditCard;
		public var marketing:Marketing;
		public var campaigns:ArrayCollection;
		public var contactId:String = "";
	
	}
}
package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Contact")]

	public class Contact extends Party
	{

		public function Contact() {
			remoteObjectName = "com.efi.printsmith.data.Contact";
		}
				
		public var shipToAddress:Address;
		public var parentAccount:Account;
		public var webAcctNameIncomplete:Boolean = false;
		public var webCatalogChange:Boolean = false;
		public var webStateChange:Boolean = false;
		public var transmitted:Boolean = false;
		public var useContactAddress:Boolean = false;
		public var isIndividual:Boolean = false;
		public var defaultSalesRep:SalesRep;
		public var mailerCampaigns:Boolean = false;
		public var creditCard:CreditCard;
		public var marketing:Marketing;
		public var campaigns:ArrayCollection;
		public var contactId:String = "";
		public var webAccess:Boolean = false;
		public var webRegistered:Boolean = false;
		public var webContactID:String = "";
		public var webCatalog:WebCatalogs;
		public var webStatus:WebStatus;
	
	}
}
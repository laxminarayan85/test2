package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Contact")]

	public class Contact extends ModelBase
	{

		public function Contact() {
		
		}
		public var shipToAddress:Address;
		public var firstName:String = "";
		public var address:Address;
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
		public var lastName:String = "";
		public var jobTitle:String = "";
		public var suffix:String = "";
		public var prefix:String = "";
		public var salutation:String = "";
		public var comLinks:ArrayCollection;
	
	}
}
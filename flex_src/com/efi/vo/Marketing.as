package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Marketing")]

	public class Marketing extends ModelBase
	{

		public function Marketing() {
		
		}
		public var marketID:int = 0;
		public var followup:Date = new Date();
		public var birthDate:Date = new Date();
		public var user3:Date = new Date();
		public var user4:Date = new Date();
		public var user5:Date = new Date();
		public var leadSource:String = "";
		public var leadSource2:String = "";
		public var commonInterst:String = "";
		public var sportsInterst:String = "";
		public var user6:String = "";
		public var user7:String = "";
		public var user8:String = "";
		public var user9:String = "";
		public var typeWork:String = "";
		public var mailerType:String = "";
		public var customer:Boolean = true;
		public var prospect:Boolean = true;
		public var noMail:Boolean = true;
		public var personalAcct:Boolean = true;
		public var numberofEmployees:int = 0;
		public var annualRev:int = 0;
		public var businessType:BusinessType;
	
	}
}
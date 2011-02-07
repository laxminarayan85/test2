package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Marketing")]
	[Managed]
	
	public dynamic class Marketing extends ModelBase
	{

		public function Marketing() {
			remoteObjectName = "com.efi.printsmith.data.Marketing";
		}
		public var isDeleted:Boolean=false;
				
		public var marketID:int = 0;
		public var followup:Date = null;
		public var birthDate:Date = null;
		public var user3:Date = null;
		public var user4:Date = null;
		public var user5:Date = null;
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
		public var customer:Boolean = false;
		public var prospect:Boolean = false;
		public var noMail:Boolean = false;
		public var personalAcct:Boolean = false;
		public var numberofEmployees:int = 0;
		public var annualRev:int = 0;
		public var businessType:String = "";
	
	}
}
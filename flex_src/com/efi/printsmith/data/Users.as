package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Users")]
	[Managed]
	
	public dynamic class Users extends ModelBase
	{

		public function Users() {
			remoteObjectName = "com.efi.printsmith.data.Users";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var password:String = "";
		public var forcePasswordChange:Boolean = false;
		public var robustPassword:Boolean = false;
		public var noOverride:Boolean = false;
		public var overrideCredit:Boolean = false;
		public var lockSalesRep:Boolean = false;
		public var refundCreditCards:Boolean = false;
		public var noCashReturn:Boolean = false;
		public var showUserNameLog:Boolean = false;
		public var quickAccess:Boolean = false;
		public var accessLevel:AccessLevel;
		public var accessGroup:AccessGroup;
		public var disableUser:Boolean = false;
		public var prevPassword1:String = "";
		public var prevPassword2:String = "";
		public var prevPassword3:String = "";
		public var prevPassword4:String = "";
		public var loginAttempts:int = 0;
		public var lastLogin:Date = new Date();
		public var userAccessLevel:int = 0;
		public var passwordChangedDate:Date = new Date();
	
	}
}
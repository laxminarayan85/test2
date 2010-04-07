package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Users")]
	[Managed]
	public class Users extends ModelBase
	{

		public function Users() {
			remoteObjectName = "com.efi.printsmith.data.Users";
		}
				
		public var name:String = "";
		public var password:String = "";
		public var forcePasswordChange:Boolean = true;
		public var robustPassword:Boolean = true;
		public var noOverride:Boolean = true;
		public var overrideCredit:Boolean = true;
		public var lockSalesRep:Boolean = true;
		public var refundCreditCards:Boolean = true;
		public var noCashReturn:Boolean = true;
		public var showUserNameLog:Boolean = true;
		public var quickAccess:Boolean = true;
		public var accessLevel:AccessLevel;
		public var accessGroup:AccessGroup;
	
	}
}
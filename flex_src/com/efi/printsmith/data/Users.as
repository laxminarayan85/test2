package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Users")]

	public class Users extends ModelBase
	{

		public function Users() {
			remoteObjectName = "com.efi.printsmith.data.Users";
		}
				
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
	
	}
}
package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Users")]

	public class Users extends ModelBase
	{

		public function Users() {
		
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
		public var accessLevel:AccessLevel = new AccessLevel();
		public var accessGroup:AccessGroup = new AccessGroup();
	
	}
}
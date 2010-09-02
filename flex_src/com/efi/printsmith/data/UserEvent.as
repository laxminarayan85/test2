package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.UserEvent")]
	[Managed]
	
	public dynamic class UserEvent extends ModelBase
	{

		public function UserEvent() {
			remoteObjectName = "com.efi.printsmith.data.UserEvent";
		}
		public var isDeleted:Boolean=false;
				
		public var userName:String = "";
		public var dateStamp:Date = new Date();
		public var reasonCode:int = 0;
		public var eventString:String = "";
		public var workstationId:int = 0;
	
	}
}
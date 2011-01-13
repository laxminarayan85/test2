package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebConsole")]
	[Managed]
	
	public dynamic class WebConsole extends ModelBase
	{

		public function WebConsole() {
			remoteObjectName = "com.efi.printsmith.data.WebConsole";
		}
		public var isDeleted:Boolean=false;
				
		public var webStatus:WebStatus;
		public var webaction:String = "";
		public var webparents:String = "";
		public var webmessagetype:String = "";
		public var webtransactionID:String = "";
		public var websenddate:Date = null;
		public var servercode:String = "";
	
	}
}
package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebBase")]
	[Managed]
	
	public dynamic class WebBase extends ModelBase
	{

		public function WebBase() {
			remoteObjectName = "com.efi.printsmith.data.WebBase";
		}
		public var isDeleted:Boolean=false;
				
		public var contactName:String = "";
		public var contactPhone:String = "";
		public var contactEmail:String = "";
		public var transferMethod:int = 0;
		public var ftpUrl:String = "";
		public var ftpUserName:String = "";
		public var ftpPassword:String = "";
		public var ftpMode:String = "";
		public var ignoreLocalCurrencyFormat:Boolean = false;
		public var retryInterval:int = 0;
		public var maxRetries:int = 0;
		public var takenBy:String = "";
		public var responseDelay:int = 0;
		public var composerUrl:String = "";
		public var composerDelay:int = 0;
		public var autoStartConnection:Boolean = false;
		public var hiddenBackgroundTask:Boolean = false;
		public var autoOenWebConsole:Boolean = false;
		public var sendOutgoingDataImmediately:Boolean = false;
		public var receiveState:String = "";
		public var rejectState:String = "";
		public var webCompanyID:WebCompany;
	
	}
}
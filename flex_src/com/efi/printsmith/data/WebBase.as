package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebBase")]

	public class WebBase extends ModelBase
	{

		public function WebBase() {
			remoteObjectName = "com.efi.printsmith.data.WebBase";
		}
				
		public var contactName:String = "";
		public var contactPhone:String = "";
		public var contactEmail:String = "";
		public var transferMethod:int = 0;
		public var ftpUrl:String = "";
		public var ftpUserName:String = "";
		public var ftpPassword:String = "";
		public var ftpMode:int = 0;
		public var ignoreLocalCurrencyFormat:Boolean = true;
		public var retryInterval:int = 0;
		public var maxRetries:int = 0;
		public var takenBy:String = "";
		public var responseDelay:int = 0;
		public var composerUrl:String = "";
		public var composerDelay:int = 0;
		public var autoStartConnection:Boolean = true;
		public var hiddenBackgroundTask:Boolean = true;
		public var autoOenWebConsole:Boolean = true;
		public var sendOutgoingDataImmediately:Boolean = true;
		public var receiveState:String = "";
		public var rejectState:String = "";
	
	}
}
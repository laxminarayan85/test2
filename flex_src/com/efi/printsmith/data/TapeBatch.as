package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TapeBatch")]
	[Managed]
	
	public dynamic class TapeBatch extends ModelBase
	{

		public function TapeBatch() {
			remoteObjectName = "com.efi.printsmith.data.TapeBatch";
		}
		public var isDeleted:Boolean=false;
				
		public var name:int = 0;
		public var openDate:Date = new Date();
		public var appVersion:String = "";
		public var closed:Boolean = false;
		public var sessionBatches:ArrayCollection;
	
	}
}
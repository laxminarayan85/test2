package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DigitalAsset")]
	[Managed]
	
	public dynamic class DigitalAsset extends ModelBase
	{

		public function DigitalAsset() {
			remoteObjectName = "com.efi.printsmith.data.DigitalAsset";
		}
		public var isDeleted:Boolean=false;
				
		public var repositoryPath:String = "";
		public var job:Job;
		public var dateAdded:Date = new Date();
		public var originalFilename:String = "";
		public var fileType:String = "";
	
	}
}
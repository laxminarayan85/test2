package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Grade")]
	[Managed]
	
	public dynamic class Grade extends ModelBase
	{

		public function Grade() {
			remoteObjectName = "com.efi.printsmith.data.Grade";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var campaigns:ArrayCollection;
		public var gradeId:String = "";
	
	}
}
package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebQuestions")]
	[Managed]
	
	public dynamic class WebQuestions extends ModelBase
	{

		public function WebQuestions() {
			remoteObjectName = "com.efi.printsmith.data.WebQuestions";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var status:String = "";
		public var prompt:String = "";
		public var questionType:String = "";
		public var choices:ArrayCollection;
	
	}
}
package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebQuestions")]

	public class WebQuestions extends ModelBase
	{

		public function WebQuestions() {
			remoteObjectName = "com.efi.printsmith.data.WebQuestions";
		}
				
		public var name:String = "";
		public var status:String = "";
		public var prompt:String = "";
		public var questionType:int = 0;
		public var choices:ArrayCollection;
	
	}
}
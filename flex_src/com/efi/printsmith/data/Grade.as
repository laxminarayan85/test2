package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Grade")]

	public class Grade extends ModelBase
	{

		public function Grade() {
			remoteObjectName = "com.efi.printsmith.data.Grade";
		}
				
		public var name:String = "";
		public var campaigns:ArrayCollection;
		public var gradeId:String = "";
	
	}
}
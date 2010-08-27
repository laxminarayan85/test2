package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.NotePad")]
	[Managed]
	
	public dynamic class NotePad extends ModelBase
	{

		public function NotePad() {
			remoteObjectName = "com.efi.printsmith.data.NotePad";
		}
		public var isDeleted:Boolean=false;
				
		public var notesWho:String = "";
		public var phoneNumber:String = "";
		public var notesWhat:String = "";
		public var howMany:String = "";
		public var whatSize:String = "";
		public var paper:String = "";
		public var notes:String = "";
		public var notesWhen:String = "";
		public var showOnOpen:Boolean = false;
	
	}
}
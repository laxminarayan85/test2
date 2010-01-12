package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.NotePad")]

	public class NotePad extends ModelBase
	{

		public function NotePad() {
			remoteObjectName = "com.efi.printsmith.data.NotePad";
		}
				
		public var notesWho:String = "";
		public var phoneNumber:String = "";
		public var notesWhat:String = "";
		public var howMany:String = "";
		public var whatSize:String = "";
		public var paper:String = "";
		public var notes:String = "";
		public var notesWhen:String = "";
		public var showOnOpen:Boolean = true;
	
	}
}
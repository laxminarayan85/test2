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
				
		public var who:String = "";
		public var phoneNumber:String = "";
		public var what:String = "";
		public var howMany:String = "";
		public var whatSize:String = "";
		public var paper:String = "";
		public var notes:String = "";
		public var when:String = "";
		public var showOnOpen:Boolean = true;
	
	}
}
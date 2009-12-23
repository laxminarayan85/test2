package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.MailerType")]

	public class MailerType extends ModelBase
	{

		public function MailerType() {
			remoteObjectName = "com.efi.printsmith.data.MailerType";
		}
				
		public var name:String = "";
	
	}
}
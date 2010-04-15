package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.MailerType")]
	[Managed]
	
	public class MailerType extends ModelBase
	{

		public function MailerType() {
			remoteObjectName = "com.efi.printsmith.data.MailerType";
		}
				
		public var name:String = "";
	
	}
}
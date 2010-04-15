package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebChoices")]
	[Managed]
	
	public class WebChoices extends ModelBase
	{

		public function WebChoices() {
			remoteObjectName = "com.efi.printsmith.data.WebChoices";
		}
				
		public var name:String = "";
	
	}
}
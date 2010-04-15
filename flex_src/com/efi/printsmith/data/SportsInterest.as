package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SportsInterest")]
	[Managed]
	
	public class SportsInterest extends ModelBase
	{

		public function SportsInterest() {
			remoteObjectName = "com.efi.printsmith.data.SportsInterest";
		}
				
		public var name:String = "";
	
	}
}
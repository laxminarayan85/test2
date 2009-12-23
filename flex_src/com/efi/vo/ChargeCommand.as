package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ChargeCommand")]

	public class ChargeCommand extends ModelBase
	{

		public function ChargeCommand() {
			remoteObjectName = "com.efi.printsmith.data.ChargeCommand";
		}
				
		public var children:ArrayCollection;
		public var name:String = "";
	
	}
}
package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.DepositType")]

	public class DepositType extends ModelBase
	{

		public function DepositType() {
			remoteObjectName = "com.efi.printsmith.data.DepositType";
		}
				
		public var name:String = "";
	
	}
}
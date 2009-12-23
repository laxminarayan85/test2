package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SpeedTable")]

	public class SpeedTable extends ModelBase
	{

		public function SpeedTable() {
			remoteObjectName = "com.efi.printsmith.data.SpeedTable";
		}
				
		public var name:String = "";
	
	}
}
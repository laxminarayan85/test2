package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.TaxTablesElements")]

	public class TaxTablesElements extends ModelBase
	{

		public function TaxTablesElements() {
			remoteObjectName = "com.efi.printsmith.data.TaxTablesElements";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}
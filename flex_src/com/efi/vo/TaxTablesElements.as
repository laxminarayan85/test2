package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
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
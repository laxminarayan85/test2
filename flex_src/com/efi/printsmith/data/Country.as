package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="com.efi.printsmith.data.Country")]
	[Managed]
	
	public dynamic class Country extends ModelBase
	{

		public function Country() {
			remoteObjectName = "com.efi.printsmith.data.Country";
		}
				
		public var name:String = "";
		
		public var addressFormattings:ArrayCollection;
	
	}
}
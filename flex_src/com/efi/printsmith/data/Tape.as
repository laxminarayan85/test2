package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Tape")]
	[Managed]
	
	public dynamic class Tape extends ModelBase
	{

		public function Tape() {
			remoteObjectName = "com.efi.printsmith.data.Tape";
		}
		public var isDeleted:Boolean=false;
				
		public var batches:ArrayCollection;
	
	}
}
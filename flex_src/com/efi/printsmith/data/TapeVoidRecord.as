package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TapeVoidRecord")]
	[Managed]
	
	public dynamic class TapeVoidRecord extends Transaction
	{

		public function TapeVoidRecord() {
			remoteObjectName = "com.efi.printsmith.data.TapeVoidRecord";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}
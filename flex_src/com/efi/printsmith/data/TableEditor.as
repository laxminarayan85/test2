package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TableEditor")]
	[Managed]
	
	public dynamic class TableEditor extends ModelBase
	{

		public function TableEditor() {
			remoteObjectName = "com.efi.printsmith.data.TableEditor";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var userName:String = "";
	
	}
}
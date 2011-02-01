package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TableProperties")]
	[Managed]
	
	public dynamic class TableProperties extends ModelBase
	{

		public function TableProperties() {
			remoteObjectName = "com.efi.printsmith.data.TableProperties";
		}
		public var isDeleted:Boolean=false;
				
		public var tableName:String = "";
		public var userName:String = "";
		public var enabled:Boolean = false;
		public var sortBy:String = "";
		public var status:String = "";
	
	}
}
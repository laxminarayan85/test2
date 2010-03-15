package com.efi.printsmith.data
{
	public class ModelBase
	{
		public static var remoteObjectName:String;
		public var id:Number;
		public var created:Date;
		public var modified:Date;
		public var prevId:String="";
		
		public function ModelBase()
		{
		}
		
		public function getRemoteObjectName():String {
			return remoteObjectName;
		}
	}
}
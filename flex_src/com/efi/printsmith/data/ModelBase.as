package com.efi.printsmith.data
{
	import net.digitalprimates.persistence.hibernate.HibernateBean;
	public class ModelBase extends HibernateBean
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
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
		public static var uid:Number; /* Needed since the base class of ModelBase on the Java side implements Serializable. */
		
		public function ModelBase()
		{
		}
		
		public function getRemoteObjectName():String {
			return remoteObjectName;
		}
	}
}
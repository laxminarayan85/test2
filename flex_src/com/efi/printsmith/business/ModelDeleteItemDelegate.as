package com.efi.printsmith.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import com.efi.printsmith.data.ModelBase;
	
	import flash.utils.describeType;
	
	import mx.rpc.IResponder;
	
	public class ModelDeleteItemDelegate
	{
		private var responder:IResponder;
		private var service:Object;
		
		public function ModelDeleteItemDelegate(responder:IResponder) {
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("dataService");
		}
		
		public function deleteItem(item:ModelBase):void {
			var classInfo:XML = describeType(item);
			var className:String = classInfo.@name;
			className = className.substr(className.lastIndexOf("::")+2,className.length-1);
			var call:Object = service.deleteItem(className,item.id);
			call.addResponder(responder);
		}
	}
}
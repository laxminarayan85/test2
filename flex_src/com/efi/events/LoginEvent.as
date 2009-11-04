package com.efi.events
{
	import flash.events.Event;
	
	import com.adobe.cairngorm.control.CairngormEvent;
	
	import mx.rpc.IResponder;

	public class LoginEvent extends CairngormEvent
	{
		public static const LOGIN:String = "Login";
		public var username:String;
		public var password:String;
		public var callbacks:IResponder;
		
		public function LoginEvent(username:String, password:String, callbacks:IResponder=null)
		{
			
			this.username = username;
			this.password = password;
			this.callbacks = callbacks;
			super(LOGIN);
		}
		
		override public function clone():Event {
			return new LoginEvent(username, password, callbacks);
		}
	}
}
package com.efi.printsmith.events
{
	import flash.events.Event;
	import mx.rpc.IResponder;

	public class LoginEvent extends EventBase
	{
		public static const LOGIN:String = "Login";
		public var username:String;
		public var password:String;
		
		public function LoginEvent(username:String, password:String, callbacks:IResponder=null)
		{
			this.username = username;
			this.password = password;
			super(LOGIN, callbacks);
		}
		
		override public function clone():Event {
			return new LoginEvent(username, password, callbacks);
		}
	}
}
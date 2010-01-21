package com.efi.printsmith.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.efi.printsmith.business.LoginDelegate;
	import com.efi.printsmith.events.LoginEvent;
	import com.efi.printsmith.model.ModelLocator;
	
	import mx.rpc.IResponder;
	
	public class LoginCommand implements ICommand {
		public var modelLocator:ModelLocator = ModelLocator.getInstance();

		public function LoginCommand() {
		}

		public function execute(event:CairngormEvent):void{
			var loginEvent:LoginEvent = event as LoginEvent;
			var delegate:LoginDelegate = new LoginDelegate(loginEvent.callbacks);
			delegate.validateLogin(loginEvent.username, loginEvent.password);
		}
	}
}

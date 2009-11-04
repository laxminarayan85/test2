package com.efi.control
{
	import com.adobe.cairngorm.control.FrontController;
	import com.efi.events.LoginEvent;
	import com.efi.commands.LoginCommand;
	
	public class MainController extends FrontController
	{
		public function MainController() {
			this.initialize();
		}
		
		public function initialize():void {
			this.addCommand(LoginEvent.LOGIN, LoginCommand);
		}
		
	}
}

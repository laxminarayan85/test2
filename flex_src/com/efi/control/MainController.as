package com.efi.control
{
	import com.adobe.cairngorm.control.FrontController;
	import com.efi.events.*;
	import com.efi.commands.*;

	public class MainController extends FrontController
	{
		public function MainController() {
			this.initialize();
		}
		
		public function initialize():void {
			this.addCommand(LoginEvent.LOGIN, LoginCommand);
			this.addCommand(ModelAddUpdateEvent.ADDUPDATE, ModelAddUpdateCommand);
			this.addCommand(ModelDeleteItemEvent.DELETE, ModelDeleteItemCommand);
			this.addCommand(ModelGetAllEvent.GETALL, ModelGetAllCommand);
		}
		
	}
}

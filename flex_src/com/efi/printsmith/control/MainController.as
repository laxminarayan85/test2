package com.efi.printsmith.control
{
	import com.adobe.cairngorm.control.FrontController;
	import com.efi.printsmith.events.*;
	import com.efi.printsmith.commands.*;
	import com.efi.printsmith.commands.commandCommands.*;
	import com.efi.printsmith.events.commandEvents.*;
	
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
			this.addCommand(ModelQueryByCriteriaEvent.QUERYBYCRITERIA, ModelQueryByCriteriaCommand);
			this.addCommand(ModelGetSingleEvent.GETSINGLE, ModelGetSingleCommand);
			this.addCommand(PriceJobEvent.PRICEJOB, PriceJobCommand);
			this.addCommand(PriceChargeEvent.PRICECHARGE, PriceChargeCommand);
			this.addCommand(PriceInvoiceEvent.PRICEINVOICE, PriceInvoiceCommand);
			this.addCommand(EditCustomerEvent.COMMANDID, EditCustomerCommand);
		}
		
	}
}

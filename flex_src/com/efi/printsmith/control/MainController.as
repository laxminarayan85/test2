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
			
			//security registered items
			//default quick access panel items
			this.addCommand(ModelAddUpdateEvent.ADDUPDATE, ModelAddUpdateCommand);
			this.addCommand(ModelDeleteItemEvent.DELETE, ModelDeleteItemCommand);
			this.addCommand(ModelGetAllEvent.GETALL, ModelGetAllCommand);
			this.addCommand(ModelQueryByCriteriaEvent.QUERYBYCRITERIA, ModelQueryByCriteriaCommand);
			this.addCommand(ModelGetSingleEvent.GETSINGLE, ModelGetSingleCommand);
			this.addCommand(PriceJobEvent.PRICEJOB, PriceJobCommand);
			this.addCommand(PriceChargeEvent.PRICECHARGE, PriceChargeCommand);
			this.addCommand(PriceInvoiceEvent.PRICEINVOICE, PriceInvoiceCommand);
			this.addCommand(EditCustomerEvent.COMMANDID, EditCustomerCommand);
			this.addCommand(EditChargeDefinitionEvent.COMMANDID, EditChargeDefinitionCommand);
			this.addCommand(EditContactEvent.COMMANDID, EditContactCommand);
			this.addCommand(EditCopierDefinitionEvent.COMMANDID, EditCopierDefinitionCommand);
			this.addCommand(EditPressDefinitionEvent.COMMANDID, EditPressDefinitionCommand);
			this.addCommand(EditStockDefinitionEvent.COMMANDID, EditStockDefinitionCommand);
			this.addCommand(EditSystemPreferencesEvent.COMMANDID, EditSystemPreferencesCommand);
			this.addCommand(EditUserEvent.COMMANDID, EditUserCommand);
			this.addCommand(EditCashRegisterEvent.COMMANDID, EditCashRegisterCommand);
			this.addCommand(EditAccountHistoryEvent.COMMANDID, EditAccountHistoryCommand);
			this.addCommand(EditEstimateHistoryEvent.COMMANDID, EditEstimateHistoryCommand);
			this.addCommand(EditPendingListEvent.COMMANDID, EditPendingListCommand);
			this.addCommand(EditEmployeeEvent.COMMANDID, EditEmployeeCommand);
			this.addCommand(EditScheduleEvent.COMMANDID, EditScheduleCommand);
			this.addCommand(EditSecurityEvent.COMMANDID, EditSecurityCommand);
			this.addCommand(EditTrackerEvent.COMMANDID, EditTrackerCommand);
			this.addCommand(EditPricingEvent.COMMANDID, EditPricingCommand);
			this.addCommand(EditClockInOutEvent.COMMANDID, EditClockInOutCommand);
			this.addCommand(EditCreateEstimateEvent.COMMANDID, EditCreateEstimateCommand);
			this.addCommand(EditEditEstimateEvent.COMMANDID, EditEditEstimateCommand);
			this.addCommand(EditCreateInvoiceEvent.COMMANDID, EditCreateInvoiceCommand);
			this.addCommand(EditEditInvoiceEvent.COMMANDID, EditEditInvoiceCommand);

			//form level items
			this.addCommand(DeleteStockDefinitionEvent.COMMANDID, DeleteStockDefinitionCommand);

			this.addCommand(AccountsAddressPanelEvent.COMMANDID, AccountsAddressPanelCommand);
			this.addCommand(AccountsCreditControlPanelEvent.COMMANDID, AccountsCreditControlPanelCommand);
			this.addCommand(AccountsLogPanelEvent.COMMANDID, AccountsLogPanelCommand);
			this.addCommand(AccountsMarketingPanelEvent.COMMANDID, AccountsMarketingPanelCommand);
			this.addCommand(AccountsNotesPanelEvent.COMMANDID, AccountsNotesPanelCommand);
			this.addCommand(AccountsSalesPanelEvent.COMMANDID, AccountsSalesPanelCommand);
			this.addCommand(AccountsSettingsPanelEvent.COMMANDID, AccountsSettingsPanelCommand);
			this.addCommand(AccountsWebPanelEvent.COMMANDID, AccountsWebPanelCommand);
			
						
		}
		
	}
}

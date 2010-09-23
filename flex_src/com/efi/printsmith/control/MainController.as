package com.efi.printsmith.control
{
	import com.adobe.cairngorm.control.FrontController;
	import com.efi.printsmith.commands.*;
	import com.efi.printsmith.commands.commandCommands.*;
	import com.efi.printsmith.commands.commandCommands.Accounts.*;
	import com.efi.printsmith.commands.commandCommands.Contacts.*;
	import com.efi.printsmith.commands.commandCommands.EditForms.*;
	import com.efi.printsmith.commands.commandCommands.Employees.*;
	import com.efi.printsmith.commands.commandCommands.Invoice.*;
	import com.efi.printsmith.commands.commandCommands.PendingList.*;
	import com.efi.printsmith.commands.commandCommands.StockDefinitions.*;
	import com.efi.printsmith.commands.commandCommands.SystemPreferences.*;
	import com.efi.printsmith.commands.commandCommands.WebAdmin.*;
	import com.efi.printsmith.events.*;
	import com.efi.printsmith.events.commandEvents.*;
	import com.efi.printsmith.events.commandEvents.Accounts.*;
	import com.efi.printsmith.events.commandEvents.Contacts.*;
	import com.efi.printsmith.events.commandEvents.EditForms.*;
	import com.efi.printsmith.events.commandEvents.Employees.*;
	import com.efi.printsmith.events.commandEvents.Invoice.*;
	import com.efi.printsmith.events.commandEvents.PendingList.*;
	import com.efi.printsmith.events.commandEvents.StockDefinitions.*;
	import com.efi.printsmith.events.commandEvents.SystemPreferences.*;
	import com.efi.printsmith.events.commandEvents.WebAdmin.*;

	public class MainController extends FrontController
	{
		public function MainController() {
			this.initialize();
		}
		
		public function initialize():void {
			this.addCommand(LoginEvent.LOGIN, LoginCommand);
			
			//security registered items
			//default quick access panel items
			this.addCommand(EncryptDataEvent.ENCRYPTDATA, EncryptDataCommand);
			this.addCommand(EncryptDataEvent.DECRYPTDATA, EncryptDataCommand);
			this.addCommand(EncryptCCTransEvent.ENCRYPTCCTRANS, EncryptCCTCommand);
			this.addCommand(EncryptCCTransEvent.DECRYPTCCTRANS, EncryptCCTCommand);
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
			//this.addCommand(EditClockInOutEvent.COMMANDID, EditClockInOutCommand);
			this.addCommand(EditCreateEstimateEvent.COMMANDID, EditCreateEstimateCommand);
			this.addCommand(EditEditEstimateEvent.COMMANDID, EditEditEstimateCommand);
			this.addCommand(EditCreateInvoiceEvent.COMMANDID, EditCreateInvoiceCommand);
			this.addCommand(EditEditInvoiceEvent.COMMANDID, EditEditInvoiceCommand);
			this.addCommand(EditWorkInProgressEvent.COMMANDID, EditWorkInProgressCommand);
			this.addCommand(EditWebAdminEvent.COMMANDID, EditWebAdminCommand);
			this.addCommand(EditPaymentEvent.COMMANDID, EditPaymentCommand);
			this.addCommand(ShowCreditCardMgrEvent.COMMANDID, ShowCreditCardMgrCommand);

			//form level items
			this.addCommand(DeleteStockDefinitionEvent.COMMANDID, DeleteStockDefinitionCommand);
			this.addCommand(DeleteAccountEvent.COMMANDID, DeleteAccountCommand);
			
			this.addCommand(AccountsAddressPanelEvent.COMMANDID, AccountsAddressPanelCommand);
			this.addCommand(AccountsCreditControlPanelEvent.COMMANDID, AccountsCreditControlPanelCommand);
			this.addCommand(AccountsLogPanelEvent.COMMANDID, AccountsLogPanelCommand);
			this.addCommand(AccountsMarketingPanelEvent.COMMANDID, AccountsMarketingPanelCommand);
			this.addCommand(AccountsNotesPanelEvent.COMMANDID, AccountsNotesPanelCommand);
			this.addCommand(AccountsSalesPanelEvent.COMMANDID, AccountsSalesPanelCommand);
			this.addCommand(AccountsSettingsPanelEvent.COMMANDID, AccountsSettingsPanelCommand);
			this.addCommand(AccountsWebPanelEvent.COMMANDID, AccountsWebPanelCommand);

			this.addCommand(ContactsAddressPanelEvent.COMMANDID, ContactsAddressPanelCommand);
			this.addCommand(ContactsCreditInfoPanelEvent.COMMANDID, ContactsCreditInfoPanelCommand);
			this.addCommand(ContactsMarketingPanelEvent.COMMANDID, ContactsMarketingPanelCommand);
			this.addCommand(ContactsWebPanelEvent.COMMANDID, ContactsWebPanelCommand);
			this.addCommand(ContactsCampaignsPanelEvent.COMMANDID, ContactsCampaignsPanelCommand);

			this.addCommand(EmployeeClockInOutEvent.COMMANDID, EmployeeClockInOutCommand);
			this.addCommand(EmployeeClockOptionsEvent.COMMANDID, EmployeeClockOptionsCommand);
			this.addCommand(EmployeeEmployeesEvent.COMMANDID, EmployeeEmployeesCommand);
			this.addCommand(EmployeeEmployeesPersonalPanelEvent.COMMANDID, EmployeeEmployeesPersonalPanelCommand); 
			this.addCommand(EmployeeEmployeesProductionPanelEvent.COMMANDID, EmployeeEmployeesProductionPanelCommand);
			this.addCommand(EmployeeEmployeesSettingsPanelEvent.COMMANDID, EmployeeEmployeesSettingsPanelCommand);
			this.addCommand(EmployeeTimeCardsEvent.COMMANDID, EmployeeTimeCardsCommand);
			this.addCommand(EmployeeTimePeriodsEvent.COMMANDID, EmployeeTimePeriodsCommand);

			this.addCommand(SystemPreferencesAddressFormattingPanelEvent.COMMANDID, SystemPreferencesAddressFormattingPanelCommand);
			this.addCommand(SystemPreferencesAgingPeriodsPanelEvent.COMMANDID, SystemPreferencesAgingPeriodsPanelCommand);
			this.addCommand(SystemPreferencesAlternateCurrencyPanelEvent.COMMANDID, SystemPreferencesAlternateCurrencyPanelCommand);
			this.addCommand(SystemPreferencesBehaviorPanelEvent.COMMANDID, SystemPreferencesBehaviorPanelCommand);
			this.addCommand(SystemPreferencesBusinessCalendarPanelEvent.COMMANDID, SystemPreferencesBusinessCalendarPanelCommand);
			this.addCommand(SystemPreferencesCashDrawerPanelEvent.COMMANDID, SystemPreferencesCashDrawerPanelCommand);
			this.addCommand(SystemPreferencesCashRegisterPanelEvent.COMMANDID, SystemPreferencesCashRegisterPanelCommand);
			this.addCommand(SystemPreferencesCompanyPanelEvent.COMMANDID, SystemPreferencesCompanyPanelCommand);
			this.addCommand(SystemPreferencesCreditCardInfoPanelEvent.COMMANDID, SystemPreferencesCreditCardInfoPanelCommand);
			this.addCommand(SystemPreferencesCreditDefaultsPanelEvent.COMMANDID, SystemPreferencesCreditDefaultsPanelCommand);
			this.addCommand(SystemPreferencesEstimatorBehaviorPanelEvent.COMMANDID, SystemPreferencesEstimatorBehaviorPanelCommand);
			this.addCommand(SystemPreferencesEstimatorPrintingPanelEvent.COMMANDID, SystemPreferencesEstimatorPrintingPanelCommand);
			this.addCommand(SystemPreferencesGLProfilesPanelEvent.COMMANDID, SystemPreferencesGLProfilesPanelCommand);
			this.addCommand(SystemPreferencesInternationalPanelEvent.COMMANDID, SystemPreferencesInternationalPanelCommand);
			this.addCommand(SystemPreferencesJobTicketPanelEvent.COMMANDID, SystemPreferencesJobTicketPanelCommand);
			this.addCommand(SystemPreferencesJournalEntriesPanelEvent.COMMANDID, SystemPreferencesJournalEntriesPanelCommand);
			this.addCommand(SystemPreferencesMarkupsPanelEvent.COMMANDID, SystemPreferencesMarkupsPanelCommand);
			this.addCommand(SystemPreferencesNumbersPanelEvent.COMMANDID, SystemPreferencesNumbersPanelCommand);
			this.addCommand(SystemPreferencesPaperCalculatorPanelEvent.COMMANDID, SystemPreferencesPaperCalculatorPanelCommand);
			this.addCommand(SystemPreferencesPendingListPanelEvent.COMMANDID, SystemPreferencesPendingListPanelCommand);
			this.addCommand(SystemPreferencesPricingMethodPanelEvent.COMMANDID, SystemPreferencesPricingMethodPanelCommand);
			this.addCommand(SystemPreferencesQuantityBreaksPanelEvent.COMMANDID, SystemPreferencesQuantityBreaksPanelCommand);
			this.addCommand(SystemPreferencesReceiptPanelEvent.COMMANDID, SystemPreferencesReceiptPanelCommand);
			this.addCommand(SystemPreferencesSalesCategoriesPanelEvent.COMMANDID, SystemPreferencesSalesCategoriesPanelCommand);
			this.addCommand(SystemPreferencesStockDefinitionsPanelEvent.COMMANDID, SystemPreferencesStockDefinitionsPanelCommand);
			this.addCommand(SystemPreferencesStocksandSizesPanelEvent.COMMANDID, SystemPreferencesStocksandSizesPanelCommand);
			
			this.addCommand(PendingListDeliverEvent.COMMANDID, PendingListDeliverCommand);
			this.addCommand(PendingListDueDateEvent.COMMANDID, PendingListDueDateCommand);
			this.addCommand(PendingListLocationEvent.COMMANDID, PendingListLocationCommand);
			this.addCommand(PendingListNotifyEvent.COMMANDID, PendingListNotifyCommand);
			this.addCommand(PendingListOpenEvent.COMMANDID, PendingListOpenCommand);
			this.addCommand(PendingListPickupEvent.COMMANDID, PendingListPickupCommand);
			this.addCommand(PendingListScheduleEvent.COMMANDID, PendingListScheduleCommand);
			this.addCommand(PendingListStatusEvent.COMMANDID, PendingListStatusCommand);
			this.addCommand(PendingListTrackerEvent.COMMANDID, PendingListTrackerCommand);
			
			this.addCommand(InvoiceChargesEvent.COMMANDID, InvoiceChargesCommand);
			this.addCommand(InvoiceJobsEvent.COMMANDID, InvoiceJobsCommand);

			this.addCommand(WebAdminAdminPanelEvent.COMMANDID, WebAdminAdminPanelCommand);
			this.addCommand(WebAdminCatagoriesPanelEvent.COMMANDID, WebAdminCatagoriesPanelCommand);
			this.addCommand(WebAdminCatalogsPanelEvent.COMMANDID, WebAdminCatalogsPanelCommand);
			this.addCommand(WebAdminGraphicsPanelEvent.COMMANDID, WebAdminGraphicsPanelCommand);
			this.addCommand(WebAdminProductsPanelEvent.COMMANDID, WebAdminProductsPanelCommand);
			this.addCommand(WebAdminQuestionsPanelEvent.COMMANDID, WebAdminQuestionsPanelCommand);
			this.addCommand(WebAdminSitePanelEvent.COMMANDID, WebAdminSitePanelCommand);

			this.addCommand(EditWebLocationsEvent.COMMANDID, EditWebLocationsCommand);
			this.addCommand(EditWebConsoleEvent.COMMANDID, EditWebConsoleCommand); 
			this.addCommand(TableEditorEvent.COMMANDID, TableEditorCommand); 
			this.addCommand(ChangePasswordEvent.COMMANDID, ChangePasswordCommand);
			this.addCommand(SalesTaxEvent.COMMANDID, SalesTaxCommand);
			this.addCommand(WasteChartEvent.COMMANDID, WasteChartCommand);
			this.addCommand(OrderStockEvent.COMMANDID, OrderStockCommand);
			this.addCommand(StockOrderEvent.COMMANDID, StockOrderCommand);
			this.addCommand(JournalEvent.COMMANDID, JournalCommand);
			}
		
	}
}

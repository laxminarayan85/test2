package com.efi.printsmith
{
	public class Constants
	{
		static public const PAPER_CALCULATOR_FOLIO_NONE:String = "NONE";
		static public const PAPER_CALCULATOR_FOLIO_LEFT:String = "Left";
		static public const PAPER_CALCULATOR_FOLIO_TOP:String = "Top";
		static public const PAPER_CALCULATOR_GRIPPER_NONE:String = "NONE";
		static public const PAPER_CALCULATOR_GRIPPER_LEFT:String = "Left";
		static public const PAPER_CALCULATOR_GRIPPER_TOP:String = "Top";

		static public const PAPER_CALCULATOR_GRAIN_DIRECTION_NEITHER:String = "NEITHER";
		static public const PAPER_CALCULATOR_GRAIN_DIRECTION_MATCH_GRAIN:String = "MATCH";
		static public const PAPER_CALCULATOR_GRAIN_DIRECTION_SWING_COMBINATION:String = "SWING";

		static public const JOB_RUN_METHOD_SHEETWISE:String = "SHEETWISE";
		static public const JOB_RUN_METHOD_WORK_TURN:String = "WORKANDTURN";
		static public const JOB_RUN_METHOD_WORK_TUMBLE:String = "WORKANDTUMBLE";
		
		static public const PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH:Number = 1;
		static public const PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:Number = 2;
		static public const PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:Number = 3;

		static public const USER_EVENT_LOGIN:Number = 1;
		static public const USER_EVENT_LOGOUT:Number = 2;
		static public const USER_EVENT_FAILED_LOGIN:Number = 3;
		static public const USER_EVENT_PASSWORD_CHANGE:Number = 4;
		static public const USER_EVENT_CREDITCARD_TAKEN:Number = 5;

		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeUnknown:Number = 0;
		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeManualEntry:Number = 1;
		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypePurchase:Number = 2;
		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeCredit:Number = 3;
		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeAuthOnly:Number = 4;
		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReversal:Number = 5;
		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeAdjustment:Number = 6;
		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeKeepOnFile:Number = 7;
		static public const CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReAutorize:Number = 7;

		static public const CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusUnknown:Number = 0;
		static public const CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusWaiting:Number = 1;
		static public const CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete:Number = 2;
		static public const CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusTimedOut:Number = 3;
		static public const CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusVoided:Number = 4;
		static public const CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusCanceled:Number = 5;

		static public const CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsUnknown:Number = 0;
		static public const CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsApproved:Number = 1;
		static public const CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined:Number = 2;
		static public const CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError:Number = 3;
		static public const CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsAuthHold:Number = 4;
		static public const CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsCallCenter:Number = 5;
		static public const CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsReversed:Number = 6;
		static public const CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsTimeOut:Number = 7;
		
		static public const PENDING_PICK_UP:String = "pickup";
		static public const PENDING_STATUS:String = "status";
		static public const PENDING_LOCATION:String = "location";
		static public const PENDING_OPEN:String = "open";
		static public const PENDING_NOTIFY:String = "notify";
		static public const PENDING_DUEDATE:String = "duedate";
		static public const PENDING_DELIVER:String = "deliver";
		static public const PENDING_SCHEDULE:String = "schedule";
		static public const PENDING_TRACKER:String = "tracker";
		
		static public const ACCOUNT_HISTORY_TYPE_INVPICKUP:String = "Invoice Pickup";
		static public const ACCOUNT_HISTORY_TYPE_PAYMENT:String = "Payment to Account";
		static public const ACCOUNT_HISTORY_TYPE_JOURNALENTRY:String = "Journal Entry";
		static public const ACCOUNT_HISTORY_TYPE_FINANCECHARGE:String = "Finance Charge";
		static public const ACCOUNT_HISTORY_TYPE_TRANSFER:String = "Transfer";
		static public const ACCOUNT_HISTORY_TYPE_DEPOSITTAKEN:String = "Deposit Taken";
		static public const ACCOUNT_HISTORY_TYPE_DEPOSITRETURN:String = "Deposit Returned";

		static public const ACCOUNT_TYPE_CASH_CHECK_CREDIT:String = "cash_check_credit";
		static public const ACCOUNT_TYPE_FULL_DEPOSIT:String = "full_deposit";
		static public const ACCOUNT_TYPE_CASH_ONLY:String = "cash_only";
		static public const ACCOUNT_TYPE_CHARGE:String = "charge_acct";
		static public const ACCOUNT_TYPE_CARD_ON_FILE:String = "credit_card_on_file";

		static public const POS_CASH_REGISTER_PAYMODE_CASH:String = "Cash";
		static public const POS_CASH_REGISTER_PAYMODE_CREDITCARD:String = "Credit Card";
		static public const POS_CASH_REGISTER_PAYMODE_CHECK:String = "Check";
		static public const POS_CASH_REGISTER_PAYMODE_CHARGE:String = "Charge";
		static public const POS_CASH_REGISTER_PAYMODE_DRAFT:String = "Draft";
		static public const POS_CASH_REGISTER_PAYMODE_DEPOSIT:String = "Deposit";
		
		static public const INVOICE_DEPOSIT_TYPE_CASH:int = 1;
		static public const INVOICE_DEPOSIT_TYPE_CHECK:int = 2;
		static public const INVOICE_DEPOSIT_TYPE_CREDIT_CARD:int = 3;
		static public const INVOICE_DEPOSIT_ENTRY_CREDIT_CARD_GENERIC:int = 0;
		
									
		public function Constants()
		{
		}
	}
}
package com.efi.printsmith;

public class Constants {
	public final static String PAPER_CALCULATOR_FOLIO_NONE = "NONE";
	public final static String PAPER_CALCULATOR_FOLIO_LEFT = "Left";
	public final static String PAPER_CALCULATOR_FOLIO_TOP = "Top";
	public final static String PAPER_CALCULATOR_GRIPPER_NONE = "NONE";
	public final static String PAPER_CALCULATOR_GRIPPER_LEFT = "Left";
	public final static String PAPER_CALCULATOR_GRIPPER_TOP = "Top";

	public final static String PAPER_CALCULATOR_GRAIN_DIRECTION_NEITHER = "NEITHER";
	public final static String PAPER_CALCULATOR_GRAIN_DIRECTION_MATCH_GRAIN = "MATCH";
	public final static String PAPER_CALCULATOR_GRAIN_DIRECTION_SWING_COMBINATION = "SWING";

	public final static String JOB_RUN_METHOD_SHEETWISE = "SHEETWISE";
	public final static String JOB_RUN_METHOD_WORK_TURN = "WORKANDTURN";
	public final static String JOB_RUN_METHOD_WORK_TUMBLE = "WORKANDTUMBLE";
	
	public static final int PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH = 1;
	public static final int PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN = 2;
	public static final int PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH = 3;
	
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeUnknown = 0;
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeManualEntry = 1;
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypePurchase = 2;
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeCredit = 3;
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeAuthOnly = 4;
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReversal = 5;
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeAdjustment = 6;
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeKeepOnFile = 7;
	public static final int CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReAutorize = 7;

	public static final int CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusUnknown = 0;
	public static final int CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusWaiting = 1;
	public static final int CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete = 2;
	public static final int CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusTimedOut = 3;
	public static final int CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusVoided = 4;
	public static final int CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusCanceled = 5;

	public static final int CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsUnknown = 0;
	public static final int CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsApproved = 1;
	public static final int CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined = 2;
	public static final int CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError = 3;
	public static final int CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsAuthHold = 4;
	public static final int CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsCallCenter = 5;
	public static final int CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsReversed = 6;
	public static final int CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsTimeOut = 7;

	public static final String SERVER_VERSION_PROPERTY = "com.efi.printsmith.server.version";
	public static final String SERVER_VERSION_DEFAULT_VALUE = "2010.0.0.0 - additional version info unavailable";
}

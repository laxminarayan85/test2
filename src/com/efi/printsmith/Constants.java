package com.efi.printsmith;

public class Constants {
	public final static String PAPER_CALCULATOR_FOLIO_NONE = "NONE";
	public final static String PAPER_CALCULATOR_FOLIO_LEFT = "LEFT";
	public final static String PAPER_CALCULATOR_FOLIO_TOP = "TOP";
	public final static String PAPER_CALCULATOR_GRIPPER_NONE = "NONE";
	public final static String PAPER_CALCULATOR_GRIPPER_LEFT = "LEFT";
	public final static String PAPER_CALCULATOR_GRIPPER_TOP = "TOP";

	public final static String PAPER_CALCULATOR_GRAIN_DIRECTION_NEITHER = "NEITHER";
	public final static String PAPER_CALCULATOR_GRAIN_DIRECTION_MATCH_GRAIN = "MATCH";
	public final static String PAPER_CALCULATOR_GRAIN_DIRECTION_SWING_COMBINATION = "SWING";

	public final static String JOB_RUN_METHOD_SHEETWISE = "SHEETWISE";
	public final static String JOB_RUN_METHOD_WORK_TURN = "WORKANDTURN";
	public final static String JOB_RUN_METHOD_WORK_TUMBLE = "WORKANDTUMBLE";
	
	public static final int PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH = 1;
	public static final int PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN = 2;
	public static final int PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH = 3;
	
	public static final String SERVER_VERSION_PROPERTY = "com.efi.printsmith.server.version";
	public static final String SERVER_VERSION_DEFAULT_VALUE = "2010.0.0.0 - additional version info unavailable";
}

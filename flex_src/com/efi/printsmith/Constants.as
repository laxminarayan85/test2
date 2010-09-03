package com.efi.printsmith
{
	public class Constants
	{
		static public const PAPER_CALCULATOR_FOLIO_NONE:String = "NONE";
		static public const PAPER_CALCULATOR_FOLIO_LEFT:String = "LEFT";
		static public const PAPER_CALCULATOR_FOLIO_TOP:String = "TOP";
		static public const PAPER_CALCULATOR_GRIPPER_NONE:String = "NONE";
		static public const PAPER_CALCULATOR_GRIPPER_LEFT:String = "LEFT";
		static public const PAPER_CALCULATOR_GRIPPER_TOP:String = "TOP";

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

		public function Constants()
		{
		}
	}
}
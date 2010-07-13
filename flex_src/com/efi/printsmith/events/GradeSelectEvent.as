package com.efi.printsmith.events
{
	import com.efi.printsmith.data.Grade;
	
	import flash.events.Event;
	
	public class GradeSelectEvent extends Event
	{
		public static const SELECTGRADE:String = "SelectGrade";
		public static const CANCELSELECTGRADE:String = "CancelSelectGrade";
		
		public var grade:Grade;
		
		public function GradeSelectEvent(type:String, grade:Grade)
		{
			super(type, true);
			this.grade = grade;
		}

		override public function clone():Event {
			return new GradeSelectEvent(type, grade);
		}
	}
}
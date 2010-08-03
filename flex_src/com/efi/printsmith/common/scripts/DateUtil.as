package com.efi.printsmith.common.scripts
{
	public class DateUtil
	{
		public static function addDays(date:Date, days:Number):Date {
		    return addHours(date, days*24);
		}
			
		public static function addHours(date:Date, hrs:Number):Date {
		    return addMinutes(date, hrs*60);
		}
		
		public static function addMinutes(date:Date, mins:Number):Date {
		    return addSeconds(date, mins*60);
		}
		
		public static function addSeconds(date:Date, secs:Number):Date {
		    var mSecs:Number = secs * 1000;
		    var sum:Number = mSecs + date.getTime();
		    return new Date(sum);
		}
		
		public static function getWeek(date:Date):Number
		{
		 	var days:Array = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; 
  			var year:Number = date.fullYearUTC;
  			var isLeap:Boolean = (year % 4 == 0) && (year % 100 != 0)
               || (year % 100 == 0) && (year % 400 == 0); 
  			if(isLeap)
			days[1]++;

 			var d:int = 0;
  			//month is conveniently 0 indexed.
 		 	for(var i:int = 0; i < date.month; i++)
			d += days[i];
  			d += date.dateUTC;

		  	var temp:Date = new Date(year, 0, 1);
		  	var jan1:Number = temp.dayUTC;
  			
  			d += jan1;

  			return int(d / 7);
		}

	}
}
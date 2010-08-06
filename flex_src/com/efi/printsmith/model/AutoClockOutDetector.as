package com.efi.printsmith.model
{
	import com.efi.printsmith.data.Employee;
	import com.efi.printsmith.data.TimeCard;
	
	import flash.events.TimerEvent;
	import flash.utils.Timer;
	
	import mx.controls.Alert;
	import mx.formatters.NumberFormatter;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	[Bindable]
	public class AutoClockOutDetector
	{
		
		public var employee:Employee;
		
		public var timeCard:TimeCard;
		
		public var timer:Timer;
		
		public var dataServiceTimeCard:RemoteObject;
		
		public var dataServiceEmployee:RemoteObject;
		
		public var numFormatter:NumberFormatter;
		
		public function AutoClockOutDetector() {
			numFormatter = new NumberFormatter();
			numFormatter.precision = 0;
			numFormatter.rounding = "none";
			dataServiceTimeCard = new RemoteObject();
			dataServiceTimeCard.destination = "dataService";
			dataServiceTimeCard.addEventListener(FaultEvent.FAULT,faultHandler,false,0,true);
			dataServiceEmployee = new RemoteObject();
			dataServiceEmployee.destination = "dataService";
			dataServiceEmployee.addEventListener(FaultEvent.FAULT,faultHandler,false,0,true);
		}
		
		public function start():void {
			timer = new Timer(60000);
			timer.addEventListener(TimerEvent.TIMER,function(event:Event):void{
				var todayDate:Date = new Date();
				var timeCardStartDate:Date = new Date(timeCard.startDateTime.fullYear,timeCard.startDateTime.month,(timeCard.startDateTime.date+1),0,0,0);
				var startDateTime:Number = (timeCard.startDateTime.hours*60*60*1000)+(timeCard.startDateTime.minutes*60*1000);
				var todayTime:Number = (todayDate.hours*60*60*1000)+(todayDate.minutes*60*1000);
				var autoClcokOutTime:Number = (employee.autoHour*60*60*1000)+(employee.autoMin*60*1000);
				if((todayDate>=timeCardStartDate) || (todayTime>=autoClcokOutTime && startDateTime<autoClcokOutTime)) {
					timer.stop();
					var remoteObject:RemoteObject = new RemoteObject();
					remoteObject.destination = "dataService";
					remoteObject.addEventListener(ResultEvent.RESULT,function(event:ResultEvent):void {
						employee = event.result as Employee;
						if(employee.clockIn || employee.clockBreak){
							if (employee.clockBreak == true)
							{
								setTimeCard("breakstopwithclockout");
							} else {
								setTimeCard("out");
							}
							employee.clockIn= false;
							employee.clockOut = true;
							employee.clockBreak= false;
							setEmployee();
						}
					},false,0,true);
					remoteObject.addEventListener(FaultEvent.FAULT,faultHandler,false,0,true);
					remoteObject.getById("Employee",employee.id);
				}
			});
			timer.start();
		}
		
		public function stop():void {
			if(timer!=null){
				if(timer.running){
					timer.stop();
				}
			}
		}
		
		private function faultHandler(event:FaultEvent):void {
			var message:String;
			message = "Error: "                          
			+ event.fault.faultCode + " - "                                  
			+ event.fault.faultDetail + " - "                                  
			+ event.fault.faultString;
			Alert.show(message, "Error", 0, null, null, null, 4);    
		}
		
		private function setTimeCard(reason:String):void {
			var clockInDate:Date = timeCard.startDateTime;
			if (reason == "out")
			{		
				timeCard.endDateTime = new Date(clockInDate.fullYear,clockInDate.month,clockInDate.date,employee.autoHour,employee.autoMin,0);
				timeCard.onClock = 0;
			} else {
				var totalBreakTime:Number = 0;
				if(reason=="breakstopwithclockout"){
					var stopTime:Date = new Date(clockInDate.fullYear,clockInDate.month,clockInDate.date,employee.autoHour,employee.autoMin,0);
					totalBreakTime = (stopTime.time-timeCard.breakTime.time)+convertStringToMilliseconds(timeCard.breakHour);
					timeCard.breakHour = convertMillisecondsToString(totalBreakTime);
					timeCard.endDateTime = stopTime;
					timeCard.onClock = 0;
				}
			}
				
			dataServiceTimeCard.addUpdate(timeCard);
		}
		
		private function convertStringToMilliseconds(timeStr:String):Number {
			var milliSeconds:Number = 0;
			if(timeStr==null||timeStr==""){
				milliSeconds = 0;
			} else {
				if(timeStr.indexOf(":")>-1){
					var hours:Number = Number(timeStr.split(":")[0]);
					var minutes:Number = Number(timeStr.split(":")[1]);
					milliSeconds = (hours*60*60*1000)+(minutes*60*1000);
				} else {
					milliSeconds = 0;
				}
			}
			return milliSeconds;
		}
		
		private function convertMillisecondsToString(milliSeconds:Number):String {
			var txtString:String = "";
			if(milliSeconds<60000){
				txtString = "00:00";
			}
			if(milliSeconds>=60000 && milliSeconds<60000*60){
		    	txtString = "00:";
		    	txtString = txtString + numFormatter.format(milliSeconds/60000);
		    }
		    if(milliSeconds>=60000*60){
		    	txtString = numFormatter.format(milliSeconds/(60000*60))+":";
		    	txtString = txtString+numFormatter.format(milliSeconds%(60000*60)/(60000));
		    }
		    return txtString;
		}
		
		private function setEmployee():void
		{	
			dataServiceEmployee.addUpdate(employee);
		}

	}
}
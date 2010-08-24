package com.efi.printsmith.model
{
	import com.efi.printsmith.data.Employee;
	import com.efi.printsmith.data.TimeCard;
	import com.efi.printsmith.data.TrackerConsoleJobs;
	import com.efi.printsmith.data.TrackerConsolePasses;
	
	import flash.events.TimerEvent;
	import flash.utils.Timer;
	
	import mx.collections.ArrayCollection;
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
		
		public var dataServiceTimeCardRetrieval:RemoteObject;
		
		public var dataServiceEmployee:RemoteObject;
		
		public var dataServiceTrackerConsole:RemoteObject;
		
		public var dataServiceTrackerConsoleJob:RemoteObject;
		
		public var numFormatter:NumberFormatter;
		
		public var updatedEmployee:Employee;
		
		public function AutoClockOutDetector() {
			numFormatter = new NumberFormatter();
			numFormatter.precision = 0;
			numFormatter.rounding = "none";
			dataServiceTimeCard = new RemoteObject();
			dataServiceTimeCard.destination = "dataService";
			dataServiceTimeCard.addEventListener(FaultEvent.FAULT,faultHandler,false,0,true);
			dataServiceEmployee = new RemoteObject();
			dataServiceEmployee.destination = "dataService";
			dataServiceEmployee.addEventListener(ResultEvent.RESULT,employeeSaveHandler,false,0,true);
			dataServiceEmployee.addEventListener(FaultEvent.FAULT,faultHandler,false,0,true);
			dataServiceTimeCardRetrieval = new RemoteObject();
			dataServiceTimeCardRetrieval.destination = "dataService";
			dataServiceTimeCardRetrieval.addEventListener(ResultEvent.RESULT,resultHandler,false,0,true);
			dataServiceTimeCardRetrieval.addEventListener(FaultEvent.FAULT,faultHandler,false,0,true);
			dataServiceTrackerConsole = new RemoteObject();
			dataServiceTrackerConsole.destination = "dataService";
			dataServiceTrackerConsole.addEventListener(ResultEvent.RESULT,trackerConsoleResultHandler,false,0,true);
			dataServiceTrackerConsole.addEventListener(FaultEvent.FAULT,faultHandler,false,0,true);
			dataServiceTrackerConsoleJob = new RemoteObject();
			dataServiceTrackerConsoleJob.destination = "dataService";
			dataServiceTrackerConsoleJob.addEventListener(FaultEvent.FAULT,faultHandler,false,0,true);
		}
		
		public function start():void {
			timer = new Timer(60000);
			timer.addEventListener(TimerEvent.TIMER,function(event:Event):void{
				var todayDate:Date = new Date();
				var timeCardStartDate:Date = new Date(timeCard.startDateTime.fullYear,timeCard.startDateTime.month,(timeCard.startDateTime.date+1),0,0,0);
				var startDateTime:Number = (timeCard.startDateTime.hours*60*60*1000)+(timeCard.startDateTime.minutes*60*1000);
				var todayTime:Number = (todayDate.hours*60*60*1000)+(todayDate.minutes*60*1000);
				var autoClcokOutTime:Number = (employee.autoHour*60*60*1000)+(employee.autoMin*60*1000);
				trace("AutoClockOut Employee =="+employee.lastName+", "+employee.firstName);
				trace("AutoClockOut Time=="+employee.autoHour+":"+employee.autoMin);
				if((todayDate>=timeCardStartDate) || (todayTime>=autoClcokOutTime && startDateTime<autoClcokOutTime)) {
					timer.stop();
					dataServiceTimeCardRetrieval.getByClockInOut("TimeCard",employee);
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
		
		private function resultHandler(event:ResultEvent):void {
			var timeCardList:ArrayCollection = event.result as ArrayCollection;
			if(timeCardList!=null && timeCardList.length>0) {
				timeCard = timeCardList.getItemAt(0,0) as TimeCard;
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
				trace("AutoClockOut Employee =="+employee.lastName+", "+employee.firstName+" Clocked Out at "+new Date());
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
		
		
		private function employeeSaveHandler(event:ResultEvent):void {
			updatedEmployee = event.result as Employee;
			if(updatedEmployee!=null){
				dataServiceTrackerConsole.getActiveTrackerConsoleJobsBasedOnEmployee(updatedEmployee);
			}			
		}
		
		private function trackerConsoleResultHandler(event:ResultEvent):void {
			var trackerConsoleJobsList:ArrayCollection = event.result as ArrayCollection;
			var updatedTrackerConsoleJobsList:ArrayCollection = new ArrayCollection();
			if(updatedEmployee!=null){
				var nowDate:Date = new Date();
				for each(var trackerConsoleJobs:TrackerConsoleJobs in trackerConsoleJobsList) {
					if(updatedEmployee.clockBreak || updatedEmployee.clockOut) {
						if(!trackerConsoleJobs.paused){
							for each(var trackerConsolePasses:TrackerConsolePasses in trackerConsoleJobs.passesList){
								if(trackerConsolePasses.passNo==trackerConsoleJobs.currentPass){
									trackerConsolePasses.trackTime = nowDate.time - trackerConsolePasses.trackDate.time+(isNaN(trackerConsolePasses.trackTime)?0:trackerConsolePasses.trackTime);
									trackerConsolePasses.trackDate = nowDate;
									break;
								}
							}
							updatedTrackerConsoleJobsList.addItem(trackerConsoleJobs);
						}
					}
				}
				if(updatedTrackerConsoleJobsList.length>0){
					dataServiceTrackerConsoleJob.addUpdateDeleteList(updatedTrackerConsoleJobsList,null);
				}
			}
		}

	}
}
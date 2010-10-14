package com.efi.mdi.event.window
{
	import flash.events.Event;
	
	import flexlib.mdi.containers.MDIWindow;

	public class WindowOpenEvent extends Event
	{	
		public static const WINDOW_OPEN:String = "windowOpen";
		
		private var _mdiWindow:MDIWindow; 
		
		
		public function WindowOpenEvent(type:String, mdiWindow:MDIWindow)
		{
			super(type);
			_mdiWindow = mdiWindow;
		}
		
		public function get mdiWindow():MDIWindow	{
			return _mdiWindow;
		}
		override public function clone():Event {
			return new WindowOpenEvent(type, _mdiWindow);
		}
	}
}
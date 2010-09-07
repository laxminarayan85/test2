package com.efi.mdi.event.window
{
	import com.efi.mdi.view.window.MDIWindow;
	
	import flash.events.Event;

	public class WindowMinimizeEvent extends Event
	{	
		public static const WINDOW_MINIMIZE:String = "windowMinimize";
		
		private var _mdiWindow:MDIWindow;
		
		public function WindowMinimizeEvent(type:String, mdiWindow:MDIWindow)
		{
			super(type);
			_mdiWindow = mdiWindow;
		}
		
		public function get mdiWindow():MDIWindow	{
			return _mdiWindow;
		}
		override public function clone():Event {
			return new WindowMinimizeEvent(type, _mdiWindow);
		}
	}
}
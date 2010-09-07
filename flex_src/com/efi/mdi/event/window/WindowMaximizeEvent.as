package com.efi.mdi.event.window
{
	import com.efi.mdi.view.window.MDIWindow;
	
	import flash.events.Event;

	public class WindowMaximizeEvent extends Event
	{	
		public static const WINDOW_MAXIMIZE:String = "windowMaximize";
		
		private var _mdiWindow:MDIWindow;
		
		public function WindowMaximizeEvent(type:String, mdiWindow:MDIWindow)
		{
			super(type);
			_mdiWindow = mdiWindow;
		}
		
		public function get mdiWindow():MDIWindow	{
			return _mdiWindow;
		}
		override public function clone():Event {
			return new WindowMaximizeEvent(type, _mdiWindow);
		}
	}
}
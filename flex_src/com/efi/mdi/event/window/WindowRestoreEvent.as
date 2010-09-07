package com.efi.mdi.event.window
{
	import com.efi.mdi.view.taskbar.MinimizedWindow;
	
	import flash.events.Event;

	public class WindowRestoreEvent extends Event
	{	
		public static const WINDOW_RESTORE:String = "windowRestore";
		
		private var _minWindow:MinimizedWindow;
		
		public function WindowRestoreEvent(type:String, minWindow:MinimizedWindow)
		{
			super(type,false);
			_minWindow = minWindow;
		}
		
		public function get minWindow():MinimizedWindow	{
			return _minWindow;
		}
		override public function clone():Event {
			return new WindowRestoreEvent(type, _minWindow);
		}
	}
}
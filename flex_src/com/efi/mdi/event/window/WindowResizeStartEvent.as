package com.efi.mdi.event.window
{
	import com.efi.mdi.view.window.MDIWindow;
	
	import flash.events.Event;
	import flash.events.MouseEvent;

	public class WindowResizeStartEvent extends Event
	{	
		public static const WINDOW_RESIZE_START:String = "windowResizeStart";
		
		private var _mdiWindow:MDIWindow;
		
		public function WindowResizeStartEvent(type:String, mdiWindow:MDIWindow)
		{
			super(type);
			_mdiWindow = mdiWindow;			
		}
		
		public function get mdiWindow():MDIWindow	{
			return _mdiWindow;
		}
		override public function clone():Event {
			return new WindowResizeStartEvent(type, _mdiWindow);
		}
	}
}
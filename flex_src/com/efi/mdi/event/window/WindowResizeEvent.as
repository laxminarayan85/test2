package com.efi.mdi.event.window
{
	import com.efi.mdi.view.window.MDIWindow;
	
	import flash.events.Event;

	public class WindowResizeEvent extends Event
	{	
		public static const WINDOW_RESIZE:String = "windowResize";
		
		private var _mdiWindow:MDIWindow;
		private var _mouseX:int;
		private var _mouseY:int;
		
		public function WindowResizeEvent(type:String, mdiWindow:MDIWindow, mouseX:int, mouseY:int)
		{
			super(type);
			_mdiWindow = mdiWindow;
			_mouseX = mouseX;
			_mouseY = mouseY;			
		}
		
		public function get mdiWindow():MDIWindow	{
			return _mdiWindow;
		}
		public function get mouseX():int	{
			return _mouseX;
		}
		public function get mouseY():int	{
			return _mouseY;
		}
		
		override public function clone():Event {
			return new WindowResizeEvent(type, _mdiWindow, _mouseX, _mouseY);
		}
	}
}
package com.efi.mdi.event.window
{
	import com.efi.mdi.view.window.MDIWindow;
	
	import flash.events.Event;

	public class WindowTitleChangedEvent extends Event
	{	
		public static const WINDOW_TITLE_CHANGED:String = "windowTitleChanged";
		
		private var _mdiWin:MDIWindow; 
		
		
		public function WindowTitleChangedEvent(type:String, mdiWin:MDIWindow)
		{
			super(type);
			_mdiWin = mdiWin;
		}
		
		public function get mdiWin():MDIWindow	{
			return _mdiWin;
		}
		override public function clone():Event {
			return new WindowTitleChangedEvent(type, _mdiWin);
		}
	}
}
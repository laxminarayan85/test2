package com.efi.mdi.event.window
{
	import flash.events.Event;
	
	import mx.core.UIComponent;

	public class WindowCloseEvent extends Event
	{	
		public static const WINDOW_CLOSE:String = "windowClose";
		
		private var _child:UIComponent; // can be MDIWindow or MinimizedWindow
		
		
		public function WindowCloseEvent(type:String, child:UIComponent)
		{
			super(type);
			_child = child;
		}
		
		public function get child():UIComponent	{
			return _child;
		}
		override public function clone():Event {
			return new WindowCloseEvent(type, _child);
		}
	}
}
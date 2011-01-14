package com.efi.mdi.event.window
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.core.UIComponent;

	public class WindowCloseEvent extends Event
	{	
		public static const WINDOW_CLOSE:String = "windowClose";
		
		private var _child:UIComponent; // can be MDIWindow or MinimizedWindow
		private var _spawnIds:Array;
		
		public function WindowCloseEvent(type:String, child:UIComponent, spawnIds:Array)
		{
			super(type);
			_child = child;
			_spawnIds = spawnIds;
		
		}
		
		public function get child():UIComponent	{
			return _child;
		}
		public function get spawnIds():Array	{
			return _spawnIds;
		}
		override public function clone():Event {
			return new WindowCloseEvent(type, _child, _spawnIds);
		}
	}
}
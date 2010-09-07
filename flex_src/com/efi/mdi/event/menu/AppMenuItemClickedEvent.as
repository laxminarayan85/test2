package com.efi.mdi.event.menu
{

	import com.efi.mdi.vo.menu.ApplicationMenuItem;
	
	import flash.events.Event;

	public class AppMenuItemClickedEvent extends Event 
	{
		public static const APP_MENU_ITEM_CLICKED:String = "appMenuItemClicked";
		
		private var _menuItem:ApplicationMenuItem;
		
		public function get menuItem():ApplicationMenuItem	{
			return _menuItem;
		}
		public function AppMenuItemClickedEvent(type:String, menuItem:ApplicationMenuItem)
		{
			super(type);
			this._menuItem = menuItem;
		}
		override public function clone():Event {
			return new AppMenuItemClickedEvent(type, _menuItem);
		}
	}
}
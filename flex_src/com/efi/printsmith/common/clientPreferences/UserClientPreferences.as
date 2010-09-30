package com.efi.printsmith.common.clientPreferences
{
	import flash.net.SharedObject;
	
	
	public class UserClientPreferences
	{
		private static var _instance:UserClientPreferences;
		
		private static const SO_NAME:String = "snowmassSO";
		
		public static const STOCK_PICKER_GRID_WIDTHS:String = "StockPickerGridWidths";
		
		
		public static function getInstance():UserClientPreferences	{
			if (_instance == null)	{
				_instance = new UserClientPreferences();
			}
			return _instance;
		}
		
		public function getData(val:String):Object	{
			var key:String = SO_NAME + "_" + Snowmass.getInstance().userName;
			var so:SharedObject =  SharedObject.getLocal(SO_NAME + "_" + Snowmass.getInstance().userName);
			var obj:Object = so.data;
			return (so.data[val]);
		}
		 
		public function setData(val:String, obj:Object):void	{
			var so:SharedObject = SharedObject.getLocal(SO_NAME + "_" + Snowmass.getInstance().userName);
			so.data[val] = obj;
			so.flush();
		}
		

	}
}
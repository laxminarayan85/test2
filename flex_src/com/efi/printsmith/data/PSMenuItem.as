package com.efi.printsmith.data
{
	import com.efi.mdi.vo.menu.ApplicationMenuItem;
	
	import mx.collections.ArrayCollection;
	
	public class PSMenuItem extends ApplicationMenuItem
	{
		private var _enabled:Boolean;
		private var _type:String; 
		private var _ss:SecurityCommands;
		
		public function PSMenuItem(label:String, children:ArrayCollection):void	{
			super(label,children);
								
		}

		public function set type (val:String):void	{
			_type = val;
		}
		public function get type ():String	{
			return _type;
		}
		public function set enabled (val:Boolean):void	{
			_enabled = val;
		}
		public function get enabled():Boolean	{
			return _enabled;
		}

		public function get ss ():SecurityCommands	{
			return _ss;
		}
		public function set ss(val:SecurityCommands):void	{
			_ss = val;
			
		}
	}
}
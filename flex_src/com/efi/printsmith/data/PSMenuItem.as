package com.efi.printsmith.data
{
	import com.efi.mdi.vo.menu.ApplicationMenuItem;
	
	import mx.collections.ArrayCollection;
	
	public class PSMenuItem extends ApplicationMenuItem
	{
		private var _ss:SecurityCommands;
		
		public function PSMenuItem(label:String, children:ArrayCollection):void	{
			super(label,children);
								
		}

		public function get ss ():SecurityCommands	{
			return _ss;
		}
		public function set ss(val:SecurityCommands):void	{
			_ss = val;
			
		}
	}
}
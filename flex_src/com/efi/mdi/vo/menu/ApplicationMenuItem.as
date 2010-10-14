package com.efi.mdi.vo.menu
{
	import mx.collections.ArrayCollection;
	
	public class ApplicationMenuItem 
	{
		private var _children:ArrayCollection;
		private var _label:String;
				
		public function ApplicationMenuItem(label:String, children:ArrayCollection):void	{
			this._label = label;
			this._children = children;					
		}
		public function set label (val:String):void	{
			_label = val;
		}
		public function get label ():String	{
			return _label;
		}
		public function get children ():ArrayCollection	{
			return _children;
		}
		public function set children(val:ArrayCollection):void	{
			_children = val;
		}
		
	}
}
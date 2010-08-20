package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection;
	
	public class PSMenuItem
	{
		private var _children:ArrayCollection;
		private var _label:String;
		private var _enabled:Boolean;
		private var _type:String; 
		private var _ss:SecuritySetup;
		
		public function PSMenuItem(label:String, children:ArrayCollection):void	{
			this._label = label;
			this._children = children;					
		}
		public function set label (val:String):void	{
			_label = val;
		}
		public function get label ():String	{
			return _label;
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
		public function get children ():ArrayCollection	{
			return _children;
		}
		public function set children(val:ArrayCollection):void	{
			_children = val;
			
		}
		public function get ss ():SecuritySetup	{
			return _ss;
		}
		public function set ss(val:SecuritySetup):void	{
			_ss = val;
			
		}
	}
}
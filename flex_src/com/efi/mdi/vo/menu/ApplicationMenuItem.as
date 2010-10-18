package com.efi.mdi.vo.menu
{
	import mx.collections.ArrayCollection;
	
	public class ApplicationMenuItem  
	{
		private var _children:ArrayCollection;
		private var _label:String;
		private var _enabled:Boolean;
		private var _type:String; 
		
		
		public function ApplicationMenuItem(label:String, children:ArrayCollection):void	{
			this._label = label;
			this._children = children;
			this._enabled = true;
			this._type = null;					
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
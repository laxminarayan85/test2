package com.efi.printsmith.common.components
{
	import com.efi.printsmith.components.Throbber;
	
	import flash.display.DisplayObject;
	
	import mx.core.UIComponent;
	
	public class NonModalThrobberHelper
	{
		private var _parent:UIComponent;
		private var _throbber:Throbber;
		
		public function NonModalThrobberHelper(parent:UIComponent, uniqueId:String)
		{
			this._parent = parent;
			this._throbber = new Throbber();
			_throbber.x = _parent.width / 2;
			_throbber.y = _parent.height / 2;
			_throbber.id = uniqueId;		 	
		}
		
		public function hideThrobberIfActive():Boolean	{
			for (var i:int = 0; i<_parent.numChildren; i++)	{
				var child:DisplayObject = _parent.getChildAt(i);
				if ((child is Throbber) && ((child as Throbber).id == _throbber.id))	{
					_throbber.stop();
					_parent.removeChild(_throbber);
					return true;						
				}
			}
			return false;
		}
		
		public function showThrobber():void	{
			_parent.addChild(_throbber);
			_throbber.play();
		}
	}
}
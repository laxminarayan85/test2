package com.efi.printsmith.common.components
{
	import mx.collections.ArrayCollection;
	import mx.containers.HBox;
	
	public class Toolbar extends HBox
	{
		private var _buttons:ArrayCollection;
		
		private var _buttonHt:int = 70;
		private var _buttonWidth:int = 70;
		
		public function Toolbar()
		{
			super();
		}
		
		override protected function createChildren():void	{
			super.createChildren();
			this.setStyle("paddingLeft", 5);
			this.setStyle("paddingRight", 5);
			this.setStyle("paddingTop", 5);
			this.setStyle("paddingBottom", 5);
			
		} 
		
		public function set buttons(val:ArrayCollection):void	{
			_buttons = val;
			
			removeAllChildren();
			
			for (var i:int = 0; i<val.length; i++)	{
				var tb:ToolbarButton = val.getItemAt(i) as ToolbarButton;
				addButton(tb);
			} 
		} 
		
		public function removeButton(btnId:String):void	{
			for (var i:int = 0; i<_buttons.length; i++)	{
				var tb:ToolbarButton = _buttons.getItemAt(i) as ToolbarButton;
				if (tb.id == btnId)	{
					removeChild(tb);
					return;
				}
			}
		}
		
		public function addButton(tb:ToolbarButton):void	{
			tb.width = _buttonWidth;
			tb.height = _buttonHt;
			addChild(tb);
		}
		
		public function getButton(btnId:String):ToolbarButton	{
			for (var i:int = 0; i<_buttons.length; i++)	{
				var tb:ToolbarButton = _buttons.getItemAt(i) as ToolbarButton;
				if (tb.id == btnId)	{
					return tb;
				}
			}
			return null;
		}
		
	}
}
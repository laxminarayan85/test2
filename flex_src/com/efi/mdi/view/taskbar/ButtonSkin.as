package com.efi.mdi.view.taskbar
{
	import flash.filters.DropShadowFilter;
	
	import mx.skins.ProgrammaticSkin;
	import mx.skins.halo.ButtonSkin;

	/*
	* John laPlante :: I wrote this experminention with programmitic skinning
	*/
	public class ButtonSkin extends ProgrammaticSkin
	{
		public function ButtonSkin()
		{
			super();
		}
		
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
		{
			var backgroundColor:Number = getStyle("backgroundColor") ? getStyle("backgroundColor"): 0xFFFFFF;
			var distance:Number = 4;
			switch(name) 
			{
				case "overSkin":
					break;
				case "overSkin":
					backgroundColor = 0xFFBE45;
					break;
				case "downSkin":
					distance = 0;
					backgroundColor  = 0xFFEAC1;
			}
			// A proper skin needs to be a rounded rectangle which this isn't yet.
			graphics.clear();
			graphics.lineStyle(0,0,0);
			graphics.beginFill(backgroundColor, 1);
			graphics.drawRect(0,0,unscaledWidth,unscaledHeight);
			graphics.endFill();
			//var shadow:DropShadowFilter = new DropShadowFilter(distance);
			//filters = [shadow];
		}
		
		private function setLuminosity(color:Number, percent:Number):Number
		{
			var red:Number = (color >> 16)* percent;
			var green:Number = (color >> 8 & 0xFF)* percent;
			var blue:Number = (color & 0xFF)* percent;
			return red << 16 | green << 8 | blue;
		}
	}
}
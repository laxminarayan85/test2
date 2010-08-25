package com.efi.printsmith.common.components
{
	import flash.display.DisplayObject;
	import flash.text.TextField;
	
	import mx.controls.Label;
	
	public class StrikeThroughLabelComponent extends Label
	{
		public function StrikeThroughLabelComponent()
		{
			super();
		}
		
		private var _strikethrough: Boolean = false;
           
        public function set strikethrough(bool: Boolean): void {
            this._strikethrough = bool;
            this.invalidateDisplayList();
        }
        
        public function get strikethrough(): Boolean {
            return this._strikethrough;
        }
		
		
		override protected function updateDisplayList(unscaledWidth: Number, unscaledHeight: Number): void {
            super.updateDisplayList (unscaledWidth, unscaledHeight);
           
            this.graphics.clear();
            if (this._strikethrough) {
                this.graphics.lineStyle(1, 0xCCCCCC);
                this.graphics.moveTo(0, unscaledHeight/2);
        		this.graphics.lineTo(unscaledWidth, unscaledHeight/2);
            }
        }
		
	}
}
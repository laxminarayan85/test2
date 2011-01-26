package com.efi.printsmith.common.components
{
	import mx.controls.DataGrid;
	import mx.controls.Label;
	
	public class PriceListElementRenderer extends Label
	{
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void {
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			
			if (data != null && listData != null) {
				if (listData.rowIndex == (this.listData.owner as DataGrid).dataProvider.length-1) {
					// var str:String = data as String;
					setStyle("fontWeight", "bold");
				}
			}
		} 
	}
}
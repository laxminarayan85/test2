package com.efi.printsmith.common.components
{
	import com.efi.printsmith.data.Charge;
	
	import mx.controls.Label;
	
	public class ChargeRenderer extends Label
	{
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void {
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			
			if (data != null && listData != null) {
				var charge:Charge = data as Charge;
				if (charge.hidden) {
					setStyle("textDecoration", "underline");
				}
			}
		} 
	}
}
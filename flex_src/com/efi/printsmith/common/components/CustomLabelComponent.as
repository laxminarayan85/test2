package com.efi.printsmith.common.components
{
	import flash.display.Graphics;
	
	import mx.controls.DataGrid;
	import mx.controls.Label;
	import mx.controls.dataGridClasses.*; 
	
	public class CustomLabelComponent extends Label
	{
		[Bindable] public var dataGridRowColor:Boolean = false;
		
		[Bindable] public var columnName:String;
		
		[Bindable] public var fontColor:String;
		
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
		{
		     super.updateDisplayList(unscaledWidth, unscaledHeight);
		 	 if(dataGridRowColor) {
			     if(data){
				     if (data[columnName] == 1) 
			         {
			         	if(fontColor){
			         		this.setStyle("color",fontColor);
			         	}
				     } else {
				     	this.setStyle("color",0x000000);
				     }
			     }
			 }
		}
	}
}
package com.efi.printsmith.components
{

import mx.core.UITextField;
import flash.text.TextFieldAutoSize;
import mx.controls.Button
import flash.display.DisplayObject;

public class MultiLineLabelButton extends Button
	 {
 
	override protected function createChildren() : void
 	{
 // Create a UITextField to display the label.
 		
	 super.createChildren();
	 textField.multiline = true;
	 textField.wordWrap = true;
	 textField.autoSize = TextFieldAutoSize.LEFT;	
	
	}
	
}
}
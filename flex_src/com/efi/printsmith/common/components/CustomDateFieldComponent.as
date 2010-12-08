package com.efi.printsmith.common.components
{
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.controls.DateField;
	import mx.controls.Image;
	import mx.events.CalendarLayoutChangeEvent;
	
	public class CustomDateFieldComponent extends DateField
	{
		[Embed("../../../../../assets/clear.png")]
		private var clearImageIcon:Class;
		 
		private var _clearImage:Image;
		
		[Bindable] public var clearRequired:Boolean = true;
		
		protected override function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void{
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			if(clearRequired){
				if(this.textInput.height-_clearImage.height>0){
					_clearImage.move(this.textInput.width-20,(this.textInput.height-_clearImage.height)/2);
				} else if(this.textInput.height-_clearImage.height<=0){
					_clearImage.move(this.textInput.width-20,(_clearImage.height-this.textInput.height)/2);
				}
			}
		}
		
		protected override function createChildren():void{
			super.createChildren();
			if(clearRequired){
				_clearImage = new Image();
				_clearImage.source = clearImageIcon;
				_clearImage.width = 16;
				_clearImage.height = 16;
				_clearImage.buttonMode = true;
				_clearImage.addEventListener(MouseEvent.CLICK,clearEventHandler,false,0,true);
				_clearImage.toolTip = resourceManager.getString(Snowmass.RESOURCE_BUNDLE,'rButtonLabel.Clear');
				addChild(_clearImage);
			}
		}
		
		private function clearEventHandler(event:Event):void {
			this.selectedDate = null;
			var e:CalendarLayoutChangeEvent = new CalendarLayoutChangeEvent(CalendarLayoutChangeEvent.CHANGE);        
	        e.newDate = null;
	        dispatchEvent(e); 
		}

	}
}
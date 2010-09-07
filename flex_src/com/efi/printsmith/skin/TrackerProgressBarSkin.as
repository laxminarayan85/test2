package com.efi.printsmith.skin
{
	import com.efi.printsmith.components.TrackerProgressBarComponent;
	import com.efi.printsmith.data.TrackerConsoleJobs;
	
	import mx.controls.ProgressBar;
	import mx.skins.Border;
	import mx.styles.StyleManager;
	import mx.utils.ColorUtil;
	
	public class TrackerProgressBarSkin extends Border
	{
			
	   
		public function TrackerProgressBarSkin()
		{
			super();		
		}
	    
	    /**
	     *  @private
	     */    
	    override public function get measuredWidth():Number
	    {
	        return 200;
	    }
	    
	    /**
	     *  @private
	     */        
	    override public function get measuredHeight():Number
	    {
	        return 6;
	    }
	
	    /**
	     *  @private
	     */        
		override protected function updateDisplayList(w:Number, h:Number):void
		{
			super.updateDisplayList(w, h);
			
			var trackerConsoleJobs:TrackerConsoleJobs;
			
			var trackWidth:Number = this.parent.parent.parent.width;
			var progressBar:ProgressBar = this.parent.parent.parent as ProgressBar;
			var labelWidth:Number = progressBar.getStyle("labelWidth") as Number;
			trackWidth = trackWidth - labelWidth;
			
			var trackerProgressBarComponent:TrackerProgressBarComponent = this.parent.parent.parent.parent as TrackerProgressBarComponent;
			
			if(trackerProgressBarComponent!=null){
				trackerConsoleJobs = trackerProgressBarComponent.trackerConsoleJobs;
			}
			
	
			// User-defined styles
			var barColorStyle:* = getStyle("barColor");
			var barColor:uint = StyleManager.isValidStyleValue(barColorStyle) ?
								barColorStyle :
								getStyle("themeColor");
	
			var barColor0:Number = ColorUtil.adjustBrightness2(barColor, 40);
	
			// default fill color for halo uses theme color
			var fillColors0:Array = [ barColor0, barColor ]; 
			
			var barColor1:Number = ColorUtil.adjustBrightness2(0x0000ff, 40);
	
			// default fill color for halo uses theme color
			var fillColors1:Array = [ barColor1, 0x0000ff ]; 
			
			var barColor2:Number = ColorUtil.adjustBrightness2(0xff0000, 40);
	
			// default fill color for halo uses theme color
			var fillColors2:Array = [ barColor2, 0xff0000 ]; 
			
			var barColor3:Number = ColorUtil.adjustBrightness2(0xffff00, 40);
	
			// default fill color for halo uses theme color
			var fillColors3:Array = [ barColor3, 0xffff00 ]; 
					
			graphics.clear();
			
			if(trackerConsoleJobs!=null){
				if(trackerConsoleJobs.paused){
					// glow
					drawRoundRect(
						0, 0, w, h, 0,
						fillColors3, 0.5,
						verticalGradientMatrix(0, 0, w - 2, h - 2));
					
					// fill
					drawRoundRect(
						1, 1, w - 2, h - 2, 0,
						fillColors3, 1,
						verticalGradientMatrix(0, 0, w - 2, h - 2));
				} else {
					if(trackerProgressBarComponent.totalTime>0){
						if(trackerProgressBarComponent.estimatedSetUpTime>0 || trackerProgressBarComponent.estimatedRunTime>0){
							if(trackerProgressBarComponent.estimatedRunTime>0 && w>((trackerProgressBarComponent.estimatedRunTime/trackerProgressBarComponent.totalTime)*trackWidth)) {
								drawDifferentGraphics(w,h,fillColors0,fillColors1,fillColors2,
								trackerProgressBarComponent.estimatedSetUpTime,trackerProgressBarComponent.estimatedRunTime,trackerProgressBarComponent.totalTime,
								true);
							} else if(trackerProgressBarComponent.estimatedSetUpTime>0 && w>((trackerProgressBarComponent.estimatedSetUpTime/trackerProgressBarComponent.totalTime)*trackWidth)) {
								drawDifferentGraphics(w,h,fillColors0,fillColors1,fillColors2,
								trackerProgressBarComponent.estimatedSetUpTime,trackerProgressBarComponent.estimatedRunTime,trackerProgressBarComponent.totalTime,
								false);
							} else {
								if(trackerProgressBarComponent.estimatedSetUpTime>0){
									drawDefaultGraphics(w,h,fillColors0);
								} else if(trackerProgressBarComponent.estimatedRunTime>0) {
									drawDefaultGraphics(w,h,fillColors1);
								} else {
									drawDefaultGraphics(w,h,fillColors2);
								}
							}
						} else {
							drawDefaultGraphics(w,h,fillColors0);
						}
					} else {
						drawDefaultGraphics(w,h,fillColors0);
					}
				}
				
			} else {
				drawDefaultGraphics(w,h,fillColors0);
			}
		}
		
		private function drawDifferentGraphics(w:Number, h:Number, fillColors0:Array, fillColors1:Array, fillColors2:Array, 
		estimatedSetUpTime:Number, estimatedRunTime:Number, totalTime:Number, isRunTimeCondition:Boolean):void {
			var trackWidth:Number = this.parent.parent.parent.width;
			var progressBar:ProgressBar = this.parent.parent.parent as ProgressBar;
			var labelWidth:Number = progressBar.getStyle("labelWidth") as Number;
			trackWidth = trackWidth - labelWidth;
			var widthValue:Number = w;
			var setUpWidthValue:Number=0;
			var runWidthValue:Number=0;
			if(isRunTimeCondition){
				if(estimatedSetUpTime>0){
					setUpWidthValue = (estimatedSetUpTime/totalTime)*trackWidth;
					widthValue = widthValue-setUpWidthValue;
					// glow
					drawRoundRect(
						0, 0, setUpWidthValue, h, 0,
						fillColors0, 0.5,
						verticalGradientMatrix(0, 0, setUpWidthValue - 2, h - 2));
					
					// fill
					drawRoundRect(
						1, 1, setUpWidthValue - 2, h - 2, 0,
						fillColors0, 1,
						verticalGradientMatrix(0, 0, setUpWidthValue - 2, h - 2));
				}
				if(estimatedRunTime>0){
					runWidthValue = ((estimatedRunTime/totalTime)*trackWidth)-setUpWidthValue;
					widthValue = widthValue-runWidthValue;
					// glow
					drawRoundRect(
						setUpWidthValue, 0, runWidthValue, h, 0,
						fillColors1, 0.5,
						verticalGradientMatrix(0, 0, runWidthValue - 2, h - 2));
					
					// fill
					drawRoundRect(
						setUpWidthValue+1, 1, runWidthValue - 2, h - 2, 0,
						fillColors1, 1,
						verticalGradientMatrix(0, 0, runWidthValue - 2, h - 2));
				}
				// glow
				drawRoundRect(
					(setUpWidthValue+runWidthValue), 0, widthValue, h, 0,
					fillColors2, 0.5,
					verticalGradientMatrix(0, 0, widthValue - 2, h - 2));
				
				// fill
				drawRoundRect(
					(setUpWidthValue+runWidthValue+1), 1, widthValue - 2, h - 2, 0,
					fillColors2, 1,
					verticalGradientMatrix(0, 0, widthValue - 2, h - 2));
			} else {
				if(estimatedSetUpTime>0){
					setUpWidthValue = (estimatedSetUpTime/totalTime)*trackWidth;
					widthValue = widthValue-setUpWidthValue;
					// glow
					drawRoundRect(
						0, 0, setUpWidthValue, h, 0,
						fillColors0, 0.5,
						verticalGradientMatrix(0, 0, setUpWidthValue - 2, h - 2));
					
					// fill
					drawRoundRect(
						1, 1, setUpWidthValue - 2, h - 2, 0,
						fillColors0, 1,
						verticalGradientMatrix(0, 0, setUpWidthValue - 2, h - 2));
				}
				if(estimatedRunTime>0){
					// glow
					drawRoundRect(
						setUpWidthValue, 0, widthValue, h, 0,
						fillColors1, 0.5,
						verticalGradientMatrix(0, 0, widthValue - 2, h - 2));
					
					// fill
					drawRoundRect(
						(setUpWidthValue+1), 1, widthValue - 2, h - 2, 0,
						fillColors1, 1,
						verticalGradientMatrix(0, 0, widthValue - 2, h - 2));
				} else {
					// glow
					drawRoundRect(
						setUpWidthValue, 0, widthValue, h, 0,
						fillColors2, 0.5,
						verticalGradientMatrix(0, 0, widthValue - 2, h - 2));
					
					// fill
					drawRoundRect(
						(setUpWidthValue+1), 1, widthValue - 2, h - 2, 0,
						fillColors2, 1,
						verticalGradientMatrix(0, 0, widthValue - 2, h - 2));
				}
				
			}
		}
		
		private function drawDefaultGraphics(w:Number, h:Number, fillColors:Array):void {
			// glow
			drawRoundRect(
				0, 0, w, h, 0,
				fillColors, 0.5,
				verticalGradientMatrix(0, 0, w - 2, h - 2));
			
			// fill
			drawRoundRect(
				1, 1, w - 2, h - 2, 0,
				fillColors, 1,
				verticalGradientMatrix(0, 0, w - 2, h - 2));
		}
	}
}
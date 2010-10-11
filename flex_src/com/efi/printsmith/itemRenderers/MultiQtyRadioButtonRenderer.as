package com.efi.printsmith.itemRenderers
{
	import com.efi.printsmith.data.JobBase;
	
	import mx.containers.Box;
	import mx.controls.RadioButton;
	import mx.core.IDataRenderer;
	
	public class MultiQtyRadioButtonRenderer extends Box implements IDataRenderer
	{
		
		private var radioButton:RadioButton;
		
		public function MultiQtyRadioButtonRenderer()
		{
			super();
		}
		
		override public function set data(value:Object):void {
			super.data = value;
			if(value!=null){
				if(value is JobBase){
					var jobBase:JobBase = value as JobBase;
					if(jobBase.multiQtyJob || jobBase.hasMultiQtyJobs){
						radioButton = new RadioButton();
						radioButton.selected = jobBase.defaultJob;
						addChild(radioButton);
					}
				}
			}
		}
		
		override public function get data():Object {
            return super.data;
        }

	}
}
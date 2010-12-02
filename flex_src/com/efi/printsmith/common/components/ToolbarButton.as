package com.efi.printsmith.common.components
{
	import flash.events.MouseEvent;
	
	import mx.controls.LinkButton;

	public class ToolbarButton extends LinkButton
	{
		
		
		
		public function ToolbarButton(id:String, label:String, icon:Class, clickEventHandler:Function)
		{
			super();
			this.id = id;
			this.label = label;
			this.labelPlacement = "bottom";
			this.setStyle("icon", icon);
			if (clickEventHandler != null)	{
				this.addEventListener(MouseEvent.CLICK, clickEventHandler);
			}
		}
		
		
	}
}
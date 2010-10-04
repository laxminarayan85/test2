package com.efi.mdi.event.compare
{
	import flash.events.Event;
	
	import mx.core.UIComponent;
	
	public class MDICompareObjectEvent extends Event
	{
		public function MDICompareObjectEvent(type:String,content:UIComponent,functionName:Function) {
            super(type);
            this._content = content;
            this._functionName = functionName;
        }
        
        public static const MDI_COMPAREOBJECT:String = "mdiCompareObject";

        
        public var _content:UIComponent;
        
        public var _functionName:Function;

        // Override the inherited clone() method.
        override public function clone():Event {
            return new MDICompareObjectEvent(type, _content, _functionName);
        }

	}
}
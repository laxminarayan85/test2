package com.efi.itemRenderers
{
    import mx.containers.Box;
    import mx.controls.Image;
    import mx.controls.dataGridClasses.DataGridListData;
    import mx.controls.listClasses.BaseListData;
    import mx.controls.listClasses.IDropInListItemRenderer;
           
    public class DataGridIconRenderer extends Box
        implements IDropInListItemRenderer
    {
                
        // Embed icons.
        [Embed(source="../../../assets/ColorIcon.png")]
        public var colorIcon:Class; 
        
        [Embed(source="../../../assets/BWIcon.png")]
        public var bwIcon:Class;
        
        [Embed(source="../../../assets/LFIcon.png")]
        public var lfIcon:Class;

        private var image:Image;
        
        public function DataGridIconRenderer()
        {
            super();
            setStyle("horizontalAlign", "center");
            image = new Image();
          }
        
        // ----- listData -----
        private var _listData:BaseListData;
        [Bindable("dataChange")]
        public function get listData():BaseListData
        {
            return _listData;
        }

        public function set listData(value:BaseListData):void
        {
            _listData = value;
        }
        // -----   -----
        override protected function createChildren():void
        {
            super.createChildren();
            addChild(image);
        }
       
        // Override the set method for the data property.
        override public function set data(value:Object):void 
        {
            super.data = value;
            if (value != null) 
            {
            	var dataGridListData:DataGridListData = listData as DataGridListData;
            	 
                var currentValue:String = dataGridListData.dataField;
                image.source = null;
                switch(currentValue) 
                {
                     case "color":
                     	if (value.color == true) {
	                        image.source = colorIcon;
                     	}
                        break;
                    case "blackwhite":
                    	if (value.blackwhite == true) {
                         	image.source = bwIcon;
                     	}
                        break;
                    case "largeFormat":
                        if (value.largeFormat == true) {
                        	image.source = lfIcon;
                        } 
                        break;                         
                     default:
                        image.source = null;
                 }
             } 
         }
    }
}
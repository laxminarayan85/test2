package com.efi.itemRenderers
{
    import mx.containers.Box;
    import mx.controls.Image;
    import mx.controls.dataGridClasses.DataGridListData;
    import mx.controls.listClasses.BaseListData;
    import mx.controls.listClasses.IDropInListItemRenderer;
           
    public class PressIconRenderer extends Box
        implements IDropInListItemRenderer
    {
                
        // Embed icons.
        [Embed(source="../../../assets/SheetFedIcon.png")]
        public var sfIcon:Class;
        
        [Embed(source="../../../assets/RollFedIcon.png")]
        public var rfIcon:Class;

        private var image:Image;
        
        public function PressIconRenderer()
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
                     case "sheetFed":
                     	if (value.sheetFed == true) {
	                        image.source = sfIcon;
                     	}
                        break;
                    case "rollFed":
                    	if (value.rollFed == true) {
                         	image.source = rfIcon;
                     	}
                        break;
                     default:
                        image.source = null;
                 }
             } 
         }
    }
}
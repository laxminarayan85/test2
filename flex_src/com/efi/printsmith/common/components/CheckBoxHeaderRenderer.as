package com.efi.printsmith.common.components
{
	import flash.display.DisplayObject;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	
	import mx.collections.ArrayCollection;
	import mx.controls.CheckBox;
	import mx.controls.DataGrid;
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.controls.dataGridClasses.DataGridListData;
	import mx.controls.listClasses.ListBase;
	
	public class CheckBoxHeaderRenderer extends CheckBox
	{
		
		public var unCheckDisabledField:String;
	
		public function CheckBoxHeaderRenderer()
		{
			focusEnabled = false;
		}
	
		override public function set data(value:Object):void
		{
			invalidateProperties();
		}
		
	    private var addedListener:Boolean = false;
	    private var partiallySelected:Boolean = false;
	
		override protected function commitProperties():void
		{
			super.commitProperties();
			if (owner is ListBase)
	        {
	        	var counter:int = 0;
	        	var dg:DataGrid = DataGrid(listData.owner);
				var column:DataGridColumn = dg.columns[listData.columnIndex];  
	            if (!addedListener)
	            {
	                addedListener = true;
	                owner.addEventListener("valueCommit", owner_changeHandler, false, 0, true);
	                owner.addEventListener("change", owner_changeHandler, false, 0, true);
	            }
	            
	            var list:ArrayCollection = ListBase(owner).dataProvider as ArrayCollection;
	            
	           	for each(var obj:Object in list){
	             	if(obj[column.dataField]) {
	             		counter++;
	             	}
	          	}
	
	            if (ListBase(owner).dataProvider.length == counter)
	            {
				    selected = true;
	                partiallySelected = false;
	            }
	            else if (ListBase(owner).selectedItems.length == 0)
	            {
	                selected = false;
	                partiallySelected = false;
	            }
	            else
	            {
	                selected = false;
	                partiallySelected = true;
	            }
	            invalidateDisplayList();
	        }
		}
	
		override protected function clickHandler(event:MouseEvent):void
		{
			var list:ArrayCollection = ListBase(owner).dataProvider as ArrayCollection;
			var dg:DataGrid = DataGrid(listData.owner);
			var column:DataGridColumn = dg.columns[listData.columnIndex];  
	        if (selected)
	        {
	            // uncheck everything
	            ListBase(owner).selectedIndex = -1;
	            for each(var obj:Object in list){
	            	if(unCheckDisabledField!=null){
	            		if(!obj[unCheckDisabledField]){
	            			obj[column.dataField] = false;	
	            		}
	            	} else {
	            		obj[column.dataField] = false;
	            	}
	            }
	        }
	        else
	        {
	            var n:int = ListBase(owner).dataProvider.length;
	            var arr:Array = [];
	            for (var i:int = i; i < n; i++)
	                arr.push(i);
	            ListBase(owner).selectedIndices = arr;
	            for each(var obj:Object in list){
	            	obj[column.dataField] = true;
	            }
	        }
		}
	
		/* center the checkbox if we're in a datagrid */
		override protected function updateDisplayList(w:Number, h:Number):void
		{
			super.updateDisplayList(w, h);
	
	        graphics.clear();
	
			if (listData is DataGridListData)
			{
				var n:int = numChildren;
				for (var i:int = 0; i < n; i++)
				{
					var c:DisplayObject = getChildAt(i);
					if (!(c is TextField))
					{
						c.x = (w - c.width) / 2;
						c.y = 0;
	                    c.alpha = 1;
					}
				}
			}
		}
	
	    private function owner_changeHandler(event:Event):void
	    {
	        invalidateProperties();
	    }
	
	}

}
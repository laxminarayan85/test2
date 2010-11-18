package com.efi.printsmith.itemRenderers
{
	import com.efi.printsmith.security.PSSecurityUtils;
	
	import mx.controls.treeClasses.TreeItemRenderer;
	import mx.controls.treeClasses.TreeListData;

	public class StyledTreeRenderer extends TreeItemRenderer
	{
		public function StyledTreeRenderer()
		{
			super();
			mouseEnabled = false;
		}
		
		override public function set data(value:Object):void
        {
			super.data = value;
            if(TreeListData (super.listData).hasChildren)
            {
            	setStyle("color", 0x000000);
               	setStyle("fontWeight", "bold");
			}
            else
            {
            	if (PSSecurityUtils.getInstance().hasPermission(value.@command))	{
            		setStyle("color", 0x000000);
            	}
            	else	{
            		setStyle("color", 0x808080);
            	}
            	
                setStyle("fontWeight", "normal");

            }
     	}
		
//		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
//		{
//			super.updateDisplayList(unscaledWidth, unscaledHeight);
//		    if(super.data)
//		    {
//		       if(TreeListData(super.listData).hasChildren)
//		       {
//					var tmp:XMLList = new XMLList(TreeListData(super.listData).node);
//					var myStr:int =tmp[0].children().length();
//			        super.label.text = TreeListData(super.listData).text + “(” + myStr + “)”;
//		    	}
//		
//			}
//		}
//		
	}
}
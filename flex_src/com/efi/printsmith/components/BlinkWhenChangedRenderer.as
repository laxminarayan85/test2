package com.efi.printsmith.components
{
import flash.events.Event;
import mx.controls.DataGrid;
import mx.controls.dataGridClasses.DataGridItemRenderer;
import mx.controls.dataGridClasses.DataGridListData;

public class BlinkWhenChangedRenderer extends DataGridItemRenderer
{

	public function BlinkWhenChangedRenderer()
	{
		super();
	}

	private var lastText:String = null;
	private var lastUID:String = null;
	private var frameCount:int = -1;


	/**
	 *  DataGridItemRenderer extends TextField and has a slightly different
	 *  validation mechanism than UIComponent-based widgets.  All visuals
	 *  are resolved within the validateNow call.  We apply the background
	 *  here
	 */
	override public function validateNow():void
	{
		var needBlink:Boolean = false;

		super.validateNow();

		if (!listData) 
		{
			// item renderers are recycled so you have to make sure
			// that all code paths lead to a known state.
			background = false;
			return;
		}

		var dgListData:DataGridListData = listData as DataGridListData;
		var dataGrid:DataGrid = dgListData.owner as DataGrid;

		var column:BlinkWhenChangedColumn = dataGrid.columns[dgListData.columnIndex];
		if (dgListData.uid == lastUID)
		{
			if (lastText != dgListData.label)
			{
				needBlink = true;
			}
		}
		lastUID = dgListData.uid;
		lastText = dgListData.label;

		if (needBlink)
		{
			// TextFields can draw solid color backgrounds.  Can't do gradients though
			background = true;
			backgroundColor = column.blinkColor;
			frameCount = column.duration - 1;
			addEventListener("enterFrame", enterFrameHandler);
		}
	}

	private function enterFrameHandler(event:Event):void
	{
		frameCount--;
		if (frameCount < 0)
		{
			background = false;
			removeEventListener("enterFrame", enterFrameHandler);
		}
	}

}

}
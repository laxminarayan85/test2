package com.efi.printsmith.components

{
import mx.controls.dataGridClasses.DataGridColumn;

public class BlinkWhenChangedColumn extends DataGridColumn
{

	public function BlinkWhenChangedColumn()
	{
		super();
	}

	/**
	 *  The background color that will appear if the value is
	 *  changed
	 */
	public var blinkColor:uint = 0xFF0000;

	/**
	 *  Number of frame updates to hold blink color
	 */
	public var duration:int = 6;

}

}
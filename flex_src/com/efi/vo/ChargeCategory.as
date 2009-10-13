package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
[Bindable]

[RemoteClass(alias="com.efi.printsmith.data.ChargeCategory")]

public class ChargeCategory extends ModelBase

{

	public function ChargeCategory() {
	
	}
	public var children:ArrayCollection;
	public var name:String = "";
	public var parent:ChargeCommand = new ChargeCommand();

	}
}
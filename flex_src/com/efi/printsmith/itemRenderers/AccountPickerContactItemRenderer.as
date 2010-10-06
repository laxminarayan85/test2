package com.efi.printsmith.itemRenderers
{
	import com.efi.printsmith.data.Account;
	import com.efi.printsmith.view.AccountPicker;
	
	import mx.controls.Label;
	import mx.core.IDataRenderer;
	
	public class AccountPickerContactItemRenderer extends Label implements IDataRenderer
	{
		
		public function AccountPickerContactItemRenderer()
		{
			super();
		}
		
		override public function set data(value:Object):void {
			super.data = value;
			
			var a:Account = value as Account;
			this.text = AccountPicker.contactLabel(a);
			
			if (a.accountId  == "")	{
				this.setStyle("color", 0xff0000);
			}
			else if (a.prospect)	{
				this.setStyle("color", 0x008000);
			}	
			else if (!a.prospect)	{
				this.setStyle("color", 0x0000ff);
			}		
		}
	
		override public function get data():Object {
            return super.data;
        }
	}
}
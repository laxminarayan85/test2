package com.efi.printsmith.itemRenderers
{
	import com.efi.printsmith.data.Account;
	import com.efi.printsmith.data.Contact;
	import com.efi.printsmith.view.AccountPicker;
	import com.efi.printsmith.view.ContactPicker;
	
	import mx.controls.Label;
	import mx.core.IDataRenderer;
	
	public class PickerContactItemRenderer extends Label implements IDataRenderer
	{
		
		public function PickerContactItemRenderer()
		{
			super();
		}
		
		override public function set data(value:Object):void {
			super.data = value;
			
			var a:Account = null;
			var c:Contact = null;
			
			if (value is Account)	{
				a = value as Account;
				c = a.contact;
				this.text = AccountPicker.contactLabel(a);
			}
			if (value is Contact)	{
				c = value as Contact;
				a = c.parentAccount;
			}
			
			if ((a == null) || (a.accountId  == ""))	{
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
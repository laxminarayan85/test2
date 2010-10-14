package com.efi.mdi.vo.menu
{
	import com.efi.mdi.view.window.MDIWindow;
	
	import mx.collections.ArrayCollection;
	
	public class WindowApplicationMenuItem extends ApplicationMenuItem
	{
		private var _mdiWindow:MDIWindow;
		

		public function set mdiWindow(val:MDIWindow):void	{
			_mdiWindow = val;
		}
		public function get mdiWindow():MDIWindow	{
			return _mdiWindow;
		}
		
		public function WindowApplicationMenuItem(labelStr:String, childrenAC:ArrayCollection, mdiWin:MDIWindow)
		{
			super(labelStr, childrenAC);
			mdiWindow = mdiWin;
		}
		
	}
}
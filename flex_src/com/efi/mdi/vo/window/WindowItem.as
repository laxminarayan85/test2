package com.efi.mdi.vo.window
{
	import mx.collections.ArrayCollection;
	
	public class WindowItem
	{
		private var _id:int;
		private var _children:ArrayCollection;
		
		public function WindowItem(id:int)
		{
			this.id = id;			 
		}

		public function set id(val:int):void	{
			_id = val;
		}
		public function get id():int{
			return _id;
		}
		public function addChildWindow(win:WindowItem):void	{
			if (_children == null)
				_children = new ArrayCollection();
			_children.addItem(win);
		}
		
		public function get children():ArrayCollection	{
			return _children;
		}
	}
}
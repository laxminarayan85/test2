package com.efi.mdi.vo.window
{
	import mx.collections.ArrayCollection;
	
	public class WindowItem
	{
		private var _id:int;
		private var _parentId:int;
		private var _children:ArrayCollection;
		
		public function WindowItem(id:int,parentId:int=-1)
		{
			this.id = id;			 
			this.parentId = parentId;
		}

		public function set id(val:int):void	{
			_id = val;
		}
		public function get id():int{
			return _id;
		}
		
		public function set parentId(val:int):void	{
			_parentId = val;
		}
		public function get parentId():int{
			return _parentId;
		}
		
		public function addChildWindow(win:WindowItem):void	{
			if (_children == null)
				_children = new ArrayCollection();
			_children.addItem(win);
		}
		
		public function get children():ArrayCollection	{
			return _children;
		}
		
		public function set children(val:ArrayCollection):void	{
			_children = val;
		}
	}
}
package com.efi.printsmith.common.components.filter
{
	import flash.utils.getQualifiedClassName;
	
	import mx.collections.ArrayCollection;
	import mx.utils.StringUtil;
	
	public class TreePickerFilter extends PickerFilter
	{
		[Bindable] private var _searchClassName:String;
		 var ac:ArrayCollection = new ArrayCollection();
		private var _treeAC:ArrayCollection;
		
		public function set searchClassName(val:String):void	{
			_searchClassName = val;
		}
		
		override protected function setCustomListData(val:ArrayCollection):void	{
			_treeAC = val;
			_listData = convertTreeToList();	
		}
		
		private function convertTreeToList():ArrayCollection	{
			var flatList:ArrayCollection = new ArrayCollection();
			for (var i:int = 0; i < _treeAC.length; i++)	{
				getRoot(_treeAC.getItemAt(i), flatList);
			}			
			return flatList; 
		} 
		
		private function getRoot(parent:Object, flatList:ArrayCollection):void	{
			if (flash.utils.getQualifiedClassName(parent) != _searchClassName)	{
				for (var i:int = 0; i < (parent["children"] as ArrayCollection).length; i++)	{
					getRoot((parent["children"] as ArrayCollection).getItemAt(i), flatList);
				}
			}
			else	{
				flatList.addItem(parent);				
			}
		}		
		override protected function search():void	{
			if (txtSearchString.text == "")		{
				_searchComponent["dataProvider"] = _treeAC;
			}
			else	{	
				var tmpArray:ArrayCollection = new ArrayCollection();
				var selectedCriterion:FilterSearchBy = cboSearchBy.selectedItem as FilterSearchBy;
				for (var i:int = 0; i < _listData.length; i++)	{
					var baseObj:Object = _listData.getItemAt(i);
					var obj:Object = selectedCriterion.property.getValueOf(baseObj);
					var entered:String = StringUtil.trim(txtSearchString.text).toLowerCase();
					if (obj != null)
						var indx:int = obj.toString().toLowerCase().indexOf(entered);
					 
					if ((selectedCriterion.property.getValueOf(baseObj) != null) 
							&& (selectedCriterion.property.getValueOf(baseObj).toString().toLowerCase().indexOf(StringUtil.trim(txtSearchString.text).toLowerCase()) > -1))	{
						tmpArray.addItem(baseObj);
					}
				}
				
				_searchComponent["dataProvider"] = tmpArray;					
			}	
		}
		
		
	}
}
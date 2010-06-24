// ActionScript file
import mx.collections.ArrayCollection;


public function getCustomTextData(comboData:Object, temp:Object):ArrayCollection{
	var tempCollection:ArrayCollection = new ArrayCollection();
	tempCollection.addItem(comboData);
	tempCollection.addItem(temp);
	return tempCollection;
}
package com.efi.printsmith.model
{
	import com.adobe.cairngorm.model.IModelLocator;

	[Bindable]
	public class ModelLocator implements IModelLocator {
		private static var instance:ModelLocator;
		public function ModelLocator(enforcer:SingletonEnforcer)
		{
			if (enforcer == null) {
				throw new Error("ModelLocator is a Singleton and can only be instantiated once. Use getInstance() instead.");
			}
		}

		public static function getInstance():ModelLocator {
			if (instance == null) {
				instance = new ModelLocator(new SingletonEnforcer);
			}
			return instance;
		}
	}
}

// Utility Class to Deny Access to Constructor
class SingletonEnforcer {}


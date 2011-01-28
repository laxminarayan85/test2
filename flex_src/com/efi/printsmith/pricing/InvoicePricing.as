package com.efi.printsmith.pricing
{
	import com.efi.printsmith.data.Charge;
	import com.efi.printsmith.data.InvoiceBase;
	import com.efi.printsmith.data.Job;
	import com.efi.printsmith.data.SalesCategory;
	import com.efi.printsmith.data.TaxCodes;
	import com.efi.printsmith.data.TaxTable;
	
	public class InvoicePricing
	{
		public var usedCategories:Array;
		public var usedCategoriesTotals:Array;
		
		public var taxTable:TaxTable;
		public var taxCode:TaxCodes;
		public var taxRate:Number;
		public var taxSub:Number; // taxable subtotal
		public var noTax:Boolean;
		public var applyOneTimeDiscount:Boolean;
		public var discount:Number;
		public var discountIsDollarAmt:Boolean;
		public var shippingCharges:Number;
		public var totalDiscount:Number;
		public var subTotal:Number;
		public var salesTax:Number;
		public var shipping:Number;
		public var total:Number;
		public var deposits:Number;
		public var totalDue:Number;
		
		private var _invoice:InvoiceBase;
		
		private var taxableSubtotal:Number;
		private var discountableSubtotal:Number;
		private var actualSubTotal:Number;
		
		public function set invoice(inv:InvoiceBase):void	{
			_invoice = inv;
		}
		
		public function performCalcs():void	{
			calcUsedCategories();
			calcTax();
			calcShipCharges();
			calcSubtotals();
			//calcSalesTax();
			calcDiscounts();
			//calcTotals();			
		}
		
		private function addToSalesCategory(sc:SalesCategory, amount:Number):void	{
			if (usedCategories == null)
				usedCategories = new Array();
			if (usedCategoriesTotals == null)
				usedCategoriesTotals  = new Array();
			
			if (sc.name == "Shipping")	{
				return;
			}
			
			if (usedCategories[sc.name] == null)	{
				usedCategories[sc.name] = sc;
				usedCategoriesTotals[sc.name] = amount;	
			}	
			else	{
				usedCategoriesTotals[sc.name] += amount;
			}
			
		}		 
		private function calcUsedCategories():void	{
						
			if (_invoice != null)	{
				if (_invoice.jobs != null)	{
					for (var i:int=0; i<_invoice.jobs.length; i++)	{
						var j:Job = _invoice.jobs.getItemAt(i) as Job;
						if (j.salesCategory != null)	{
							addToSalesCategory(j.salesCategory, j.pricingRecord.totalPrice);
						}	
						else	{
							if (j.pricingPress != null)	{
								addToSalesCategory(j.pricingPress.salesCat, j.pricingRecord.totalPrice);
							}
							else if (j.pricingCopier != null)	{
								addToSalesCategory(j.pricingCopier.salesCat, j.pricingRecord.totalPrice);
							}
						}
						if (j.charges != null)	{
							for (var k:int = 0; k<j.charges.length; k++)	{
								var c:Charge = j.charges.getItemAt(k) as Charge;
								if (c.chargeDefinition.salesCategory != null)	{
									addToSalesCategory(c.chargeDefinition.salesCategory, c.price);
								}
							}
						}						 
					}										
				}
				if (_invoice.charges != null)	{
					for (var n:int=0; n<_invoice.charges.length; n++)	{
						var c:Charge = _invoice.charges.getItemAt(n) as Charge;
						if (c.chargeDefinition.salesCategory != null)	{
							addToSalesCategory(c.chargeDefinition.salesCategory, c.price);
						}	
					}					
				}
			}
		}
		
		private function calcTax():void	{
			if (_invoice != null)	{
				if (_invoice.taxTable != null)	{
					taxTable = _invoice.taxTable;
				}
				else if (_invoice.account != null)	{
					taxTable = _invoice.account.taxTable;
				}
				if (taxTable != null)
					taxRate = taxTable.effectiveTaxRate;
				
				if (_invoice.taxCode != null)	{
					taxCode = _invoice.taxCode;
				}	
				else if (_invoice.account != null)	{
					taxCode = _invoice.account.taxCode;
				}
				noTax = _invoice.notTaxable;
				
				taxableSubtotal = 0;
				
				if (_invoice.jobs != null)	{
					for (var i:int=0; i<_invoice.jobs.length; i++)	{
						var j:Job = _invoice.jobs.getItemAt(i) as Job;
						if (j.taxable)	{
							taxableSubtotal += j.pricingRecord.totalPrice; 
						}
						if (j.charges != null)	{
							for (var k:int = 0; k<j.charges.length; k++)	{
								var c:Charge = j.charges.getItemAt(k) as Charge;
								if (c.taxable)	{
									taxableSubtotal += c.price;
								}
							}
						}						 
					}										
				}
				if (_invoice.charges != null)	{
					for (var n:int=0; n<_invoice.charges.length; n++)	{
						var c:Charge = _invoice.charges.getItemAt(n) as Charge;
						if (c.taxable)	{
							taxableSubtotal += c.price;
						}	
					}					
				}
				
				taxSub = taxableSubtotal;
				
			}
		}
		
		private function calcShipCharges():void	{
			var sc:Number = 0;
			
			if (_invoice.jobs != null)	{
				for (var i:int=0; i<_invoice.jobs.length; i++)	{
					var j:Job = _invoice.jobs.getItemAt(i) as Job;
					if (j.charges != null)	{
						for (var k:int = 0; k<j.charges.length; k++)	{
							var c:Charge = j.charges.getItemAt(k) as Charge;
							if (c.chargeDefinition.salesCategory.name == "Shipping")	{
								sc += c.price;
							}
						}
					}						 
				}										
			}
			if (_invoice.charges != null)	{
				for (var n:int=0; n<_invoice.charges.length; n++)	{
					var c:Charge = _invoice.charges.getItemAt(n) as Charge;
						if (c.chargeDefinition.salesCategory.name == "Shipping")	{
							sc += c.price;
						}
				}					
			}
			
			shippingCharges = sc;
		}
		
		
		private function calcSubtotals():void	{
			if (_invoice != null)	{
				if (_invoice.jobs != null)	{
					for (var i:int=0; i<_invoice.jobs.length; i++)	{
						var j:Job = _invoice.jobs.getItemAt(i) as Job;
						actualSubTotal += j.pricingRecord.totalPrice;
						
						if (j.charges != null)	{
							for (var k:int = 0; k<j.charges.length; k++)	{
								var c:Charge = j.charges.getItemAt(k) as Charge;
								actualSubTotal += c.price;
							}
						}						 
					}										
				}
				if (_invoice.charges != null)	{
					for (var n:int=0; n<_invoice.charges.length; n++)	{
						var c:Charge = _invoice.charges.getItemAt(n) as Charge;
						actualSubTotal += c.price;	
					}					
				}
			}
		}
		
		
		private function calcDiscounts():void	{
			if (_invoice != null)	{
				if (_invoice.jobs != null)	{
					for (var i:int=0; i<_invoice.jobs.length; i++)	{
						var j:Job = _invoice.jobs.getItemAt(i) as Job;
						discountableSubtotal += j.pricingRecord.totalPrice;
						
						if (j.charges != null)	{
							for (var k:int = 0; k<j.charges.length; k++)	{
								var c:Charge = j.charges.getItemAt(k) as Charge;
								if (c.chargeDefinition.doNotDiscount == false)
									discountableSubtotal += c.price;
							}
						}						 
					}										
				}
				if (_invoice.charges != null)	{
					for (var n:int=0; n<_invoice.charges.length; n++)	{
						var c:Charge = _invoice.charges.getItemAt(n) as Charge;
						if (c.chargeDefinition.doNotDiscount == false)
							discountableSubtotal += c.price;
					}					
				}
				
				if (_invoice["oneTimeDiscount"])	{
					discountIsDollarAmt = false;
					discount = _invoice.account.discount;
					if (discountableSubtotal < discount)	{
						
					}
				}
			}
			
		}
		
	}
}
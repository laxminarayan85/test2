package com.efi.printsmith.pricing
{
	import com.efi.printsmith.data.Charge;
	import com.efi.printsmith.data.DepositEntry;
	import com.efi.printsmith.data.InvoiceBase;
	import com.efi.printsmith.data.Job;
	import com.efi.printsmith.data.SalesCategory;
	import com.efi.printsmith.data.TaxCodes;
	import com.efi.printsmith.data.TaxTable;
	
	import mx.collections.ArrayCollection;
	
	public class InvoicePricing
	{
		
		public static const TAX:int = 1;
		public static const SHIP:int = 2;
		public static const DISCOUNT:int = 3;
		public static const DEPOSITS:int = 4;
		public static const ALL:int = 0;

		public function InvoicePricing()	{
			
		}


		private static function fixNaNs(_invoice:InvoiceBase):void	{
			if (isNaN(_invoice.discount))
				_invoice.discount = 0;
			if (isNaN(_invoice.subTotal))
				_invoice.subTotal = 0;
			if (isNaN(_invoice.amountDue))
				_invoice.amountDue = 0;
			if (isNaN(_invoice.grandTotal))	
				_invoice.grandTotal = 0;
							
		}
		public static function calculateTotals(_invoice:InvoiceBase, step:int ):void	{
			fixNaNs(_invoice);
			calcTax(_invoice);
			calcShipCharges(_invoice);
			calcSubtotals(_invoice);
			calcDiscounts(_invoice);
			calcSalesTax(_invoice);
			calcTotals(_invoice);
			calcTotalDue(_invoice);			
		}
		
		private static function addToSalesCategory(usedCategories:Array, usedCategoriesTotals:Array, sc:SalesCategory, amount:Number):void	{
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
		public static function calcUsedCategories(_invoice:InvoiceBase):ArrayCollection	{
			var usedCategories:Array = null;
			var usedCategoriesTotals:Array = null;
						
			if (_invoice != null)	{
				if (_invoice.jobs != null)	{
					for (var i:int=0; i<_invoice.jobs.length; i++)	{
						var j:Job = _invoice.jobs.getItemAt(i) as Job;
						if (j.salesCategory != null)	{
							addToSalesCategory(usedCategories, usedCategoriesTotals, j.salesCategory, j.pricingRecord.totalPrice);
						}	
						else	{
							if (j.pricingPress != null && j.pricingPress.salesCat != null)	{
								addToSalesCategory(usedCategories, usedCategoriesTotals, j.pricingPress.salesCat, j.pricingRecord.totalPrice);
							}
							else if (j.pricingCopier != null && j.pricingCopier.salesCat != null)	{
								addToSalesCategory(usedCategories, usedCategoriesTotals, j.pricingCopier.salesCat, j.pricingRecord.totalPrice);
							}
						}
						if (j.charges != null)	{
							for (var k:int = 0; k<j.charges.length; k++)	{
								var c:Charge = j.charges.getItemAt(k) as Charge;
								if (c.chargeDefinition.salesCategory != null)	{
									addToSalesCategory(usedCategories, usedCategoriesTotals, c.chargeDefinition.salesCategory, c.price);
								}
							}
						}						 
					}										
				}
				if (_invoice.charges != null)	{
					for (var n:int=0; n<_invoice.charges.length; n++)	{
						var c:Charge = _invoice.charges.getItemAt(n) as Charge;
						if (c.chargeDefinition.salesCategory != null)	{
							addToSalesCategory(usedCategories, usedCategoriesTotals, c.chargeDefinition.salesCategory, c.price);
						}	
					}					
				}
			}
			
			var ac:ArrayCollection = new ArrayCollection();
			ac.addItem(usedCategories);
			ac.addItem(usedCategoriesTotals);
			return ac;
		}
		
		private static function  calcTax(_invoice:InvoiceBase):void	{
			if (_invoice != null)	{
				var taxTable:TaxTable;
				var taxCode:TaxCodes;
				var taxRate:Number = 0;
				
				if (_invoice.taxTable != null)	{
					taxTable = _invoice.taxTable;
				}
				else if (_invoice.account != null)	{
					taxTable = _invoice.account.taxTable;
				}
				if (_invoice.taxCode != null)	{
					taxCode = _invoice.taxCode;
				}	
				else if (_invoice.account != null)	{
					taxCode = _invoice.account.taxCode;
				}
				
				_invoice.taxTable = taxTable;
				_invoice.taxCode = taxCode;
				
				if (taxTable != null)
					taxRate = taxTable.effectiveTaxRate;
				
				var taxableSubtotal:Number = 0;
				
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
				
				_invoice.taxableSubtotal = taxableSubtotal;
				
				
				
			}
		}
		
		private static function  calcShipCharges(_invoice:InvoiceBase):void	{
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
			
			_invoice.shipCharges = sc;
		}
		
		
		private static function  calcSubtotals(_invoice:InvoiceBase):void	{
			if (_invoice != null)	{
				var actualSubTotal:Number = 0;
				
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
				_invoice.actualSubtotal = actualSubTotal;
			}
		}
		
		private static function  calcDiscountableSubTotal(_invoice:InvoiceBase):void	{
			if (_invoice != null)	{
				var discountableSubtotal:Number = 0;
				
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
				
				_invoice.discountableSubtotal = discountableSubtotal;
			}
			
		}
		
		private static function  calcDollarDiscount(_invoice:InvoiceBase):void	{
			if (_invoice != null)	{				
				if (_invoice.discountableSubtotal >= _invoice.discount)	{
					_invoice.subTotal = _invoice.actualSubTotal - _invoice.discount;
					_invoice.dollarDiscount = _invoice.discount;
				}
				else	{
					_invoice.subTotal = _invoice.actualSubTotal - _invoice.discountableSubtotal;
					_invoice.dollarDiscount = _invoice.discountableSubtotal;
				}
			}
		}
		
		private static function calcPercentageDiscount(_invoice:InvoiceBase):void	{
			if (_invoice != null)	{
				var dollarDisc:Number = (_invoice.discount*_invoice.discountableSubtotal) / 100;
				_invoice.subTotal = _invoice.actualSubtotal - dollarDisc;
				_invoice.dollarDiscount  =dollarDisc;
			}
			
		}
		private static function calcDiscounts(_invoice:InvoiceBase):void	{
			if (_invoice != null)	{
				calcDiscountableSubTotal(_invoice);
				if (_invoice.discount > 0)	{
					if (_invoice.discountIsOneTime || _invoice.discountIsDollars)	{
						calcDollarDiscount(_invoice); 
					}
					else	{
						calcPercentageDiscount(_invoice);
					}
				}	
				else	{
					_invoice.subTotal = _invoice.actualSubtotal;
				}							
			}
			
		}
		
		private static function  calcShippingTax(_invoice:InvoiceBase):void	{
			if (_invoice.shipPrice > 0 && _invoice.taxTable.taxShipping)	{
				_invoice.tax += (_invoice.shipPrice * _invoice.taxTable.effectiveTaxRate ); 
			}
		}
		private static function  calcSalesTax(_invoice:InvoiceBase):void	{
			if (_invoice != null)	{
				// calculate sales tax
				calcShippingTax(_invoice);
			}
		}
		
		public static function  getDeposits(_invoice:InvoiceBase):Number	{
			if (_invoice != null)	{
				var deposits:Number = 0;
				if (_invoice.deposits != null && _invoice.deposits.length > 0)	{
					for (var i:int=0; i<_invoice.deposits.length; i++)	{
						var de:DepositEntry = _invoice.deposits.getItemAt(i) as DepositEntry;
						if (de.amount > 0)	{
							deposits += de.amount;
						}
					}  
				}
				return deposits;
			}
			return 0;
		} 
		private static function  calcTotals(_invoice:InvoiceBase):void	{
			_invoice.grandTotal = _invoice.subTotal + _invoice.tax + _invoice.shipPrice;
			 
		}		
		
		private static function calcTotalDue(_invoice:InvoiceBase):void	{
			if (_invoice != null)	{
				fixNaNs(_invoice);
					 
				var deposits:Number = getDeposits(_invoice);
				_invoice.amountDue = _invoice.grandTotal - deposits;
			}
		}
	}
}
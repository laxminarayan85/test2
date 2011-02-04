package com.efi.printsmith.pricing
{
	import com.efi.printsmith.data.Charge;
	import com.efi.printsmith.data.DepositEntry;
	import com.efi.printsmith.data.InvoiceBase;
	import com.efi.printsmith.data.Job;
	import com.efi.printsmith.data.SalesCategory;
	import com.efi.printsmith.data.TaxCodes;
	import com.efi.printsmith.data.TaxTable;
	
	public class InvoicePricing
	{
		
		public static const TAX:int = 1;
		public static const SHIP:int = 2;
		public static const DISCOUNT:int = 3;
		public static const DEPOSITS:int = 4;
		public static const ALL:int = 0;

		public function InvoicePricing()	{
			
		}
		// used by DocumentTotalsWindow - all fields modified by this window should be copied back into original invoice
		public static function copyPricingFields(_fromInvoice:InvoiceBase, _toInvoice:InvoiceBase):void	{
			
			_toInvoice.jobs = _fromInvoice.jobs;
			_toInvoice.charges = _fromInvoice.charges;
			_toInvoice.discount = _fromInvoice.discount;
			_toInvoice.dollarDiscount = _fromInvoice.dollarDiscount;
			_toInvoice.notTaxable = _fromInvoice.notTaxable;
			_toInvoice.taxTable = _fromInvoice.taxTable;
			_toInvoice.taxCode = _fromInvoice.taxCode;
			_toInvoice.taxRate = _fromInvoice.taxRate;
			_toInvoice.discountIsOneTime = _fromInvoice.discountIsOneTime;
			_toInvoice.discountIsDollars = _fromInvoice.discountIsDollars;
			_toInvoice.shipPrice = _fromInvoice.shipPrice;
			_toInvoice.actualSubtotal = _fromInvoice.actualSubtotal;
			_toInvoice.amountDue = _fromInvoice.amountDue;
			_toInvoice.discountableSubtotal = _fromInvoice.discountableSubtotal;
			_toInvoice.grandTotal = _fromInvoice.grandTotal;
			_toInvoice.priceLocked  = _fromInvoice.priceLocked;
			_toInvoice.shipCharges = _fromInvoice.shipCharges;
			_toInvoice.shipPrice = 	_fromInvoice.shipPrice;
			_toInvoice.subTotal = _fromInvoice.subTotal;
			_toInvoice.tax = _fromInvoice.tax;
			_toInvoice.taxableSubtotal = _fromInvoice.taxableSubtotal;
			_toInvoice.deposits = _fromInvoice.deposits;
			_toInvoice.orderedDate = _fromInvoice.orderedDate;
			_toInvoice.proofDate = _fromInvoice.proofDate;
			_toInvoice.wantedDate = _fromInvoice.wantedDate;
			_toInvoice.completedDate = _fromInvoice.completedDate;
			_toInvoice.customerNotificationDate = _fromInvoice.customerNotificationDate;
			_toInvoice.pickupDate = _fromInvoice.pickupDate;	
			
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
		
		private static function addToSalesCategory(usedCategories:Array, sc:SalesCategory, amount:Number):Array	{
			if (usedCategories == null)
				usedCategories = new Array();
//			if (usedCategoriesTotals == null)
//				usedCategoriesTotals  = new Array();
			
			if (sc.name == "Shipping")	{
				return usedCategories;
			}
			
			if (usedCategories[sc.name] == null)	{
				usedCategories[sc.name] = amount;
//				usedCategoriesTotals[sc.name] = amount;	
			}	
			else	{
				usedCategories[sc.name] += amount;
			}
			return usedCategories;
		}		 
		public static function calcUsedCategories(_invoice:InvoiceBase):Array	{
			var usedCategories:Array = null;
//			var usedCategoriesTotals:Array = null;
						
			if (_invoice != null)	{
				if (_invoice.jobs != null)	{
					for (var i:int=0; i<_invoice.jobs.length; i++)	{
						var j:Job = _invoice.jobs.getItemAt(i) as Job;
						if (j.salesCategory != null)	{
							usedCategories = addToSalesCategory(usedCategories, j.salesCategory, j.pricingRecord.totalPrice);
						}	
						else	{
							if (j.pricingPress != null && j.pricingPress.salesCat != null)	{
								usedCategories = addToSalesCategory(usedCategories, j.pricingPress.salesCat, j.pricingRecord.totalPrice);
							}
							else if (j.pricingCopier != null && j.pricingCopier.salesCat != null)	{
								usedCategories = addToSalesCategory(usedCategories, j.pricingCopier.salesCat, j.pricingRecord.totalPrice);
							}
						}
						if (j.charges != null)	{
							for (var k:int = 0; k<j.charges.length; k++)	{
								var c:Charge = j.charges.getItemAt(k) as Charge;
								if (c.chargeDefinition.salesCategory != null)	{
									usedCategories = addToSalesCategory(usedCategories, c.chargeDefinition.salesCategory, c.price);
								}
							}
						}						 
					}										
				}
				if (_invoice.charges != null)	{
					for (var n:int=0; n<_invoice.charges.length; n++)	{
						var c:Charge = _invoice.charges.getItemAt(n) as Charge;
						if (c.chargeDefinition.salesCategory != null)	{
							usedCategories = addToSalesCategory(usedCategories, c.chargeDefinition.salesCategory, c.price);
						}	
					}					
				}
			}
			
//			var ac:ArrayCollection = new ArrayCollection();
//			ac.addItem(usedCategories);
//			ac.addItem(usedCategoriesTotals);
			return usedCategories;
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
				if (_invoice.notTaxable)		{
					_invoice.taxableSubtotal = 0;					
				}
				else	{
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
					_invoice.subTotal = _invoice.actualSubtotal - _invoice.discount;
					_invoice.dollarDiscount = _invoice.discount;
				}
				else	{
					_invoice.subTotal = _invoice.actualSubtotal - _invoice.discountableSubtotal;
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
				_invoice.tax = 0;
				if (!_invoice.notTaxable)	{
					// calculate sales tax
					if (_invoice.taxTable != null)	{
						calcShippingTax(_invoice);
					}
				}
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
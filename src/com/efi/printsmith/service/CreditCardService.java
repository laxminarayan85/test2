package com.efi.printsmith.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.lang.*;
import java.util.List;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CreditCardTransactions;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.PreferencesAccounting;
import com.efi.printsmith.network.Base64;
import com.efi.printsmith.network.HttpContentType;
import com.efi.printsmith.network.HttpPostContent;
import com.efi.printsmith.network.HttpResponse;
import com.efi.printsmith.network.MessageUtil;
import com.efi.printsmith.network.NetworkHelper;
import com.efi.printsmith.service.EncryptionService;
import com.efi.printsmith.service.VersionService;
import com.efi.printsmith.Constants;

public class CreditCardService extends SnowmassHibernateService {
	private Logger log = Logger.getLogger(CreditCardService.class);

	public CreditCardService() {
		super();
	}
	
	//*************************************************************************
	//***	FilterURLdataChars
	//*************************************************************************
	private String FilterURLdataChars(String buf)	// make sure that entered text is legal and won't mess things up
	{			
		String	temp;
		
		temp = buf.replaceAll(" ", "+");	// trade spaces for "+" symbol, see HTTP POST logic for forms
		temp = temp.replaceAll("~", "");
		temp = temp.replaceAll("`", "");
		temp = temp.replaceAll("!", "");
		temp = temp.replaceAll("@", "");	// Don't use this function on email address data
		temp = temp.replaceAll("#", "");
		temp = temp.replaceAll("$", "");
		temp = temp.replaceAll("%", "");
		temp = temp.replaceAll("^", "");
		temp = temp.replaceAll("&", "");
	//	temp = temp.replaceAll("*", "");
	//	temp = temp.replaceAll("(", "");
	//	temp = temp.replaceAll(")", "");
		temp = temp.replaceAll("_", "");
		temp = temp.replaceAll("-", "");
		temp = temp.replaceAll("\\.", "");
		temp = temp.replaceAll("=", "+");
		return(temp);
	} // FilterURLdataChars


	//********************************************************************************
//		AppeandFormInputData - 
	//********************************************************************************
	private String AppeandFormInputData(String valStr, String fieldName, String textData, Boolean prependseperator, Boolean filterStr)
	{
		String		variableSeparator = "&";
		String		temp = null,buf;
		
		if (valStr != null) {
			if (prependseperator)
				temp = valStr.concat(variableSeparator);
			else
				temp = valStr;
			temp = temp.concat(fieldName);
			temp = temp.concat("=");
						
			// does the data string need spaces and special characters removed
			if (filterStr) {
				buf = FilterURLdataChars(textData);
				temp = temp.concat(buf);
			} else {
				temp = temp.concat(textData);
			}
		}
		
		return(temp);
	} /* AppeandFormInputData */
	
	//
	// get the current serial number from the preference system
	//
	private String GetSerialNumber(PreferencesSystem preferences) {
		String 		serialNumber;

		if (preferences != null && preferences.getSerialNumber() != null) {
			serialNumber = preferences.getSerialNumber().toString();
			if (serialNumber == null)
				serialNumber = "9999";
		} else
			serialNumber = "9999";
		return(serialNumber);
	}
	
	private String CreateCreditCardTransactionID(DataService dataService, int max, CreditCardTransactions cct)
	{
		String 		buf;
		String		temp;
		Long		idNumber = cct.getId();
		String		formattedNumber;
		int			zeroCnt = 0;
		long 		serialNumber;
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences == null) {
			preferences = new PreferencesSystem();
		}
		
		temp = GetSerialNumber(preferences);
		buf = String.format("PS%s", temp);
		formattedNumber = String.format("%d", idNumber);
		
		zeroCnt = max - (buf.length()+formattedNumber.length());
		if (zeroCnt > 0) {
			for (;zeroCnt > 0; --zeroCnt)
				buf = buf.concat("0");
		}
		
		buf = buf.concat(formattedNumber);
		return(buf);
	}	/* CreateCreditCardTransactionID */

	// =============================== MAIN ===============================
	//
	// Given a credit card transaction database record, read the data and send to appropriate processing
	//
	//
	public Long sendCardTransaction(Long id) throws Exception {
		Boolean	results;
		DataService dataService = new DataService();
		String serialNum, devNum;
		
		try {
			CreditCardTransactions ccTransaction = (CreditCardTransactions)dataService.getById("CreditCardTransactions", id);
			
			PreferencesAccounting preferencesAccounting = (PreferencesAccounting)dataService.getSingle("PreferencesAccounting");
			
			if (preferencesAccounting == null)
				preferencesAccounting = new PreferencesAccounting();
			
			//================================================================
			// Handle any DEMO mode here
			//
			//
			// TODO
			
			//================================================================
			// Bad transaction test, JAVA will crash is not caught here
			//
			if (ccTransaction.getAmount() == null || ccTransaction.getAmount() == 0.0) {
		    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
	    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined);
	    		// TODO - localized version
	    		ccTransaction.setMessage("Bad value");
		    	
	    		ccTransaction = SafeDeleteCriticalDataInTransaction(ccTransaction);
		    	dataService.addUpdate(ccTransaction);
			} else {
				//================================================================
				// Skipjack system
				//
				if(preferencesAccounting.getUseSkipJackProcessor() == true) {
					
					serialNum = preferencesAccounting.getSerialNumber();
					devNum = preferencesAccounting.getDevelopmentNumber();
					
					//
					// are the setting done properly
					//
					if (serialNum == null || serialNum.length() == 0 || devNum == null || devNum.length() == 0) {
				    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
			    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
			    		// TODO - localized version
			    		ccTransaction.setMessage("Approval system not ready");
					} else {
		
						if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeCredit || 
								ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReversal || 
									ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReAutorize) {
							
							ccTransaction = skipJackCreditTransaction(dataService, preferencesAccounting, ccTransaction);
						} else {
							
							ccTransaction = skipJackAuthTransaction(dataService, preferencesAccounting, ccTransaction);
						}
					}
					
			    	ccTransaction = SafeDeleteCriticalDataInTransaction(ccTransaction);
			    	dataService.addUpdate(ccTransaction);
				} 
				//================================================================
				// EFS system
				//
				else if(preferencesAccounting.getUseEfsProcessor() == true){
					//
					// send the request to EFS (Sage)
					//
					ccTransaction = efsTransaction(dataService, preferencesAccounting, ccTransaction);
					
					//
					// zero out critical data
					//
			    	ccTransaction = SafeDeleteCriticalDataInTransaction(ccTransaction);
			    	dataService.addUpdate(ccTransaction);				
				} 
				//================================================================
				// system not read
				//
				else {
			    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
		    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
		    		// TODO - localized version
		    		ccTransaction.setMessage("Approval system not ready");
		    		
		    		ccTransaction = SafeDeleteCriticalDataInTransaction(ccTransaction);
					dataService.addUpdate(ccTransaction);
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(id);
	}
	
	// Given a OLD order number from a previous transaction, perform a lookup and read
	//	the given status of that transaction, some can be voided, others need adjustment.
	//
	//
	private List SkipjackGetTransactionStatusModal(PreferencesAccounting preferencesAccounting, String orderName) throws Exception {
		Boolean			results = true;
		ArrayList 		returnList = new ArrayList();
		String 			sendStr = "";
		int 			StatusCodeCurrent = 0;
		int 			StatusCodePending = 0;
		String 			message = "";
		double 			origAmount = 0;
		String 			statusOrigFileName = "";
		String			temp;
		
	//	URL url = new URL("https://developer.skipjackic.com/scripts/evolvcc.dll?AuthorizeAPI");
		URL url = new URL("https://www.skipjackic.com/scripts/evolvcc.dll?SJAPI_TransactionStatusRequest");

		try {
			if (!url.getProtocol().equals("https")) throw new ProtocolException("CreditCardService only supports HTTPS.");
			NetworkHelper.enableSSL();

	//		temp = preferencesAccounting.getSerialNumber();
	//		if (temp == null || temp.length() == 0)
	//			temp = "000111114451";
			sendStr = AppeandFormInputData(sendStr, "szserialnumber", preferencesAccounting.getSerialNumber(), false, false);
			
	//		temp =preferencesAccounting.getDevelopmentNumber();
	//		if (temp == null || temp.length() == 0)
	//			temp = "666644442222";
			sendStr = AppeandFormInputData(sendStr, "szdeveloperserialnumber", preferencesAccounting.getDevelopmentNumber(), true, false);
			
			sendStr = AppeandFormInputData(sendStr, "szordernumber", orderName, true, false);
			
			HttpPostContent postContent = new HttpPostContent(sendStr, HttpContentType.CONTENT_TYPE_DEFAULT);
			HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);

			int statusCode = response.getStatusCode(); // Status code, 200==success, 400==bad request, etc. 
			//String statusStr = response.getStatusText();
			String responseBody = response.getBody();
			
			System.out.println(responseBody);
			
			if (statusCode != 200 || responseBody.length() == 0) {
				results = false;
			} else {
				String	SkipJackResponseErrorCode = "";
				
				String	SkipJackResponseTransactionAmount = "";
				String  SkipJackResponseTransactionStatusCode = "";
				String	SkipJackResponseStatusResponseMessage = "";
				String 	SkipJackResponseTransFileName = "";
			    String 	firstLine[]=new String [50];
			    String 	secondLine[]=new String [50];
			    String 	token;
			    StringTokenizer st=new StringTokenizer(responseBody,"\r\"", true);
			    int 	fieldCnt = 0;
			    int 	dataCnt = 0;
			    int 	quoteCnt = 0;
			    
			    Boolean onFieldList = true;
			    while (st.hasMoreTokens()) {
			    	token = st.nextToken();
			    	if (token.equals("\r")) {
			    		onFieldList = false;
			    	}
			    	if (token.equals("\r") == false && 
			    			token.equals("\n") == false && 
			    				token.equals(",") == false) {
			    		
			    		if (token.equals("\"") == false) {
					    	if (onFieldList) {
					    		firstLine[fieldCnt] =  token;
					    	} else {
					    		secondLine[dataCnt] = token;
					    	}
			    		} else {
					    	if ((++quoteCnt%2) == 0) {
					    		if (onFieldList) {
						    		++fieldCnt;
					    		} else {
						    		++dataCnt;
					    		}
					    	}
			    		}
			    	}
			    }
		    
			    if (fieldCnt > 0) {
					// get status response from the first line.
					//
					// 1 = serial number
					// 2 = transaction amount
					// 3 = transaction status code
					// 4 = transation status message
					// 5 = order number
					// 6 = transaction date and time
					// 7 = transaction ID
					// 8 = approval code
					// 9 = batch number
					//

				//	SkipJackResponseSerialNumber = firstLine[0];
					SkipJackResponseErrorCode = firstLine[1];
				//	SkipJackResponseNumberRecords = firstLine[2];
					
				//	SkipJackResponseStatusCode = secondLine[0];
					SkipJackResponseTransactionAmount = secondLine[1];
					SkipJackResponseTransactionStatusCode = secondLine[2];
					SkipJackResponseStatusResponseMessage = secondLine[3];
				//	SkipJackResponseOrderNumber = secondLine[4];
				//  SkipJackResponseTransactionDate = secondLine[5];
					SkipJackResponseTransFileName = secondLine[6];			    
			    	
			    	// good request/response value
			    	if (SkipJackResponseErrorCode.contentEquals("0")) {
			    		// found in processor system
			    		results = true;
			    		StatusCodeCurrent = SkipJackResponseTransactionStatusCode.charAt(0) - 48;
			    		StatusCodePending = SkipJackResponseTransactionStatusCode.charAt(1) - 48;
			    		message = SkipJackResponseStatusResponseMessage;
			    		origAmount = Double.parseDouble(SkipJackResponseTransactionAmount);
			    		statusOrigFileName = SkipJackResponseTransFileName;
			    	} else {
			    		message = SkipJackResponseErrorCode.toString();
			    		results = false;
			    	}
			    }	
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			results = false;
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			results = false;
		}	
			
		returnList.add(results);
		returnList.add(StatusCodeCurrent);
		returnList.add(StatusCodePending);
		returnList.add(origAmount);
		returnList.add(message);
		returnList.add(statusOrigFileName);
		return(returnList);
	}

	//*************************************************************************
	//***	FormatSkipJackPennies
	//		minimum number of digits can be requested.
	//		000 = for a zero positive
	//		-000 = for a negative
	//		Otherwise the number of digits will grow to include a total penny count.
	//*************************************************************************
	private String FormatSkipJackPennies(int p)
	{
		String temp;
		
		if (p < 0)
			temp = String.format("%04d", p); // account for "-" sign
		else
			temp = String.format("%03d", p);
		return(temp);
	} /* FormatSkipJackPennies */
	
	
	//
	// handle all CREDIT type transactions for SkipJack
	//
	private CreditCardTransactions skipJackCreditTransaction(DataService dataService, PreferencesAccounting preferencesAccounting, CreditCardTransactions ccTransaction) throws Exception {
		String 			sendStr = "";
		String 			temp = "";
		int				StatusCodeCurrent;
		int				StatusCodePending;
		int				amount;
		double			origAmount = 0;
		String 			statusOrigFileName = "";
		List 			returnList;
		String 			street = "";
		String 			zip = "";
		String 			temp2 = "";
	
		Calendar rightNow = Calendar.getInstance();
		
	//	URL url = new URL("https://developer.skipjackic.com/scripts/evolvcc.dll?AuthorizeAPI");
		URL url;

		try {			
			
			// get the current status of this transaction
			if (ccTransaction.getOrderName().length() > 0) {
				//
				// Need to original transaction data to complete a CREDIT
				//
				returnList = SkipjackGetTransactionStatusModal(preferencesAccounting, ccTransaction.getOrderName());
	
				origAmount = (Double) returnList.get(3);
				statusOrigFileName = (String)returnList.get(5);
			
				if ((Boolean)returnList.get(0) == false) {
					ccTransaction.setMessage((String)returnList.get(3));
					ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);	
					ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
					return(ccTransaction);
				} else {
					
					StatusCodeCurrent = (Integer) returnList.get(1);
					StatusCodePending = (Integer) returnList.get(2);
					//
					// only when the original transaction has been settled and idle
					//
					if (StatusCodeCurrent == 3 && StatusCodePending == 0) {
						if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReversal)	// trying to reverse a OLD change
							ccTransaction.setTransactionType(Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeCredit);		// change to a credit
						// stay with "TransactionChangeStatusRequest" request and DELETE or CREDIT
					} 
					//
					// unsettled transaction still waiting to be processed
					//
					else {
						//
						// if the request is a CREDIT and the original transaction is NOT settled, try a reautherize at another amount
						//
						if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeCredit)
							ccTransaction.setTransactionType(Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReAutorize);
					}
				}
			}
			//
			// try a blind credit authorize in place of a ChangeStatus call
			else {
				ccTransaction.setTransactionType(Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeAdjustment);
				// amount will be sent as a Negative
			}
			
			//
			// this is a BLIND credit type, send as a normal charge (but in reverse) Negative
			// ===============
			//
			if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeAdjustment) {
				
				url = new URL("https://www.skipjackic.com/scripts/evolvcc.dll?AuthorizeAPI");
				if (!url.getProtocol().equals("https")) throw new ProtocolException("CreditCardService only supports HTTPS.");
				NetworkHelper.enableSSL();

			//	temp = preferencesAccounting.getSerialNumber();
			//	if (temp == null || temp.length() == 0)
			//		temp = "000111114451";
				sendStr = AppeandFormInputData(sendStr, "serialnumber", preferencesAccounting.getSerialNumber(), false, false);
				
			//	temp =preferencesAccounting.getDevelopmentNumber();
			//	if (temp == null || temp.length() == 0)
			//		temp = "666644442222";
				sendStr = AppeandFormInputData(sendStr, "developerserialnumber", preferencesAccounting.getDevelopmentNumber(), true, false);
				
				sendStr = AppeandFormInputData(sendStr, "shiptophone", "0000000000", true, true);
				sendStr = AppeandFormInputData(sendStr, "email", "transaction@skipjack.com", true, false);

				sendStr = AppeandFormInputData(sendStr, "sjname", ccTransaction.getCreditCard().getCardHolderName(), true, true);

				temp = EncryptionService.decryptData(ccTransaction.getCreditCard().getCardNumber(), "AES256WITHSERIALNUMBER");
				sendStr = AppeandFormInputData(sendStr, "accountnumber", temp, true, false);
				
				rightNow.setTime(ccTransaction.getCreditCard().getExpiresDate());
				temp = String.format("%02d", rightNow.get(Calendar.MONTH) + 1);
				sendStr = AppeandFormInputData(sendStr, "month", temp, true, false);
				
				temp = String.format("%02d", (rightNow.get(Calendar.YEAR) - 2000));
				sendStr = AppeandFormInputData(sendStr, "year", temp, true, false);
				

				amount = (int)(ccTransaction.getAmount() * 100);			// pennies
				temp = String.format("%d", -amount);
				sendStr = AppeandFormInputData(sendStr, "transactionamount", temp, true, false);
				
				// TODO Needs real version from system
				temp = "1.0";		//VersionService.getServerVersion();
				
				temp = String.format("1~Adjustment to Charge Amount (v%s)~%f~0~N~||", temp, ccTransaction.getAmount());
				sendStr = AppeandFormInputData(sendStr, "orderstring", temp, true, false);
				
				temp = CreateCreditCardTransactionID(dataService, 14, ccTransaction);
				sendStr = AppeandFormInputData(sendStr, "ordernumber", temp, true, false);
				ccTransaction.setOrderName(temp);
				
				temp = ccTransaction.getOrderNumber();
				if (temp.length() == 0)
					temp = "0";
				sendStr = AppeandFormInputData(sendStr, "invoicenumber", temp, true, true);
			
				//
				// If this transaction was manually approved, then fill in the approval code here.
				// This keeps Skipjack from getting a new code for the transaction.
				//
				if (ccTransaction.getManualCode().length() > 0) {
					sendStr = AppeandFormInputData(sendStr, "approvalcode", ccTransaction.getApprovalCode(), true, true);
				}
				
				if (ccTransaction.getCreditCard().getAddress1() != null) 
					street = ccTransaction.getCreditCard().getAddress1();
				if (ccTransaction.getCreditCard().getZipCode() != null)
					zip = ccTransaction.getCreditCard().getZipCode();
				
				// ensure the data is not empty, even after purge of spaces and dash
				street = street.replaceAll(" ", "");
				if (street.length() == 0)
					street = "123 Test Way";
				sendStr = AppeandFormInputData(sendStr, "streetaddress", street, true, true);
				sendStr = AppeandFormInputData(sendStr, "city", "None", true, true);
				sendStr = AppeandFormInputData(sendStr, "state", "XX", true, true);

				zip = zip.replaceAll(" ", "");
				zip = zip.replaceAll("-", "");
				if (zip.length() == 0)
					zip = "00000";		
				sendStr = AppeandFormInputData(sendStr, "zipcode", zip, true, true);
				
				if (ccTransaction.getContact() != null && ccTransaction.getContact().getContactId().length() > 0)
					temp = ccTransaction.getContact().getContactId();
				else
					temp = String.format("%d", ccTransaction.getId()); // order number not known use record number, have something for level II rate
				sendStr = AppeandFormInputData(sendStr, "customercode", temp, true, true);
				
				if (ccTransaction.getPoNumber().length() > 0)
					sendStr = AppeandFormInputData(sendStr, "purchaseordernumber", ccTransaction.getPoNumber(), true, true);
				else
					sendStr = AppeandFormInputData(sendStr, "purchaseordernumber", "A1234567890", true, true);		// fake number for Level II rates
				
				if (ccTransaction.getUserName().length() > 0)
					sendStr = AppeandFormInputData(sendStr, "comment", ccTransaction.getUserName(), true, true);
			
				// encrypt the number in the file or show as clear text (Track data contains the card number and name)
				if (ccTransaction.getHasCVVdata() == false) {			// if the track data is present, but CVV2 data is not hand entered into the same field
					temp = EncryptionService.decryptData(ccTransaction.getTrackOne(), "AES256WITHSERIALNUMBER");
					temp2 = EncryptionService.decryptData(ccTransaction.getTrackTwo(), "AES256WITHSERIALNUMBER");
					temp.concat(temp2);
					if (temp.length() > 0) {
						temp = temp.replaceAll("%", "");
						sendStr = AppeandFormInputData(sendStr, "trackdata", temp, true, false);
					}
				}

				if (ccTransaction.getTax() > 0) {
					temp = String.format("%d", ccTransaction.getTax() * 100);
				} else
					temp = "0";
				sendStr = AppeandFormInputData(sendStr, "customertax", temp, true, true);

				if (ccTransaction.getHasCVVdata() == true) {
					temp = EncryptionService.decryptData(ccTransaction.getTempCVV2(), "AES256WITHSERIALNUMBER");
					sendStr = AppeandFormInputData(sendStr, "CVV2", temp, true, false);
				}
				
				HttpPostContent postContent = new HttpPostContent(sendStr, HttpContentType.CONTENT_TYPE_DEFAULT);
				HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);

				int statusCode = response.getStatusCode(); // Status code, 200==success, 400==bad request, etc. 
				String statusStr = response.getStatusText();
				String responseBody = response.getBody();
				
				System.out.println(responseBody);
				
				//
				// Process a blind credit response, just like a CHARGE but with negative
				//
				if (statusCode != 200 || responseBody.length() == 0) {
					ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
					ccTransaction.setMessage(statusStr);
			    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
				} else {
					String	SkipJackResponseAuthCode = "";
					String	SkipJackResponseReturnCode = "";
					String	SkipJackResponseDeclinedMessage = "";
					String	SkipJackResponseIsApproved = "";
					String	SkipJackResponseTransFileName = "";
					String	SkipJackResponseErrorCode = "";
					
				    String fieldTagName[]=new String [50];
				    String fieldTagAnswer[]=new String [50];
				    String token;
				    StringTokenizer st=new StringTokenizer(responseBody,"\r\"", true);
				    int fieldCnt = 0;
				    int dataCnt = 0;
				    int quoteCnt = 0;
				    int	idx = 0;
				    
				    Boolean onFieldList = true;
				    while (st.hasMoreTokens()) {
				    	token = st.nextToken();
				    	if (token.equals("\r")) {
				    		onFieldList = false;
				    	}
				    	if (token.equals("\r") == false && 
				    			token.equals("\n") == false && 
				    				token.equals(",") == false) {
				    		
				    		if (token.equals("\"") == false) {
						    	if (onFieldList) {
						    		fieldTagName[fieldCnt] =  token;
						    	} else {
						    		fieldTagAnswer[dataCnt] = token;
						    	}
				    		} else {
						    	if ((++quoteCnt%2) == 0) {
						    		if (onFieldList) {
							    		++fieldCnt;
						    		} else {
							    		++dataCnt;
						    		}
						    	}
				    		}
				    	}
				    }
				    
				    if (fieldCnt > 0) {
				    	for (idx = 0; idx < fieldCnt; ++idx) {
				    		if (fieldTagName[idx].contentEquals("AUTHCODE"))
				    			SkipJackResponseAuthCode = fieldTagAnswer[idx];
				    //		if (fieldTagName[idx].contentEquals("szSerialNumber"))
				    //			SkipJackResponseSerialNumber = fieldTagAnswer[idx];
				    //		if (fieldTagName[idx].contentEquals("szTransactionAmount"))
				    //			SkipJackResponseTransactionAmount = fieldTagAnswer[idx];
				    //		if (fieldTagName[idx].contentEquals("szAuthorizationResponseCode"))
				    //			SkipJackResponseAuthResponseCode = fieldTagAnswer[idx];
				    		if (fieldTagName[idx].contentEquals("szReturnCode"))
				    			SkipJackResponseReturnCode = fieldTagAnswer[idx];
				    		if (fieldTagName[idx].contentEquals("szAuthorizationDeclinedMessage"))
				    			SkipJackResponseDeclinedMessage = fieldTagAnswer[idx];
				    //		if (fieldTagName[idx].contentEquals("szAVSResponseCode"))
				    //			SkipJackResponseAVSResponseCode = fieldTagAnswer[idx];
				    //		if (fieldTagName[idx].contentEquals("szAVSResponseMessage"))
				    //			SkipJackResponseAVSResponseMessage = fieldTagAnswer[idx];
				    //		if (fieldTagName[idx].contentEquals("szOrderNumber"))
				    //			SkipJackResponseOrderNumber = fieldTagAnswer[idx];
				    		if (fieldTagName[idx].contentEquals("szIsApproved"))
				    			SkipJackResponseIsApproved = fieldTagAnswer[idx];
				    	//	if (fieldTagName[idx].contentEquals("szCVV2ResponseCode"))
				    	//		SkipJackResponseCVV2ResponseCode = fieldTagAnswer[idx];
				    	//	if (fieldTagName[idx].contentEquals("szCVV2ResponseMessage"))
				    	//		SkipJackResponseCVV2ResponseMessage = fieldTagAnswer[idx];
				    		if (fieldTagName[idx].contentEquals("szTransactionFileName"))
				    			SkipJackResponseTransFileName = fieldTagAnswer[idx];
				    	//	if (fieldTagName[idx].contentEquals("szCAVVResponseCode"))
				    	//		SkipJackResponseCAVVResponseCode = fieldTagAnswer[idx];
				    		if (fieldTagName[idx].contentEquals("szErrorCode"))
				    			SkipJackResponseErrorCode = fieldTagAnswer[idx];
				    	//	if (fieldTagName[idx].contentEquals("szNumberRecords"))
				    	//		SkipJackResponseNumberRecords = fieldTagAnswer[idx];
				    	}
				    	
				    	// good request/response value
				    	if (SkipJackResponseReturnCode.contentEquals("1")) {
				    		// approved
				    		if (SkipJackResponseIsApproved.contentEquals("1")) {
								ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsApproved);
								ccTransaction.setApprovalCode(SkipJackResponseAuthCode);
								ccTransaction.setReferenceNumber(SkipJackResponseTransFileName);
				    		} 
				    		// declined
				    		else {
					    		ccTransaction.setMessage(SkipJackResponseDeclinedMessage);
					    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined);
				    		}
				    	} else {
				    		if (SkipJackResponseReturnCode.length() > 0)
				    			ccTransaction.setMessage(SkipJackResponseReturnCode);
				    		else
				    			ccTransaction.setMessage(SkipJackResponseErrorCode);
							ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined);
				    	}
				    	
						ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
				    }
				}
			} 
			//
			// Normal Credit Auth request here
			//
			else {
				
				url = new URL("https://www.skipjackic.com/scripts/evolvcc.dll?SJAPI_TransactionChangeStatusRequest");
				if (!url.getProtocol().equals("https")) throw new ProtocolException("CreditCardService only supports HTTPS.");
				NetworkHelper.enableSSL();

			//	temp = preferencesAccounting.getSerialNumber();
			//	if (temp == null || temp.length() == 0)
			//		temp = "000111114451";
				sendStr = AppeandFormInputData(sendStr, "szserialnumber", preferencesAccounting.getSerialNumber(), false, false);
				
			//	temp =preferencesAccounting.getDevelopmentNumber();
			//	if (temp == null || temp.length() == 0)
			//		temp = "666644442222";
				sendStr = AppeandFormInputData(sendStr, "szdeveloperserialnumber", preferencesAccounting.getDevelopmentNumber(), true, false);
				
				// used here as the search and find number in there system
				if (ccTransaction.getOrderName().length() > 0)
					sendStr = AppeandFormInputData(sendStr, "szordernumber", ccTransaction.getOrderName(), true, false);
				else {
					if (statusOrigFileName.length() > 0)
						sendStr = AppeandFormInputData(sendStr, "sztransactionid", statusOrigFileName, true, false);
					else if (ccTransaction.getReferenceNumber().length() > 0)
						sendStr = AppeandFormInputData(sendStr, "sztransactionid", ccTransaction.getReferenceNumber(), true, false);
				}
				
				//
				// Credits must have a process reference number from the original transaction
				//
				if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeCredit) {
					// create a NEW order number for the credit, that way our Status request will always return a single entry
					//
					ccTransaction.setOrderName(CreateCreditCardTransactionID(dataService, 14, ccTransaction));
					
					sendStr = AppeandFormInputData(sendStr, "szNewOrderNumber", ccTransaction.getOrderName(), true, false);
	
					sendStr = AppeandFormInputData(sendStr, "szdesiredstatus", "CREDITEX", true, false);			// was "CREDIT"
					temp = FormatSkipJackPennies((int)(ccTransaction.getAmount() * 100.0));		// Bill, always pass positive number
					sendStr = AppeandFormInputData(sendStr, "szamount", temp, true, false);
					
					// the EX version can except new order string
					// TODO get the real version string
					temp = String.format("1~Credit for Amount (v%s)~%f~0~N~||", "1.0", ccTransaction.getAmount());
					sendStr = AppeandFormInputData(sendStr, "orderstring", temp, true, false);
				}
				else if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReAutorize) {
					// create a NEW order number for the credit, that way our Status request will always return a single entry
					//
					ccTransaction.setOrderName(CreateCreditCardTransactionID(dataService, 14, ccTransaction));
					sendStr = AppeandFormInputData(sendStr, "szNewOrderNumber", ccTransaction.getOrderName(), true, false);
					
					sendStr = AppeandFormInputData(sendStr, "szdesiredstatus", "SETTLE", true, false);			// AUTHORIZE
					
					temp = FormatSkipJackPennies((int)((origAmount - ccTransaction.getAmount()) * 100.0));		// Bill, always pass positive number
					sendStr = AppeandFormInputData(sendStr, "szamount", temp, true, false);
					
					sendStr = AppeandFormInputData(sendStr, "szForceSettlement", "0", true, false);	
				}
				else if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReversal) {
					sendStr = AppeandFormInputData(sendStr, "szdesiredstatus", "DELETE", true, false);
				}
				
				HttpPostContent postContent = new HttpPostContent(sendStr, HttpContentType.CONTENT_TYPE_DEFAULT);
				HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);

				int statusCode = response.getStatusCode(); // Status code, 200==success, 400==bad request, etc. 
				String statusStr = response.getStatusText();
				String responseBody = response.getBody();
				
				System.out.println(responseBody);
				
				//
				// process the response from a CREDIT request
				//
				if (statusCode != 200 || responseBody.length() == 0) {
			    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
		    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
					ccTransaction.setMessage(statusStr);
				} else {
					String	SkipJackResponseErrorCode = "";
					
					String	SkipJackResponseStatusResponse = "";
					String	SkipJackResponseStatusResponseMessage = "";
					String 	SkipJackResponseAuditID = "";
					
				    String 	firstLine[]=new String [50];
				    String 	secondLine[]=new String [50];
				    String 	token;
				    StringTokenizer st=new StringTokenizer(responseBody,"\r\"", true);
				    int 	fieldCnt = 0;
				    int 	dataCnt = 0;
				    int 	quoteCnt = 0;
				    
				    Boolean onFieldList = true;
				    while (st.hasMoreTokens()) {
				    	token = st.nextToken();
				    	if (token.equals("\r")) {
				    		onFieldList = false;
				    	}
				    	if (token.equals("\r") == false && 
				    			token.equals("\n") == false && 
				    				token.equals(",") == false) {
				    		
				    		if (token.equals("\"") == false) {
						    	if (onFieldList) {
						    		firstLine[fieldCnt] =  token;
						    	} else {
						    		secondLine[dataCnt] = token;
						    	}
				    		} else {
						    	if ((++quoteCnt%2) == 0) {
						    		if (onFieldList) {
							    		++fieldCnt;
						    		} else {
							    		++dataCnt;
						    		}
						    	}
				    		}
				    	}
				    }
				    
				    if (fieldCnt > 0) {
					//	SkipJackResponseSerialNumber = firstLine[0];
						SkipJackResponseErrorCode = firstLine[1];
					//	SkipJackResponseNumberRecords = firstLine[2];
						
					//	SkipJackResponseStatusCode = secondLine[0];
					//	SkipJackResponseTransactionAmount = secondLine[1];
					//	SkipJackResponseDesiredStatus = secondLine[2];
						SkipJackResponseStatusResponse = secondLine[3];
						SkipJackResponseStatusResponseMessage = secondLine[4];
					//	SkipJackResponseOrderNumber = secondLine[5];
						SkipJackResponseAuditID = secondLine[6];			    
				    	
				    	// good request/response value
				    	if (SkipJackResponseErrorCode.contentEquals("0")) {
				    		// Successful submit
			    		
				    		if (SkipJackResponseStatusResponse.equals("SUCCESSFUL")) {
					    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsApproved);
								// the CREDIT transaction has NO approval code, so take the reference code
					    		ccTransaction.setApprovalCode(SkipJackResponseAuditID);
				    		} else {
					    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined);
				    		}
				    		
				    		ccTransaction.setMessage(SkipJackResponseStatusResponseMessage);
				    		ccTransaction.setReferenceNumber(SkipJackResponseAuditID);
				    	} else {
				    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
							ccTransaction.setMessage(SkipJackResponseErrorCode);
				    	}
				    	
				    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
				    }	
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			
			ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
			ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
			ccTransaction.setMessage(e.getLocalizedMessage());
		}
		return(ccTransaction);
	}
	
	public CreditCardTransactions skipJackAuthTransaction(DataService dataService, PreferencesAccounting preferencesAccounting, CreditCardTransactions ccTransaction) throws Exception {
		String sendStr = "";
		String temp = "";
		String temp2 = "";
		String street = "";
		String zip = "";
		
		int	amount;
		
		Calendar rightNow = Calendar.getInstance();
		
	//	URL url = new URL("https://developer.skipjackic.com/scripts/evolvcc.dll?AuthorizeAPI");
		URL url = new URL("https://www.skipjackic.com/scripts/evolvcc.dll?AuthorizeAPI");
		
		try {			
			if (!url.getProtocol().equals("https")) throw new ProtocolException("CreditCardService only supports HTTPS.");
			NetworkHelper.enableSSL();

	//		temp = preferencesAccounting.getSerialNumber();
	//		if (temp == null || temp.length() == 0)
	//			temp = "000111114451";
			sendStr = AppeandFormInputData(sendStr, "serialnumber", preferencesAccounting.getSerialNumber(), false, false);
			
	//		temp =preferencesAccounting.getDevelopmentNumber();
	//		if (temp == null || temp.length() == 0)
	//			temp = "666644442222";
			sendStr = AppeandFormInputData(sendStr, "developerserialnumber", preferencesAccounting.getDevelopmentNumber(), true, false);

			sendStr = AppeandFormInputData(sendStr, "shiptophone", "0000000000", true, true);
			sendStr = AppeandFormInputData(sendStr, "email", "transaction@skipjack.com", true, false);

			sendStr = AppeandFormInputData(sendStr, "sjname", ccTransaction.getCreditCard().getCardHolderName(), true, true);

			temp = EncryptionService.decryptData(ccTransaction.getCreditCard().getCardNumber(), "AES256WITHSERIALNUMBER");
			sendStr = AppeandFormInputData(sendStr, "accountnumber", temp, true, false);
			
			rightNow.setTime(ccTransaction.getCreditCard().getExpiresDate());
			temp = String.format("%02d", rightNow.get(Calendar.MONTH) + 1);
			sendStr = AppeandFormInputData(sendStr, "month", temp, true, false);
			
			temp = String.format("%02d", (rightNow.get(Calendar.YEAR) - 2000));
			sendStr = AppeandFormInputData(sendStr, "year", temp, true, false);
			

			amount = (int)(ccTransaction.getAmount() * 100);			// pennies
			if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeAdjustment)				// blind credit
				temp = String.format("%d", -amount);
			else
				temp = String.format("%d", amount);
			sendStr = AppeandFormInputData(sendStr, "transactionamount", temp, true, false);
			
			temp = "1.0";		//VersionService.getServerVersion();
			
			if (ccTransaction.getTransactionType() == Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeAdjustment)
				temp = String.format("1~Adjustment to Charge Amount (v%s)~%f~0~N~||", temp, ccTransaction.getAmount());
			else
				temp = String.format("1~Credit Card Payment (v%s)~%f~1~N~||", temp, ccTransaction.getAmount());
			sendStr = AppeandFormInputData(sendStr, "orderstring", temp, true, false);
			
			temp = CreateCreditCardTransactionID(dataService, 14, ccTransaction);
			sendStr = AppeandFormInputData(sendStr, "ordernumber", temp, true, false);
			ccTransaction.setOrderName(temp);
			
			temp = ccTransaction.getOrderNumber();
			if (temp.length() == 0)
				temp = "0";
			sendStr = AppeandFormInputData(sendStr, "invoicenumber", temp, true, true);
		
			//
			// If this transaction was manually approved, then fill in the approval code here.
			// This keeps Skipjack from getting a new code for the transaction.
			//
			if (ccTransaction.getManualCode().length() > 0) {
				sendStr = AppeandFormInputData(sendStr, "approvalcode", ccTransaction.getApprovalCode(), true, true);
			}
			
			if (ccTransaction.getCreditCard().getAddress1() != null) 
				street = ccTransaction.getCreditCard().getAddress1();
			if (ccTransaction.getCreditCard().getZipCode() != null)
				zip = ccTransaction.getCreditCard().getZipCode();
			
			// ensure the data is not empty, even after purge of spaces and dash
			street = street.replaceAll(" ", "");
			if (street.length() == 0)
				street = "123 Test Way";
			sendStr = AppeandFormInputData(sendStr, "streetaddress", street, true, true);
			sendStr = AppeandFormInputData(sendStr, "city", "None", true, true);
			sendStr = AppeandFormInputData(sendStr, "state", "XX", true, true);

			zip = zip.replaceAll(" ", "");
			zip = zip.replaceAll("-", "");
			if (zip.length() == 0)
				zip = "00000";		
			sendStr = AppeandFormInputData(sendStr, "zipcode", zip, true, true);
			
			if (ccTransaction.getContact() != null && ccTransaction.getContact().getContactId().length() > 0)
				temp = ccTransaction.getContact().getContactId();
			else
				temp = String.format("%d", ccTransaction.getId()); // order number not known use record number, have something for level II rate
			sendStr = AppeandFormInputData(sendStr, "customercode", temp, true, true);
			
			if (ccTransaction.getPoNumber().length() > 0)
				sendStr = AppeandFormInputData(sendStr, "purchaseordernumber", ccTransaction.getPoNumber(), true, true);
			else
				sendStr = AppeandFormInputData(sendStr, "purchaseordernumber", "A1234567890", true, true);		// fake number for Level II rates
			
			if (ccTransaction.getUserName().length() > 0)
				sendStr = AppeandFormInputData(sendStr, "comment", ccTransaction.getUserName(), true, true);
		
			// encrypt the number in the file or show as clear text (Track data contains the card number and name)
			if (ccTransaction.getHasCVVdata() == false) {			// if the track data is present, but CVV2 data is not hand entered into the same field
				temp = EncryptionService.decryptData(ccTransaction.getTrackOne(), "AES256WITHSERIALNUMBER");
				temp2 = EncryptionService.decryptData(ccTransaction.getTrackTwo(), "AES256WITHSERIALNUMBER");
				temp.concat(temp2);
				if (temp.length() > 0) {
					temp = temp.replaceAll("%", "");
					sendStr = AppeandFormInputData(sendStr, "trackdata", temp, true, false);
				}
			}

			if (ccTransaction.getTax() > 0) {
				temp = String.format("%d", ccTransaction.getTax() * 100);
			} else
				temp = "0";
			sendStr = AppeandFormInputData(sendStr, "customertax", temp, true, true);

			if (ccTransaction.getHasCVVdata() == true) {
				sendStr = AppeandFormInputData(sendStr, "CVV2", ccTransaction.getTempCVV2(), true, false);
			}

			System.out.println(sendStr);
			log.info(sendStr);
			
		//	temp = MessageUtil.serializeObject(sendStr).toString();
		//	System.out.println(temp);
			
			HttpPostContent postContent = new HttpPostContent(sendStr, HttpContentType.CONTENT_TYPE_DEFAULT);
			HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);

			int statusCode = response.getStatusCode(); // Status code, 200==success, 400==bad request, etc. 
			String statusStr = response.getStatusText();
			String responseBody = response.getBody();
			
			System.out.println(responseBody);
			
			if (statusCode != 200 || responseBody.length() == 0) {				
				ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
				ccTransaction.setMessage(statusStr);
		    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
			} else {
				String	SkipJackResponseAuthCode = "";
				String	SkipJackResponseReturnCode = "";
				String	SkipJackResponseDeclinedMessage = "";
				String	SkipJackResponseIsApproved = "";
				String	SkipJackResponseTransFileName = "";
				String	SkipJackResponseErrorCode = "";

				
			    String fieldTagName[]=new String [50];
			    String fieldTagAnswer[]=new String [50];
			    String token;
			    StringTokenizer st=new StringTokenizer(responseBody,"\r\"", true);
			    int fieldCnt = 0;
			    int dataCnt = 0;
			    int quoteCnt = 0;
			    
			    Boolean onFieldList = true;
			    while (st.hasMoreTokens()) {
			    	token = st.nextToken();
			    	if (token.equals("\r")) {
			    		onFieldList = false;
			    	}
			    	if (token.equals("\r") == false && 
			    			token.equals("\n") == false && 
			    				token.equals(",") == false) {
			    		
			    		if (token.equals("\"") == false) {
					    	if (onFieldList) {
					    		fieldTagName[fieldCnt] =  token;
					    	} else {
					    		fieldTagAnswer[dataCnt] = token;
					    	}
			    		} else {
					    	if ((++quoteCnt%2) == 0) {
					    		if (onFieldList) {
						    		++fieldCnt;
					    		} else {
						    		++dataCnt;
					    		}
					    	}
			    		}
			    	}
			    }
	
		//	    "AUTHCODE","szSerialNumber","szTransactionAmount","szAuthorizationDeclinedMessage","szAVSResponseCode","szAVSResponseMessage","szOrderNumber","szAuthorizationResponseCode","szIsApproved","szCVV2ResponseCode","szCVV2ResponseMessage","szReturnCode","szTransactionFileName","szCAVVResponseCode"
		//	    "TAS019","000111114451","2100","","N","Card authorized, no address or zip code match.","PS099810005813","TAS019","1","","","1","50000046116000.110",""
			    int idx = 0;
			    
			    if (fieldCnt > 0) {
			    	for (idx = 0; idx < fieldCnt; ++idx) {
			    		if (fieldTagName[idx].contentEquals("AUTHCODE"))
			    			SkipJackResponseAuthCode = fieldTagAnswer[idx];
			    //		if (fieldTagName[idx].contentEquals("szSerialNumber"))
			    //			SkipJackResponseSerialNumber = fieldTagAnswer[idx];
			    //		if (fieldTagName[idx].contentEquals("szTransactionAmount"))
			    //			SkipJackResponseTransactionAmount = fieldTagAnswer[idx];
			    //		if (fieldTagName[idx].contentEquals("szAuthorizationResponseCode"))
			    //			SkipJackResponseAuthResponseCode = fieldTagAnswer[idx];
			    		if (fieldTagName[idx].contentEquals("szReturnCode"))
			    			SkipJackResponseReturnCode = fieldTagAnswer[idx];
			    		if (fieldTagName[idx].contentEquals("szAuthorizationDeclinedMessage"))
			    			SkipJackResponseDeclinedMessage = fieldTagAnswer[idx];
			    	//	if (fieldTagName[idx].contentEquals("szAVSResponseCode"))
			    	//		SkipJackResponseAVSResponseCode = fieldTagAnswer[idx];
			    	//	if (fieldTagName[idx].contentEquals("szAVSResponseMessage"))
			    	//		SkipJackResponseAVSResponseMessage = fieldTagAnswer[idx];
			    	//	if (fieldTagName[idx].contentEquals("szOrderNumber"))
			    	//		SkipJackResponseOrderNumber = fieldTagAnswer[idx];
			    		if (fieldTagName[idx].contentEquals("szIsApproved"))
			    			SkipJackResponseIsApproved = fieldTagAnswer[idx];
			    	//	if (fieldTagName[idx].contentEquals("szCVV2ResponseCode"))
			    	//		SkipJackResponseCVV2ResponseCode = fieldTagAnswer[idx];
			    	//	if (fieldTagName[idx].contentEquals("szCVV2ResponseMessage"))
			    	//		SkipJackResponseCVV2ResponseMessage = fieldTagAnswer[idx];
			    		if (fieldTagName[idx].contentEquals("szTransactionFileName"))
			    			SkipJackResponseTransFileName = fieldTagAnswer[idx];
			    	//	if (fieldTagName[idx].contentEquals("szCAVVResponseCode"))
			    	//		SkipJackResponseCAVVResponseCode = fieldTagAnswer[idx];
			    		if (fieldTagName[idx].contentEquals("szReturnCode"))
			    			SkipJackResponseReturnCode = fieldTagAnswer[idx];
			    	//	if (fieldTagName[idx].contentEquals("szNumberRecords"))
			    	//		SkipJackResponseNumberRecords = fieldTagAnswer[idx];
			    	}
			    	
			    	// good request/response value
			    	if (SkipJackResponseReturnCode.contentEquals("1")) {
			    		// approved
			    		if (SkipJackResponseIsApproved.contentEquals("1")) {
							ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsApproved);
			    		
							ccTransaction.setApprovalCode(SkipJackResponseAuthCode);
							ccTransaction.setReferenceNumber(SkipJackResponseTransFileName);
			    		} 
			    		// declined
			    		else {
				    		ccTransaction.setMessage(SkipJackResponseDeclinedMessage);
				    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined);
			    		}
			    	} else {
			    		if (SkipJackResponseReturnCode.length() > 0)
			    			ccTransaction.setMessage(SkipJackResponseReturnCode);
			    		else
			    			ccTransaction.setMessage(SkipJackResponseErrorCode);
						ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined);
			    	}
			    	
					ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
			    }
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
    		
			ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
			ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
			ccTransaction.setMessage(e.getLocalizedMessage());
		}
		
		return ccTransaction;
	}
	
	//
	//
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//
	public CreditCardTransactions efsTransaction(DataService dataService, PreferencesAccounting preferencesAccounting, CreditCardTransactions ccTransaction) throws Exception {
		String sendStr = "";
		String temp = "";
		String temp2 = "";
		String street = "";
		String zip = "";
				
		Calendar rightNow = Calendar.getInstance();
		
		URL url = new URL("https://www.sagepayments.net/cgi-bin/eftbankcard.dll?transaction");
		
		try {			
			if (!url.getProtocol().equals("https")) throw new ProtocolException("CreditCardService only supports HTTPS.");
			NetworkHelper.enableSSL();

			temp = preferencesAccounting.getMerchantID();
			if (temp.length() == 0)
				temp = "1234";
			sendStr = AppeandFormInputData(sendStr, "M_id", temp, false, false);
			
			temp =preferencesAccounting.getMerchantKey();
			if (temp.length() == 0)
				temp = "abc";
			sendStr = AppeandFormInputData(sendStr, "M_key", temp, true, false);

			sendStr = AppeandFormInputData(sendStr, "C_name", ccTransaction.getCreditCard().getCardHolderName(), true, true);
			
			// Do not include the address or zip if Track data is valid
			//	Informed by (Robert Brown; rbrown@e-f-s.com) on 1/8/10
			//
			if (ccTransaction.getTrackDataUsed() == false) {
				
				if (ccTransaction.getCreditCard().getAddress1() != null) 
					street = ccTransaction.getCreditCard().getAddress1();
				if (ccTransaction.getCreditCard().getZipCode() != null)
					zip = ccTransaction.getCreditCard().getZipCode();
				
				// ensure the data is not empty, even after purge of spaces and dash
				street = street.replaceAll(" ", "");
				if (street.length() == 0)
					street = "123 Test Way";
				sendStr = AppeandFormInputData(sendStr, "C_address", street, true, true);
				sendStr = AppeandFormInputData(sendStr, "C_city", "None", true, true);
				sendStr = AppeandFormInputData(sendStr, "C_state", "XX", true, true);

				zip = zip.replaceAll(" ", "");
				zip = zip.replaceAll("-", "");
				if (zip.length() == 0)
					zip = "00000";		
				sendStr = AppeandFormInputData(sendStr, "C_zip", zip, true, true);
			}
			
			sendStr = AppeandFormInputData(sendStr, "C_email", "none@none.com", true, true);
			
			temp = EncryptionService.decryptData(ccTransaction.getCreditCard().getCardNumber(), "AES256WITHSERIALNUMBER");
			sendStr = AppeandFormInputData(sendStr, "C_cardnumber", temp, true, false);

			rightNow.setTime(ccTransaction.getCreditCard().getExpiresDate());
			temp = String.format("%02d", rightNow.get(Calendar.MONTH) + 1);
			temp2 = String.format("%02d", (rightNow.get(Calendar.YEAR) - 2000));
			temp.concat(temp2);
			sendStr = AppeandFormInputData(sendStr, "C_exp", temp, true, false);
			
			temp = String.format("%.2lf", ccTransaction.getAmount());
			sendStr = AppeandFormInputData(sendStr, "T_amt", temp, true, false);

			if (ccTransaction.getTransactionType() == 
				Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeCredit) {
				
				sendStr = AppeandFormInputData(sendStr, "T_code", "06", true, false);	// credit
				if (ccTransaction.getReferenceNumber().length() > 0)
					sendStr = AppeandFormInputData(sendStr, "T_reference", ccTransaction.getReferenceNumber(), true, false);

			} if (ccTransaction.getTransactionType() == 
				Constants.CREDIT_CARD_TRANSACTION_TYPE_kTransactionTypeReversal) {
				
				sendStr = AppeandFormInputData(sendStr, "T_code", "04", true, false);	// void
				if (ccTransaction.getReferenceNumber().length() > 0)
					sendStr = AppeandFormInputData(sendStr, "T_reference", ccTransaction.getReferenceNumber(), true, false);
				
			} else {
				sendStr = AppeandFormInputData(sendStr, "T_code", "01", true, false);	// Sale
			}
			
			temp = CreateCreditCardTransactionID(dataService, 14, ccTransaction);
			sendStr = AppeandFormInputData(sendStr, "T_ordernum", temp, true, false);
			ccTransaction.setOrderName(temp);

			//
			// If this transaction was manually approved, then fill in the approval code here.
			// This keeps EFS from getting a new code for the transaction.
			//
			if (ccTransaction.getManualCode().length() > 0 && ccTransaction.getApprovalCode().length() > 0) {
				sendStr = AppeandFormInputData(sendStr, "T_auth", ccTransaction.getApprovalCode(), true, true);
			}
					
			// could have track data when CVV2 not present
			//
			if (ccTransaction.getHasCVVdata() == false) {
				//
				// Track (2) is all they want in transaction
				//
				temp = EncryptionService.decryptData(ccTransaction.getTrackTwo(), "AES256WITHSERIALNUMBER");
				if (temp.length() > 0) {
					temp = temp.replaceAll("%", "");
					sendStr = AppeandFormInputData(sendStr, "T_trackdata", temp, true, false);
				}

			}

			if (ccTransaction.getTax() > 0) {
				temp = String.format("%.2lf", ccTransaction.getTax());
				sendStr = AppeandFormInputData(sendStr, "T_tax", temp, true, false);
			} else {
				sendStr = AppeandFormInputData(sendStr, "T_tax", "0.00", true, false);
			}
			

			if (ccTransaction.getHasCVVdata() == true) {
				temp = EncryptionService.decryptData(ccTransaction.getTempCVV2(), "AES256WITHSERIALNUMBER");
				sendStr = AppeandFormInputData(sendStr, "C_cvv", temp, true, false);
			}

			if (ccTransaction.getContact() != null && ccTransaction.getContact().getContactId().length() > 0)
				temp = ccTransaction.getContact().getContactId();
			else
				temp = ccTransaction.getOrderName();
			sendStr = AppeandFormInputData(sendStr, "T_customer_number", temp, true, false);
			
			System.out.println(sendStr);
			log.info(sendStr);
						
			HttpPostContent postContent = new HttpPostContent(sendStr, HttpContentType.CONTENT_TYPE_DEFAULT);
			HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);

			int statusCode = response.getStatusCode(); // Status code, 200==success, 400==bad request, etc. 
			String statusStr = response.getStatusText();
			String responseBody = response.getBody();
			
			System.out.println(responseBody);
			
			if (statusCode != 200 || responseBody.length() == 0) {				
				ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
				ccTransaction.setMessage(statusStr);
		    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
			} else {
				
				//
				// EFS resonse is one line of text with positional responses, not separators except for OrderNumber at the end
				// Position			Length				Description
				// 1				1					STX
				// 2				1					Approval Code
				// 3				6					Code approval or Error
				// 9				32					Messeage (approval or Error)
				// 41				2					Internal Use only
				// 43				1					CVV2 indicator
				// 44				1					AVS indicator
				// 45				2					Risk indicator
				// 47				10					Reference String (voids and credits)
				// 57				1					field separators (ascii 28)
				// 58				?					Order Number
				// ?				?					field separators (ascii 28)
				
				String		EFSResponseSTX = "";
				String		EFSResponseApprovalIndicator = "";
				String		EFSResponseCode = "";
				String		EFSResponseMessage = "";
				String		EFSResponseInternalUse = "";
				String		EFSResponseCVVindicator = "";
				String		EFSResponseAVSindicator = "";
				String		EFSResponseRISKindicator = "";
				String		EFSResponseReference = "";
				String		EFSResponseSeparator = "";
				String		EFSResponseOrderNumber = "";

				EFSResponseSTX = responseBody.substring(0, 1);
				EFSResponseApprovalIndicator = responseBody.substring(1, 2);
				EFSResponseCode = responseBody.substring(2, 8);
				EFSResponseMessage = responseBody.substring(8, 40);
				EFSResponseInternalUse = responseBody.substring(40, 42);
				EFSResponseCVVindicator = responseBody.substring(42, 43);
				EFSResponseAVSindicator = responseBody.substring(43, 44);
				EFSResponseRISKindicator = responseBody.substring(44, 46);
				EFSResponseReference = responseBody.substring(46, 56);
				EFSResponseSeparator = responseBody.substring(56, 57);
				EFSResponseOrderNumber = responseBody.substring(57, responseBody.length());
				
				if (EFSResponseSTX.equals("2") && EFSResponseOrderNumber.length() > 0) {
					
					// response approval codes
					// A = approved
					// E = front end error / Non approved
					// X = Gateway error / Non approved
					//
					if (EFSResponseApprovalIndicator.equals("A")) {
						ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsApproved);
					} else if (EFSResponseApprovalIndicator.equals("E")) {
			    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined);
					} else if (EFSResponseApprovalIndicator.equals("X")) {
			    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsDeclined);
					}
					
					ccTransaction.setApprovalCode(EFSResponseCode);
	    			ccTransaction.setMessage(EFSResponseMessage);
				
					//
					// CVV2 data match or not
					// M = Match
					// N = CVV no match
					// P = Not present
					// S = Merchant not present
					// U = issuer not certified
					//
	    			if (EFSResponseCVVindicator.equals("N")) {
	    				ccTransaction.setFailedAVS(true);
	    			} else {
	    				ccTransaction.setFailedAVS(false);		// match or not supplied
	    			}

					// AVS respone code.
					// X = Exact match
					// Y = Yes match on address and zip
					// A = address matchs, not zip
					// W = 9 digit zip matches, address does not
					// Z = 5 digit zip match, address does not
					// U = unavailable
					// R = retry
					// E = Error
					// S = service not supported
					//		
	    			if (EFSResponseAVSindicator.equals("N")) {
	    				ccTransaction.setFailedAVS(true);
	    			} else {
	    				ccTransaction.setFailedAVS(false);
	    			}
	    			if (EFSResponseAVSindicator.equals("A") || EFSResponseAVSindicator.equals("Z")) {
	    				// TODO
	    				//	cct.partialAVSmatch = 1;
	    			}
					
	    			// Risk indicators
					// 01 = Max sale exceeded
					// 02 = Min sale not met
					// 03 = 1 day volume exceeded
					// 04 = 1 day usage exceeded
					// 05 = 3 day volume exceeded
					// 06 = 3 day usage exceeded
					// 07 = 15 day volume exceeded
					// 08 = 15 day usage exceeded
					// 09 = 30 day volume exceeded
					// 10 = 30 day usage exceeded
					// 11 = stolen or lost card
					// 12 = AVS failure
					if (EFSResponseRISKindicator.equals("12")) {
						ccTransaction.setFailedAVS(true);
					}
					
					ccTransaction.setReferenceNumber(EFSResponseReference);
			    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
				} else {
	    			ccTransaction.setMessage(EFSResponseMessage);
		    		ccTransaction.setTransactionResults(Constants.CREDIT_CARD_TRANSACTION_RESULTS_kTransactionResultsError);
			    	ccTransaction.setTransactionStatus(Constants.CREDIT_CARD_TRANSACTION_STATUS_kTransactionStatusComplete);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ccTransaction;
	}
	
	
	//
	// clean any data from the transaction that CANNOT be permanently saved
	//
	private CreditCardTransactions SafeDeleteCriticalDataInTransaction(CreditCardTransactions ccTransaction) throws Exception {
		//
		// SAFE delete any field data that CANNOT keep around
		//
		ccTransaction.setTrackOne(EncryptionService.encryptData("0000000000000000000000000000000000000000000000000000000000000000", "AES256WITHSERIALNUMBER"));
		ccTransaction.setTrackTwo(EncryptionService.encryptData("0000000000000000000000000000000000000000000000000000000000000000", "AES256WITHSERIALNUMBER"));
		ccTransaction.setTempCVV2(EncryptionService.encryptData("0000", "AES256WITHSERIALNUMBER"));
		
		return(ccTransaction);
	}
	
}



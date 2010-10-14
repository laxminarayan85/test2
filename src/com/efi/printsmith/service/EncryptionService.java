package com.efi.printsmith.service;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeCost;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.ShippingCharge;
import com.efi.printsmith.data.SquareAreaCharge;
import com.efi.printsmith.data.enums.ChargeCostMethod;
import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.data.enums.PreferenceProgramType;
import com.efi.printsmith.data.CreditCardTransactions;
import com.efi.printsmith.data.CreditCard;

import com.efi.printsmith.pricing.charge.ChargeCostingPrices;
import com.efi.printsmith.pricing.charge.ChargeUtilities;
import com.mchange.lang.ByteUtils;

import java.security.NoSuchAlgorithmException;
import java.security.Key;
import java.security.Security;

import javassist.bytecode.ByteArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionService extends SnowmassHibernateService{
	protected static Logger log = Logger.getLogger(EncryptionService.class);

	/*
	 * The main public function to Encrypt data using a know style of key generation.	
	 * 
	 */
	static public String encryptData(String encryptionData, String encryptionStyle) throws Exception {
		DataService dataService = new DataService();
	//	String		temp;
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences == null) {
			preferences = new PreferencesSystem();
		}
		
		if (encryptionStyle.equalsIgnoreCase("AES256PASSWORD_A") ||
			encryptionStyle.equalsIgnoreCase("AES256STATIC_A") ||
			encryptionStyle.equalsIgnoreCase("AES256TEMPKEYWITHSERIALNUMBER") ||
			encryptionStyle.equalsIgnoreCase("AES256WITHSERIALNUMBER")) {
				
			encryptionData = Aes256BitEncryptData(getAes256KeySpec(encryptionStyle, dataService, preferences), encryptionData);
		
	//		temp = encryptionData;
	//		temp = Aes256BitDecryptData(getAes256KeySpec(encryptionStyle, dataService, preferences), temp);
		}
		
		return encryptionData;
	}
	/*
	 * The main public function to Decryption data using a know style of key generation.	
	 * 
	 */	
	static public String decryptData(String encryptionData, String encryptionStyle) throws Exception {
		DataService dataService = new DataService();
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences == null) {
			preferences = new PreferencesSystem();
		}
		
		if (encryptionStyle.equalsIgnoreCase("AES256PASSWORD_A") ||
				encryptionStyle.equalsIgnoreCase("AES256STATIC_A") ||
				encryptionStyle.equalsIgnoreCase("AES256WITHSERIALNUMBER")) {		
				
			encryptionData = Aes256BitDecryptData(getAes256KeySpec(encryptionStyle, dataService, preferences), encryptionData);
		}
		return encryptionData.trim();		// remove empty bytes at the end
	}

	/*
	 * A specific version that will handle the whole credit card transaction at one time
	 * 
	 */
	static public CreditCardTransactions encryptCCT(CreditCardTransactions cct) throws Exception {
		DataService dataService = new DataService();
		String		temp;
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences == null) {
			preferences = new PreferencesSystem();
		}
		
		temp = Aes256BitEncryptData(getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences), cct.getCreditCard().getCardNumber());
		cct.getCreditCard().setCardNumber(temp);
		
		temp = Aes256BitEncryptData(getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences), cct.getTrackOne());
		cct.setTrackOne(temp);
		
		temp = Aes256BitEncryptData(getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences), cct.getTrackTwo());
		cct.setTrackTwo(temp);
		
		temp = Aes256BitEncryptData(getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences), cct.getTempCVV2());
		cct.setTempCVV2(temp);
		
		return cct;
	}
	/*
	 * A specific version that will handle the whole credit card transaction at one time
	 * 
	 */	
	static public CreditCardTransactions decryptCCT(CreditCardTransactions cct) throws Exception {
		DataService dataService = new DataService();
		String		temp;
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences == null) {
			preferences = new PreferencesSystem();
		}
		
		temp = Aes256BitDecryptData(getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences), cct.getCreditCard().getCardNumber());
		cct.getCreditCard().setCardNumber(temp.trim());		// remove empty bytes at the end
		
		temp = Aes256BitDecryptData(getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences), cct.getTrackOne());
		cct.setTrackOne(temp.trim());		// remove empty bytes at the end
		
		temp = Aes256BitDecryptData(getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences), cct.getTrackTwo());
		cct.setTrackTwo(temp.trim());		// remove empty bytes at the end
		
		temp = Aes256BitDecryptData(getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences), cct.getTempCVV2());
		cct.setTempCVV2(temp.trim());		// remove empty bytes at the end
		
		return cct;		// remove empty bytes at the end
	}

	
	// 
	// external function to generate a new key and encrypt that key for storage
	//
	public String generateNewKey(String encryptionStyle) throws Exception {
		String	newKeyString = null;
		
		newKeyString = localNewKey(encryptionStyle);
		
		// encrypt and convert to HEX
		// turns a 32 byte (256 bits) into 64 bytes.
		if (encryptionStyle.equalsIgnoreCase("AES256")) {
			newKeyString = Aes256BitEncryptData(getAes256KeySpec("AES256STATIC_A", null, null), newKeyString);
		}
		
		return newKeyString;
	}
	//
	// =============================== private from here down =====================================
	//

	//
	// this generates the keys for the encryption functions, the type of key is passed in.
	// several static and dynamic keys can be generated.
	// Keys are return in there native format for consumption by AES cipher calls.
	//
	private static SecretKeySpec getAes256KeySpec(String encryptionStyle, DataService dataService, PreferencesSystem preferences) throws Exception {
		SecretKeySpec	spec;
		byte 			[]newKey;
		long 			serialNumber;
		int				countKeyParts = 0;
		String			savedKeyData = null;
		String			savedKeyDataPart;
		//
		// static key for other keys to be encrypted
		//
		byte[] mystaticKey = new byte[]{(byte)0x3D, (byte)0x60, (byte)0xEB, (byte)0x10, (byte)0x15, (byte)0xCA, (byte)0x71, (byte)0xBE,
				(byte)0x2B, (byte)0x73, (byte)0xAE, (byte)0xF0, (byte)0x85, (byte)0x7D, (byte)0x77, (byte)0x81,
			    		0x1F,0x35,0x2C,0x07,0x3B,0x61,0x08,(byte)0xD7,
			    		0x2D,(byte)0x98,0x10,(byte)0xA3,0x09,0x14,(byte)0xDF,(byte)0xF4};
		
		// static key for passwords	
		byte[] passwordKey = new byte[]{(byte)0x2D, (byte)0x09, (byte)0x1F, (byte)0x7D, (byte)0x77, (byte)0xCA, (byte)0xBE, (byte)0xF0,
				(byte)0x2B, (byte)0x73, (byte)0xAE, (byte)0xF0, (byte)0x85, (byte)0x7D, (byte)0x77, (byte)0x81,
			    		0x1F,0x35,0x2C,0x07,0x3B,0x61,0x08,(byte)0xD7,
			    		0x1A,(byte)0xA1,0x10,(byte)0xA2,0x08,0x15,(byte)0xDF,(byte)0xF5};
	// key after overlay
	//	byte[] mystaticKey = new byte[]{(byte)0x73, (byte)0x28, (byte)0x6E, (byte)0x42, (byte)0x7D, (byte)0x27, (byte)0x5E, (byte)0x7E,
	//			(byte)0x2D, (byte)0x37, (byte)0x33, (byte)0x4A, (byte)0x2B, (byte)0x6F, (byte)0x77, (byte)0x2F,
	//		    		0x3B,0x5D,0x5B,0x4E,0x2D,0x77,0x6F,(byte)0x4F,
	//		    		0x30,(byte)0x20,0x67,(byte)0x77,0x6B,0x57,(byte)0x3E,(byte)0x26};
	
	//	byte[] savedKey = new byte[]{(byte)0x73, (byte)0x28, (byte)0x6E, (byte)0x40, (byte)0x74, (byte)0x26, (byte)0x58, (byte)0x7E,
	//			(byte)0x2D, (byte)0x37, (byte)0x33, (byte)0x48, (byte)0x2A, (byte)0x6E, (byte)0x77, (byte)0x2B,
	//		    		0x3B,0x5D,0x5B,0x4E,0x25,0x76,0x6F,(byte)0x4F,
	//		    		0x30,(byte)0x20,0x67,(byte)0x75,0x6B,0x50,(byte)0x3C,(byte)0x24};
		
		//
		// built in password key, always the same for this type
		//
		if (encryptionStyle.equalsIgnoreCase("AES256PASSWORD_A")) {
			newKey = passwordKey.clone();
		
		//
		// The built in static key, this is for reading/writing other keys to the database
		//
		} else if (encryptionStyle.equalsIgnoreCase("AES256STATIC_A")) {
			newKey = mystaticKey.clone();
		
		//
		// normal operations using the saved key, which itself is stored as encrypted hex
		//	
		} else if (encryptionStyle.equalsIgnoreCase("AES256WITHSERIALNUMBER")) {
			// read from saved key
			//
			if (preferences != null) {
				if ((savedKeyDataPart = preferences.getConfig()) != null) {
					if (savedKeyDataPart.length() > 0)
						++countKeyParts;
					savedKeyData = savedKeyDataPart;
				}
				if ((savedKeyDataPart = preferences.getProcess()) != null) {
					if (savedKeyDataPart.length() > 0)
						++countKeyParts;
					savedKeyData = savedKeyData.concat(savedKeyDataPart);
				}
				
				if ((savedKeyDataPart = preferences.getSlogan()) != null) {
					if (savedKeyDataPart.length() > 0)
						++countKeyParts;
					savedKeyData = savedKeyData.concat(savedKeyDataPart);
				}
				
				if ((savedKeyDataPart = preferences.getSettings()) != null) {
					if (savedKeyDataPart.length() > 0)
						++countKeyParts;
					savedKeyData = savedKeyData.concat(savedKeyDataPart);
				}				
			}
			
			// must have all four parts to make a valid encyption key
			// if not valid, then create a new key and store in the preference system
			//
			if (countKeyParts < 4) {
				savedKeyData = localNewKey("AES256");
				
				// encrypt and convert to HEX
				// turns a 32 byte (256 bits) into 64 bytes.
				savedKeyDataPart = Aes256BitEncryptData(getAes256KeySpec("AES256STATIC_A", null, null), savedKeyData);

				if (dataService != null) {
					preferences.setConfig(savedKeyDataPart.substring(0, 16));
					preferences.setProcess(savedKeyDataPart.substring(16, 32));
					preferences.setSlogan(savedKeyDataPart.substring(32, 48));
					preferences.setSettings(savedKeyDataPart.substring(48, 64));
					dataService.addUpdate(preferences);
				}
			} else {
			
				//
				// saved key is also encrypted, using the static key
				//
				savedKeyData = Aes256BitDecryptData(getAes256KeySpec("AES256STATIC_A", null, null), savedKeyData);
			}
			
			if (preferences != null) {
				serialNumber = preferences.getSerialNumber();
			} else
				serialNumber = 9999;
			
			newKey = OverlaySerialNumberOntoKeyPhrase( savedKeyData.getBytes(), serialNumber);
		//
		// the key must be in the process of updating, get the TEMP key
		//
		} if (encryptionStyle.equalsIgnoreCase("AES256TEMPKEYWITHSERIALNUMBER")) {
			
			// Read the stored key from the preference system.
			// (THIS VERSION WORKS ON THE TEMP KEY, NOT THE MAIN USE KEY)
			//
			if (preferences != null) {
				if ((savedKeyDataPart = preferences.getOconfig()) != null) {
					if (savedKeyDataPart.length() > 0)
						++countKeyParts;
					savedKeyData = savedKeyDataPart;
				}
				if ((savedKeyDataPart = preferences.getOprocess()) != null) {
					if (savedKeyDataPart.length() > 0)
						++countKeyParts;
					savedKeyData = savedKeyData.concat(savedKeyDataPart);
				}
				
				if ((savedKeyDataPart = preferences.getOslogan()) != null) {
					if (savedKeyDataPart.length() > 0)
						++countKeyParts;
					savedKeyData = savedKeyData.concat(savedKeyDataPart);
				}
				
				if ((savedKeyDataPart = preferences.getOsettings()) != null) {
					if (savedKeyDataPart.length() > 0)
						++countKeyParts;
					savedKeyData = savedKeyData.concat(savedKeyDataPart);
				}				
			}
			// must have all four parts to make a valid encyption key
			// if not valid, then create a new key and store in the preference system
			// (THIS VERSION WORKS ON THE TEMP KEY, NOT THE MAIN USE KEY)
			//
			if (countKeyParts < 4) {
				savedKeyData = localNewKey("AES256");
				
				// encrypt and convert to HEX
				// turns a 32 byte (256 bits) into 64 bytes.
				savedKeyDataPart = Aes256BitEncryptData(getAes256KeySpec("AES256STATIC_A", null, null), savedKeyData);

				if (dataService != null) {
					preferences.setOconfig(savedKeyDataPart.substring(0, 16));
					preferences.setOprocess(savedKeyDataPart.substring(16, 32));
					preferences.setOslogan(savedKeyDataPart.substring(32, 48));
					preferences.setOsettings(savedKeyDataPart.substring(48, 64));
					dataService.addUpdate(preferences);
				}
			} else {
			
				//
				// saved key is also encrypted, using the static key
				//
				savedKeyData = Aes256BitDecryptData(getAes256KeySpec("AES256STATIC_A", null, null), savedKeyData);
			}
			
			if (preferences != null) {
				serialNumber = preferences.getSerialNumber();
			} else
				serialNumber = 9999;
			
			newKey = OverlaySerialNumberOntoKeyPhrase( savedKeyData.getBytes(), serialNumber);
		} else {
			newKey = mystaticKey.clone();
		}
				
	    spec = new SecretKeySpec(newKey,"AES");
	    return spec;
	}
	
	//
	// local function which performs the JAVA cipher calls to handle encryption
	//
	//
	private static String Aes256BitEncryptData(SecretKeySpec spec, String value) throws Exception {
		int newlength = value.length();
		int originallength = newlength;
		byte [] inputBytes;
		//
		// the style of AES used here is very specific, otherwise the classic data will not decrypt properly
		//
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");		//AES/ECB/NoPadding
		cipher.init(Cipher.ENCRYPT_MODE, spec);
		
		if ((newlength % 16) != 0) {
			newlength = (newlength / 16) + 16;		// even increments 
		}
		
		if (newlength != originallength) {
			inputBytes = new byte[newlength];
			byte[] stringInBytes = value.getBytes();
			int	i;
			for (i = 0; i < originallength; ++i) {
				inputBytes[i] = stringInBytes[i];
			}
		} else {
			inputBytes = value.getBytes();
		}
		
		byte [] rawEncryptedData = cipher.doFinal(inputBytes);// do all the work here
		String hexString = asHex (rawEncryptedData);			// convert raw bytes into HEX string
		return hexString;
	}
	//
	// local function which performs the JAVA cipher calls to handle decryption
	//
	//
	private static String Aes256BitDecryptData(SecretKeySpec spec, String value) throws Exception {
		byte	localBytes[];
		String	originalString;
		
		//
		// the style of AES used here is very specific, otherwise the classic data will not decrypt properly
		//
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");		//AES/ECB/NoPadding
        cipher.init(Cipher.DECRYPT_MODE, spec);
        
        byte [] rawEncryptedData = hexToBytes(value.getBytes());	// convert HEX to byte array
        
        localBytes = cipher.doFinal(rawEncryptedData);		// do all the work here
        
        originalString = new String(localBytes);			// convert from byte array into a string

		return originalString;
	}

	//
	// OverlaySerialNumberOntoKeyPhrase - mask the encryption key with a overlay from the serial number.
	//										makes all installs of PrintSmith unique key.
	//
	private static byte[] OverlaySerialNumberOntoKeyPhrase( byte []inputKey, long serialNumber)
	{
		int				i,k;
		byte			[]formattedSerialNumber;
		byte 			[]encyptKey;
		
		// get the unique printsmith install number
		serialNumber = (serialNumber * 3);
		formattedSerialNumber = String.format("%08d", serialNumber).getBytes();

		encyptKey = inputKey.clone();
		
		// merge the key and serial number to create a site specific key
		for (i = 0; i < 4; ++i) {
			for (k = 0; k < 8; ++k) {
				// use ever other byte as a mask.
				// the mask is only the low order (4) bits, not the whole byte.
				//
				encyptKey[(i*8)+k] = (byte) (encyptKey[(i*8)+k] | ((formattedSerialNumber[k] & 0x0F)));
				
			}
		}
		return encyptKey;
	} /* OverlaySerialNumberOntoKeyPhrase */

	
	/**
	 * Turns array of bytes into string
	 *
	 * @param buf	Array of bytes to convert to hex string
	 * @return	Generated hex string
	 */
	 private static String asHex (byte buf[]) {
		  StringBuffer strbuf = new StringBuffer(buf.length * 2);
		  int i;
		
		  for (i = 0; i < buf.length; i++) {
		   if (((int) buf[i] & 0xff) < 0x10)
		    strbuf.append("0");
		
		   strbuf.append(Long.toString((int) buf[i] & 0xff, 16).toUpperCase());
		  }
		
		  return strbuf.toString();
	 }
	 
	 //
	 // turn hex bytes into a byte array, which in turn is a string
	 //
	  private static byte[] hexToBytes(byte[] hex) {
	    int length = hex.length / 2;
	    byte[] raw = new byte[length];
	    for (int i = 0; i < length; i++) {
	      int high = Character.digit(hex[i * 2], 16);
	      int low = Character.digit(hex[i * 2 + 1], 16);
	      int value = (high << 4) | low;
	      if (value > 127)
	        value -= 256;
	      raw[i] = (byte) value;
	    }
	    return raw;
	  }
	    
	    // generate a new key for AES 256, the key will be in HEX and be encrypted using a static key
		// return value:  256bit (32 bytes) that have been turned into HEX, for a total of (64) bytes.
		//
		private static String localNewKey(String encryptionStyle) throws Exception {
			String	newKeyString = null;
			
			if (encryptionStyle.equalsIgnoreCase("AES256")) {
				KeyGenerator kgen = KeyGenerator.getInstance("AES");
				kgen.init(256);

				// Generate the secret key specs.
				SecretKey skey = kgen.generateKey();
				byte[] raw = skey.getEncoded();
				newKeyString = new String(raw);
			} 
			
			return newKeyString;
		}
		
		@SuppressWarnings("unchecked")
		public int UpdateAllRecordsToNewKey() throws Exception {
			int					results = 0;
			DataService 		dataService = new DataService();
			SecretKeySpec 		newKey;
			SecretKeySpec 		origKey;			
			String				localData;
			PreferencesSystem 	preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
			CreditCard			tempCC;
			List<CreditCard> 	ccRec = new ArrayList<CreditCard>();
			
			if (preferences == null) {
				preferences = new PreferencesSystem();
			}
			
			// get the current key
			//
			origKey = getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences);
			
			// force a new key
			preferences.setConfig("");
			preferences.setSlogan("");
			preferences.setSettings("");
			preferences.setProcess("");
			newKey = getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences);

			// read in array of credit card records
			ccRec = (List<CreditCard>)dataService.getAll("CreditCard");
			
			//
			// read, decrypt and encrypt all credit card records
			//
			for (int i=0;i<ccRec.size();i++) {
				tempCC = ccRec.get(i);	
				localData = Aes256BitDecryptData(origKey, tempCC.getCardNumber());
				tempCC.setCardNumber(Aes256BitEncryptData(newKey, localData));
				dataService.addUpdate(tempCC);
			}
			
			results = ccRec.size();
			return(results);
		}
		
		@SuppressWarnings("unchecked")
		public int PurgeEncryptedDataFields() throws Exception {
			int					results = 0;
			int 				i;
			DataService 		dataService = new DataService();
			SecretKeySpec 		origKey;			
			String				localData;
			PreferencesSystem 	preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
			CreditCard			tempCC;
			CreditCardTransactions	tempCCT;
			List<CreditCard> 	ccRec = new ArrayList<CreditCard>();
			List<CreditCardTransactions> 	cct = new ArrayList<CreditCardTransactions>();
			
			if (preferences == null) {
				preferences = new PreferencesSystem();
			}
			
			// get the current key
			//
			origKey = getAes256KeySpec("AES256WITHSERIALNUMBER", dataService, preferences);
			
			// read in array of credit card records
			ccRec = (List<CreditCard>)dataService.getAll("CreditCard");
			
			//
			// read, encrypt bogus data for all credit card records
			//
			for (i=0;i<ccRec.size();i++) {
				tempCC = ccRec.get(i);	
				if (tempCC.getPermanent() == null || tempCC.getPermanent() == false) {		// not a card on file
					localData = "0000000000000000";
					localData = Aes256BitEncryptData(origKey, localData);
					tempCC.setCardNumber(localData);
					dataService.addUpdate(tempCC);
				}
			}
			
			results = ccRec.size();
			ccRec.clear();				// release memory
			
			// read in array of credit card records
			cct = (List<CreditCardTransactions>)dataService.getAll("CreditCardTransactions");
			
			//
			// read, encrypt bogus data for all credit card transaction records
			// This should not be needed, as the data is removed after use, but done here
			//	for a matter of completeness.
			//
			for (i=0;i<cct.size();i++) {
				tempCCT = cct.get(i);	
				// test for permanent state
				localData = "0000000000000000";
				localData = Aes256BitEncryptData(origKey, localData);
				tempCCT.setTrackOne(localData);
				tempCCT.setTrackTwo(localData);
				tempCCT.setTempCVV2(localData);
				dataService.addUpdate(tempCCT);
			}
			
			results += cct.size();
			return(results);
		}
}



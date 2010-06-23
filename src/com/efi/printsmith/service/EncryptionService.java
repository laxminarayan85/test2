package com.efi.printsmith.service;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeCost;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.CuttingCharge;
import com.efi.printsmith.data.InkCharge;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.ShippingCharge;
import com.efi.printsmith.data.SquareAreaCharge;
import com.efi.printsmith.data.enums.ChargeCostMethod;
import com.efi.printsmith.data.enums.ChargeMethod;
import com.efi.printsmith.data.enums.PreferenceProgramType;
import com.efi.printsmith.pricing.charge.ChargeCostingPrices;
import com.efi.printsmith.pricing.charge.ChargeUtilities;

import java.security.NoSuchAlgorithmException;
import java.security.Key;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionService extends SnowmassHibernateService{
	protected static Logger log = Logger.getLogger(EncryptionService.class);

	public String encryptData(String encryptionData, String encryptionStyle) throws Exception {
		DataService dataService = new DataService();
		String		temp;
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences != null){
			if (preferences.getProgramType().equals(PreferenceProgramType.CopyShop)) {
				// For illustration purposes
			}
			
			if ((encryptionData = preferences.getCCEncryptionData()) != null) {
				// For illustration purposes
				
			}
		}
		
		encryptionData = Aes256BitEncryptData(getKeySpec(encryptionStyle, preferences), encryptionData);
		temp = encryptionData;
		temp = Aes256BitDecryptData(getKeySpec(encryptionStyle, preferences), temp);
		
		return encryptionData;
	}
	
	public String decryptData(String encryptionData, String encryptionStyle) throws Exception {
		DataService dataService = new DataService();
		
		PreferencesSystem preferences = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		
		if (preferences != null){
			if (preferences.getProgramType().equals(PreferenceProgramType.CopyShop)) {
				// For illustration purposes
			}
			
			if ((encryptionData = preferences.getCCEncryptionData()) != null) {
				// For illustration purposes
				
			}
		}
		
		encryptionData = Aes256BitDecryptData(getKeySpec(encryptionStyle, preferences), encryptionData);
		
		return encryptionData;
	}
	

	private static SecretKeySpec getKeySpec(String encryptionStyle, PreferencesSystem preferences) throws Exception {
		SecretKeySpec	spec;
		byte 			[]newKey;
		int 			serialNumber;
	//	byte[] b = new byte[4];
		
	//	byte[] mystaticKey = new byte[]{(byte)0x3D, (byte)0x60, (byte)0xEB, (byte)0x10, (byte)0x15, (byte)0xCA, (byte)0x71, (byte)0xBE,
	//			(byte)0x2B, (byte)0x73, (byte)0xAE, (byte)0xF0, (byte)0x85, (byte)0x7D, (byte)0x77, (byte)0x81,
	//		    		0x1F,0x35,0x2C,0x07,0x3B,0x61,0x08,(byte)0xD7,
	//		    		0x2D,(byte)0x98,0x10,(byte)0xA3,0x09,0x14,(byte)0xDF,(byte)0xF4};
		byte[] mystaticKey = new byte[]{(byte)0x73, (byte)0x28, (byte)0x6E, (byte)0x42, (byte)0x7D, (byte)0x27, (byte)0x5E, (byte)0x7E,
				(byte)0x2D, (byte)0x37, (byte)0x33, (byte)0x4A, (byte)0x2B, (byte)0x6F, (byte)0x77, (byte)0x2F,
			    		0x3B,0x5D,0x5B,0x4E,0x2D,0x77,0x6F,(byte)0x4F,
			    		0x30,(byte)0x20,0x67,(byte)0x77,0x6B,0x57,(byte)0x3E,(byte)0x26};
						
	    //byte[] mystaticKey = new byte []{(byte)0x3D,(byte)0x60,(byte)0xEB,(byte)0x10,(byte)0x15,(byte)0xCA,(byte)0x71,(byte)0xBE};
	    
	    //		0x2B,0x73,0xAE,0xF0,0x85,0x7D,0x77,0x81,
	    //		0x1F,0x35,0x2C,0x07,0x3B,0x61,0x08,0xD7,
	    //		0x2D,0x98,0x10,0xA3,0x09,0x14,0xDF,0xF4};
	    
		if (preferences != null) {
			//	int serialNumber = Integer.getInteger(preferences.getSerialNumber()).intValue();
		} else
			serialNumber = 0;
		
		if (encryptionStyle.equalsIgnoreCase("AES256WITHSERIALNUMBER")) {
			serialNumber = 9922;	//•• TEMP
			newKey = OverlaySerialNumberOntoKeyPhrase( mystaticKey, serialNumber);
		} else
			newKey = mystaticKey.clone();
		
	    spec = new SecretKeySpec(newKey,"AES");
	    return spec;
	}
	
	private static String Aes256BitEncryptData(SecretKeySpec spec, String value) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, spec);
		
		byte [] inputBytes = value.getBytes();
		byte [] rawEncryptedData = cipher.doFinal(inputBytes);
		String hexString = asHex (rawEncryptedData);
		return hexString;
	}
	
	private static String Aes256BitDecryptData(SecretKeySpec spec, String value) throws Exception {
		byte	localBytes[];
		String	originalString;
		
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, spec);
        
        byte [] rawEncryptedData = hexToBytes(value.getBytes());
        
        localBytes = cipher.doFinal(rawEncryptedData);		//
        
        originalString = new String(localBytes);

		return originalString;
	}

	//
	// OverlaySerialNumberOntoKeyPhrase - mask the encryption key with a overlay from the serial number.
	//										makes all installs of PrintSmith unique key.
	//
	private static byte[] OverlaySerialNumberOntoKeyPhrase( byte []inputKey, int serialNumber)
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
		
		   strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		  }
		
		  return strbuf.toString();
	 }
	 
	// private static String getHexString(byte[] b) throws Exception {
	//	  String result = "";
	//	  for (int i=0; i < b.length; i++) {
	//	    result +=
	//	          Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	//	  }
	//	  return result;
	//	}
	 
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
}



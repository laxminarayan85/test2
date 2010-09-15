package com.efi.printsmith.service;

import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CreditCardTransactions;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.network.Base64;
import com.efi.printsmith.network.HttpContentType;
import com.efi.printsmith.network.HttpPostContent;
import com.efi.printsmith.network.HttpResponse;
import com.efi.printsmith.network.MessageUtil;
import com.efi.printsmith.network.NetworkHelper;

public class CreditCardService extends SnowmassHibernateService {
	private Logger log = Logger.getLogger(CreditCardService.class);

	public CreditCardService() {
		super();
	}
	
	public Long sendCardTransaction(Long id) throws Exception {
		String sendStr = "abcdefg"; //TODO
		DataService dataService = new DataService();
		URL url = new URL("https://www.efi.com");
		
		try {
			CreditCardTransactions ccTransaction = (CreditCardTransactions)dataService.getById("CreditCardTransactions", id);
			
			if (!url.getProtocol().equals("https")) throw new ProtocolException("CreditCardService only supports HTTPS.");
			NetworkHelper.enableSSL();
			
			System.out.println(sendStr);
			log.info(sendStr);
			HttpPostContent postContent = new HttpPostContent(MessageUtil.serializeObject(sendStr).toString(), HttpContentType.CONTENT_TYPE_MULTIPART_RELATED);
			HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);

			int statusCode = response.getStatusCode(); // Status code, 200==success, 400==bad request, etc. 
			String statusStr = response.getStatusText();
			String responseBody = response.getBody();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
}

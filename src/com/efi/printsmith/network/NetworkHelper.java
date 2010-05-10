package com.efi.printsmith.network;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Security;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;


public class NetworkHelper {	
	static private Logger log = Logger.getLogger(NetworkHelper.class);
	
	private static BASE64Decoder DECODER = new BASE64Decoder();

	static public final int SUN_CLIENT = 0;

	static public final int APACHE_CLIENT = 1;

	public static final String AUTH_HEADER = "Authorization";
	public static final String PROXY_AUTH_HEADER = "Proxy-Authorization";
	public static final String PROXY_HOST_PROPERTY = "http.proxyHost";
	public static final String PROXY_PORT_PROPERTY = "http.proxyPort";
	
	private static String PROXY_USERNAME_PASSWORD = null;

	static {
		enableSSL();
		setProxyUsernamePassword();
	}

	private static void setProxyUsernamePassword() {
		String proxyAuth = System.getProperty(PROXY_AUTH_HEADER);
		if (proxyAuth != null) {
			// JDK 1.3 must be supported for installer
			int indexOfSpace = proxyAuth.indexOf(" ");
			if (indexOfSpace != -1 && proxyAuth.length() > indexOfSpace)
			{
				String encodedUsernamePassword = proxyAuth.substring(indexOfSpace + 1);
				try {
					PROXY_USERNAME_PASSWORD = new String(DECODER.decodeBuffer(encodedUsernamePassword));
				} catch (IOException e) {
					log.error("Error decoding " + PROXY_AUTH_HEADER + ". Proxy authorization will not be supplied.");
				}
			} else {
				log.error("Error parsing " + PROXY_AUTH_HEADER + ". Proxy authorization will not be supplied.");
			}
		}
	}

	public static String extractXmlContentForPost(InputStream in) {
		StringBuffer sbuf = null;
		String result = null;
		try {
			byte[] buf = new byte[1024 * 4];
			int readIn = 0;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((readIn = in.read(buf, 0, buf.length)) > 0) {
				baos.write(buf, 0, readIn);
			}
			result = new String(baos.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException io) {
				// ignore io here
			}
		}
		return result;
	}

	public static void enableSSL() {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		System.setProperty("java.protocol.handler.pkgs",
				"com.sun.net.ssl.internal.www.protocol");
	}

	public static HttpResponse httpGet(String urlS) throws Exception {
		return httpGet(urlS, HttpCredentials.NULL_CREDENTIALS,
				HttpTimeouts.DEFAULT_TIMEOUTS);
	}

	public static HttpResponse httpGet(String urlS, HttpTimeouts timeouts)
			throws Exception {
		return httpGet(urlS, HttpCredentials.NULL_CREDENTIALS, timeouts);
	}

	public static HttpResponse httpGet(String urlS, HttpCredentials credentials)
			throws Exception {
		return httpGet(urlS, credentials, HttpTimeouts.DEFAULT_TIMEOUTS);
	}

	public static HttpResponse httpGet(String urlS,
			HttpCredentials credentials, HttpTimeouts timeouts)
			throws Exception {
		HttpResponse response = null;
		GetMethod method = null;

		try {
			URL urlObj = new URL(urlS);

			HttpClient client = new HttpClient();

			client.getHostConfiguration().setHost(urlObj.getHost(),
					urlObj.getPort(), urlObj.getProtocol());
			method = new GetMethod();
			NetworkHelper.setApacheTimeouts(timeouts, client);
			NetworkHelper.setApacheProxyInfo(client, method);
			NetworkHelper.setApacheCredentials(credentials, method);
			method.setPath(URIUtil.getPath(urlS));
			method.setQueryString(URIUtil.getQuery(urlS));
			method.setHttp11(true);
			method.setStrictMode(false);
			method.setRequestHeader("Content-Type", "text/xml; charset=\"utf-8\"");

			int resultCode = client.executeMethod(method);
			log.info("HttpClient GET response code: " + resultCode);

			response = new HttpResponse(method);
		} finally {
			if (method != null)
				method.releaseConnection();
		}

		return response;
	}

	public static HttpResponse httpPost(String content, String url,
			OutputStream os) throws Exception {
		return httpPost(new HttpPostContent(content, "application/vnd.cip4-jmf+xml"), url, os,
				HttpCredentials.NULL_CREDENTIALS, HttpTimeouts.DEFAULT_TIMEOUTS);
	}
	
	public static HttpResponse httpPost(HttpPostContent content, String url,
			OutputStream os) throws Exception {
		return httpPost(content, url, os,
				HttpCredentials.NULL_CREDENTIALS, HttpTimeouts.DEFAULT_TIMEOUTS);
	}

	public static HttpResponse httpPost(HttpPostContent content, String url,
			OutputStream os, HttpCredentials credentials, HttpTimeouts timeouts)
			throws Exception {
		int client = (Boolean
				.getBoolean("com.printcafe.common.network.useSunVersion")) ? SUN_CLIENT
				: APACHE_CLIENT;
		return httpPost(content, url, os, credentials, timeouts, client);
	}

	/**
	 * @deprecated Don't pass the client indicator unless absolutely required;
	 *             use
	 */
	public static HttpResponse httpPost(HttpPostContent content, String url,
			OutputStream os, HttpCredentials credentials,
			HttpTimeouts timeouts, int client) throws Exception {
		switch (client) {
		case APACHE_CLIENT:
			return internalPostApache(content, url, os, credentials, timeouts);
		case SUN_CLIENT:
			return internalPostSun(content, url, os, credentials, timeouts);
		}
		throw new Exception("Unknown client type");
	}

	// PRIVATE methods

	/**
	 * Perform an HTTP post.
	 * 
	 * @param is
	 *            The data to be writen out via the post
	 * @param contentLength
	 *            The length of the content specified by is. If -1 is passed
	 *            then the content length will not be set in the request
	 *            headers.
	 * @param urlS
	 *            The url to POST
	 * @param os
	 *            If this is set to null then the respose's body is returned via
	 *            the HttpResponse object, otherwise, the response's body will
	 *            be writen to os
	 * @param user
	 *            A user name to use for authentication if it is required. If
	 *            user is null then authentication won't be attempted.
	 * @param password
	 *            A password to use for authentication if it is required.
	 * @param timeout
	 *            The number of seconds to wait for a response. A value of 0
	 *            means block indefinately.
	 * @throws Exception
	 */
	private static HttpResponse internalPostApache(HttpPostContent content,
			String urlS, OutputStream os, HttpCredentials credentials,
			HttpTimeouts timeouts) throws Exception {
		HttpResponse response = null;
		PostMethod method = null;

		try {
			URL urlObj = new URL(urlS);
			
			HttpClient client = new HttpClient();

			client.getHostConfiguration().setHost(urlObj.getHost(),
					urlObj.getPort(), urlObj.getProtocol());
			method = new PostMethod(urlS);
			NetworkHelper.setApacheTimeouts(timeouts, client);
			NetworkHelper.setApacheProxyInfo(client, method);
			NetworkHelper.setApacheCredentials(credentials, method);
			method.setDoAuthentication(false);
			method.setPath(URIUtil.getPath(urlS));
			method.setQueryString(URIUtil.getQuery(urlS));
//			method.setStrictMode(true);
			method.setHttp11(false);

			method.setRequestHeader("Content-type", content.getType());

			if (content.getLength() >= 0) {
				method.setRequestContentLength(content.getLength());
			}

			method.setRequestBody(content.getInputStream());

			int resultCode = client.executeMethod(method);
			log.info("HttpClient POST response code: " + resultCode);

			if (os != null) {
				// Could probably be optimized a bit
				InputStream is = new BufferedInputStream(method
						.getResponseBodyAsStream());
				for (int c = is.read(); c != -1; c = is.read()) {
					os.write(c);
				}
				os.flush();
			}

			response = new HttpResponse(method, (os == null));
		} finally {
			try {
				if (content.getInputStream() != null)
					content.getInputStream().close();
			} catch (Exception ex) {
				// ignore any error here
			}
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
				// ignore any error here
			}
			if (method != null)
				method.releaseConnection();
		}

		return response;
	}
	
	/**
	 * @deprecated The Apache httpclient should be used instead, for better
	 *             control of timeouts.
	 */
	private static HttpResponse internalPostSun(HttpPostContent content,
			String urlS, OutputStream os, HttpCredentials credentials,
			HttpTimeouts timeouts) throws Exception {
		HttpResponse response = null;
		OutputStream requestOutput = null;
		BufferedReader responseReader = null;

		try {
			URL url = new URL(urlS);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			NetworkHelper.setSunProxyInfo(conn);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-Length", "" + content.getLength());
			conn.setRequestProperty("Content-Type", content.getType());
			NetworkHelper.setSunCredentials(credentials, conn);

			requestOutput = conn.getOutputStream();

			byte[] buffer = new byte[1024];

			InputStream is = content.getInputStream();
			for (int l = is.read(buffer); l != -1; l = is.read(buffer)) {
				requestOutput.write(buffer, 0, l);
			}

			requestOutput.flush();
			requestOutput.close();

			if (os != null) {
				InputStream bufferedIn = new BufferedInputStream(conn
						.getInputStream());
				for (int c = bufferedIn.read(); c != -1; c = bufferedIn.read()) {
					os.write(c);
				}
				os.flush();
			}

			response = new HttpResponse(conn, (os == null));

		} finally {
			try {
				if (requestOutput != null)
					requestOutput.close();
			} catch (Exception e) {
				// ignore any error here
			}
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
				// ignore any error here
			}
			try {
				if (responseReader != null)
					responseReader.close();
			} catch (Exception e) {
				// ignore any error here
			}
		}

		return response;
	}
	
	private static void setApacheTimeouts(HttpTimeouts timeouts, HttpClient client) {
		if (timeouts != null) {
			client.setTimeout((int) timeouts.getReadTimeoutMillis());
			client.setConnectionTimeout((int) timeouts
					.getConnectTimeoutMillis());
		}
	}
	
	private static void setApacheCredentials(HttpCredentials credentials, HttpMethod method) {
		if (credentials.headerString() != null) {
			method.setRequestHeader(AUTH_HEADER, credentials
					.headerString());
		}
	}
	
	private static void setApacheProxyInfo(HttpClient client, HttpMethod method) {
		String proxyHost = System.getProperty(PROXY_HOST_PROPERTY);
		if ((proxyHost != null) && (proxyHost.length() > 0)) {
			int proxyPort = Integer.getInteger(PROXY_PORT_PROPERTY).intValue();
			client.getHostConfiguration().setProxy(proxyHost, proxyPort);			
			if (PROXY_USERNAME_PASSWORD != null) {
				UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(PROXY_USERNAME_PASSWORD);
				client.getState().setProxyCredentials(null, proxyHost, credentials);
			}
		}
	}
	
	private static void setSunCredentials(HttpCredentials credentials, HttpURLConnection conn) {
		if (credentials.headerString() != null) {
			conn.setRequestProperty("Authorization", credentials
					.headerString());
		}
	}

	private static void setSunProxyInfo(HttpURLConnection conn) {
		// Proxy is enabled by setting the System properites
		// http.proxyHost and http.proxyPort
		
		String authHeaderValue = System.getProperty(PROXY_AUTH_HEADER);

		if (authHeaderValue != null) {
			conn.setRequestProperty(PROXY_AUTH_HEADER, authHeaderValue);
		}
	}
}

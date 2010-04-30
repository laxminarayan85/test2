package com.efi.printsmith.network;

public interface HttpContentType {

	public static final String CONTENT_TYPE_MULTIPART_RELATED = System
			.getProperty("com.efi.printsmith.network.contentType.multipartRelated",
					"multipart/related");

	public static final String CONTENT_TYPE_DEFAULT = System.getProperty(
			"com.efi.printsmith.network.contentType.default", "plain/text");

	public static final String CONTENT_TYPE_JDF = System.getProperty(
			"com.efi.printsmith.network.contentType.jdf",
			"application/vnd.cip4-jdf+xml");

	public static final String CONTENT_TYPE_JMF = System.getProperty(
			"com.efi.printsmith.network.contentType.jmf",
			"application/vnd.cip4-jmf+xml");

	public static final String CONTENT_TYPE_DEFAULT_XML = System.getProperty(
			"com.efi.printsmith.network.contentType.xml", "application/xml");

}

package com.efi.printsmith.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Content for an HTTP post, to help encapsulate different ways of instantiating - from streams, etc. - and also
 * to incorporate other critical post properties, like Content-type and Content-length.
 */
public class HttpPostContent {
    /**
     * Creates post content from a String, automatically determining content type from the String content.
     */
    public HttpPostContent(String content) {
        this(content, HttpContentType.CONTENT_TYPE_DEFAULT_XML);
    }

    /**
     * Creates post content with a predetermined content type
     */
    public HttpPostContent(String content, String contentType) {
        this(new ByteArrayInputStream(content.getBytes()), content.length(), contentType);
    }

    public HttpPostContent(InputStream is, int contentLength, String contentType) {
        this.inputStream = is;
        this.length = contentLength;
        this.type = contentType;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public int getLength() {
        return this.length;
    }

    public String getType() {
        return this.type;
    }

    private InputStream inputStream;
    private int length = 0;
    private String type;
}

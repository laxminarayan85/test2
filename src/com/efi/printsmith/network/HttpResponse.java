package com.efi.printsmith.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.Enumeration;
import java.util.Vector;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.StatusLine;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;


public class HttpResponse
{
  private Logger log = Logger.getLogger(HttpResponse.class);
  private int _statusCode = -1;
  private StatusLine _statusLine = null;
  private String _statusText = null;
  
  private String _body = null;

  private Header[] _headers = null;

  public HttpResponse(HttpMethod method)
  {
    this(method,true);
  }

  public HttpResponse(HttpMethod method, boolean setBody)
  {
    _statusCode = method.getStatusCode();
    _statusLine = method.getStatusLine();
    _statusText = method.getStatusText();
    _headers = method.getResponseHeaders();

    if (setBody) {
		try {
			setBody(method.getResponseBodyAsStream());
		} catch (IOException e) {
		    log.error("I/O failure reading response body", e);
		    _body = null;
		}
	}
  }

private void setBody(InputStream bodyAsStream) throws IOException {
	if (bodyAsStream != null) {
		ByteArrayOutputStream outstream = new ByteArrayOutputStream(4*1024);
		byte[] buffer = new byte[4096];
		int len;
		while ((len = bodyAsStream.read(buffer)) > 0) {
			outstream.write(buffer, 0, len);
		}
		outstream.close();
		_body = new String(outstream.toByteArray());
	}
}

  public HttpResponse(HttpURLConnection conn, boolean setBody)
      throws IOException
  {
    _statusCode = conn.getResponseCode();
    if (_statusCode == -1)
        _statusCode = HttpURLConnection.HTTP_OK; // Assume the best
    _statusText = conn.getResponseMessage();

    Vector headerVect = new Vector();
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      String key = conn.getHeaderFieldKey(i);
      if (key == null)
        break;
      String value = conn.getHeaderField(key);
      headerVect.addElement(new Header(key,value));
    }

    if (headerVect.size() > 0) {
      _headers = new Header[headerVect.size()];
      headerVect.copyInto(_headers);
    }

    if (setBody) {
      Reader responseReader = new InputStreamReader(conn.getInputStream());
      StringWriter writer = new StringWriter();

      char[] buffer = new char[1024];

      for (int l = responseReader.read(buffer); l != -1; l = responseReader.read(buffer)) {
        writer.write(buffer,0,l);
      }
      writer.flush();
      writer.close();

      _body = writer.toString();
    }
  }
  /**
   *
   * @return The headers set by the server.
   *
   * @see org.apache.commons.httpclient.Header
   */
  public Header[] getHeaders()
  {
    return _headers;
  }

  public Enumeration getHeaderNames()
  {
    if (_headers != null) {
      Vector names = new Vector();
      for (int i = 0; i < _headers.length; i++) {
        names.add(_headers[i].getName());
      }
      return names.elements();
    }
    return null;
  }

  public String getHeaderValue(String keyname)
  {
    if(_headers != null) {
      for(int i=0; i < _headers.length; i++) {
        if(_headers[i].getName().equals(keyname)) {
          return _headers[i].getValue();
        }
      }
    }

    return null;
  }

  public int getStatusCode()
  {
    return _statusCode;
  }

  /**
   *
   * @return The status line set by the server.
   *
   * @see org.apache.commons.httpclient.StatusLine
   */
  public StatusLine getStatusLine()
  {
    return _statusLine;
  }

  public String getStatusText()
  {
    return _statusText;
  }

  public String getBody()
  {
    return _body;
  }

  public String toString()
  {
    StringBuffer buf = new StringBuffer(200);
    buf.append("HttpResponse: status=");
    buf.append(_statusCode);
    buf.append(" status text=");
    buf.append(_statusText);

    return buf.toString();
  }

}

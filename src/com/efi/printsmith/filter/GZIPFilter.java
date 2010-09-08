/*
* Copyright 2003 Jayson Falkner (jayson@jspinsider.com)
* This code is from "Servlets and JavaServer pages; the J2EE Web Tier",
* http://www.jspbook.com. You may freely use the code both commercially
* and non-commercially. If you like the code, please pick up a copy of
* the book and help support the authors, development of more free code,
* and the JSP/Servlet/J2EE community.
*/
package com.efi.printsmith.filter;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


public class GZIPFilter implements Filter
{

  private ServletContext servletContext;

  public void destroy() {}

  public void doFilter(ServletRequest req, ServletResponse res,
    FilterChain chain) throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(true);
    String gzip = request.getParameter("gzip");
    String ae = request.getHeader("accept-encoding");
    if ((ae != null) && (ae.indexOf("gzip") != -1))
    {	
      GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);
      chain.doFilter(req, wrappedResponse);
      wrappedResponse.finishResponse();
    }
    else
    {
      chain.doFilter(req, res);
    }

  }

  public void init(FilterConfig config) throws ServletException
  {
    servletContext = config.getServletContext();
  }

}

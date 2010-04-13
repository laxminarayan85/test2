package com.efi.printsmith.integration;

import java.io.IOException;
	 
	import javax.servlet.Servlet;
	import javax.servlet.ServletException;

	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	 
	import org.apache.log4j.Logger;

	public class IntegrationServlet extends HttpServlet implements Servlet {
		private static final long serialVersionUID = 1L;

		protected static Logger log = Logger.getLogger(IntegrationServlet.class);
	 
		public void init() throws ServletException {
		}
	 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//			String realPath = request.getSession().getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"integration"+File.separator;
	 
		}
	 
	}
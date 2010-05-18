package com.efi.printsmith.integration.xpedx;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.efi.printsmith.integration.xpedx.xsd.*;

import org.apache.log4j.Logger;

public class XpedxIntegrationServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected static Logger log = Logger.getLogger(XpedxIntegrationServlet.class);

	@Override
	public void init() throws ServletException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request != null) {
			System.out.println(request);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request != null) {
			System.out.println(request);
		}
	}
}
package com.efi.printsmith.integration.dsf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DSFIntegrationServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected static Logger log = Logger.getLogger(DSFIntegrationServlet.class);

	public void init() throws ServletException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request != null) {
			System.out.println(request);
		}
	}
}
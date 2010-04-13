package com.efi.printsmith.integration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


	public class IntegrationServletListener implements ServletContextListener {

		protected static Logger log = Logger.getLogger(IntegrationServlet.class);

		public void contextInitialized(ServletContextEvent arg0) {
			log.info("Integration Servlet Listener is initialized....");
		}

		public void contextDestroyed(ServletContextEvent arg0) {
			log.info("Integration Servlet Listener is destroyed....");
		}
}


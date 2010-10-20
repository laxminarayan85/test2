package com.efi.printsmith.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.efi.printsmith.properties.PropertiesHelper;
import com.efi.printsmith.service.repository.InvoiceRepository;
import com.efi.printsmith.service.repository.ReportRepository;
import com.inet.report.Engine;
import com.inet.report.ReportException;
import com.inet.report.ReportProperties;

public class ReportService extends SnowmassHibernateService {
	
	protected static Logger log = Logger.getLogger(ReportService.class);
	private static File repository = null;
	
	public File generateReport(String reportName, String parameter) throws ReportException, IOException {
		try {
			Engine engine = new Engine(Engine.EXPORT_PDF);
			ReportRepository reportRepository = new ReportRepository();
			File reportFile = reportRepository.getFile(reportName);
			URL reportURL = reportFile.toURL();
			engine.setReportFile(reportURL);
			engine.execute();
			File exportedFile = File.createTempFile("snowmassReport", ".pdf");
			FileOutputStream fos = new FileOutputStream(exportedFile);
			for (int i = 1; i <= engine.getPageCount(); i++) {
				fos.write(engine.getPageData(i));
			}
			fos.close();
			return exportedFile;
		} catch (ReportException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}
	
	public File generateInvoice(String reportName, String parameter) throws ReportException, IOException {
		try {
			Engine engine = new Engine(Engine.EXPORT_PDF);
			InvoiceRepository invoiceRepository = new InvoiceRepository();
			File reportFile = invoiceRepository.getFile(reportName);
			URL reportURL = reportFile.toURL();
			engine.setReportFile(reportURL);
			if (parameter != null) {
				engine.setPrompt("InvoiceId",  parameter);
			}
			engine.execute();
			File exportedFile = File.createTempFile("snowmassReport", ".pdf");
			FileOutputStream fos = new FileOutputStream(exportedFile);
			for (int i = 1; i <= engine.getPageCount(); i++) {
				fos.write(engine.getPageData(i));
			}
			fos.close();
			return exportedFile;
		} catch (ReportException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}
	
	public File generateJobTicket(String reportName, String parameter) throws ReportException, IOException {
		try {
			Engine engine = new Engine(Engine.EXPORT_PDF);
			ReportRepository reportRepository = new ReportRepository();
			File reportFile = reportRepository.getFile(reportName);
			URL reportURL = reportFile.toURL();
			engine.setReportFile(reportURL);
			if (parameter != null) {
				engine.setPrompt("JobID",  parameter);
			}
			engine.execute();
			File exportedFile = File.createTempFile("snowmassReport", ".pdf");
			FileOutputStream fos = new FileOutputStream(exportedFile);
			for (int i = 1; i <= engine.getPageCount(); i++) {
				fos.write(engine.getPageData(i));
			}
			fos.close();
			return exportedFile;
		} catch (ReportException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

}

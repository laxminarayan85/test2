package com.efi.printsmith.service.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.efi.printsmith.properties.PropertiesHelper;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.service.RepositoryService;
import com.efi.printsmith.service.SnowmassHibernateService;
import com.efi.printsmith.utilities.FileIOServlet;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

public class InvoiceRepository extends RepositoryService {

	public InvoiceRepository() {
		defaultRepositoryName = "../invoiceRepository";
		repositoryPropertyName = "com.efi.printsmith.invoiceTemplateRepository";
	}	
}
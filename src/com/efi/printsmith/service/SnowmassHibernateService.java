package com.efi.printsmith.service;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

public class SnowmassHibernateService extends HibernateService {
	public Object load(Class clazz, long id) {
		Session session = null;
		Object result;

		try {
			session = DataService.getSession();
			long tStart = new Date().getTime();
			result = session.get(clazz, id);
			long tEnd = new Date().getTime();
		} catch (HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			ex.printStackTrace();
			throw ex;
		} catch (RuntimeException ex) {
			HibernateUtil.rollbackTransaction();
			ex.printStackTrace();
			throw ex;
		} finally {
			session.close();
		}

		return result;
	}
}

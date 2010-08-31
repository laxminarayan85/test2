package com.efi.printsmith.service;

import com.efi.printsmith.data.*;
import com.efi.printsmith.defaultdata.*;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.lang.String;
import java.lang.reflect.Field;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;

import com.efi.printsmith.messaging.MessageServiceAdapter;
import com.efi.printsmith.messaging.MessageTypes;
import com.efi.printsmith.properties.PropertiesHelper;
import com.efi.printsmith.query.RemoteCriterion;
import com.efi.printsmith.query.RemoteRestriction;
import com.efi.printsmith.data.ProductionLocations;

public class DataService extends HibernateService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(DataService.class);

	protected static EntityManagerFactory entityManagerFactory = null;

	protected static EntityManager sharedEntityManager = null;

	public DataService() {
		super();
		try {
			if (entityManagerFactory == null) {
				entityManagerFactory = Persistence
						.createEntityManagerFactory(PERSISTENCE_UNIT);

				boolean needToLoadStaticData = checkStaticData();

				if (needToLoadStaticData == true) {
					try {
						// LoadStaticData(new String[]{new
						// DefaultDataFactory().getClass().getResource(
						// "DefaultDataFactory.class").getPath()});
						DefaultDataFactory df = new DefaultDataFactory();
						df.LoadDefaultData(this);
					} catch (Exception e) {
						log.error("** Exception: " + e.getMessage());
						System.out.println("Exception caught when creating DataService");
						System.out.println(e.getMessage());
					}
				}
			}
		} catch (PersistenceException e) {
			log.error(e);
			log.error(e.getCause().getMessage());
			System.out.println("Exception caught when creating DataService");
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getMessage());
		} catch (Exception e) {
			log.error(e);
			System.out.println("Exception caught when creating DataService");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private boolean checkStaticData() {
		log.debug("** checkStaticData called.");
		boolean retVal = false;
		List<DataManager> dataManagerList = (List<DataManager>) this
				.getAll("DataManager");

		log.debug("** Found " + dataManagerList.size() + "records:");

		if (dataManagerList.size() > 0) {
			DataManager dataManager = dataManagerList.get(0);
			if (dataManager.getDataloaded() == false) {
				dataManager.setDataloaded(true);
				try {
					this.addUpdate(dataManager);
				} catch (Exception e) {
					log.debug("** Exception: " + e.getMessage());
				}
				retVal = true;
			}
		} else {
			DataManager dataManager = new DataManager();
			dataManager.setDataloaded(true);
			try {
				this.addUpdate(dataManager);
			} catch (Exception e) {
				log.debug("** Exception: " + e.getMessage());
			}
			retVal = true;
		}
		return retVal;
	}

	public List<?> getAll(String className) {
		log.debug("** getAll called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findAllQuery = em.createQuery("from " + className
					+ " fetch all properties order by id");
			resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return resultList;
	}
	public List<?>getUsers(String className) {
		log.debug("** getUsers called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findAllQuery = em.createQuery("from " + className
					+ " where showusernamelog = 'TRUE' ");
			resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return resultList;
	}
	public List<?> getCurrentTaxTables(String className) {
		log.debug("** getAll called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findAllQuery = em.createQuery("from " + className
					+ " where taxTableIsCurrent = 'TRUE' ");
			resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return resultList;
	}
	public List<?> getAllOrdeBy(String className, String orderBy) {
		log.debug("** getAll called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findAllQuery = em.createQuery("from " + className
					+ " fetch all properties order by " + orderBy);
			resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return resultList;
	}
	
	public List<?> getAllOrderByDecsending(String className, String orderBy) {
		log.debug("** getAll called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findAllQuery = em.createQuery("from " + className
					+ " fetch all properties order by " + orderBy + " desc");
			resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return resultList;
	}

	public List<?> getAllNameIDOnly(String className) throws Exception {
		log.debug("** getAllNameIDOnly.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			String queryString = "select new " + className
					+ "( a.id, a.name) from " + className + " a";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	public List<?> getStockPicker(String className,
			List<PreferencesStockDefinition> Columns) throws Exception {
		log.debug("** getStockPicker.");
		System.out.println(System.currentTimeMillis());
		EntityManager em = entityManagerFactory.createEntityManager();

		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();

		columnstring = "a.id, a.name, a.weight, a.parentsize, a.color, a.genericColor, a.finish, a.thickness, a.grade, "
				+ "a.cwt1, a.vendor, a.stocknumber, a.onHand, a.committed, a.onOrder, a.shellItem, a.normalRunSize, "
				+ "a.stktype, a.stkgroup, a.coated, a.minorder, a.cost1, a.priceExpires, a.forestManagement, "
				+ "a.pcwRecycledPercent, a.fscCertified, a.sfiCertified, a.greenSealCertified, a.sheetsPerSet, a.uom  ";
		try {
			String queryString = "select new " + className + "( "
					+ columnstring + ") from " + className + " a ";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
			System.out.println(System.currentTimeMillis());
		}
		return null;
	}

	public List<?> getAccountPicker(String className) throws Exception {
		log.debug("** getAccountPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();

		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();

		columnstring = "a.id, a.title, a.accountId, a.externalRef, a.masterAcct, a.prospect, a.externalAcctId, a.contact ";
		try {
			String queryString = "select new " + className + "( "
					+ columnstring + ") from " + className + " a order by title";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			if (resultList != null){
				for (int i=0; i<resultList.size(); i++){
					Contact c = ((Account) (resultList.get(i))).getContact();
					Hibernate.initialize(c.getComLinks());
				}
			}
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
		
	@SuppressWarnings("unchecked")
	public List<?> getTracker(String className) throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<ModelBase> resultList = new ArrayList<ModelBase>();
		List<ModelBase> invoiceList = new ArrayList<ModelBase>();
		String columnstring = new String();

		columnstring = "a.id, a.invoiceNumber";
		try {

			String queryString = "select new Invoice" + "( " + columnstring
					+ ") from Invoice a where a.onPendingList = 'TRUE'";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			for (int i = 0; i < resultList.size(); i++) {
				Invoice listItem = (Invoice) resultList.get(i);
				Invoice invoice = (Invoice) this.getById("Invoice",
						((ModelBase) listItem).getId());
				Invoice resultInvoice = new Invoice(invoice.getId(), invoice
						.getInvoiceNumber(), invoice.getAccount(), invoice
						.getContact(), invoice.getName(), invoice
						.getGrandTotal().doubleValue(), invoice.getOrderedDate(), invoice
						.getWantedDate(), invoice.getProofDate());
				invoiceList.add(resultInvoice);
			}

			if (invoiceList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return invoiceList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<JobBase> getPendingIntegratedJobs() throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<InvoiceBase> resultList = new ArrayList<InvoiceBase>();
		List<JobBase> retVal = new ArrayList<JobBase>();
		String columnstring = new String();

		try {
			String queryString = "select a from Invoice a inner join a.jobs where a.onPendingList = 'TRUE'";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();

//			for (int i = 0; i < resultList.size(); i++) {
//				InvoiceBase invoice = resultList.get(i);
//
//				for (int j = 0; j < invoice.getJobs().size(); j++) {
//					Job job = invoice.getJobs().get(j);
//
//					if (job == null) {
//						log.error("Null job found in invoice");
//					} else {
//						// if (job.getPricingCopier() != null &&
//						// job.getPricingCopier().getOemDeviceID() != null &&
//						// job.getPricingCopier().getOemDeviceID().length() > 0)
//						// {
//						job.setParentInvoice(invoice);
//						retVal.add(job);
//						// }
//					}
//				}
//			}
//
//			Session session = (Session) em.getDelegate();
//			List<JobBase> jobs = null;
//			jobs = session.createCriteria(JobBase.class).list();
//			Iterator<JobBase> it = jobs.iterator();
//			 List <JobBase> retVal = new ArrayList<JobBase>();
						
			 // TODO: Following code is just plain atrocious - let's get it wrapped into the query above instead of hacking at it like a dead moose
			Iterator<InvoiceBase> it = resultList.iterator();
			while (it.hasNext()) {
				InvoiceBase invoice = it.next();
				List<JobBase> jobs = null;
				jobs = invoice.getJobs();
				
				Iterator<JobBase> jobIt = jobs.iterator();
				while (jobIt.hasNext()) {
					JobBase job = jobIt.next();
					if (job.getPricingCopier() != null &&
							job.getPricingCopier().getOemDeviceID() != null &&
							job.getPricingCopier().getOemDeviceID().length() > 0) {
						job.setParentInvoice(invoice);
						Iterator assetIt = job.getDigitalAssets().iterator();
						while (assetIt.hasNext()) {
							if (assetIt.next() == null) {
								log.error("Null digital asset found");
							}
						}
						retVal.add(job);
					}
				}
			}
			return retVal;
		} catch (Exception e) {
			log.error(e);
			throw e;
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<?> getPending() throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Session session = (Session) em.getDelegate();
			List<InvoiceBase> invoices = null;
			invoices = session.createCriteria(Invoice.class).add(
					Restrictions.eq("onPendingList", true)).list();
			List<Estimate> estimates = session.createCriteria(Estimate.class)
					.add(Restrictions.eq("onPendingList", true)).list();
			invoices.addAll(estimates);

			// for (int i = 0; i < invoices.size(); i++) {
			// InvoiceBase invoice = invoices.get(i);
			//
			// for (int j = 0; j < invoice.getJobs().size(); j++) {
			// Job job = invoice.getJobs().get(j);
			//
			// if (job == null) {
			// log.error("Null job found in invoice");
			// }
			// }
			// }
			return invoices;
		} catch (Exception e) {
			log.error(e);
			throw e;
		} finally {
			em.close();
		}
	}

	public List<?> getContactPicker(String className) throws Exception {
		log.debug("** getContactPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Object> resultList = new ArrayList<Object>();
		String columnstring = new String();

		columnstring = "a.id, a.firstName, a.lastName, a.contactId, a.parentAccount ";
		try {
			//String queryString = "select new " + className + "( "
			//		+ columnstring + ") from " + className + " a";
			String queryString = " from " + className;
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			
			if (resultList != null){
				for (int i=0; i<resultList.size(); i++)	{
					Contact c = (Contact) (resultList.get(i));
					Hibernate.initialize(c.getComLinks());									 
				}
			} 
			 
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public List<?> getPressPicker(String className) throws Exception {
		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();
		log.debug("** getPressPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();

		columnstring = "a.id, a.name, a.machineID, a.machineName";
		try {
			String queryString = "select new " + className + "( "
					+ columnstring + ") from " + className + " a" + " order by a.id";
			Query query = em.createQuery(queryString);
			resultList = query.getResultList();
			
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public List<?> getCopierPicker(String className) throws Exception {
		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();

		log.debug("** getCopierPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();

		columnstring = "a.id, a.name, a.copyID, a.machineName, a.blackwhite, a.color, a.largeFormat";
		try {
			String queryString = "select new " + className + "( "
					+ columnstring + ") from " + className + " a";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getSingle(String className) {
		log.debug("** getSingle called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query findQuery = em.createQuery("from " + className);
			ModelBase result = (ModelBase) findQuery.getSingleResult();
			for (Field field : result.getClass().getDeclaredFields()) {
				if(field.getType().getName().equals("java.util.List") || field.getType().getName().equals("java.util.ArrayList")) {
					String propertyName = field.getName().substring(0,1).toUpperCase()+field.getName().substring(1,field.getName().length());
					try {
						Hibernate.initialize(result.getProperty(propertyName));
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			return result;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getQuery(String className, String where) {
		log.debug("** getQuery called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query findQuery = em.createQuery("from " + className + where);
			ModelBase result = (ModelBase) findQuery.getSingleResult();
			return result;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public List<?> getAllQuery(String className, String where) {
		log.debug("** getQuery called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findQuery = em.createQuery("from " + className + where);
			resultList = findQuery.getResultList();
			return resultList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getByPrevId(String className, String prevId) {
		log.debug("** getByPrevId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where prevId = '"
					+ prevId + "'";
			Query query = em.createQuery(queryString);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	

	public StockDefinition getByStockId(String stockId) {
		log.debug("** getByStockId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockDefinition where stockId = '"
					+ stockId + "'";
			Query query = em.createQuery(queryString);
			StockDefinition object = (StockDefinition) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	public StockDefinition getByStockNumber(String stockNumber) {
		log.debug("** getByStockNumber called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockDefinition where stocknumber = '"
					+ stockNumber + "'";
			Query query = em.createQuery(queryString);
			StockDefinition object = (StockDefinition) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public StockType getByStockTypeID(String stocktypeId) {
		log.debug("** getByStocktypeId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockType where viewableID = '"
					+ stocktypeId + "'";
			Query query = em.createQuery(queryString);
			StockType object = (StockType) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public PressDefinition getByPressId(String pressId) {
		log.debug("** getByPressId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from PressDefinition where pressId = '"
					+ pressId + "'";
			Query query = em.createQuery(queryString);
			PressDefinition object = (PressDefinition) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public Account getByAccountId(String accountId) {
		log.debug("** getByAccountId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Account where accountId = '" + accountId
					+ "'";
			Query query = em.createQuery(queryString);
			Account object = (Account) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	public AccountHistoryData getAccountHistoryByAccountId(Long Id) {
		log.debug("** AccountHistoryData called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		
			String queryString = "select a from AccountHistoryData a where a.account.id = :id";
			Query query = em.createQuery(queryString);
			query.setParameter("id", Id);
			AccountHistoryData object = (AccountHistoryData) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	public UnpurchasedMerchandise getUnPurchaseByAccountId(Long Id) {
		log.debug("** getBypurchasesAccountId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		
			String queryString = "select a from UnpurchasedMerchandise a where a.account.id = :id";
			Query query = em.createQuery(queryString);
			query.setParameter("id", Id);
			UnpurchasedMerchandise object = (UnpurchasedMerchandise) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getByName(String className, String name) {
		log.debug("** getByName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where name = '" + name
					+ "'";
			Query query = em.createQuery(queryString);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getByLastFirstName(String className, String namelast,
			String namefirst, long id) {
		log.debug("** getByName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where lastName = '"
					+ namelast + "' and " + "firstName = '" + namefirst
					+ "' and " + "parentaccount_id = '" + id + "'";
			Query query = em.createQuery(queryString);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public List<?> getFromParent(String className, String parentName, Long id)
			throws Exception {
		log.debug("** getId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where " + parentName
					+ "_id = :id";

			Query query = em.createQuery(queryString);
			query.setParameter("id", id);

			List<?> list = query.getResultList();
			if (list != null)
				log.debug("** Found " + list.size() + "records:");
			return list;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public StockColors getByStockColorName(String name) throws Exception {
		log.debug("** getBySockColorName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockColors where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockColors object = (StockColors) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public StockClass getByStockClassName(String name) throws Exception {
		log.debug("** getBySockClassName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockClass where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockClass object = (StockClass) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public SalesCategory getBySalesCategoryName(String name) throws Exception {
		log.debug("** getBySalesCategoryName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from SalesCategory where name = '" + name
					+ "'";
			Query query = em.createQuery(queryString);
			SalesCategory object = (SalesCategory) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public StockFinish getByStockFinishName(String name) throws Exception {
		log.debug("** getBySockFinishName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockFinish where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockFinish object = (StockFinish) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public StockGroup getByStockGroupName(String name) throws Exception {
		log.debug("** getBySockGroupName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockGroup where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockGroup object = (StockGroup) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	public StockForest getByStockForestName(String name) throws Exception {
		log.debug("** getByStockForestName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockForest where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockForest object = (StockForest) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	
	public GenericColors getByGenericColorsName(String name) throws Exception {
		log.debug("** getByGenericColorsName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from GenericColors where name = '" + name
					+ "'";
			Query query = em.createQuery(queryString);
			GenericColors object = (GenericColors) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public StockGrade getByStockGradeName(String name) throws Exception {
		log.debug("** getByStockGradeName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockGrade where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockGrade object = (StockGrade) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public CostCenter getByCostCenterName(String name) throws Exception {
		log.debug("** getByCostCenterName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from CostCenter where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			CostCenter object = (CostCenter) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ProductionLocations getByLocationName(String name) throws Exception {
		log.debug("** getByLocationName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from ProductionLocations where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			ProductionLocations object = (ProductionLocations) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public PriceList getByPriceListName(String name) throws Exception {
		log.debug("** getByPriceListName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from PriceList where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			PriceList object = (PriceList) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ShippingMethod getByShippingMethodName(String name) throws Exception {
		log.debug("** getByShippingMethodName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from ShippingMethod where name = '" + name
					+ "'";
			Query query = em.createQuery(queryString);
			ShippingMethod object = (ShippingMethod) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public Substrate getBySubstrateName(String name) throws Exception {
		log.debug("** getBySubstrateName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Substrate where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			Substrate object = (Substrate) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public TaxTable getByTaxTableName(String name) throws Exception {
		log.debug("** getByTaxTableName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from TaxTable where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			TaxTable object = (TaxTable) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public PreferencesPricingMethod getByMethodType(String name)
			throws Exception {
		log.debug("** PreferencesPricingMethod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from PreferencesPricingMethod where method = '"
					+ name + "'";
			Query query = em.createQuery(queryString);
			PreferencesPricingMethod object = (PreferencesPricingMethod) query
					.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public WasteChart getByWasteChartName(String name) throws Exception {
		log.debug("** getByWasteChartName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from WasteChart where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			WasteChart object = (WasteChart) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

		
	
	public ChargeCommand getByChargeCommandName(String name) throws Exception {
		log.debug("** getByChargeCommandName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from ChargeCommand where name = '" + name
					+ "'";
			Query query = em.createQuery(queryString);
			ChargeCommand chargeCommand = (ChargeCommand) query
					.getSingleResult();
			List<ChargeCategory> categories = chargeCommand.getChildren();
			for (int i = 0; i < categories.size(); i++) {
				ChargeCategory chargeCategory = categories.get(i);
				if (chargeCategory == null) {
					log.error("null chargeCategory");
				}
			}
			return chargeCommand;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ChargeCategory getByChargeCategoryName(String name) throws Exception {
		log.debug("** getByChargeCategoryName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from ChargeCategory where name = '" + name
					+ "'";
			Query query = em.createQuery(queryString);
			ChargeCategory chargeCategory = (ChargeCategory) query
					.getSingleResult();
			List<ChargeDefinition> chargeDefinitions = chargeCategory
					.getChildren();
			for (int i = 0; i < chargeDefinitions.size(); i++) {
				ChargeDefinition chargeDefinition = chargeDefinitions.get(i);
				if (chargeDefinition == null) {
					log.error("null chargeDefinition");
				}
			}
			return chargeCategory;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ChargeCategory getByChargeCategoryPrevId(String prevId)
			throws Exception {
		log.debug("** getByChargeCategoryPrevId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from ChargeCategory where prevId = '"
					+ prevId + "'";
			Query query = em.createQuery(queryString);
			ChargeCategory chargeCategory = (ChargeCategory) query
					.getSingleResult();
			List<ChargeDefinition> chargeDefinitions = chargeCategory
					.getChildren();
			for (int i = 0; i < chargeDefinitions.size(); i++) {
				ChargeDefinition chargeDefinition = chargeDefinitions.get(i);
				if (chargeDefinition == null) {
					log.error("null chargeDefinition");
				}
			}
			return chargeCategory;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Account> getByAccountsPartialName(String name) throws Exception {
		log.debug("** getAccountsByPartialName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Account where title like '" + name
					+ "%'";
			Query query = em.createQuery(queryString);
			List<Account> accounts = query.getResultList();

			if (accounts != null)
				log.debug("** Found " + accounts.size() + "records:");

			return accounts;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return new ArrayList<Account>();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getByEmployeesPartialName(String name)
			throws Exception {
		log.debug("** getByEmployeesPartialName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Employee where title like '" + name
					+ "%'";
			Query query = em.createQuery(queryString);
			List<Employee> employees = query.getResultList();

			if (employees != null)

				log.debug("** Found " + employees.size() + "records:");

			return employees;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return new ArrayList<Employee>();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getContactsByPartialName(String name) throws Exception {
		log.debug("** getCountactsByPartialName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Contact where title like '" + name
					+ "%'";
			Query query = em.createQuery(queryString);
			List<Contact> contacts = query.getResultList();

			if (contacts != null)

				log.debug("** Found " + contacts.size() + "records:");

			return contacts;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return new ArrayList<Contact>();
	}

	// The following Id generation code is a temporary placeholder for the real
	// handlers, but should work for a few days in
	// a single user environment. And yes it's ugly as snot...

	public PreferencesSequenceValues getSequenceValues() throws Exception {
		PreferencesSequenceValues sequenceValues = (PreferencesSequenceValues) this
				.getSingle("PreferencesSequenceValues");
		if (sequenceValues == null) {
			sequenceValues = new PreferencesSequenceValues();
			sequenceValues.setAccount(new Long(0));
			sequenceValues.setBroker(new Long(0));
			sequenceValues.setChargeDefinition(new Long(0));
			sequenceValues.setContact(new Long(0));
			sequenceValues.setCopierDefinition(new Long(0));
			sequenceValues.setEmployee(new Long(0));
			sequenceValues.setInvoice(new Long(0));
			sequenceValues.setEstimate(new Long(0));
			sequenceValues.setJob(new Long(0));
			sequenceValues.setPressDefinition(new Long(0));
			sequenceValues.setStockDefinition(new Long(0));
			sequenceValues.setCampaign(new Long(0));
			sequenceValues.setGrade(new Long(0));
			sequenceValues.setCreditCard(new Long(0));
			sequenceValues.setStockOrder(new Long(0));
		}
		return sequenceValues;
	}

	private void setAccountId(Account account) throws Exception {
		if (account.getAccountId() != null
				&& account.getAccountId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getAccount();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Account",
					" where accountId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		account.setAccountId(value.toString());
		sequenceValues.setAccount(value);
		this.addUpdate(sequenceValues);
	}

	private void setEmployeeId(Employee employee) throws Exception {
		if (employee.getEmployeeId() != null
				&& employee.getEmployeeId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getEmployee();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Employee",
					" where employeeId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		employee.setEmployeeId(value.toString());
		sequenceValues.setEmployee(value);
		this.addUpdate(sequenceValues);
	}

	private void setContactId(Contact contact) throws Exception {
		if (contact.getContactId() != null
				&& contact.getContactId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getContact();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Contact",
					" where contactId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		contact.setContactId(value.toString());
		sequenceValues.setContact(value);
		this.addUpdate(sequenceValues);
	}

	private void setBrokerId(Broker broker) throws Exception {
		if (broker.getBrokerId() != null && broker.getBrokerId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getBroker();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Broker", " where brokerId = '"
					+ value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		broker.setBrokerId(value.toString());
		sequenceValues.setBroker(value);
		this.addUpdate(sequenceValues);
	}

	private void setStockDefinitionId(StockDefinition stockDefinition)
			throws Exception {
		if (stockDefinition.getStockId() != null
				&& stockDefinition.getStockId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getStockDefinition();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("StockDefinition",
					" where stockId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		stockDefinition.setStockId(value.toString());
		sequenceValues.setStockDefinition(value);
		this.addUpdate(sequenceValues);
	}

	private void setInvoiceId(Invoice invoice) throws Exception {
		if (invoice.getInvoiceNumber() != null
				&& invoice.getInvoiceNumber().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getInvoice();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Invoice",
					" where invoiceNumber = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		invoice.setInvoiceNumber(value.toString());
		sequenceValues.setInvoice(value);
		this.addUpdate(sequenceValues);
	}
	private void setEstimateId(Estimate estimate) throws Exception {
		if (estimate.getInvoiceNumber() != null
				&& estimate.getInvoiceNumber().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getEstimate();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Estimate",
					" where invoiceNumber = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		estimate.setInvoiceNumber(value.toString());
		sequenceValues.setEstimate(value);
		this.addUpdate(sequenceValues);
	}

	private void setJobId(Job job) throws Exception {
		if (job.getJobNumber() != null && job.getJobNumber().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getJob();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Job", " where jobNumber = '"
					+ value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		job.setJobNumber(value.toString());
		sequenceValues.setJob(value);
		this.addUpdate(sequenceValues);
	}

	private void setPressDefinitionId(PressDefinition pressDefinition)
			throws Exception {
		if (pressDefinition.getPressId() != null
				&& pressDefinition.getPressId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getPressDefinition();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("PressDefinition",
					" where pressId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		pressDefinition.setPressId(value.toString());
		sequenceValues.setPressDefinition(value);
		this.addUpdate(sequenceValues);
	}

	private void setCopierDefinitionId(CopierDefinition copierDefinition)
			throws Exception {
		if (copierDefinition.getCopierId() != null
				&& copierDefinition.getCopierId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getCopierDefinition();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("CopierDefinition",
					" where copierId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		copierDefinition.setCopierId(value.toString());
		sequenceValues.setCopierDefinition(value);
		this.addUpdate(sequenceValues);
	}

	private void setCampaignId(Campaigns campaign) throws Exception {
		if (campaign.getCampaignId() != null
				&& campaign.getCampaignId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getCampaign();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Campaigns",
					" where campaignId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		campaign.setCampaignId(value.toString());
		sequenceValues.setCampaign(value);
		this.addUpdate(sequenceValues);
	}

	private void setGradeId(Grade grade) throws Exception {
		if (grade.getGradeId() != null && grade.getGradeId().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getGrade();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Grade", " where gradeId = '"
					+ value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		grade.setGradeId(value.toString());
		sequenceValues.setGrade(value);
		this.addUpdate(sequenceValues);
	}

	private void setCreditCardId(CreditCard creditcard) throws Exception {
		if (creditcard.getCreditCardID() != null
				&& creditcard.getCreditCardID().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getCreditCard();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("CreditCard",
					" where creditCardId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		creditcard.setCreditCardID(value.toString());
		sequenceValues.setCreditCard(value);
		this.addUpdate(sequenceValues);
	}
	private void setStockOrderId(StockOrder stockOrder) throws Exception {
		if (stockOrder.getOrderNumber() != null
				&& stockOrder.getOrderNumber().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getStockOrder();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("StockOrder",
					" where OrderNumber = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		stockOrder.setOrderNumber(value.toString());
		sequenceValues.setStockOrder(value);
		this.addUpdate(sequenceValues);
	}

	public ModelBase addUpdate(ModelBase object) throws Exception {
		log.debug("** addUpdateAccount called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			if (object.getId() == null || object.getId() == 0) {
				object.setId(null);
				if (object.getCreated() == null)
					object.setCreated(new Timestamp(new Date().getTime()));
				object.setModified(new Timestamp(new Date().getTime()));
			} else {
				// Existing object is updated - do nothing.
			}
			if (object instanceof Account) {
				this.setAccountId((Account) object);
			} else if (object instanceof Employee) {
				this.setEmployeeId((Employee) object);
			} else if (object instanceof Contact) {
				this.setContactId((Contact) object);
			} else if (object instanceof Broker) {
				this.setBrokerId((Broker) object);
			} else if (object instanceof StockDefinition) {
				this.setStockDefinitionId((StockDefinition) object);
			} else if (object instanceof Invoice) {
				this.setInvoiceId((Invoice) object);
			} else if (object instanceof Estimate) {
				this.setEstimateId((Estimate) object);
			} else if (object instanceof Job) {
				this.setJobId((Job) object);
			} else if (object instanceof PressDefinition) {
				this.setPressDefinitionId((PressDefinition) object);
			} else if (object instanceof CopierDefinition) {
				this.setCopierDefinitionId((CopierDefinition) object);
			} else if (object instanceof Campaigns) {
				this.setCampaignId((Campaigns) object);
			} else if (object instanceof Grade) {
				this.setGradeId((Grade) object);
			} else if (object instanceof CreditCard) {
				this.setCreditCardId((CreditCard) object);
			} else if (object instanceof StockOrder) {
				this.setStockOrderId((StockOrder) object);
			}

			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				object = em.merge(object);
				tx.commit();
				MessageServiceAdapter.sendNotification(MessageTypes.ADDUPDATE,
						object.getClass().getSimpleName(), object.getId());
			} catch (RollbackException e) {
				ConstraintViolationException cve = (ConstraintViolationException) e
						.getCause();
				SQLException sqle = cve.getSQLException().getNextException();
				while (sqle != null) {
					sqle = sqle.getNextException();
				}
			} catch (PersistenceException e) {
				log.error("** Error: " + e.getMessage());
				GenericJDBCException jdbcEx = (GenericJDBCException) e
						.getCause();
				System.out.println(jdbcEx.getSQL());
				tx.rollback();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				log.error("** Error: " + e.getMessage());
				tx.rollback();
				throw new Exception(e.getMessage());
			}
		} catch (Exception e) {
			log.error("Exception caught");
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
		return object;
	}
	
	/**
	 * Method used to perform CRUD operations on the List
	 * @param addUpdateList
	 * @param deleteList
	 * @throws Exception
	 */
	public void addUpdateDeleteList(List<ModelBase> addUpdateList, List<ModelBase> deleteList) throws Exception {
		if(deleteList!=null && deleteList.size()>0) {
			for (ModelBase modelBase : deleteList) {
				if(modelBase.getId()!=null && modelBase.getId().longValue()!=0) {
					int classNameIndex=modelBase.getClass().getName().lastIndexOf ('.') + 1;
				    String className = modelBase.getClass().getName().substring(classNameIndex);
					deleteItem(className, modelBase.getId());
				}
			}
		}
		if(addUpdateList!=null && addUpdateList.size()>0) {
			for (ModelBase modelBase : addUpdateList) {
				addUpdate(modelBase);
			}
		}
	}

	public ChargeCategory addChargeCategoryToCommand(ChargeCategory category,
			ChargeCommand command) throws Exception {
		log.debug("** addChargeCategoryToCommand called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {

			if (command == null || category == null) {
				String msg = "null value passed to addChargeCategoryToCommand";
				log.error(msg);
				throw new Exception(msg);
			} else {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				try {
					command.addChildren(category);
					command = em.merge(command);
					tx.commit();
					category = command.getChildren().get(
							command.getChildren().size() - 1);
					return category;
				} catch (Exception e) {
					log.error("** Error: " + e.getMessage());
					tx.rollback();
					throw new Exception(e.getMessage());

				}
			}
		} catch (Exception e) {
			log.error("Exception caught");
		} finally {
			em.close();
		}
		return null;
	}

	public ChargeDefinition addChargeToCategory(ChargeDefinition charge,
			ChargeCategory category) throws Exception {
		log.debug("** addChargeCategoryToCommand called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			if (charge == null || category == null) {
				String msg = "null value passed to addChargeCategoryToCommand";
				log.error(msg);
				throw new Exception(msg);
			} else {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				try {
					category.addChildren(charge);
					category = em.merge(category);
					charge = category.getChildren().get(
							category.getChildren().size() - 1);
					tx.commit();
					// MessageServiceAdapter.sendNotification("Object Created");
					return charge;
				} catch (Exception e) {
					log.error("** Error: " + e.getMessage());
					tx.rollback();
					throw new Exception(e.getMessage());
				}
			}
		} catch (Exception e) {
			log.error("Exception caught");
		} finally {
			em.close();
		}
		return null;
	}

	public List<ChargeCommand> getChargeList() throws Exception {
		List<ChargeCommand> resultList = new ArrayList<ChargeCommand>();
		log.debug("** getChargeList called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query findAllQuery = em
					.createQuery("from ChargeCommand fetch all properties order by id");
			resultList = findAllQuery.getResultList();

			if (resultList != null)
				for (ChargeCommand chargeCommand : resultList) {
					List<ChargeCategory> categories = chargeCommand
							.getChildren();
					for (ChargeCategory category : categories) {
						List<ChargeDefinition> charges = category.getChildren();
						for (ChargeDefinition charge : charges) {
							if (charge == null) {
								log.error("null charge found");
							}
						}
					}
				}
			log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return resultList;
	}

	public Job getJob(Long id) throws Exception {
		log.debug("** getJob called.");
		Job job = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Job.byId");
			query.setParameter("id", id);
			job = (Job) query.getSingleResult();

			if (job != null) {
				for (int i = 0; i < job.getDigitalAssets().size(); i++) {
					DigitalAsset asset = job.getDigitalAssets().get(i);
					if (asset == null) {
						log.error("Found null asset");
					}
				}
				long tmpId;
				
				if (job.getCostingCopier() != null) {
					tmpId = job.getCostingCopier().getId();
					job.setCostingCopier((CopierDefinition)this.getById("CopierDefinition", tmpId));
				}
				if (job.getPricingCopier() != null) {
					tmpId = job.getPricingCopier().getId();
					job.setPricingCopier((CopierDefinition)this.getById("CopierDefinition", tmpId));
				}
				if (job.getCostingPress() != null) {
					tmpId = job.getCostingPress().getId();
					job.setCostingPress((PressDefinition)this.getById("PressDefinition", tmpId));
				}
				if (job.getPricingPress() != null) {
					tmpId = job.getPricingPress().getId();
					job.setPricingPress((PressDefinition)this.getById("PressDefinition", tmpId));
				}
				if (job.getParentInvoice() != null) {
					tmpId = job.getParentInvoice().getId();
					job.setParentInvoice((InvoiceBase)this.getById("InvoiceBase", tmpId));
				}
				
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return job;		
	}
	
	public InvoiceBase getInvoice(Long id) throws Exception {
		log.debug("** getInvoice called.");
		InvoiceBase invoice = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("InvoiceBase.byId");
			query.setParameter("id", id);
			invoice = (InvoiceBase) query.getSingleResult();

			if (invoice != null) {
				for (int i = 0; i < invoice.getJobs().size(); i++) {
					JobBase job = invoice.getJobs().get(i);
					if (job != null) {
						for (int j = 0; j < job.getCharges().size(); j++) {
							Charge charge = job.getCharges().get(j);
							if (charge == null) {
								log.error("null charge found");
							}
						}
					}
				}
			}
		} catch (GenericJDBCException e) {
			log.error(e);
			log.error(e.getSQL());
			System.out.println(e.getSQL());
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return invoice;
	}
	
	public ModelBase saveInvoice(InvoiceBase invoice) throws Exception {
		log.debug("** addUpdateAccount called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			if (invoice.getId() == null || invoice.getId() == 0) {
				invoice.setId(null);
				invoice.setCreated(new Timestamp(new Date().getTime()));
				invoice.setModified(new Timestamp(new Date().getTime()));
			} else {
				// Existing object is updated - do nothing.
			}
			if (invoice instanceof Invoice) {
				this.setInvoiceId((Invoice) invoice);
			} else if (invoice instanceof Estimate) {
				this.setEstimateId((Estimate) invoice);
			}
			List<JobBase> jobs = invoice.getJobs();
			List<Charge> charges = invoice.getCharges();
			
			if (jobs != null) {
				Iterator<JobBase> jobIter = jobs.iterator();
				
				while (jobIter.hasNext()) {
					JobBase job = jobIter.next();
					
					log.info("assigning parentInvoice to job. Invoice: " + invoice.getId() + " Job: " + job.getId());
					job.setParentInvoice(invoice);
				}
			}
			
			
			if (charges != null) {
				Iterator<Charge> chargeIter = charges.iterator();
				
				while (chargeIter.hasNext()) {
					Charge charge = chargeIter.next();

					log.info("assigning parentInvoice to charge. Invoice: " + invoice.getId() + " Charge: " + charge.getId());
					charge.setParentInvoice(invoice);
				}
			}

			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				invoice = em.merge(invoice);
				tx.commit();
				jobs = invoice.getJobs();
				charges = invoice.getCharges();
				
				if (jobs != null) {
					Iterator<JobBase> jobIter = jobs.iterator();
					
					while (jobIter.hasNext()) {
						JobBase job = jobIter.next();
						
						log.info("assigning parentInvoice to job. Invoice: " + invoice.getId() + " Job: " + job.getId());
						job.setParentInvoice(invoice);
						addUpdate(job);
					}
				}
				
				
				if (charges != null) {
					Iterator<Charge> chargeIter = charges.iterator();
					
					while (chargeIter.hasNext()) {
						Charge charge = chargeIter.next();

						log.info("assigning parentInvoice to charge. Invoice: " + invoice.getId() + " Charge: " + charge.getId());
						charge.setParentInvoice(invoice);
						addUpdate(charge);
					}
				}
				MessageServiceAdapter.sendNotification(MessageTypes.ADDUPDATE,
						invoice.getClass().getSimpleName(), invoice.getId());
			} catch (RollbackException e) {
				ConstraintViolationException cve = (ConstraintViolationException) e
						.getCause();
				SQLException sqle = cve.getSQLException().getNextException();
				while (sqle != null) {
					sqle = sqle.getNextException();
				}
			} catch (PersistenceException e) {
				log.error("** Error: " + e.getMessage());
				GenericJDBCException jdbcEx = (GenericJDBCException) e
						.getCause();
				System.out.println(jdbcEx.getSQL());
				tx.rollback();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				log.error("** Error: " + e.getMessage());
				tx.rollback();
				throw new Exception(e.getMessage());
			}
		} catch (Exception e) {
			log.error("Exception caught");
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
		return invoice;	
	}
	
	public StockDefinition getStockDefinition(Long id) throws Exception {
		log.debug("** getStockDefinition called.");
		StockDefinition stockDefinition = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("StockDefinition.byId");
			query.setParameter("id", id);
			stockDefinition = (StockDefinition) query.getSingleResult();

			if (stockDefinition != null) {
				for (int i = 0; i < stockDefinition.getCharges().size(); i++) {
					ChargeDefinition chargeDefinition = stockDefinition.getCharges().get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return stockDefinition;
	}	
	public Grade getGrade(Long id) throws Exception {
		log.debug("** getGrade called.");
		Grade grade = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Grade.byId");
			query.setParameter("id", id);
			grade = (Grade) query.getSingleResult();

			if (grade != null) {
				for (int i = 0; i < grade.getCampaigns().size(); i++) {
					 Campaigns camp = grade.getCampaigns().get(i);
					if (camp == null) {
						log.error("null camp found");
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return grade;
	}	

	public PressDefinition getPressDefinition(Long id) throws Exception {
		log.debug("** getPressDefinition called.");
		PressDefinition pressDefinition = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("PressDefinition.byId");
			query.setParameter("id", id);
			pressDefinition = (PressDefinition) query.getSingleResult();

			if (pressDefinition != null) {
				for (int i = 0; i < pressDefinition.getCharges().size(); i++) {
					ChargeDefinition chargeDefinition = pressDefinition.getCharges().get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return pressDefinition;
	}	
	public Account getAccount(Long id) throws Exception {
		log.debug("** getAccount called.");
		Account account = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Account.byId");
			query.setParameter("id", id);
			account = (Account) query.getSingleResult();

			if (account != null) {
				for (int i = 0; i < account.getInvoiceEstimateCharges().size(); i++) {
					ChargeDefinition chargeDefinition = account.getInvoiceEstimateCharges().get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
				for (int i = 0; i < account.getJobCharges().size(); i++) {
					ChargeDefinition chargeDefinition = account.getJobCharges().get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
				for (int i = 0; i < account.getContact().getComLinks().size(); i++) {
					 ComLink link = account.getContact().getComLinks().get(i);
					if (link == null) {
						log.error("null charge found");
					}
				}
				for (int i = 0; i < account.getBillToContact().getComLinks().size(); i++) {
					 ComLink link = account.getBillToContact().getComLinks().get(i);
					if (link == null) {
						log.error("null charge found");
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return account;
	}
	public CopierDefinition getCopierDefinition(Long id) throws Exception {
		log.debug("** getCopierDefinition called.");
		CopierDefinition copierDefinition = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("CopierDefinition.byId");
			query.setParameter("id", id);
			copierDefinition = (CopierDefinition) query.getSingleResult();

			if (copierDefinition != null) {
				for (int i = 0; i < copierDefinition.getCharges().size(); i++) {
					ChargeDefinition chargeDefinition = copierDefinition.getCharges().get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
				
				Matrix matrix = copierDefinition.getCopierMatrix();
				
				if (matrix != null) {
					for (int i = 0; i < matrix.getElements().size(); i++) {
						MatrixElement element = matrix.getElements().get(i);
						if (element == null) {
							log.error("null matrix element found");
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return copierDefinition;
	}
	public Contact getContact(Long id) throws Exception {
		log.debug("** getContact called.");
		Contact contact = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Contact.byId");
			query.setParameter("id", id);
			contact = (Contact) query.getSingleResult();

			if (contact != null) {
				for (int i = 0; i < contact.getComLinks().size(); i++) {
					 ComLink link = contact.getComLinks().get(i);
					if (link == null) {
						log.error("null contact found");
					}
				}
				for (int i = 0; i < contact.getShipToAddress().size(); i++) {
					 Address add = contact.getShipToAddress().get(i);
					if (add == null) {
						log.error("null charge found");
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return contact;
	}
	public TaxTable getTaxTable(Long id) throws Exception {
		log.debug("** getTaxTable called.");
		TaxTable taxTable = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("TaxTable.byId");
			query.setParameter("id", id);
			taxTable = (TaxTable) query.getSingleResult();

			if (taxTable != null) {
				for (int i = 0; i < taxTable.getTaxElements().size(); i++) {
					TaxElement taxElement = taxTable.getTaxElements().get(i);
					if (taxElement == null) {
						log.error("null tax found");
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return taxTable;
	}

	public InvoiceBase getInvoiceByInvoiceNumber(String invoiceNumber,
			String docType) throws Exception {
		log.debug("** getInvoice called.");
		InvoiceBase invoice = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Session session = (Session) em.getDelegate();
			if (docType.equals("I")) {
				Query findQuery = em
						.createQuery("from Invoice where invoiceNumber = '"
								+ invoiceNumber + "'");
				invoice = (InvoiceBase) findQuery.getSingleResult();
			} else {
				Query findQuery = em
						.createQuery("from Estimate where invoiceNumber = '"
								+ invoiceNumber + "'");
				invoice = (InvoiceBase) findQuery.getSingleResult();
			}

			if (invoice != null) {
				for (int i = 0; i < invoice.getJobs().size(); i++) {
					JobBase job = invoice.getJobs().get(i);
					if (job != null) {
						for (int j = 0; j < job.getCharges().size(); j++) {
							Charge charge = job.getCharges().get(j);
							if (charge == null) {
								log.error("null charge found");
							}
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return invoice;
	}

	public ModelBase getById(String className, Long id) throws Exception {
		log.debug("** getById called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery(className + ".byId");
			query.setParameter("id", id);
			ModelBase object = (ModelBase) query.getSingleResult();
			for (Field field : object.getClass().getDeclaredFields()) {
				if(field.getType().getName().equals("java.util.List") || field.getType().getName().equals("java.util.ArrayList")) {
					String propertyName = field.getName().substring(0,1).toUpperCase()+field.getName().substring(1,field.getName().length());
					try {
						Hibernate.initialize(object.getProperty(propertyName));
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getPriceList(Long id) throws Exception {
		log.debug("** getPriceList called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("PriceListBase.byId");
			query.setParameter("id", id);
			PriceListBase priceList = (PriceListBase) query.getSingleResult();

			if (priceList.getElements() != null) {
				for (int i = 0; i < priceList.getElements().size(); i++) {
					PriceListElement element = priceList.getElements().get(i);

					if (element == null) {
						log.error("Null priceList element found");
					}
				}
			}
			return priceList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getEmployee(Long id) throws Exception {
		log.debug("** getEmployee called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Employee.byId");
			query.setParameter("id", id);
			Employee employee = (Employee) query.getSingleResult();

			if (employee.getComLinks() != null) {
				for (int i = 0; i < employee.getComLinks().size(); i++) {
					ComLink comLink = employee.getComLinks().get(i);

					if (comLink == null) {
						log.error("Null comLink found");
					}
				}
			}
			if (employee.getEmployeeCharges() != null) {
				for (int i = 0; i < employee.getEmployeeCharges().size(); i++) {
					ChargeCommand charge = employee.getEmployeeCharges().get(i);

					if (charge == null) {
						log.error("Null charge found");
					}
				}
			}
			if (employee.getEmployeeCopiers() != null) {
				for (int i = 0; i < employee.getEmployeeCopiers().size(); i++) {
					ProductionCopiers copier = employee.getEmployeeCopiers()
							.get(i);

					if (copier == null) {
						log.error("Null copier found");
					}
				}
			}
			if (employee.getEmployeePresses() != null) {
				for (int i = 0; i < employee.getEmployeePresses().size(); i++) {
					ProductionPress press = employee.getEmployeePresses()
							.get(i);

					if (press == null) {
						log.error("Null press found");
					}
				}
			}
			if (employee.getEmployeePricings() != null) {
				for (int i = 0; i < employee.getEmployeePricings().size(); i++) {
					PreferencesPricingMethod preferencesPricingMethod = employee
							.getEmployeePricings().get(i);

					if (preferencesPricingMethod == null) {
						log.error("Null preferencesPricingMethod found");
					}
				}
			}
			if (employee.getProductionParents() != null) {
				for (int i = 0; i < employee.getProductionParents().size(); i++) {
					ProductionLocations productionLocations = employee
							.getProductionParents().get(i);

					if (productionLocations == null) {
						log.error("Null productionLocations found");
					}
				}
			}

			return employee;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getMatrix(Long id) throws Exception {
		log.debug("** getMatrix called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Matrix.byId");
			query.setParameter("id", id);
			Matrix matrix = (Matrix) query.getSingleResult();

			if (matrix.getElements() != null) {
				for (int i = 0; i < matrix.getElements().size(); i++) {
					MatrixElement element = matrix.getElements().get(i);

					if (element == null) {
						log.error("Null matrix element found");
					}
				}
			}
			return matrix;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	public ModelBase getByIdMaster(String className, Long id) throws Exception {
		log.debug("** getById called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery(className + ".byId");
			query.setParameter("id", id);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> getByAccountId(String className, Long id)
			throws Exception {
		log.debug("** getByaccountid Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "select a from " + className
					+ " a where a.account.id = :id";
			Query query = em.createQuery(queryString);
			query.setParameter("id", id);
			List<Invoice> invoicelist = query.getResultList();
			if (invoicelist != null)
				log.debug("** Found " + invoicelist.size() + "records:");
			return invoicelist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> getInvoiceByAccountId(String className, Long id)
			throws Exception {
		log.debug("** getByaccountid Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();

		String columnstring = new String();
		columnstring = "a.id, a.name, a.invoiceNumber, a.grandTotal, a.customerPO";

		try {
			// cej
			String queryString = "select new " + className + "( "
					+ columnstring + ") from " + className
					+ " a where a.account.id = :id";
			// String queryString = "select a.id, a.name, a.invoiceName from " +
			// className
			// + " a where a.account.id = :id";

			Query query = em.createQuery(queryString);
			query.setParameter("id", id);
			List<Invoice> invoicelist = query.getResultList();
			if (invoicelist != null)
				log.debug("** Found " + invoicelist.size() + "records:");
			return invoicelist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> getEstimateByAccountId(String className, Long id)
			throws Exception {
		String columnstring = new String();

		columnstring = "a.id, a.name, a.invoiceNumber, a.grandTotal";
		EntityManager em = entityManagerFactory.createEntityManager();

		try {
			log.debug("** getEstimateByAccountId Id called.");
			// cej
			String queryString = "select new " + className + "( "
					+ columnstring + ") from " + className
					+ " a where a.account.id = :id";
			// String queryString = "select a.id, a.name, a.invoiceName from " +
			// className
			// + " a where a.account.id = :id";

			Query query = em.createQuery(queryString);
			query.setParameter("id", id);
			List<Invoice> invoicelist = query.getResultList();
			if (invoicelist != null)
				log.debug("** Found " + invoicelist.size() + "records:");
			return invoicelist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getContactsByAccountId(String className, Long id)
			throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			log.debug("** getByaccountid Id called.");

			String queryString = "select a from " + className
					+ " a where a.parentAccount.id = :id";

			Query query = em.createQuery(queryString);
			query.setParameter("id", id);
			List<Contact> contactlist = query.getResultList();
			if (contactlist != null)
				log.debug("** Found " + contactlist.size() + "records:");
			return contactlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TimeCard> getByClockInOut(String className, Employee employee)
			throws Exception {
		log.debug("** getByEmployee Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			/*DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();*/

			/*String queryString = "from " + className
					+ " where to_char(startdatetime,'YYYY-MM-DD') = '"
					+ dateFormat.format(date).toString()
					+ "' and employee = :employee and onClock = 1";*/
			String queryString = "from " + className
			+ " where employee = :employee and onClock = 1";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
			List<TimeCard> timecardlist = query.getResultList();
			if (timecardlist != null)
				log.debug("** Found " + timecardlist.size() + "records:");
			return timecardlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TimeCard> getByClockInOutBreak(String className,
			Employee employee) throws Exception {
		log.debug("** getByEmployee Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();

			String queryString = "from " + className
					+ " where to_char(breaktime,'YYYY-MM-DD') = '"
					+ dateFormat.format(date).toString()
					+ "' and employee = :employee";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
			List<TimeCard> timecardlist = query.getResultList();
			if (timecardlist != null)
				log.debug("** Found " + timecardlist.size() + "records:");
			return timecardlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployee(String className,
			Employee employee) throws Exception {
		log.debug("** getByEmployee Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();

			/*String queryString = "from " + className
					+ " where to_char(created,'YYYY-MM-DD') = '"
					+ dateFormat.format(date).toString()
					+ "' and employee = :employee";*/
			String queryString = "from " + className
					+ " where employee = :employee order by period desc";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
			List<TimeCard> timecardlist = query.getResultList();
			if (timecardlist != null)
				log.debug("** Found " + timecardlist.size() + "records:");
			return timecardlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	/**
	 * This method retrieves Time Cards for Active Period and Employee 
	 * @param className
	 * @param employee
	 * @param periodNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployeeByActivePeriod(String className,
			Employee employee, int periodNumber) throws Exception {
		log.debug("** getByTimeCardByEmployeeByActivePeriod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className
					+ " where employee = :employee and period = :periodNumber order by period desc";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
			query.setParameter("periodNumber", periodNumber);
			List<TimeCard> timecardlist = query.getResultList();
			if (timecardlist != null)
				log.debug("** Found " + timecardlist.size() + "records:");
			return timecardlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	/**
	 * This method retrieves Time Cards for Close Periods and Employee 
	 * @param className
	 * @param employee
	 * @param periodNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployeeByClosePeriod(String className,
			Employee employee, List closePeriods) throws Exception {
		log.debug("** getByTimeCardByEmployeeByClosePeriod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className
					+ " where employee = :employee and period in (:closePeriods) order by period desc";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
			query.setParameter("closePeriods", closePeriods);
			List<TimeCard> timecardlist = query.getResultList();
			if (timecardlist != null)
				log.debug("** Found " + timecardlist.size() + "records:");
			return timecardlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	/**
	 * This method retrieves Time Cards for All Periods and Employee 
	 * @param className
	 * @param employee
	 * @param periodNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployeeByAllPeriod(String className,
			Employee employee, List allPeriods) throws Exception {
		log.debug("** getByTimeCardByEmployeeByAllPeriod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className
					+ " where employee = :employee and period in (:allPeriods) order by period desc";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
			query.setParameter("allPeriods", allPeriods);
			List<TimeCard> timecardlist = query.getResultList();
			if (timecardlist != null)
				log.debug("** Found " + timecardlist.size() + "records:");
			return timecardlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	/**
	 * This method retrieves Time Cards for Specific Period and Employee 
	 * @param className
	 * @param employee
	 * @param periodNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployeeBySpecificPeriod(String className,
			Employee employee, int period) throws Exception {
		log.debug("** getByTimeCardByEmployeeBySpecificPeriod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className
					+ " where employee = :employee and period = :period order by period desc";
			Query query = em.createQuery(queryString);
			query.setParameter("employee", employee);
			query.setParameter("period", period);
			List<TimeCard> timecardlist = query.getResultList();
			if (timecardlist != null)
				log.debug("** Found " + timecardlist.size() + "records:");
			return timecardlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Period> getByPeriodOpen(String className) throws Exception {
		log.debug("** getByPeriodOpen called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className
					+ " where periodClosed = false";
			Query query = em.createQuery(queryString);
			List<Period> periodlist = query.getResultList();
			if (periodlist != null)
				log.debug("** Found " + periodlist.size() + "records:");
			return periodlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	
	/**
	 * This method retrieves Maximum PeriodNumber
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public int getMaxPeriod(String className) throws Exception {
		log.debug("** getMaxPeriod called.");
		int maxPeriod = -1;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Session session = (Session) em.getDelegate();
			String queryString = "select max(periodNumber) from " + className
					+ " where periodClosed = false";
			org.hibernate.Query query = session.createQuery(queryString);
			ScrollableResults rs = query.scroll();
			if(rs.next()) {
				maxPeriod = rs.getInteger(0).intValue();
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return maxPeriod;
	}
	
	
	
	/**
	 * This method retrieves all close periods 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Period> getAllClosePeriods(String className) throws Exception {
		log.debug("** getByEmployee Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className
					+ " where periodClosed = true order by periodnumber desc";
			Query query = em.createQuery(queryString);
			List<Period> periodlist = query.getResultList();
			if (periodlist != null)
				log.debug("** Found " + periodlist.size() + "records:");
			return periodlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	/**
	 * This method retrieves all periods 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Period> getAllPeriods(String className) throws Exception {
		log.debug("** getAllPeriods called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className+" order by periodnumber desc";
			Query query = em.createQuery(queryString);
			List<Period> periodlist = query.getResultList();
			if (periodlist != null)
				log.debug("** Found " + periodlist.size() + "records:");
			return periodlist;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	/**
	 * This method retrieves List of TimeCards required for Export functionality
	 * @param orderByField
	 * @param fromDate
	 * @param toDate
	 * @param periodFrom
	 * @param periodTo
	 * @param selectedEmployeeList
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TimeCard> getEmployeeTimeExports(String orderByField, Date fromDate, Date toDate,
			int periodFrom, int periodTo, List selectedEmployeeList) throws Exception {
		log.debug("** getEmployeeTimeExports called.");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from TimeCard tc fetch all properties";
			if(fromDate==null && toDate==null) {	
				queryString = queryString+" where period between "+periodFrom+" and "+periodTo;
			} else {
				queryString = queryString+" where (startDateTime between '"+dateFormat.format(fromDate)+"' and '"+dateFormat.format(toDate)+"' " +
						"or endDateTime between '"+dateFormat.format(fromDate)+"' and '"+dateFormat.format(toDate)+"')";
			}
			queryString = queryString + " and tc.onClock=0 and tc.endDateTime is not null and tc.employee.employeeId in (:employeeIds)";
			queryString = queryString + " order by tc."+orderByField+" asc";
			Query query = em.createQuery(queryString);
			query.setParameter("employeeIds", selectedEmployeeList);
			List<TimeCard> timeCardList = query.getResultList();
			for(TimeCard timeCard : timeCardList) {
				timeCard.setEmployee((Employee) getEmployee(timeCard.getEmployee().getId()));
			}
			if (timeCardList != null)
				log.debug("** Found " + timeCardList.size() + "records:");
			return timeCardList;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<SecuritySetup> getByAccessGroup(String className,
			AccessGroup accessGroup) throws Exception {
		log.debug("** getByAccess called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "select a from SecuritySetup a where a.accessGroup.id = :id";
			Query query = em.createQuery(queryString);
			query.setParameter("id", accessGroup.getId());
			List<SecuritySetup> securitySetups = query.getResultList();

			if (securitySetups != null)
				log.debug("** Found " + securitySetups.size() + "records:");
			return securitySetups;

		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * This method retrieves the list of active employees and inactive employees who are
	 * clocked in 
	 */
	public List<Employee> getActiveEmployees() throws Exception {
		log.debug("** getActiveEmployees called.");
		List<Employee> activeEmployees = new ArrayList<Employee>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Employee where (active=true or clockin=true)";
			Query query = em.createQuery(queryString);
			activeEmployees = query.getResultList();
			if (activeEmployees != null)
				log.debug("** Found " + activeEmployees.size() + "records:");

		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return activeEmployees;
	}
	
	/**
	 * This method retrieves list of active employees who are clocked in
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getClockedInEmployee() throws Exception {
		log.debug("** getClockedInEmployee called.");
		List<Employee> clockedInEmployees = new ArrayList<Employee>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Employee where active=true and clockin=true";
			Query query = em.createQuery(queryString);
			clockedInEmployees = query.getResultList();
			if (clockedInEmployees != null)
				log.debug("** Found " + clockedInEmployees.size() + "records:");

		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return clockedInEmployees;
	}

	/**
	 * This method retrieves jobs & charges list based on the employee filtering
	 * @param employeeId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ModelBase> getJobsChargesForTrackerByEmployee(long employeeId, Date todayDate) throws Exception {
		log.debug("** getJobsChargesForTrackerByEmployee called.");
		List<ModelBase> jobChargesList = new ArrayList<ModelBase>();
		EntityManager em = entityManagerFactory.createEntityManager();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Calendar todayCalendar = Calendar.getInstance();
			todayCalendar.setTime(todayDate);
			Calendar tomorrowCalendar = Calendar.getInstance();
			tomorrowCalendar.setTime(todayDate);
			tomorrowCalendar.add(Calendar.DATE, 1);
			Calendar startDateOfThisWeek = Calendar.getInstance();
			Calendar endDateOfThisWeek = Calendar.getInstance();
			endDateOfThisWeek.setTime(todayDate);
			endDateOfThisWeek.add(Calendar.DATE,8-todayCalendar.get(Calendar.DAY_OF_WEEK));
			startDateOfThisWeek.setTime(endDateOfThisWeek.getTime());
			startDateOfThisWeek.add(Calendar.DATE, -8);
			Calendar startDateOfNextWeek = Calendar.getInstance();
			startDateOfNextWeek.setTime(todayDate);
			startDateOfNextWeek.add(Calendar.DATE,8-todayCalendar.get(Calendar.DAY_OF_WEEK));
			Calendar endDateOfNextWeek = Calendar.getInstance();
			endDateOfNextWeek.setTime(startDateOfNextWeek.getTime());
			endDateOfNextWeek.add(Calendar.DATE, 8);
			Query findQuery = em.createQuery("from TrackerConsole");
			TrackerConsole trackerConsole =  (TrackerConsole) findQuery.getSingleResult();
			Hibernate.initialize(trackerConsole.getSelectedStations());
			Query employeeQuery = em.createNamedQuery("Employee.byId");
			employeeQuery.setParameter("id", employeeId);
			Employee employee = (Employee) employeeQuery.getSingleResult();
			if(employee!=null) {
				if(employee.getIncludeInvoice()) {
					if(employee.getIncludeJobs()) {
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select job from Invoice as invoice inner join invoice.jobs as job where";
						if(!employee.getAllPricingMethods()) {
							queryString = queryString + " job.pricingMethod in (:pricingMethods) and";
						}
						if(!employee.getAllCopiers()) {
							queryString = queryString + " job.costingCopier.machineName in (:copiers) and";
						}
						if(!employee.getAllChargeTypes()) {
							//queryString = queryString + " job.costingCopier in (:copiers) and";
						}
						if(!employee.getAllPresses()) {
							queryString = queryString + " job.costingPress.machineName in (:presses) and";
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							queryString = queryString + " job.location in (:locations) and";
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							boolean checkFlag = false;
							if(employee.getCustomerWant()!=null) {
								if(employee.getCustomerWant().equals("Due_Today") || employee.getCustomerWant().equals("Due_Tomorrow")) {
									queryString = queryString + " ((to_char(invoice.deliveryIntentDate,'DD/MM/YYYY')=:date or invoice.deliveryIntentDate is null) ";
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_This_Week") || employee.getCustomerWant().equals("Due_Next")){
									queryString = queryString + " ((invoice.deliveryIntentDate between :startdate and :enddate or invoice.deliveryIntentDate is null) ";
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_Any_Time")) {
									queryString = queryString + " ((invoice.deliveryIntentDate is not null or invoice.deliveryIntentDate is null) ";
									checkFlag = true;
								}
							}
							if(employee.getAnyPastDue()) {
								if(checkFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString + " (invoice.deliveryIntentDate < :pastdate or invoice.deliveryIntentDate is null)";
								if(checkFlag) {
									queryString = queryString + ")";
								}
								queryString = queryString + " and";
							} else {
								if(checkFlag) {
									queryString = queryString + ") and";
								}
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							queryString = queryString + " (invoice.deliveryIntentDate < :pastdate or invoice.deliveryIntentDate is null) and";
						}
						if(employee.getHideNonReleaseProduction() || trackerConsole.getHideItemsNotReleasedToProd()) {
							queryString = queryString + " (job.releasedToProduction=true and job.releasedToProduction is not null)";
						} else {
							queryString = queryString + " ((job.releasedToProduction=true or job.releasedToProduction=false) and job.releasedToProduction is not null)";
						}
						
						Query query = em.createQuery(queryString);
						if(!employee.getAllPricingMethods()) {
							query.setParameter("pricingMethods", employee.getEmployeePricings());
						}
						if(!employee.getAllCopiers()) {
							List<String> copiersList = new ArrayList<String>();
							for (ProductionCopiers productionCopiers : employee.getEmployeeCopiers()) {
								copiersList.add(productionCopiers.getName());
							}
							query.setParameter("copiers", copiersList);
						}
						if(!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand.getName());
							}
						}
						if(!employee.getAllPresses()) {
							List<String> pressesList = new ArrayList<String>();
							for (ProductionPress productionPress : employee.getEmployeePresses()) {
								pressesList.add(productionPress.getName());
							}
							query.setParameter("presses", pressesList);
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations",employee.getProductionParents());
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							if(employee.getCustomerWant()!=null) {
								if(employee.getCustomerWant().equals("Due_Today")) {
									query.setParameter("date",dateFormat.format(todayDate));
								} else if(employee.getCustomerWant().equals("Due_Tomorrow")) {
									query.setParameter("date",dateFormat.format(tomorrowCalendar.getTime()));
								} else if(employee.getCustomerWant().equals("Due_This_Week")) {
									query.setParameter("startdate",startDateOfThisWeek.getTime());
									query.setParameter("enddate",endDateOfThisWeek.getTime());
								} else if(employee.getCustomerWant().equals("Due_Next")) {
									query.setParameter("startdate",startDateOfNextWeek.getTime());
									query.setParameter("enddate",endDateOfNextWeek.getTime());
								}
							}
							if(employee.getAnyPastDue()) {
								query.setParameter("pastdate",todayDate);
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							query.setParameter("pastdate",todayDate);
						}
						List<Job> jobList = query.getResultList();
						for (Job job : jobList) {
							if(job!=null) {
								/*if(employee.getIncludeJobCharges()) {
									if(job.getCharges()!=null && job.getCharges().size()>0) {
										for (Charge charge : job.getCharges()) {
											if(charge!=null) {
												if(!employee.getAllChargeTypes()) {
													if(charge.getChargeDefinition()!=null) {
														if(chargeDefinitionsList.contains(charge.getChargeDefinition().getName())) {
															Hibernate.initialize(charge.getParentJob());
															jobChargesList.add(charge);
														}
													}
												} else {
													Hibernate.initialize(charge.getParentJob());
													jobChargesList.add(charge);
												}
											}
										}
									}
								}*/
								Hibernate.initialize(job.getParentInvoice());
								jobChargesList.add(job);
							}
						}
					}
					if(employee.getIncludeJobCharges()) {
						boolean checkFlag = false;
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select charge from Invoice as invoice inner join invoice.jobs as job inner join job.charges as charge";
						if(!employee.getAllChargeTypes()) {
							checkFlag = true;
							queryString = queryString + "  where charge.chargeDefinition.name in (:charges)";
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							boolean checkBooleanFlag = false;
							if(employee.getCustomerWant()!=null) {
								if(checkFlag){
									queryString = queryString + " and ";
								} else {
									queryString = queryString + " where ";
								}
								if(employee.getCustomerWant().equals("Due_Today") || employee.getCustomerWant().equals("Due_Tomorrow")) {
									queryString = queryString + " ((to_char(invoice.deliveryIntentDate,'DD/MM/YYYY')=:date or invoice.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_This_Week") || employee.getCustomerWant().equals("Due_Next")){
									queryString = queryString + " ((invoice.deliveryIntentDate between :startdate and :enddate or invoice.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_Any_Time")) {
									queryString = queryString + " ((invoice.deliveryIntentDate is not null or invoice.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								}
							}
							if(employee.getAnyPastDue()) {
								checkFlag = true;
								if(checkBooleanFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString + " (invoice.deliveryIntentDate < :pastdate or invoice.deliveryIntentDate is null)";
								if(checkBooleanFlag) {
									queryString = queryString + ")";
								}
							} else {
								if(checkBooleanFlag) {
									queryString = queryString + ")";
								}
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							queryString = queryString + " (invoice.deliveryIntentDate < :pastdate or invoice.deliveryIntentDate is null) and";
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							if(checkFlag) {
								queryString = queryString + " and charge.productionLocation in (:locations)";
							} else {
								queryString = queryString + " where charge.productionLocation in (:locations)";
							}
						}
						Query query = em.createQuery(queryString);
						if(!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand.getName());
							}
							query.setParameter("charges", chargeDefinitionsList);
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations",employee.getProductionParents());
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							if(employee.getCustomerWant()!=null) {
								if(employee.getCustomerWant().equals("Due_Today")) {
									query.setParameter("date",dateFormat.format(todayDate));
								} else if(employee.getCustomerWant().equals("Due_Tomorrow")) {
									query.setParameter("date",dateFormat.format(tomorrowCalendar.getTime()));
								} else if(employee.getCustomerWant().equals("Due_This_Week")) {
									query.setParameter("startdate",startDateOfThisWeek.getTime());
									query.setParameter("enddate",endDateOfThisWeek.getTime());
								} else if(employee.getCustomerWant().equals("Due_Next")) {
									query.setParameter("startdate",startDateOfNextWeek.getTime());
									query.setParameter("enddate",endDateOfNextWeek.getTime());
								}
							}
							if(employee.getAnyPastDue()) {
								query.setParameter("pastdate",todayDate);
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							query.setParameter("pastdate",todayDate);
						}
						List<Charge> chargesList = query.getResultList();
						for (Charge charge : chargesList) {
							if(charge!=null) {
								Hibernate.initialize(charge.getParentJob().getParentInvoice());
								jobChargesList.add(charge);
							}
						}
					}
					if(employee.getIncludeInvoiceCharges()){
						boolean checkFlag = false;
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select charge from Invoice as invoice inner join invoice.charges as charge";
						if(!employee.getAllChargeTypes()) {
							checkFlag = true;
							queryString = queryString + "  where charge.chargeDefinition.name in (:charges)";
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							boolean checkBooleanFlag = false;
							if(employee.getCustomerWant()!=null) {
								if(checkFlag){
									queryString = queryString + " and ";
								} else {
									queryString = queryString + " where ";
								}
								if(employee.getCustomerWant().equals("Due_Today") || employee.getCustomerWant().equals("Due_Tomorrow")) {
									queryString = queryString + " ((to_char(invoice.deliveryIntentDate,'DD/MM/YYYY')=:date or invoice.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_This_Week") || employee.getCustomerWant().equals("Due_Next")){
									queryString = queryString + " ((invoice.deliveryIntentDate between :startdate and :enddate or invoice.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_Any_Time")) {
									queryString = queryString + " ((invoice.deliveryIntentDate is not null or invoice.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								}
							}
							if(employee.getAnyPastDue()) {
								checkFlag = true;
								if(checkBooleanFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString + " (invoice.deliveryIntentDate < :pastdate or invoice.deliveryIntentDate is null)";
								if(checkBooleanFlag) {
									queryString = queryString + ")";
								}
							} else {
								if(checkBooleanFlag) {
									queryString = queryString + ")";
								}
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							queryString = queryString + " (invoice.deliveryIntentDate < :pastdate or invoice.deliveryIntentDate is null) and";
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							if(checkFlag) {
								queryString = queryString + " and charge.productionLocation in (:locations)";
							} else {
								queryString = queryString + " where charge.productionLocation in (:locations)";
							}
						}
						Query query = em.createQuery(queryString);
						if(!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand.getName());
							}
							query.setParameter("charges", chargeDefinitionsList);
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations",employee.getProductionParents());
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							if(employee.getCustomerWant()!=null) {
								if(employee.getCustomerWant().equals("Due_Today")) {
									query.setParameter("date",dateFormat.format(todayDate));
								} else if(employee.getCustomerWant().equals("Due_Tomorrow")) {
									query.setParameter("date",dateFormat.format(tomorrowCalendar.getTime()));
								} else if(employee.getCustomerWant().equals("Due_This_Week")) {
									query.setParameter("startdate",startDateOfThisWeek.getTime());
									query.setParameter("enddate",endDateOfThisWeek.getTime());
								} else if(employee.getCustomerWant().equals("Due_Next")) {
									query.setParameter("startdate",startDateOfNextWeek.getTime());
									query.setParameter("enddate",endDateOfNextWeek.getTime());
								}
							}
							if(employee.getAnyPastDue()) {
								query.setParameter("pastdate",todayDate);
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							query.setParameter("pastdate",todayDate);
						}
						List<Charge> chargesList = query.getResultList();
						for (Charge charge : chargesList) {
							if(charge!=null) {
								/*if(!employee.getAllChargeTypes()) {
									if(charge.getChargeDefinition()!=null) {
										if(chargeDefinitionsList.contains(charge.getChargeDefinition().getName())) {
											Hibernate.initialize(charge.getParentInvoice());
											jobChargesList.add(charge);
										}
									}
								} else {*/
								Hibernate.initialize(charge.getParentInvoice());
								jobChargesList.add(charge);
								//}
							}
						}
					}
				}
				if(employee.getIncludeEstimate()) {
					if(employee.getIncludeJobs()) {
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select job from Estimate as estimate inner join estimate.jobs as job where";
						if(!employee.getAllPricingMethods()) {
							queryString = queryString + " job.pricingMethod in (:pricingMethods) and";
						}
						if(!employee.getAllCopiers()) {
							queryString = queryString + " job.costingCopier.machineName in (:copiers) and";
						}
						if(!employee.getAllChargeTypes()) {
							//queryString = queryString + " job.costingCopier in (:copiers) and";
						}
						if(!employee.getAllPresses()) {
							queryString = queryString + " job.costingPress.machineName in (:presses) and";
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							queryString = queryString + " job.location in (:locations) and";
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							boolean checkFlag = false;
							if(employee.getCustomerWant()!=null) {
								if(employee.getCustomerWant().equals("Due_Today") || employee.getCustomerWant().equals("Due_Tomorrow")) {
									queryString = queryString + " ((to_char(estimate.deliveryIntentDate,'DD/MM/YYYY')=:date or estimate.deliveryIntentDate is null) ";
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_This_Week") || employee.getCustomerWant().equals("Due_Next")){
									queryString = queryString + " ((estimate.deliveryIntentDate between :startdate and :enddate or estimate.deliveryIntentDate is null) ";
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_Any_Time")) {
									queryString = queryString + " ((estimate.deliveryIntentDate is not null or estimate.deliveryIntentDate is null) ";
									checkFlag = true;
								}
							}
							if(employee.getAnyPastDue()) {
								if(checkFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString + " (estimate.deliveryIntentDate < :pastdate or estimate.deliveryIntentDate is null)";
								if(checkFlag) {
									queryString = queryString + ")";
								}
								queryString = queryString + " and";
							} else {
								if(checkFlag) {
									queryString = queryString + ") and";
								}
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							queryString = queryString + " (estimate.deliveryIntentDate < :pastdate or estimate.deliveryIntentDate is null) and";
						}
						if(employee.getHideNonReleaseProduction() || trackerConsole.getHideItemsNotReleasedToProd()) {
							queryString = queryString + " (job.releasedToProduction=true and job.releasedToProduction is not null)";
						} else {
							queryString = queryString + " ((job.releasedToProduction=true or job.releasedToProduction=false) and job.releasedToProduction is not null)";
						}
						Query query = em.createQuery(queryString);
						if(!employee.getAllPricingMethods()) {
							query.setParameter("pricingMethods", employee.getEmployeePricings());
						}
						if(!employee.getAllCopiers()) {
							List<String> copiersList = new ArrayList<String>();
							for (ProductionCopiers productionCopiers : employee.getEmployeeCopiers()) {
								copiersList.add(productionCopiers.getName());
							}
							query.setParameter("copiers", copiersList);
						}
						if(!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand.getName());
							}
						}
						if(!employee.getAllPresses()) {
							List<String> pressesList = new ArrayList<String>();
							for (ProductionPress productionPress : employee.getEmployeePresses()) {
								pressesList.add(productionPress.getName());
							}
							query.setParameter("presses", pressesList);
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations",employee.getProductionParents());
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							if(employee.getCustomerWant()!=null) {
								if(employee.getCustomerWant().equals("Due_Today")) {
									query.setParameter("date",dateFormat.format(todayDate));
								} else if(employee.getCustomerWant().equals("Due_Tomorrow")) {
									query.setParameter("date",dateFormat.format(tomorrowCalendar.getTime()));
								} else if(employee.getCustomerWant().equals("Due_This_Week")) {
									query.setParameter("startdate",startDateOfThisWeek.getTime());
									query.setParameter("enddate",endDateOfThisWeek.getTime());
								} else if(employee.getCustomerWant().equals("Due_Next")) {
									query.setParameter("startdate",startDateOfNextWeek.getTime());
									query.setParameter("enddate",endDateOfNextWeek.getTime());
								}
							}
							if(employee.getAnyPastDue()) {
								query.setParameter("pastdate",todayDate);
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							query.setParameter("pastdate",todayDate);
						}
						
						List<Job> jobList = query.getResultList();
						for (Job job : jobList) {
							if(job!=null) {
								/*if(employee.getIncludeJobCharges()) {
									if(job.getCharges()!=null && job.getCharges().size()>0) {
										for (Charge charge : job.getCharges()) {
											if(charge!=null) {
												if(!employee.getAllChargeTypes()) {
													if(charge.getChargeDefinition()!=null) {
														if(chargeDefinitionsList.contains(charge.getChargeDefinition().getName())) {
															Hibernate.initialize(charge.getParentJob());
															jobChargesList.add(charge);
														}
													}
												} else {
													Hibernate.initialize(charge.getParentJob());
													jobChargesList.add(charge);
												}
											}
										}
									}
								}*/
								Hibernate.initialize(job.getParentInvoice());
								jobChargesList.add(job);
							}
						}
					}
					if(employee.getIncludeJobCharges()) {
						boolean checkFlag = false;
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select charge from Estimate as estimate inner join estimate.jobs as job inner join job.charges as charge";
						if(!employee.getAllChargeTypes()) {
							checkFlag = true;
							queryString = queryString + "  where charge.chargeDefinition.name in (:charges)";
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							boolean checkBooleanFlag = false;
							if(employee.getCustomerWant()!=null) {
								if(checkFlag){
									queryString = queryString + " and ";
								} else {
									queryString = queryString + " where ";
								}
								if(employee.getCustomerWant().equals("Due_Today") || employee.getCustomerWant().equals("Due_Tomorrow")) {
									queryString = queryString + " ((to_char(estimate.deliveryIntentDate,'DD/MM/YYYY')=:date or estimate.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_This_Week") || employee.getCustomerWant().equals("Due_Next")){
									queryString = queryString + " ((estimate.deliveryIntentDate between :startdate and :enddate or estimate.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_Any_Time")) {
									queryString = queryString + " ((estimate.deliveryIntentDate is not null or estimate.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								}
							}
							if(employee.getAnyPastDue()) {
								checkFlag = true;
								if(checkBooleanFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString + " (estimate.deliveryIntentDate < :pastdate or estimate.deliveryIntentDate is null)";
								if(checkBooleanFlag) {
									queryString = queryString + ")";
								}
							} else {
								if(checkBooleanFlag) {
									queryString = queryString + ")";
								}
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							queryString = queryString + " (estimate.deliveryIntentDate < :pastdate or estimate.deliveryIntentDate is null) and";
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							if(checkFlag) {
								queryString = queryString + " and charge.productionLocation in (:locations)";
							} else {
								queryString = queryString + " where charge.productionLocation in (:locations)";
							}
						}
						Query query = em.createQuery(queryString);
						if(!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand.getName());
							}
							query.setParameter("charges", chargeDefinitionsList);
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations",employee.getProductionParents());
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							if(employee.getCustomerWant()!=null) {
								if(employee.getCustomerWant().equals("Due_Today")) {
									query.setParameter("date",dateFormat.format(todayDate));
								} else if(employee.getCustomerWant().equals("Due_Tomorrow")) {
									query.setParameter("date",dateFormat.format(tomorrowCalendar.getTime()));
								} else if(employee.getCustomerWant().equals("Due_This_Week")) {
									query.setParameter("startdate",startDateOfThisWeek.getTime());
									query.setParameter("enddate",endDateOfThisWeek.getTime());
								} else if(employee.getCustomerWant().equals("Due_Next")) {
									query.setParameter("startdate",startDateOfNextWeek.getTime());
									query.setParameter("enddate",endDateOfNextWeek.getTime());
								}
							}
							if(employee.getAnyPastDue()) {
								query.setParameter("pastdate",todayDate);
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							query.setParameter("pastdate",todayDate);
						}
						List<Charge> chargesList = query.getResultList();
						for (Charge charge : chargesList) {
							if(charge!=null) {
								Hibernate.initialize(charge.getParentJob().getParentInvoice());
								jobChargesList.add(charge);
							}
						}
					}
					if(employee.getIncludeInvoiceCharges()){
						boolean checkFlag = false;
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select charge from Estimate as estimate inner join estimate.charges as charge";
						if(!employee.getAllChargeTypes()) {
							checkFlag = true;
							queryString = queryString + "  where charge.chargeDefinition.name in (:charges)";
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							boolean checkBooleanFlag = false;
							if(employee.getCustomerWant()!=null) {
								if(checkFlag){
									queryString = queryString + " and ";
								} else {
									queryString = queryString + " where ";
								}
								if(employee.getCustomerWant().equals("Due_Today") || employee.getCustomerWant().equals("Due_Tomorrow")) {
									queryString = queryString + " ((to_char(estimate.deliveryIntentDate,'DD/MM/YYYY')=:date or estimate.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_This_Week") || employee.getCustomerWant().equals("Due_Next")){
									queryString = queryString + " ((estimate.deliveryIntentDate between :startdate and :enddate or estimate.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if(employee.getCustomerWant().equals("Due_Any_Time")) {
									queryString = queryString + " ((estimate.deliveryIntentDate is not null or estimate.deliveryIntentDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								}
							}
							if(employee.getAnyPastDue()) {
								checkFlag = true;
								if(checkBooleanFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString + " (estimate.deliveryIntentDate < :pastdate or estimate.deliveryIntentDate is null)";
								if(checkBooleanFlag) {
									queryString = queryString + ")";
								}
							} else {
								if(checkBooleanFlag) {
									queryString = queryString + ")";
								}
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							queryString = queryString + " (estimate.deliveryIntentDate < :pastdate or estimate.deliveryIntentDate is null) and";
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							if(checkFlag) {
								queryString = queryString + " and charge.productionLocation in (:locations)";
							} else {
								queryString = queryString + " where charge.productionLocation in (:locations)";
							}
						}
						Query query = em.createQuery(queryString);
						if(!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand.getName());
							}
							query.setParameter("charges", chargeDefinitionsList);
						}
						if(employee.getOnlyShowProductionParents() || trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations",employee.getProductionParents());
						}
						if(employee.getCustomerWant()!=null || employee.getAnyPastDue()) {
							if(employee.getCustomerWant()!=null) {
								if(employee.getCustomerWant().equals("Due_Today")) {
									query.setParameter("date",dateFormat.format(todayDate));
								} else if(employee.getCustomerWant().equals("Due_Tomorrow")) {
									query.setParameter("date",dateFormat.format(tomorrowCalendar.getTime()));
								} else if(employee.getCustomerWant().equals("Due_This_Week")) {
									query.setParameter("startdate",startDateOfThisWeek.getTime());
									query.setParameter("enddate",endDateOfThisWeek.getTime());
								} else if(employee.getCustomerWant().equals("Due_Next")) {
									query.setParameter("startdate",startDateOfNextWeek.getTime());
									query.setParameter("enddate",endDateOfNextWeek.getTime());
								}
							}
							if(employee.getAnyPastDue()) {
								query.setParameter("pastdate",todayDate);
							}
						} else if(employee.getCustomerWant()==null && employee.getAnyPastDue()) {
							query.setParameter("pastdate",todayDate);
						}
						List<Charge> chargesList = query.getResultList();
						for (Charge charge : chargesList) {
							if(charge!=null) {
								/*if(!employee.getAllChargeTypes()) {
									if(charge.getChargeDefinition()!=null) {
										if(chargeDefinitionsList.contains(charge.getChargeDefinition().getName())) {
											Hibernate.initialize(charge.getParentInvoice());
											jobChargesList.add(charge);
										}
									}
								} else {*/
								Hibernate.initialize(charge.getParentInvoice());
								jobChargesList.add(charge);
								//}
							}
						}
					}
				}
			}
			if (jobChargesList != null)
				log.debug("** Found " + jobChargesList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return jobChargesList; 
	}
	
	/**
	 * This method retrieves incomplete/in-progress Tracker console jobs based on employee and Tracker Console Configuration
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TrackerConsoleJobs> getActiveTrackerConsoleJobsBasedOnEmployeeAndTrackerConsole(Employee employee) throws Exception {
		log.debug("** getActiveTrackerConsoleJobsBasedOnEmployeeAndTrackerConsole called.");
		List<TrackerConsoleJobs> trackerConsoleJobList = new ArrayList<TrackerConsoleJobs>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query findQuery = em.createQuery("from TrackerConsole");
			TrackerConsole trackerConsole =  (TrackerConsole) findQuery.getSingleResult();
			if(trackerConsole!=null && trackerConsole.getProductionFacilities()!=null && trackerConsole.getProductionStations()!=null) {
				Hibernate.initialize(trackerConsole.getSelectedStations());
				boolean checkFlag = true;
				if(trackerConsole.getShowSelectedEmployee() && employee==null) {
					checkFlag = false;
				}
				if(checkFlag){
					String queryString = "from TrackerConsoleJobs where completed=false";
					if(trackerConsole.getShowSelectedEmployee()) {
						queryString = queryString + " and employee = :employee";
					}
					if(!trackerConsole.getShowAllFacilities()){
						queryString = queryString + " and productionFacilities = :productionFacilities";
					}
					if(!trackerConsole.getShowAllStations()) {
						queryString = queryString + " and productionStations in (:selectedStations)";
					}
					Query query = em.createQuery(queryString);
					if(trackerConsole.getShowSelectedEmployee()) {
						query.setParameter("employee", employee);
					}
					if(!trackerConsole.getShowAllFacilities()){
						query.setParameter("productionFacilities", trackerConsole.getProductionFacilities());
					}
					if(!trackerConsole.getShowAllStations()) {
						List<ProductionStations> selectedStations = new ArrayList<ProductionStations>();
						if(trackerConsole.getSelectedStations()!=null){
							selectedStations = trackerConsole.getSelectedStations();
						}
						selectedStations.add(trackerConsole.getProductionStations());
						query.setParameter("selectedStations", selectedStations);
					}
					trackerConsoleJobList = query.getResultList();
					for (TrackerConsoleJobs trackerConsoleJobs : trackerConsoleJobList) {
						Hibernate.initialize(trackerConsoleJobs.getPassesList());
						if(trackerConsoleJobs.getJob()!=null) {
							Hibernate.initialize(trackerConsoleJobs.getJob().getParentInvoice());
						} else if(trackerConsoleJobs.getCharge()!=null) {
							Hibernate.initialize(trackerConsoleJobs.getCharge().getParentInvoice());
							Hibernate.initialize(trackerConsoleJobs.getCharge().getParentJob().getParentInvoice());
						} 
					}
					if (trackerConsoleJobList != null)
						log.debug("** Found " + trackerConsoleJobList.size() + "records:");
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return trackerConsoleJobList;
	}
	
	/**
	 * This method retrieves incomplete/in-progress Tracker console jobs based on employee
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TrackerConsoleJobs> getActiveTrackerConsoleJobsBasedOnEmployee(Employee employee) throws Exception {
		log.debug("** getActiveTrackerConsoleJobsBasedOnEmployee called.");
		List<TrackerConsoleJobs> trackerConsoleJobList = new ArrayList<TrackerConsoleJobs>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createQuery("from TrackerConsoleJobs where completed=false and employee=:employee");
			query.setParameter("employee", employee);
			trackerConsoleJobList = query.getResultList();
			for (TrackerConsoleJobs trackerConsoleJobs : trackerConsoleJobList) {
				Hibernate.initialize(trackerConsoleJobs.getPassesList());
				if(trackerConsoleJobs.getJob()!=null) {
					Hibernate.initialize(trackerConsoleJobs.getJob().getParentInvoice());
				} else if(trackerConsoleJobs.getCharge()!=null) {
					Hibernate.initialize(trackerConsoleJobs.getCharge().getParentInvoice());
					Hibernate.initialize(trackerConsoleJobs.getCharge().getParentJob().getParentInvoice());
				} 
			}
			if (trackerConsoleJobList != null)
				log.debug("** Found " + trackerConsoleJobList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return trackerConsoleJobList;
	}
	
	/**
	 * This method retrieves TrackerConsoleJobs Object based on Id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public TrackerConsoleJobs getTrackerConsoleJobsById(Long id) throws Exception {
		log.debug("** getTrackerConsoleJobsById called.");
		TrackerConsoleJobs trackerConsoleJobs = new TrackerConsoleJobs();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("TrackerConsoleJobs" + ".byId");
			query.setParameter("id", id);
			trackerConsoleJobs = (TrackerConsoleJobs) query.getSingleResult();
			Hibernate.initialize(trackerConsoleJobs.getPassesList());
			if(trackerConsoleJobs.getJob()!=null) {
				Hibernate.initialize(trackerConsoleJobs.getJob().getParentInvoice());
			} else if(trackerConsoleJobs.getCharge()!=null) {
				Hibernate.initialize(trackerConsoleJobs.getCharge().getParentInvoice());
				Hibernate.initialize(trackerConsoleJobs.getCharge().getParentJob());
			} 
			if(trackerConsoleJobs!=null)
				log.debug("** Found TrackerConsoleJJob for Id :"+trackerConsoleJobs.getId()); 
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return trackerConsoleJobs;
	}

	@SuppressWarnings("unchecked")
	public void deleteItem(String className, Long id) {
		log.debug("** deleteObject called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query q = em.createNamedQuery(className + ".byId");
			q.setParameter("id", id);
			ModelBase object = (ModelBase) q.getSingleResult();

			if (object != null) {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				try {
					em.remove(object);
					tx.commit();
					MessageServiceAdapter.sendNotification(MessageTypes.DELETE,
							className, id);
				} catch (Exception e) {
					log.error("** Error: " + e.getMessage());
					tx.rollback();
				}
			}
		} finally {
			log.info("** Closing Entity Manager.");
			em.close();
		}
	}

	public List<?> criteriaQuery(String entityName,
			List<RemoteCriterion> criteria) {
		log.debug("** criteriaQuery called.");
		List<?> resultList = new ArrayList<Object>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			for (RemoteCriterion criterion : criteria) {
				if (criterion instanceof RemoteRestriction) {
					RemoteRestriction remoteRestriction = (RemoteRestriction) criterion;

					DetachedCriteria query = DetachedCriteria
							.forEntityName(entityName);

					String operator = remoteRestriction.getOperator();
					if (operator.equals(RemoteRestriction.eq)) {
						query.add(Restrictions.eq(remoteRestriction
								.getPropertyName(), remoteRestriction
								.getValue()));
					} else if (operator.equals(RemoteRestriction.between)) {
						query.add(Restrictions.between(remoteRestriction
								.getPropertyName(), remoteRestriction.getLow(),
								remoteRestriction.getHigh()));
					} else if (operator.equals(RemoteRestriction.ge)) {
						query.add(Restrictions.ge(remoteRestriction
								.getPropertyName(), remoteRestriction
								.getValue()));
					} else if (operator.equals(RemoteRestriction.gt)) {
						query.add(Restrictions.gt(remoteRestriction
								.getPropertyName(), remoteRestriction
								.getValue()));
					} else if (operator.equals(RemoteRestriction.le)) {
						query.add(Restrictions.le(remoteRestriction
								.getPropertyName(), remoteRestriction
								.getValue()));
					} else if (operator.equals(RemoteRestriction.lt)) {
						query.add(Restrictions.lt(remoteRestriction
								.getPropertyName(), remoteRestriction
								.getValue()));
					} else if (operator.equals(RemoteRestriction.ne)) {
						query.add(Restrictions.ne(remoteRestriction
								.getPropertyName(), remoteRestriction
								.getValue()));
					}
					Session session = (Session) em.getDelegate();
					Transaction tx = session.beginTransaction();
					resultList = query.getExecutableCriteria(session).list();
					tx.commit();

					if (resultList != null) {
						log.debug("** Found " + resultList.size() + "records.");
					}
				}
			}
		} catch (HibernateException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return resultList;
	}

	// static public Session getSession() {
	// if (sharedEntityManager == null)
	// sharedEntityManager = entityManagerFactory.createEntityManager();
	// return (Session) sharedEntityManager.getDelegate();
	//
	// }

	static public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
		// return (Session) em.getDelegate();
	}

	public Object load(Class clazz, long id) {
		Session session = null;
		Object result;
		// session = getSession();
		EntityManager em = getEntityManager();
		session = (Session) em.getDelegate();
		try {
			long tStart = new Date().getTime();
			result = session.get(clazz, id);
			long tEnd = new Date().getTime();
			log.debug("{load()}" + (tEnd - tStart) + "ms  class="
					+ clazz.getName());

		} catch (HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			ex.printStackTrace();
			throw ex;
		} catch (RuntimeException ex) {
			HibernateUtil.rollbackTransaction();
			ex.printStackTrace();
			throw ex;
		} finally {
			em.close();
		}

		return result;
	}

	private static SessionFactory sessionFactory = null;
	public static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
	public static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();

	public static SessionFactory getSessionFactory() throws HibernateException {
		if (sessionFactory == null && entityManagerFactory != null) {
			try {
				// Create the SessionFactory
				sessionFactory = ((HibernateEntityManagerFactory) entityManagerFactory)
						.getSessionFactory();
			} catch (Throwable ex) {
				// Make sure you log the exception, as it might be swallowed
				System.err.println("Initial SessionFactory creation failed."
						+ ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		return sessionFactory;
	}

	public static Session getCurrentSession() throws HibernateException {
		return getCurrentSession(false);
	}

	public static Session getCurrentSession(Boolean forceNewConnection)
			throws HibernateException {
		Session s = null;
		if (!forceNewConnection) {
			s = threadSession.get();
		}

		// Open a new Session, if this Thread has none yet
		if (s == null) {
			s = getSessionFactory().openSession();
			threadSession.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = threadSession.get();
		threadSession.set(null);
		try {
			if (s != null && !s.connection().isClosed())
				s.close();
		} catch (SQLException ex) {
		}
	}

	public static Transaction getTransaction() {
		return threadTransaction.get();
	}

	public static void beginTransaction() {
		Transaction tx = threadTransaction.get();
		if (tx == null) {
			tx = getCurrentSession().beginTransaction();
			threadTransaction.set(tx);
		}
	}

	public static void commitTransaction() {
		Transaction tx = threadTransaction.get();
		try {
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
				tx.commit();
			threadTransaction.set(null);
		} catch (HibernateException ex) {
			rollbackTransaction();
			throw ex;
		}
	}

	public static void rollbackTransaction() {
		Transaction tx = threadTransaction.get();
		threadTransaction.set(null);
		try {
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
				tx.rollback();
			}
		} finally {
			closeSession();
		}

	}
}
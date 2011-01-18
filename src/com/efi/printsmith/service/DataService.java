package com.efi.printsmith.service;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;

import com.efi.printsmith.comparator.InvoiceBaseComparator;
import com.efi.printsmith.data.AccessGroup;
import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.AccountHistoryData;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.Broker;
import com.efi.printsmith.data.Campaigns;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeCategory;
import com.efi.printsmith.data.ChargeCommand;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.ComLink;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.CostCenter;
import com.efi.printsmith.data.CreditCard;
import com.efi.printsmith.data.CreditCardTransactions;
import com.efi.printsmith.data.DataManager;
import com.efi.printsmith.data.DeliveryTicket;
import com.efi.printsmith.data.DeliveryTicketJobs;
import com.efi.printsmith.data.DepositEntry;
import com.efi.printsmith.data.DigitalAsset;
import com.efi.printsmith.data.Dimension;
import com.efi.printsmith.data.Employee;
import com.efi.printsmith.data.Estimate;
import com.efi.printsmith.data.FoldTemplate;
import com.efi.printsmith.data.GenericColors;
import com.efi.printsmith.data.Grade;
import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.StampSchedule;
import com.efi.printsmith.data.Period;
import com.efi.printsmith.data.PickerObject;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PreferencesSequenceValues;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.PriceListBase;
import com.efi.printsmith.data.PriceListElement;
import com.efi.printsmith.data.PriceLogEntry;
import com.efi.printsmith.data.ProductionCopiers;
import com.efi.printsmith.data.ProductionLocations;
import com.efi.printsmith.data.ProductionPress;
import com.efi.printsmith.data.ProductionStations;
import com.efi.printsmith.data.RoutingStepSetUp;
import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.data.SecuritySetup;
import com.efi.printsmith.data.ShippingMethod;
import com.efi.printsmith.data.SpecialInstructions;
import com.efi.printsmith.data.StockClass;
import com.efi.printsmith.data.StockColors;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.StockFinish;
import com.efi.printsmith.data.StockForest;
import com.efi.printsmith.data.StockGrade;
import com.efi.printsmith.data.StockGroup;
import com.efi.printsmith.data.StockOrder;
import com.efi.printsmith.data.StockType;
import com.efi.printsmith.data.Substrate;
import com.efi.printsmith.data.TapeBatch;
import com.efi.printsmith.data.TapeSessionBatch;
import com.efi.printsmith.data.TaxElement;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.TimeCard;
import com.efi.printsmith.data.TrackerConsole;
import com.efi.printsmith.data.TrackerConsoleJobs;
import com.efi.printsmith.data.TrackerManager;
import com.efi.printsmith.data.UnpurchasedMerchandise;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.data.PaperPrice;
import com.efi.printsmith.defaultdata.DefaultDataFactory;
import com.efi.printsmith.messaging.MessageServiceAdapter;
import com.efi.printsmith.messaging.MessageTypes;
import com.efi.printsmith.query.RemoteCriterion;
import com.efi.printsmith.query.RemoteRestriction;


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
						System.out
								.println("Exception caught when creating DataService");
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
		try {
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
		}
		catch (Exception e) {
			log.error(e);
		}
		return retVal;
	}

	public List<?> getAll(String className) throws Exception {
		log.debug("** getAll called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {

			Query findAllQuery = em.createQuery("from " + className
					+ " fetch all properties order by orderby,id");
			resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
			throw e; 
		} finally {
			em.close();
		}
		return resultList;
	}

	public List<?> getUsers(String className) throws Exception {
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
			throw e; 
		} finally {
			em.close();
		}
		return resultList;
	}

	public List<?> getCurrentTaxTables(String className) throws Exception {
		log.debug("** getAll called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findAllQuery = em.createQuery("from " + className
					+ " where taxTableIsCurrent = 'TRUE' and disableTable = 'FALSE' ");
			resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
			throw e; 
		} finally {
			em.close();
		}
		return resultList;
	}

	public List<?> getAllOrderBy(String className, String orderBy) throws Exception {
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
			throw e; 
		} finally {
			em.close();
		}
		return resultList;
	}

	public List<?> getAllOrderByDescending(String className, String orderBy) throws Exception {
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
			throw e; 
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
			throw e; 
		} finally {
			em.close();
		}
	}

	public List<?> getStockPicker() throws Exception {
		log.debug("** getStockPicker.");
		System.out.println(System.currentTimeMillis());
		EntityManager em = entityManagerFactory.createEntityManager();

		List<?> resultList = new ArrayList<Object>();
		String columnStr = new String();

		columnStr = "a.id, a.name, a.weight, a.parentsize, a.color, a.genericColor, a.finish, a.thickness, a.grade, "
				+ "a.cwt1, a.vendor, a.stocknumber, a.onHand, a.committed, a.onOrder, a.shellItem, a.normalRunSize, "
				+ "a.stktype, a.stkgroup, a.coated, a.minorder, a.cost1, a.priceExpires, a.forestManagement, "
				+ "a.pcwRecycledPercent, a.fscCertified, a.sfiCertified, a.greenSealCertified, a.sheetsPerSet, a.uom , a.stockunit, a.standardItem ";
		try {
			String queryString = "select new StockDefinition( "
					+ columnStr
					+ ") from StockDefinition a left outer join a.normalRunSize left outer join a.parentsize";

			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
			System.out.println(System.currentTimeMillis());
		}
	}

	public List<?> getAccountPicker() throws Exception {
		log.debug("** getAccountPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();

		List<?> resultList = new ArrayList<Object>();
		String columnStr = new String();

		columnStr = "a.id, a.title, a.accountId, a.externalRef, a.masterAcct, a.prospect, a.externalAcctId, a.contact ";
		try {
			// String queryString = "select new " + className + "( "
			// + columnstring + ") from " + className + " a where a.id is not
			// null order by title";
			String queryString = "select new Account( "
					+ columnStr
					+ ") from Account a left outer join a.contact order by a.prospect, a.title ";

			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			if (resultList != null) {
				for (int i = 0; i < resultList.size(); i++) {
					Account account = ((Account) (resultList.get(i)));
					
					Contact c = account.getContact();
					if (c != null)
						Hibernate.initialize(c.getComLinks());
					
					if (account.getMasterAcct() != null)	{
						if (account.getMasterAcct() == 0)
							account.setMasterAcct(null);
						else	{
							Account masterAcc = (Account) (getQuery("Account", " where id=" + account.getMasterAcct()));
							if (masterAcc != null)
								account.setMasterAcct(Long.parseLong(masterAcc.getAccountId()));
							else
								account.setMasterAcct(null);
						}
					}
				}
			}
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
						.getGrandTotal().doubleValue(), invoice
						.getOrderedDate(), invoice.getWantedDate(), invoice
						.getProofDate());
				invoiceList.add(resultInvoice);
			}

			if (invoiceList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return invoiceList;
		} catch (Exception e) {
			log.error(e);
			throw e;
		} finally {
			em.close();
		}
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

			// for (int i = 0; i < resultList.size(); i++) {
			// InvoiceBase invoice = resultList.get(i);
			//
			// for (int j = 0; j < invoice.getJobs().size(); j++) {
			// Job job = invoice.getJobs().get(j);
			//
			// if (job == null) {
			// log.error("Null job found in invoice");
			// } else {
			// // if (job.getPricingCopier() != null &&
			// // job.getPricingCopier().getOemDeviceID() != null &&
			// // job.getPricingCopier().getOemDeviceID().length() > 0)
			// // {
			// job.setParentInvoice(invoice);
			// retVal.add(job);
			// // }
			// }
			// }
			// }
			//
			// Session session = (Session) em.getDelegate();
			// List<JobBase> jobs = null;
			// jobs = session.createCriteria(JobBase.class).list();
			// Iterator<JobBase> it = jobs.iterator();
			// List <JobBase> retVal = new ArrayList<JobBase>();

			// TODO: Following code is just plain atrocious - let's get it
			// wrapped into the query above instead of hacking at it like a dead
			// moose
			Iterator<InvoiceBase> it = resultList.iterator();
			while (it.hasNext()) {
				InvoiceBase invoice = it.next();
				List<JobBase> jobs = null;
				jobs = invoice.getJobs();

				Iterator<JobBase> jobIt = jobs.iterator();
				while (jobIt.hasNext()) {
					JobBase job = jobIt.next();
					if (job.getPricingCopier() != null
							&& job.getPricingCopier().getOemDeviceID() != null
							&& job.getPricingCopier().getOemDeviceID().length() > 0) {
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
			
			for (InvoiceBase invoiceBase : invoices) {
				if(invoiceBase.getContact()!=null) {
					Hibernate.initialize(invoiceBase.getContact().getComLinks());
				}
			}
			
			String columnString = "a.id,a.comment,a.location,a.parentInvoice";
			for (InvoiceBase invoiceBase : invoices) {
				List<JobBase> jobsList = new ArrayList<JobBase>();
				String queryString = "select "+columnString+" from JobBase" + " a inner join a.parentInvoice invoice left join a.location location where invoice.id="+invoiceBase.getId();
				org.hibernate.Query query = session.createQuery(queryString);
				ScrollableResults rs = query.scroll();
				while (rs.next()) {
					JobBase jobBase = new JobBase();
					jobBase.setId(rs.getLong(0));
					jobBase.setComment(rs.getString(1));
					jobBase.setLocation((ProductionLocations) rs.get(2));
					jobsList.add(jobBase);
				}
				invoiceBase.setJobs(jobsList);
			}
			Collections.sort(invoices, new InvoiceBaseComparator());
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

	public List<?> getContactPicker() throws Exception {
		log.debug("** getContactPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Object> resultList = new ArrayList<Object>();
		String columnStr = new String();

		columnStr = "a.id, a.firstName, a.lastName, a.contactId, a.parentAccount ";
		try {
			// String queryString = "select new " + className + "( "
			// + columnstring + ") from " + className + " a";
			// String queryString = " from " + className;
			String queryString = "select new Contact( " + columnStr
					+ ") from Contact a left outer join a.parentAccount where (a.tempFlag = false or a.tempFlag = null) ";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();

			if (resultList != null) {
				for (int i = 0; i < resultList.size(); i++) {
					Contact c = (Contact) (resultList.get(i));
					Hibernate.initialize(c.getComLinks());
				}
			}

			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public List<?> getPressPicker() throws Exception {
		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();
		log.debug("** getPressPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();

		columnstring = "a.id, a.name, a.machineID, a.machineName";
		try {
			String queryString = "select new PressDefinition( " + columnstring
					+ ") from PressDefinition a order by a.id";
			Query query = em.createQuery(queryString);
			resultList = query.getResultList();

			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public List<?> getCopierPicker() throws Exception {
		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();

		log.debug("** getCopierPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();

		columnstring = "a.id, a.name, a.copyID, a.machineName, a.blackwhite, a.color, a.largeFormat";
		try {
			String queryString = "select new CopierDefinition( " + columnstring
					+ ") from CopierDefinition a";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public ModelBase getSingle(String className) throws Exception {
		log.debug("** getSingle called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query findQuery = em.createQuery("from " + className);
			ModelBase result = (ModelBase) findQuery.getSingleResult();
			for (Field field : result.getClass().getDeclaredFields()) {
				if (field.getType().getName().equals("java.util.List")
						|| field.getType().getName().equals(
								"java.util.ArrayList")) {
					String propertyName = field.getName().substring(0, 1)
							.toUpperCase()
							+ field.getName().substring(1,
									field.getName().length());
					try {
						Hibernate.initialize(result.getProperty(propertyName));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return result;
		} catch (NoResultException e) {
			log.warn("No result found for getSingle " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getSingle " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public ModelBase getQuery(String className, String where)  throws Exception {
		log.debug("** getQuery called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query findQuery = em.createQuery("from " + className + where);
			ModelBase result = (ModelBase) findQuery.getSingleResult();
			return result;
		} catch (NoResultException e) {
			log.warn("No result found for getQuery " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getQuery " + e);
			return null;
		}catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public List<?> getAllQuery(String className, String where)  throws Exception {
		log.debug("** getQuery called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findQuery = em.createQuery("from " + className + where);
			resultList = findQuery.getResultList();
			return resultList;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}
	
	public ModelBase getByPrevId(String className, String prevId) throws Exception {
		log.debug("** getByPrevId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where prevId = '"
					+ prevId + "'";
			Query query = em.createQuery(queryString);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByPrevId " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByPrevId " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockDefinition getByStockId(String stockId) throws Exception {
		log.debug("** getByStockId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockDefinition where stockId = '"
					+ stockId + "'";
			Query query = em.createQuery(queryString);
			StockDefinition object = (StockDefinition) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockId " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByStockId " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockDefinition getByStockNumber(String stockNumber)  throws Exception {
		log.debug("** getByStockNumber called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockDefinition where stocknumber = '"
					+ stockNumber + "'";
			Query query = em.createQuery(queryString);
			StockDefinition object = (StockDefinition) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockNumber " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByStockNumber " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockType getByStockTypeID(String stocktypeId)  throws Exception {
		log.debug("** getByStocktypeId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockType where viewableID = '"
					+ stocktypeId + "'";
			Query query = em.createQuery(queryString);
			StockType object = (StockType) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockTypeID " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByStockTypeID " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public PressDefinition getByPressId(String pressId)  throws Exception {
		log.debug("** getByPressId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from PressDefinition where pressId = '"
					+ pressId + "'";
			Query query = em.createQuery(queryString);
			PressDefinition object = (PressDefinition) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByPressId " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByPressId " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public Account getByAccountId(String accountId)  throws Exception {
		log.debug("** getByAccountId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Account where accountId = '" + accountId
					+ "'";
			Query query = em.createQuery(queryString);
			Account object = (Account) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByAccountId " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByAccountId " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public AccountHistoryData getAccountHistoryByAccountId(Long Id) throws Exception {
		log.debug("** AccountHistoryData called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {

			String queryString = "select a from AccountHistoryData a where a.account.id = :id";
			Query query = em.createQuery(queryString);
			query.setParameter("id", Id);
			AccountHistoryData object = (AccountHistoryData) query
					.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getAccountHistoryByAccountId " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getAccountHistoryByAccountId " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public List<?> getAccountCustomerLogByAccountId(Long Id)  throws Exception {
		log.debug("** CustomerLogB called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {

			String queryString = "select a from CustomerLog a where a.account.id = :id";
			Query query = em.createQuery(queryString);
			query.setParameter("id", Id);
			List<?> list = query.getResultList();
			if (list != null)
				log.debug("** Found " + list.size() + "records:");
			return list;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public UnpurchasedMerchandise getUnPurchaseByAccountId(Long Id)  throws Exception {
		log.debug("** getBypurchasesAccountId called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {

			String queryString = "select a from UnpurchasedMerchandise a where a.account.id = :id";
			Query query = em.createQuery(queryString);
			query.setParameter("id", Id);
			UnpurchasedMerchandise object = (UnpurchasedMerchandise) query
					.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getUnPurchaseByAccountId " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getUnPurchaseByAccountId " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public ModelBase getByName(String className, String name)  throws Exception {
		log.debug("** getByName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where name = '" + name
					+ "'";
			Query query = em.createQuery(queryString);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public Dimension getByDimensionName(String className, String name)  throws Exception {
		log.debug("** getByName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where name = '" + name
					+ "'";
			Query query = em.createQuery(queryString);
			Dimension object = (Dimension) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByDimensionName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByDimensionName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public ModelBase getByLastFirstName(String className, String namelast,
			String namefirst, long id) throws Exception {
		log.debug("** getByLastFirstName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where lastName = '"
					+ namelast + "' and " + "firstName = '" + namefirst
					+ "' and " + "parentaccount_id = '" + id + "'";
			Query query = em.createQuery(queryString);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByLastFirstName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByLastFirstName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockColors getByStockColorName(String name) throws Exception {
		log.debug("** getBySockColorName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockColors where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockColors object = (StockColors) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockColorName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByStockColorName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockClass getByStockClassName(String name) throws Exception {
		log.debug("** getBySockClassName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockClass where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockClass object = (StockClass) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockClassName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByStockClassName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getBySalesCategoryName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getBySalesCategoryName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockFinish getByStockFinishName(String name) throws Exception {
		log.debug("** getBySockFinishName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockFinish where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockFinish object = (StockFinish) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockFinishName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByStockFinishName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockGroup getByStockGroupName(String name) throws Exception {
		log.debug("** getBySockGroupName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockGroup where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockGroup object = (StockGroup) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockGroupName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByStockGroupName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 		
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockForest getByStockForestName(String name) throws Exception {
		log.debug("** getByStockForestName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockForest where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockForest object = (StockForest) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockForestName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByStockForestName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getByGenericColorsName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByGenericColorsName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public StockGrade getByStockGradeName(String name) throws Exception {
		log.debug("** getByStockGradeName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from StockGrade where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockGrade object = (StockGrade) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByStockGradeName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByStockGradeName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public CostCenter getByCostCenterName(String name) throws Exception {
		log.debug("** getByCostCenterName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from CostCenter where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			CostCenter object = (CostCenter) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByCostCenterName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByCostCenterName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public ProductionLocations getByLocationName(String name) throws Exception {
		log.debug("** getByLocationName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from ProductionLocations where name = '"
					+ name + "'";
			Query query = em.createQuery(queryString);
			ProductionLocations object = (ProductionLocations) query
					.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByLocationName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByLocationName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public PriceList getByPriceListName(String name) throws Exception {
		log.debug("** getByPriceListName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from PriceList where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			PriceList object = (PriceList) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByPriceListName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByPriceListName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getByShippingMethodName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("Too many results found for getByShippingMethodName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public Substrate getBySubstrateName(String name) throws Exception {
		log.debug("** getBySubstrateName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Substrate where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			Substrate object = (Substrate) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getBySubstrateName" + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getBySubstrateName" + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public TaxTable getByTaxTableName(String name) throws Exception {
		log.debug("** getByTaxTableName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from TaxTable where  taxtableiscurrent = true and name = '" + name + "'";
			Query query = em.createQuery(queryString);
			TaxTable object = (TaxTable) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByTaxTableName " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByTaxTableName " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getByMethodType " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByMethodType " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public WasteChart getByWasteChartName(String name) throws Exception {
		log.debug("** getByWasteChartName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from WasteChart where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			WasteChart object = (WasteChart) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByWasteChartName " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByWasteChartName " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getByChargeCommandName " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByChargeCommandName " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getByChargeCategoryName " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByChargeCategoryName " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getByChargeCategoryPrevId " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByChargeCategoryPrevId " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
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
			sequenceValues.setDeliveryTicket(new Long(0));
			sequenceValues.setCharge(new Long(0));
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
		
		// since this is a new account, need to assign contact ids as well
		this.setContactId(account.getContact());
		this.setContactId(account.getBillToContact());
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
		
		if(value==null)
			value = new Long(0);
		
		value++;
		/*boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Job", " where jobNumber = '"
					+ value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}*/
		job.setJobNumber(value.toString());
		sequenceValues.setJob(value);
		this.addUpdate(sequenceValues);
	}
	
	public void setChargeId(Charge charge) throws Exception {
		if (charge.getChargeNumber() != null && charge.getChargeNumber()!=0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getCharge();
		
		if(value==null)
			value = new Long(0);
		
		value++;
		/*boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("Charge", " where chargeNumber = "
					+ value);
			if (modelBase == null)
				goodId = true;
		}*/
		charge.setChargeNumber(Long.parseLong(value.toString()));
		sequenceValues.setCharge(value);
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
			} catch (GenericJDBCException e) {
				System.out.println(e.getSQL());				
				tx.rollback();
				throw e;
			} catch (PersistenceException e) {
				log.error("** Error: " + e.getMessage());
				tx.rollback();
				throw e;
			} catch (Exception e) {
				log.error("** Error: " + e.getMessage());
				tx.rollback();
				throw e;
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
	 * 
	 * @param addUpdateList
	 * @param deleteList
	 * @throws Exception
	 */
	public void addUpdateDeleteList(List<ModelBase> addUpdateList,
			List<ModelBase> deleteList) throws Exception {
		if (deleteList != null && deleteList.size() > 0) {
			for (ModelBase modelBase : deleteList) {
				if (modelBase.getId() != null
						&& modelBase.getId().longValue() != 0) {
					int classNameIndex = modelBase.getClass().getName()
							.lastIndexOf('.') + 1;
					String className = modelBase.getClass().getName()
							.substring(classNameIndex);
					deleteItem(className, modelBase.getId());
				}
			}
		}
		if (addUpdateList != null && addUpdateList.size() > 0) {
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
		List<PickerObject> pickerList = new ArrayList<PickerObject>();
		try {
			Query findAllQuery = em
					.createQuery("from ChargeCommand fetch all properties order by id");
			resultList = findAllQuery.getResultList();
			if (resultList != null) {
				for (ChargeCommand chargeCommand : resultList) {
					List<ChargeCategory> categories = chargeCommand
							.getChildren();
					Collections.sort(categories);
					for (ChargeCategory category : categories) {
						List<ChargeDefinition> charges = category.getChildren();
						Collections.sort(charges);
						for (ChargeDefinition charge : charges) {
							if (charge == null) {
								log.error("null charge found");
							}
						}
					}
				}
				// PickerObject currentChargeCommand = null;
				// for (ChargeCommand chargeCommand : resultList) {
				// currentChargeCommand = new
				// PickerObject(chargeCommand.getName(), chargeCommand.getId());
				// currentChargeCommand.setChildren(new
				// ArrayList<PickerObject>());
				// pickerList.add(currentChargeCommand);
				//					
				// List<ChargeCategory> categories =
				// chargeCommand.getChildren();
				// PickerObject currentChargeCategory = null;
				// for (ChargeCategory category : categories) {
				// currentChargeCategory = new PickerObject(category.getName(),
				// category.getId());
				// currentChargeCategory.setChildren(new
				// ArrayList<PickerObject>());
				// currentChargeCommand.getChildren().add(currentChargeCategory);
				//						
				// List<ChargeDefinition> charges = category.getChildren();
				// PickerObject currentCharge = null;
				// for (ChargeDefinition charge : charges) {
				// currentCharge = new PickerObject(charge.getName(),
				// charge.getId());
				// currentChargeCategory.getChildren().add(currentCharge);
				// }
				// }
				// }

				log.debug("** Found " + resultList.size() + "records:");
			}
		} catch (Exception e) {
						log.error(e); 			throw e; 
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
					job.setCostingCopier((CopierDefinition) this.getById(
							"CopierDefinition", tmpId));
				}
				if (job.getPricingCopier() != null) {
					tmpId = job.getPricingCopier().getId();
					job.setPricingCopier((CopierDefinition) this.getById(
							"CopierDefinition", tmpId));
				}
				if (job.getCostingPress() != null) {
					tmpId = job.getCostingPress().getId();
					job.setCostingPress((PressDefinition) this.getById(
							"PressDefinition", tmpId));
				}
				if (job.getPricingPress() != null) {
					tmpId = job.getPricingPress().getId();
					job.setPricingPress((PressDefinition) this.getById(
							"PressDefinition", tmpId));
				}
				if (job.getParentInvoice() != null) {
					tmpId = job.getParentInvoice().getId();
					job.setParentInvoice((InvoiceBase) this.getById(
							"InvoiceBase", tmpId));
				}
				if (job.getStock() != null) {
					tmpId = job.getStock().getId();
					job.setStock((StockDefinition) this.getById(
							"StockDefinition", tmpId));
				}
				if (job.getSalesCategory() != null) {
					tmpId = job.getSalesCategory().getId();
					job.setSalesCategory((SalesCategory) this.getById("SalesCategory", tmpId));
				}
				
				if (job.getTaxTable() != null ) {
					tmpId = job.getTaxTable().getId();
					job.setTaxTable((TaxTable) this.getById("TaxTable", tmpId));
				}
				if (job.getPress() != null) {
					tmpId = job.getPress().getId();
					job.setPress((PressDefinition) this.getById("PressDefinition", tmpId));
				}

			}
		} catch (NoResultException e) {
			log.warn("No result found for getJob " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getJob " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
						Hibernate.initialize(job.getPricingPress());
						Hibernate.initialize(job.getCostingPress());
						Hibernate.initialize(job.getStock());
						Hibernate.initialize(job.getPricingCopier());
						Hibernate.initialize(job.getCostingCopier());
					}
				}
				if (invoice.getDeposits() != null)	{
					for (int i=0; i<invoice.getDeposits().size(); i++)	{
						DepositEntry de = (DepositEntry) (invoice.getDeposits().get(i));						
					}
				}
				if(invoice.getContact()!=null) {
					Hibernate.initialize(invoice.getContact().getComLinks());
				}
				Hibernate.initialize(invoice.getCharges());
			}
		} catch (NoResultException e) {
			log.warn("No result found for getInvoice " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getInvoice " + e);
			return null;
		} catch (GenericJDBCException e) {
			log.error(e); 			
			log.error(e.getSQL());
			System.out.println(e.getSQL());
			throw e; 
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return invoice;
	}

	public ModelBase saveInvoice(InvoiceBase invoice) throws Exception {
		log.debug("** addUpdateAccount called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		DataService dataService = new DataService();
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
			
			if (invoice.getSpecialInstructions() != null)	{					
				invoice.setSpecialInstructions((SpecialInstructions) this.addUpdate(invoice.getSpecialInstructions()));
			}
			List<JobBase> jobs = invoice.getJobs();
			List<Charge> charges = invoice.getCharges();
			
			if (jobs != null) {
				Iterator<JobBase> jobIter = jobs.iterator();

				while (jobIter.hasNext()) {
					JobBase job = jobIter.next();

					log.info("assigning parentInvoice to job. Invoice: "
							+ invoice.getId() + " Job: " + job.getId());
					//Make sure dimensions are using valid dimension objects
					if (job.getParentSize() != null) {
						Dimension dimension = dataService.getByDimensionName("Dimension", job.getParentSize().getName());
						if (dimension == null && job.getParentSize().getName().equals("") == false) {
							dimension = new Dimension();
							dimension.setName(job.getParentSize().getName());
							dimension.setHeight(job.getParentSize().getHeight());
							dimension.setWidth(job.getParentSize().getWidth());
							dimension = (Dimension)addUpdate(dimension);
						}
						job.setParentSize(dimension);
					}
					if (job.getRunSize() != null) {
						Dimension dimension = dataService.getByDimensionName("Dimension", job.getRunSize().getName());
						if (dimension == null && job.getRunSize().getName().equals("") == false) {
							dimension = new Dimension();
							dimension.setName(job.getRunSize().getName());
							dimension.setHeight(job.getRunSize().getHeight());
							dimension.setWidth(job.getRunSize().getWidth());
							dimension = (Dimension)addUpdate(dimension);
						}
						job.setRunSize(dimension);
					}
					if (job.getFinishSize() != null) {
						Dimension dimension = dataService.getByDimensionName("Dimension", job.getFinishSize().getName());
						if (dimension == null && job.getFinishSize().getName().equals("") == false) {
							dimension = new Dimension();
							dimension.setName(job.getFinishSize().getName());
							dimension.setHeight(job.getFinishSize().getHeight());
							dimension.setWidth(job.getFinishSize().getWidth());
							dimension = (Dimension)addUpdate(dimension);
						}
						job.setFinishSize(dimension);
					}
					if (job.getFoldedSize() != null) {
						Dimension dimension = dataService.getByDimensionName("Dimension", job.getFoldedSize().getName());
						if (dimension == null && job.getFoldedSize().getName().equals("") == false) {
							dimension = new Dimension();
							dimension.setName(job.getFoldedSize().getName());
							dimension.setHeight(job.getFoldedSize().getHeight());
							dimension.setWidth(job.getFoldedSize().getWidth());
							dimension = (Dimension)addUpdate(dimension);
						}
						job.setFoldedSize(dimension);
					}
					job.setParentInvoice(invoice);
				}
			}

			if (charges != null) {
				Iterator<Charge> chargeIter = charges.iterator();

				while (chargeIter.hasNext()) {
					Charge charge = chargeIter.next();

					log.info("assigning parentInvoice to charge. Invoice: "
							+ invoice.getId() + " Charge: " + charge.getId());
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
					
					//Resetting jobNumber in sequencevalues back to 0
					PreferencesSequenceValues sequenceValues = getSequenceValues();
					sequenceValues.setJob(new Long(0));
					addUpdate(sequenceValues);

					while (jobIter.hasNext()) {
						JobBase job = jobIter.next();
						
						log.info("assigning parentInvoice to job. Invoice: "
								+ invoice.getId() + " Job: " + job.getId());
						
						if(job.getCharges()!=null) {
							//Resetting chargeNumber in sequencevalues back to 0
							sequenceValues = getSequenceValues();
							sequenceValues.setCharge(new Long(0));
							addUpdate(sequenceValues);
							Iterator<Charge> chargeIter = job.getCharges().iterator();
							
							while (chargeIter.hasNext()) {
								Charge charge = chargeIter.next();
								//Resetting the chargeNumber in charge back to 0
								charge.setChargeNumber(new Long(0));
								setChargeId(charge);
							}
						}
						
						//Resetting the jobnumber in job back to null
						job.setJobNumber(null);
						job.setParentInvoice(invoice);
						addUpdate(job);
					}
					
				}

				if (charges != null) {
					Iterator<Charge> chargeIter = charges.iterator();

					while (chargeIter.hasNext()) {
						Charge charge = chargeIter.next();

						log.info("assigning parentInvoice to charge. Invoice: "
								+ invoice.getId() + " Charge: "
								+ charge.getId());
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
					ChargeDefinition chargeDefinition = stockDefinition
							.getCharges().get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
			}
		} catch (NoResultException e) {
			log.warn("No result found for getStockDefinition " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getStockDefinition " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
		} catch (NoResultException e) {
			log.warn("No result found for getGrade " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getGrade " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
					ChargeDefinition chargeDefinition = pressDefinition
							.getCharges().get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
			}
		} catch (NoResultException e) {
			log.warn("No result found for getPressDefinition " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getPressDefinition " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
					ChargeDefinition chargeDefinition = account
							.getInvoiceEstimateCharges().get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
				
				for (int i = 0; i < account.getJobCharges().size(); i++) {
					ChargeDefinition chargeDefinition = account.getJobCharges()
							.get(i);
					if (chargeDefinition == null) {
						log.error("null charge found");
					}
				}
				if ( account.getContact() != null){
					for (int i = 0; i < account.getContact().getComLinks().size(); i++) {
						ComLink link = account.getContact().getComLinks().get(i);
						if (link == null) {
							log.error("null charge found");
						}
					}
				}
				if ( account.getBillToContact() != null){
					for (int i = 0; i < account.getBillToContact().getComLinks()
							.size(); i++) {
						ComLink link = account.getBillToContact().getComLinks()
								.get(i);
						if (link == null) {
							log.error("null charge found");
						}
					}
				}
				
			}
		} catch (NoResultException e) {
			log.warn("No result found for getAccount " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getAccount " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
					ChargeDefinition chargeDefinition = copierDefinition
							.getCharges().get(i);
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
		} catch (NoResultException e) {
			log.warn("No result found for getCopierDefinition " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getCopierDefinition " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
		} catch (NoResultException e) {
			log.warn("No result found for getContact " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getContact " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
		} catch (NoResultException e) {
			log.warn("No result found for getTaxTable " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getTaxTable " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
			if (docType.equals("I")) {
				Query findQuery = em
						.createQuery("from Invoice a where a.invoiceNumber = '"
								+ invoiceNumber + "'");
				invoice = (InvoiceBase) findQuery.getSingleResult();
			} else {
				Query findQuery = em
						.createQuery("from Estimate a where a.invoiceNumber = '"
								+ invoiceNumber + "'");
				invoice = (InvoiceBase) findQuery.getSingleResult();
			}

			if (invoice != null) {
				if (invoice.getJobs().size() > 0) {
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
				} else {
					invoice.setJobs(new ArrayList<JobBase>());
				}
				if (invoice.getCharges().size() > 0) {
					for (int i = 0; i < invoice.getCharges().size(); i++) {
						Charge charge = invoice.getCharges().get(i);
						if (charge == null) {
							log.error("null charge found");
						}
					}
				} else {
					invoice.setCharges(new ArrayList<Charge>());
				}
			}
		} catch (NoResultException e) {
			log.warn("No result found for getInvoiceByInvoiceNumber " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getInvoiceByInvoiceNumber " + e);
			return null;
		} catch (GenericJDBCException e) {
			System.out.println(e);
			System.out.println(e.getSQL());
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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
				if (field.getType().getName().equals("java.util.List")
						|| field.getType().getName().equals(
								"java.util.ArrayList")) {
					String propertyName = field.getName().substring(0, 1)
							.toUpperCase()
							+ field.getName().substring(1,
									field.getName().length());
					try {
						Hibernate.initialize(object.getProperty(propertyName));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getById " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getById " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
				Collections.sort(priceList.getElements());
			}
			
			return priceList;
		} catch (NoResultException e) {
			log.warn("No result found for getPriceList " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getPriceList " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public ModelBase getWasteChart(Long id) throws Exception {
		log.debug("** getWasteChart called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("WasteChart.byId");
			query.setParameter("id", id);
			WasteChart priceList = (WasteChart) query.getSingleResult();

			if (priceList.getElements() != null) {
				for (int i = 0; i < priceList.getElements().size(); i++) {
					PriceListElement element = priceList.getElements().get(i);

					if (element == null) {
						log.error("Null priceList element found");
					}
				}
				Collections.sort(priceList.getElements());
			}
			return priceList;
		} catch (NoResultException e) {
			log.warn("No result found for getWasteChart " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getWasteChart " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getEmployee " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getEmployee " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}
	
	public ModelBase getPaperPrice(Long id) throws Exception {
		log.debug("** getPaperPrice called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("PaperPrice.byId");
			query.setParameter("id", id);
			PaperPrice paperPrice = (PaperPrice) query.getSingleResult();

			if (paperPrice.getElements() != null) {
				for (int i = 0; i < paperPrice.getElements().size(); i++) {
					MatrixElement element = paperPrice.getElements().get(i);

					if (element == null) {
						log.error("Null matrix element found");
					}
				}
			}
			return paperPrice;
		} catch (NoResultException e) {
			log.warn("No result found for getMatrix " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getMatrix " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public ModelBase getStampSchedule() throws Exception {
		log.debug("** getPaperPrice called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			//Query query = em.createNamedQuery("PaperPrice.byId");
			//query.setParameter("id", id);
			Query findQuery = em.createQuery("from StampSchedule");
			StampSchedule stampSchedule = (StampSchedule) findQuery.getSingleResult();

			if (stampSchedule.getElements() != null) {
				for (int i = 0; i < stampSchedule.getElements().size(); i++) {
					MatrixElement element = stampSchedule.getElements().get(i);

					if (element == null) {
						log.error("Null matrix element found");
					}
				}
			}
			return stampSchedule;
		} catch (NoResultException e) {
			log.warn("No result found for getMatrix " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getMatrix " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
		} catch (NoResultException e) {
			log.warn("No result found for getMatrix " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getMatrix " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	public ModelBase getByIdMaster(String className, Long id) throws Exception {
		log.debug("** getById called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery(className + ".byId");
			query.setParameter("id", id);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getByIdMaster " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getByIdMaster " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Estimate> getEstimateByAccountId(String className, Long id)
			throws Exception {
		log.debug("** getEstimateByAccountId Id called.");
		List<Estimate> estimateList = new ArrayList<Estimate>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String columnString = "a.id,a.created,a.invoiceNumber,a.name,a.grandTotal,a.convertedInvoiceNo,a.status,a.offPendingDate,a.estimateNotes";
			Session session = (Session) em.getDelegate();
			String queryString = "select "+columnString+" from " + className
					+ " a where a.account.id="+id+" and a.onPendingList=false order by a.created asc";
			org.hibernate.Query query = session.createQuery(queryString);
			ScrollableResults rs = query.scroll();
			while (rs.next()) {
				Estimate estimate = new Estimate();
				estimate.setId(rs.getLong(0));
				estimate.setCreated(rs.getDate(1));
				estimate.setInvoiceNumber(rs.getString(2));
				estimate.setName(rs.getString(3));
				estimate.setGrandTotal(rs.getBigDecimal(4));
				if(rs.getString(5)==null) {
					estimate.setConvertedInvoiceNo("");
				} else {
					estimate.setConvertedInvoiceNo(rs.getString(5));
				}
				estimate.setStatus(rs.getString(6));
				estimate.setOffPendingDate(rs.getDate(7));
				estimate.setEstimateNotes(rs.getString(8));
				estimateList.add(estimate);
			}
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return estimateList;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getContactsByAccountId(String className, Long id)
			throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			log.debug("** getByaccountid Id called.");

			String queryString = "select a from " + className
					+ " a where a.parentAccount.id = :id and (a.tempFlag = false or a.tempFlag = null) order by lastName";

			Query query = em.createQuery(queryString);
			query.setParameter("id", id);
			List<Contact> contactlist = query.getResultList();
			if (contactlist != null) {
				for (int i = 0; i < contactlist.size(); i++) {
					Contact c = (Contact) contactlist.get(i);
					if (c != null)	{
						Hibernate.initialize(c.getComLinks());
						Hibernate.initialize(c.getShipToAddress());
					}
				}
			}
			if (contactlist != null)
				log.debug("** Found " + contactlist.size() + "records:");
			return contactlist;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TimeCard> getByClockInOut(String className, Employee employee)
			throws Exception {
		log.debug("** getByEmployee Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			/*
			 * DateFormat dateFormat = new
			 * java.text.SimpleDateFormat("yyyy-MM-dd"); java.util.Date date =
			 * new java.util.Date();
			 */

			/*
			 * String queryString = "from " + className + " where
			 * to_char(startdatetime,'YYYY-MM-DD') = '" +
			 * dateFormat.format(date).toString() + "' and employee = :employee
			 * and onClock = 1";
			 */
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
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployee(String className,
			Employee employee) throws Exception {
		log.debug("** getByEmployee Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();

			/*
			 * String queryString = "from " + className + " where
			 * to_char(created,'YYYY-MM-DD') = '" +
			 * dateFormat.format(date).toString() + "' and employee =
			 * :employee";
			 */
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
			throw e; 
		} finally {
			em.close();
		}
	}

	/**
	 * This method retrieves Time Cards for Active Period and Employee
	 * 
	 * @param className
	 * @param employee
	 * @param periodNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployeeByActivePeriod(
			String className, Employee employee, int periodNumber)
			throws Exception {
		log.debug("** getByTimeCardByEmployeeByActivePeriod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from "
					+ className
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
			throw e; 
		} finally {
			em.close();
		}
	}

	/**
	 * This method retrieves Time Cards for Close Periods and Employee
	 * 
	 * @param className
	 * @param employee
	 * @param periodNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployeeByClosePeriod(
			String className, Employee employee, List closePeriods)
			throws Exception {
		log.debug("** getByTimeCardByEmployeeByClosePeriod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from "
					+ className
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
			throw e; 
		} finally {
			em.close();
		}
	}

	/**
	 * This method retrieves Time Cards for All Periods and Employee
	 * 
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
			String queryString = "from "
					+ className
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
			throw e; 
		} finally {
			em.close();
		}
	}

	/**
	 * This method retrieves Time Cards for Specific Period and Employee
	 * 
	 * @param className
	 * @param employee
	 * @param periodNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployeeBySpecificPeriod(
			String className, Employee employee, int period) throws Exception {
		log.debug("** getByTimeCardByEmployeeBySpecificPeriod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from "
					+ className
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
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
	}

	/**
	 * This method retrieves Maximum PeriodNumber
	 * 
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
			if (rs.next()) {
				if(rs.getInteger(0)==null) {
					maxPeriod = -1;
				} else {
					maxPeriod = rs.getInteger(0).intValue();
				}
			}
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return maxPeriod;
	}

	/**
	 * This method retrieves all close periods
	 * 
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
			throw e; 
		} finally {
			em.close();
		}
	}

	/**
	 * This method retrieves all periods
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Period> getAllPeriods(String className) throws Exception {
		log.debug("** getAllPeriods called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className
					+ " order by periodnumber desc";
			Query query = em.createQuery(queryString);
			List<Period> periodlist = query.getResultList();
			if (periodlist != null)
				log.debug("** Found " + periodlist.size() + "records:");
			return periodlist;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	/**
	 * This method retrieves List of TimeCards required for Export functionality
	 * 
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
	public List<TimeCard> getEmployeeTimeExports(String orderByField,
			Date fromDate, Date toDate, int periodFrom, int periodTo,
			List selectedEmployeeList) throws Exception {
		log.debug("** getEmployeeTimeExports called.");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from TimeCard tc fetch all properties";
			if (fromDate == null && toDate == null) {
				queryString = queryString + " where period between "
						+ periodFrom + " and " + periodTo;
			} else {
				queryString = queryString + " where (startDateTime between '"
						+ dateFormat.format(fromDate) + "' and '"
						+ dateFormat.format(toDate) + "' "
						+ "or endDateTime between '"
						+ dateFormat.format(fromDate) + "' and '"
						+ dateFormat.format(toDate) + "')";
			}
			queryString = queryString
					+ " and tc.onClock=0 and tc.endDateTime is not null and tc.employee.employeeId in (:employeeIds)";
			queryString = queryString + " order by tc." + orderByField + " asc";
			Query query = em.createQuery(queryString);
			query.setParameter("employeeIds", selectedEmployeeList);
			List<TimeCard> timeCardList = query.getResultList();
			for (TimeCard timeCard : timeCardList) {
				timeCard.setEmployee((Employee) getEmployee(timeCard
						.getEmployee().getId()));
			}
			if (timeCardList != null)
				log.debug("** Found " + timeCardList.size() + "records:");
			return timeCardList;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
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
			throw e; 
		} finally {
			em.close();
		}
	}

	public long getMaxDisplayId(String className) throws Exception {
		log.debug("** getMaxDisplayId called.");
		long maxDisplayId = -1;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Session session = (Session) em.getDelegate();
			String queryString = "select max(displayId) from " + className;
			org.hibernate.Query query = session.createQuery(queryString);
			ScrollableResults rs = query.scroll();
			if (rs != null && rs.next()) {
				if (rs.getLong(0) != null) {
					maxDisplayId = rs.getLong(0).longValue();
				}
			}
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return maxDisplayId;
	}

	@SuppressWarnings("unchecked")
	/**
	 * This method retrieves the list of active employees and inactive employees
	 * who are clocked in
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
			throw e; 
		} finally {
			em.close();
		}
		return activeEmployees;
	}

	/**
	 * This method retrieves list of active employees who are clocked in
	 * 
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
						log.error(e); 			throw e; 
		} finally {
			em.close();
		}
		return clockedInEmployees;
	}

	/**
	 * This method retrieves jobs & charges list based on the employee filtering
	 * 
	 * @param employeeId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ModelBase> getJobsChargesForTrackerByEmployee(long employeeId,
			Date todayDate) throws Exception {
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
			endDateOfThisWeek.add(Calendar.DATE, 8 - todayCalendar
					.get(Calendar.DAY_OF_WEEK));
			startDateOfThisWeek.setTime(endDateOfThisWeek.getTime());
			startDateOfThisWeek.add(Calendar.DATE, -8);
			Calendar startDateOfNextWeek = Calendar.getInstance();
			startDateOfNextWeek.setTime(todayDate);
			startDateOfNextWeek.add(Calendar.DATE, 8 - todayCalendar
					.get(Calendar.DAY_OF_WEEK));
			Calendar endDateOfNextWeek = Calendar.getInstance();
			endDateOfNextWeek.setTime(startDateOfNextWeek.getTime());
			endDateOfNextWeek.add(Calendar.DATE, 8);
			Query findQuery = em.createQuery("from TrackerConsole");
			TrackerConsole trackerConsole = (TrackerConsole) findQuery
					.getSingleResult();
			Hibernate.initialize(trackerConsole.getSelectedStations());
			Query employeeQuery = em.createNamedQuery("Employee.byId");
			employeeQuery.setParameter("id", employeeId);
			Employee employee = (Employee) employeeQuery.getSingleResult();
			if (employee != null) {
				if (employee.getIncludeInvoice()) {
					if (employee.getIncludeJobs()) {
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select job from Invoice as invoice inner join invoice.jobs as job where";
						if (!employee.getAllPricingMethods()) {
							queryString = queryString
									+ " job.pricingMethod in (:pricingMethods) and";
						}
						if (!employee.getAllCopiers()) {
							queryString = queryString
									+ " job.costingCopier.machineName in (:copiers) and";
						}
						if (!employee.getAllChargeTypes()) {
							// queryString = queryString + " job.costingCopier
							// in (:copiers) and";
						}
						if (!employee.getAllPresses()) {
							queryString = queryString
									+ " job.costingPress.machineName in (:presses) and";
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							queryString = queryString
									+ " job.location in (:locations) and";
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							boolean checkFlag = false;
							if (employee.getCustomerWant() != null) {
								if (employee.getCustomerWant().equals(
										"Due_Today")
										|| employee.getCustomerWant().equals(
												"Due_Tomorrow")) {
									queryString = queryString
											+ " ((to_char(invoice.wantedDate,'DD/MM/YYYY')=:date or invoice.wantedDate is null) ";
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")
										|| employee.getCustomerWant().equals(
												"Due_Next")) {
									queryString = queryString
											+ " ((invoice.wantedDate between :startdate and :enddate or invoice.wantedDate is null) ";
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_Any_Time")) {
									queryString = queryString
											+ " ((invoice.wantedDate is not null or invoice.wantedDate is null) ";
									checkFlag = true;
								}
							}
							if (employee.getAnyPastDue()) {
								if (checkFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString
										+ " (invoice.wantedDate < :pastdate or invoice.wantedDate is null)";
								if (checkFlag) {
									queryString = queryString + ")";
								}
								queryString = queryString + " and";
							} else {
								if (checkFlag) {
									queryString = queryString + ") and";
								}
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							queryString = queryString
									+ " (invoice.wantedDate < :pastdate or invoice.wantedDate is null) and";
						}
						if (employee.getHideNonReleaseProduction()
								|| trackerConsole
										.getHideItemsNotReleasedToProd()) {
							queryString = queryString
									+ " (job.releasedToProduction=true and job.releasedToProduction is not null) and";
						} else {
							queryString = queryString
									+ " ((job.releasedToProduction=true or job.releasedToProduction=false) and job.releasedToProduction is not null) and";
						}
						queryString = queryString + " (invoice.completed=false and invoice.readyToPickup=false and invoice.onPendingList=true)";
						queryString = queryString
								+ " order by invoice.invoiceNumber,job.jobNumber asc";

						Query query = em.createQuery(queryString);
						if (!employee.getAllPricingMethods()) {
							query.setParameter("pricingMethods", employee
									.getEmployeePricings());
						}
						if (!employee.getAllCopiers()) {
							List<String> copiersList = new ArrayList<String>();
							for (ProductionCopiers productionCopiers : employee
									.getEmployeeCopiers()) {
								copiersList.add(productionCopiers.getName());
							}
							query.setParameter("copiers", copiersList);
						}
						if (!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee
									.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand
										.getName());
							}
						}
						if (!employee.getAllPresses()) {
							List<String> pressesList = new ArrayList<String>();
							for (ProductionPress productionPress : employee
									.getEmployeePresses()) {
								pressesList.add(productionPress.getName());
							}
							query.setParameter("presses", pressesList);
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations", employee
									.getProductionParents());
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							if (employee.getCustomerWant() != null) {
								if (employee.getCustomerWant().equals(
										"Due_Today")) {
									query.setParameter("date", dateFormat
											.format(todayDate));
								} else if (employee.getCustomerWant().equals(
										"Due_Tomorrow")) {
									query
											.setParameter("date", dateFormat
													.format(tomorrowCalendar
															.getTime()));
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")) {
									query.setParameter("startdate",
											startDateOfThisWeek.getTime());
									query.setParameter("enddate",
											endDateOfThisWeek.getTime());
								} else if (employee.getCustomerWant().equals(
										"Due_Next")) {
									query.setParameter("startdate",
											startDateOfNextWeek.getTime());
									query.setParameter("enddate",
											endDateOfNextWeek.getTime());
								}
							}
							if (employee.getAnyPastDue()) {
								query.setParameter("pastdate", todayDate);
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							query.setParameter("pastdate", todayDate);
						}
						List<Job> jobList = query.getResultList();
						for (Job job : jobList) {
							if (job != null) {
								/*
								 * if(employee.getIncludeJobCharges()) {
								 * if(job.getCharges()!=null &&
								 * job.getCharges().size()>0) { for (Charge
								 * charge : job.getCharges()) { if(charge!=null) {
								 * if(!employee.getAllChargeTypes()) {
								 * if(charge.getChargeDefinition()!=null) {
								 * if(chargeDefinitionsList.contains(charge.getChargeDefinition().getName())) {
								 * Hibernate.initialize(charge.getParentJob());
								 * jobChargesList.add(charge); } } } else {
								 * Hibernate.initialize(charge.getParentJob());
								 * jobChargesList.add(charge); } } } } }
								 */
								Hibernate.initialize(job.getParentInvoice());
								jobChargesList.add(job);
							}
						}
					}
					if (employee.getIncludeJobCharges()) {
						boolean checkFlag = false;
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select charge from Invoice as invoice inner join invoice.jobs as job inner join job.charges as charge";
						if (!employee.getAllChargeTypes()) {
							checkFlag = true;
							queryString = queryString
									+ "  where charge.chargeDefinition.name in (:charges)";
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							boolean checkBooleanFlag = false;
							if (employee.getCustomerWant() != null) {
								if (checkFlag) {
									queryString = queryString + " and ";
								} else {
									queryString = queryString + " where ";
								}
								if (employee.getCustomerWant().equals(
										"Due_Today")
										|| employee.getCustomerWant().equals(
												"Due_Tomorrow")) {
									queryString = queryString
											+ " ((to_char(invoice.wantedDate,'DD/MM/YYYY')=:date or invoice.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")
										|| employee.getCustomerWant().equals(
												"Due_Next")) {
									queryString = queryString
											+ " ((invoice.wantedDate between :startdate and :enddate or invoice.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_Any_Time")) {
									queryString = queryString
											+ " ((invoice.wantedDate is not null or invoice.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								}
							}
							if (employee.getAnyPastDue()) {
								checkFlag = true;
								if (checkBooleanFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString
										+ " (invoice.wantedDate < :pastdate or invoice.wantedDate is null)";
								if (checkBooleanFlag) {
									queryString = queryString + ")";
								}
							} else {
								if (checkBooleanFlag) {
									queryString = queryString + ")";
								}
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							if (checkFlag) {
								queryString = queryString + " and ";
							} else {
								checkFlag = true;
								queryString = queryString + " where ";
							}
							queryString = queryString
									+ " (invoice.wantedDate < :pastdate or invoice.wantedDate is null)";
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							if (checkFlag) {
								queryString = queryString
										+ " and charge.productionLocation in (:locations)";
							} else {
								checkFlag = true;
								queryString = queryString
										+ " where charge.productionLocation in (:locations)";
							}
						}
						if (checkFlag) {
							queryString = queryString + " and (invoice.completed=false and invoice.readyToPickup=false and invoice.onPendingList=true)";
						} else {
							checkFlag = true;
							queryString = queryString + " where (invoice.completed=false and invoice.readyToPickup=false and invoice.onPendingList=true)";
						}
						queryString = queryString
								+ " order by invoice.invoiceNumber asc";
						Query query = em.createQuery(queryString);
						if (!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee
									.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand
										.getName());
							}
							query
									.setParameter("charges",
											chargeDefinitionsList);
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations", employee
									.getProductionParents());
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							if (employee.getCustomerWant() != null) {
								if (employee.getCustomerWant().equals(
										"Due_Today")) {
									query.setParameter("date", dateFormat
											.format(todayDate));
								} else if (employee.getCustomerWant().equals(
										"Due_Tomorrow")) {
									query
											.setParameter("date", dateFormat
													.format(tomorrowCalendar
															.getTime()));
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")) {
									query.setParameter("startdate",
											startDateOfThisWeek.getTime());
									query.setParameter("enddate",
											endDateOfThisWeek.getTime());
								} else if (employee.getCustomerWant().equals(
										"Due_Next")) {
									query.setParameter("startdate",
											startDateOfNextWeek.getTime());
									query.setParameter("enddate",
											endDateOfNextWeek.getTime());
								}
							}
							if (employee.getAnyPastDue()) {
								query.setParameter("pastdate", todayDate);
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							query.setParameter("pastdate", todayDate);
						}
						List<Charge> chargesList = query.getResultList();
						for (Charge charge : chargesList) {
							if (charge != null) {
								Hibernate.initialize(charge.getParentJob()
										.getParentInvoice());
								jobChargesList.add(charge);
							}
						}
					}
					if (employee.getIncludeInvoiceCharges()) {
						boolean checkFlag = false;
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select charge from Invoice as invoice inner join invoice.charges as charge";
						if (!employee.getAllChargeTypes()) {
							checkFlag = true;
							queryString = queryString
									+ "  where charge.chargeDefinition.name in (:charges)";
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							boolean checkBooleanFlag = false;
							if (employee.getCustomerWant() != null) {
								if (checkFlag) {
									queryString = queryString + " and ";
								} else {
									queryString = queryString + " where ";
								}
								if (employee.getCustomerWant().equals(
										"Due_Today")
										|| employee.getCustomerWant().equals(
												"Due_Tomorrow")) {
									queryString = queryString
											+ " ((to_char(invoice.wantedDate,'DD/MM/YYYY')=:date or invoice.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")
										|| employee.getCustomerWant().equals(
												"Due_Next")) {
									queryString = queryString
											+ " ((invoice.wantedDate between :startdate and :enddate or invoice.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_Any_Time")) {
									queryString = queryString
											+ " ((invoice.wantedDate is not null or invoice.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								}
							}
							if (employee.getAnyPastDue()) {
								checkFlag = true;
								if (checkBooleanFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString
										+ " (invoice.wantedDate < :pastdate or invoice.wantedDate is null)";
								if (checkBooleanFlag) {
									queryString = queryString + ")";
								}
							} else {
								if (checkBooleanFlag) {
									queryString = queryString + ")";
								}
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							if (checkFlag) {
								queryString = queryString + " and ";
							} else {
								checkFlag = true;
								queryString = queryString + " where ";
							}
							queryString = queryString
									+ " (invoice.wantedDate < :pastdate or invoice.wantedDate is null)";
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							if (checkFlag) {
								queryString = queryString
										+ " and charge.productionLocation in (:locations)";
							} else {
								checkFlag = true;
								queryString = queryString
										+ " where charge.productionLocation in (:locations)";
							}
						}
						if (employee.getHideNonReleaseProduction()
								|| trackerConsole
										.getHideItemsNotReleasedToProd()) {
							if (checkFlag) {
								queryString = queryString + " and ";
							} else {
								checkFlag = true;
								queryString = queryString + " where ";
							}
							queryString = queryString
									+ " (invoice.releasedToProduction=true and invoice.releasedToProduction is not null)";
						} else {
							if (checkFlag) {
								queryString = queryString + " and ";
							} else {
								checkFlag = true;
								queryString = queryString + " where ";
							}
							queryString = queryString
									+ " ((invoice.releasedToProduction=true or invoice.releasedToProduction=false) and invoice.releasedToProduction is not null)";
						}
						if (checkFlag) {
							queryString = queryString + " and (invoice.completed=false and invoice.readyToPickup=false and invoice.onPendingList=true)";
						} else {
							checkFlag = true;
							queryString = queryString + " where (invoice.completed=false and invoice.readyToPickup=false and invoice.onPendingList=true)";
						}
						queryString = queryString
								+ " order by invoice.invoiceNumber asc";
						Query query = em.createQuery(queryString);
						if (!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee
									.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand
										.getName());
							}
							query
									.setParameter("charges",
											chargeDefinitionsList);
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations", employee
									.getProductionParents());
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							if (employee.getCustomerWant() != null) {
								if (employee.getCustomerWant().equals(
										"Due_Today")) {
									query.setParameter("date", dateFormat
											.format(todayDate));
								} else if (employee.getCustomerWant().equals(
										"Due_Tomorrow")) {
									query
											.setParameter("date", dateFormat
													.format(tomorrowCalendar
															.getTime()));
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")) {
									query.setParameter("startdate",
											startDateOfThisWeek.getTime());
									query.setParameter("enddate",
											endDateOfThisWeek.getTime());
								} else if (employee.getCustomerWant().equals(
										"Due_Next")) {
									query.setParameter("startdate",
											startDateOfNextWeek.getTime());
									query.setParameter("enddate",
											endDateOfNextWeek.getTime());
								}
							}
							if (employee.getAnyPastDue()) {
								query.setParameter("pastdate", todayDate);
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							query.setParameter("pastdate", todayDate);
						}
						List<Charge> chargesList = query.getResultList();
						for (Charge charge : chargesList) {
							if (charge != null) {
								/*
								 * if(!employee.getAllChargeTypes()) {
								 * if(charge.getChargeDefinition()!=null) {
								 * if(chargeDefinitionsList.contains(charge.getChargeDefinition().getName())) {
								 * Hibernate.initialize(charge.getParentInvoice());
								 * jobChargesList.add(charge); } } } else {
								 */
								Hibernate.initialize(charge.getParentInvoice());
								jobChargesList.add(charge);
								// }
							}
						}
					}
				}
				if (employee.getIncludeEstimate()) {
					if (employee.getIncludeJobs()) {
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select job from Estimate as estimate inner join estimate.jobs as job where";
						if (!employee.getAllPricingMethods()) {
							queryString = queryString
									+ " job.pricingMethod in (:pricingMethods) and";
						}
						if (!employee.getAllCopiers()) {
							queryString = queryString
									+ " job.costingCopier.machineName in (:copiers) and";
						}
						if (!employee.getAllChargeTypes()) {
							// queryString = queryString + " job.costingCopier
							// in (:copiers) and";
						}
						if (!employee.getAllPresses()) {
							queryString = queryString
									+ " job.costingPress.machineName in (:presses) and";
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							queryString = queryString
									+ " job.location in (:locations) and";
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							boolean checkFlag = false;
							if (employee.getCustomerWant() != null) {
								if (employee.getCustomerWant().equals(
										"Due_Today")
										|| employee.getCustomerWant().equals(
												"Due_Tomorrow")) {
									queryString = queryString
											+ " ((to_char(estimate.wantedDate,'DD/MM/YYYY')=:date or estimate.wantedDate is null) ";
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")
										|| employee.getCustomerWant().equals(
												"Due_Next")) {
									queryString = queryString
											+ " ((estimate.wantedDate between :startdate and :enddate or estimate.wantedDate is null) ";
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_Any_Time")) {
									queryString = queryString
											+ " ((estimate.wantedDate is not null or estimate.wantedDate is null) ";
									checkFlag = true;
								}
							}
							if (employee.getAnyPastDue()) {
								if (checkFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString
										+ " (estimate.wantedDate < :pastdate or estimate.wantedDate is null)";
								if (checkFlag) {
									queryString = queryString + ")";
								}
								queryString = queryString + " and";
							} else {
								if (checkFlag) {
									queryString = queryString + ") and";
								}
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							queryString = queryString
									+ " (estimate.wantedDate < :pastdate or estimate.wantedDate is null) and";
						}
						if (employee.getHideNonReleaseProduction()
								|| trackerConsole
										.getHideItemsNotReleasedToProd()) {
							queryString = queryString
									+ " (job.releasedToProduction=true and job.releasedToProduction is not null) and";
						} else {
							queryString = queryString
									+ " ((job.releasedToProduction=true or job.releasedToProduction=false) and job.releasedToProduction is not null) and";
						}
						queryString = queryString + " (estimate.completed=false and estimate.readyToPickup=false and estimate.onPendingList=true)";
						queryString = queryString
								+ " order by estimate.invoiceNumber,job.jobNumber asc";
						Query query = em.createQuery(queryString);
						if (!employee.getAllPricingMethods()) {
							query.setParameter("pricingMethods", employee
									.getEmployeePricings());
						}
						if (!employee.getAllCopiers()) {
							List<String> copiersList = new ArrayList<String>();
							for (ProductionCopiers productionCopiers : employee
									.getEmployeeCopiers()) {
								copiersList.add(productionCopiers.getName());
							}
							query.setParameter("copiers", copiersList);
						}
						if (!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee
									.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand
										.getName());
							}
						}
						if (!employee.getAllPresses()) {
							List<String> pressesList = new ArrayList<String>();
							for (ProductionPress productionPress : employee
									.getEmployeePresses()) {
								pressesList.add(productionPress.getName());
							}
							query.setParameter("presses", pressesList);
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations", employee
									.getProductionParents());
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							if (employee.getCustomerWant() != null) {
								if (employee.getCustomerWant().equals(
										"Due_Today")) {
									query.setParameter("date", dateFormat
											.format(todayDate));
								} else if (employee.getCustomerWant().equals(
										"Due_Tomorrow")) {
									query
											.setParameter("date", dateFormat
													.format(tomorrowCalendar
															.getTime()));
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")) {
									query.setParameter("startdate",
											startDateOfThisWeek.getTime());
									query.setParameter("enddate",
											endDateOfThisWeek.getTime());
								} else if (employee.getCustomerWant().equals(
										"Due_Next")) {
									query.setParameter("startdate",
											startDateOfNextWeek.getTime());
									query.setParameter("enddate",
											endDateOfNextWeek.getTime());
								}
							}
							if (employee.getAnyPastDue()) {
								query.setParameter("pastdate", todayDate);
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							query.setParameter("pastdate", todayDate);
						}

						List<Job> jobList = query.getResultList();
						for (Job job : jobList) {
							if (job != null) {
								/*
								 * if(employee.getIncludeJobCharges()) {
								 * if(job.getCharges()!=null &&
								 * job.getCharges().size()>0) { for (Charge
								 * charge : job.getCharges()) { if(charge!=null) {
								 * if(!employee.getAllChargeTypes()) {
								 * if(charge.getChargeDefinition()!=null) {
								 * if(chargeDefinitionsList.contains(charge.getChargeDefinition().getName())) {
								 * Hibernate.initialize(charge.getParentJob());
								 * jobChargesList.add(charge); } } } else {
								 * Hibernate.initialize(charge.getParentJob());
								 * jobChargesList.add(charge); } } } } }
								 */
								Hibernate.initialize(job.getParentInvoice());
								jobChargesList.add(job);
							}
						}
					}
					if (employee.getIncludeJobCharges()) {
						boolean checkFlag = false;
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select charge from Estimate as estimate inner join estimate.jobs as job inner join job.charges as charge";
						if (!employee.getAllChargeTypes()) {
							checkFlag = true;
							queryString = queryString
									+ "  where charge.chargeDefinition.name in (:charges)";
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							boolean checkBooleanFlag = false;
							if (employee.getCustomerWant() != null) {
								if (checkFlag) {
									queryString = queryString + " and ";
								} else {
									queryString = queryString + " where ";
								}
								if (employee.getCustomerWant().equals(
										"Due_Today")
										|| employee.getCustomerWant().equals(
												"Due_Tomorrow")) {
									queryString = queryString
											+ " ((to_char(estimate.wantedDate,'DD/MM/YYYY')=:date or estimate.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")
										|| employee.getCustomerWant().equals(
												"Due_Next")) {
									queryString = queryString
											+ " ((estimate.wantedDate between :startdate and :enddate or estimate.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_Any_Time")) {
									queryString = queryString
											+ " ((estimate.wantedDate is not null or estimate.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								}
							}
							if (employee.getAnyPastDue()) {
								checkFlag = true;
								if (checkBooleanFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString
										+ " (estimate.wantedDate < :pastdate or estimate.wantedDate is null)";
								if (checkBooleanFlag) {
									queryString = queryString + ")";
								}
							} else {
								if (checkBooleanFlag) {
									queryString = queryString + ")";
								}
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							if (checkFlag) {
								queryString = queryString + " and ";
							} else {
								checkFlag = true;
								queryString = queryString + " where ";
							}
							queryString = queryString
									+ " (estimate.wantedDate < :pastdate or estimate.wantedDate is null)";
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							if (checkFlag) {
								queryString = queryString
										+ " and charge.productionLocation in (:locations)";
							} else {
								checkFlag = true;
								queryString = queryString
										+ " where charge.productionLocation in (:locations)";
							}
						}
						if (checkFlag) {
							queryString = queryString + " and (estimate.completed=false and estimate.readyToPickup=false and estimate.onPendingList=true)";
						} else {
							checkFlag = true;
							queryString = queryString + " where (estimate.completed=false and estimate.readyToPickup=false and estimate.onPendingList=true)";
						}
						queryString = queryString
								+ " order by estimate.invoiceNumber asc";
						Query query = em.createQuery(queryString);
						if (!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee
									.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand
										.getName());
							}
							query
									.setParameter("charges",
											chargeDefinitionsList);
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations", employee
									.getProductionParents());
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							if (employee.getCustomerWant() != null) {
								if (employee.getCustomerWant().equals(
										"Due_Today")) {
									query.setParameter("date", dateFormat
											.format(todayDate));
								} else if (employee.getCustomerWant().equals(
										"Due_Tomorrow")) {
									query
											.setParameter("date", dateFormat
													.format(tomorrowCalendar
															.getTime()));
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")) {
									query.setParameter("startdate",
											startDateOfThisWeek.getTime());
									query.setParameter("enddate",
											endDateOfThisWeek.getTime());
								} else if (employee.getCustomerWant().equals(
										"Due_Next")) {
									query.setParameter("startdate",
											startDateOfNextWeek.getTime());
									query.setParameter("enddate",
											endDateOfNextWeek.getTime());
								}
							}
							if (employee.getAnyPastDue()) {
								query.setParameter("pastdate", todayDate);
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							query.setParameter("pastdate", todayDate);
						}
						List<Charge> chargesList = query.getResultList();
						for (Charge charge : chargesList) {
							if (charge != null) {
								Hibernate.initialize(charge.getParentJob()
										.getParentInvoice());
								jobChargesList.add(charge);
							}
						}
					}
					if (employee.getIncludeInvoiceCharges()) {
						boolean checkFlag = false;
						List<String> chargeDefinitionsList = new ArrayList<String>();
						String queryString = "select charge from Estimate as estimate inner join estimate.charges as charge";
						if (!employee.getAllChargeTypes()) {
							checkFlag = true;
							queryString = queryString
									+ "  where charge.chargeDefinition.name in (:charges)";
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							boolean checkBooleanFlag = false;
							if (employee.getCustomerWant() != null) {
								if (checkFlag) {
									queryString = queryString + " and ";
								} else {
									queryString = queryString + " where ";
								}
								if (employee.getCustomerWant().equals(
										"Due_Today")
										|| employee.getCustomerWant().equals(
												"Due_Tomorrow")) {
									queryString = queryString
											+ " ((to_char(estimate.wantedDate,'DD/MM/YYYY')=:date or estimate.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")
										|| employee.getCustomerWant().equals(
												"Due_Next")) {
									queryString = queryString
											+ " ((estimate.wantedDate between :startdate and :enddate or estimate.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								} else if (employee.getCustomerWant().equals(
										"Due_Any_Time")) {
									queryString = queryString
											+ " ((estimate.wantedDate is not null or estimate.wantedDate is null) ";
									checkBooleanFlag = true;
									checkFlag = true;
								}
							}
							if (employee.getAnyPastDue()) {
								checkFlag = true;
								if (checkBooleanFlag) {
									queryString = queryString + " or";
								}
								queryString = queryString
										+ " (estimate.wantedDate < :pastdate or estimate.wantedDate is null)";
								if (checkBooleanFlag) {
									queryString = queryString + ")";
								}
							} else {
								if (checkBooleanFlag) {
									queryString = queryString + ")";
								}
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							if (checkFlag) {
								queryString = queryString + " and ";
							} else {
								checkFlag = true;
								queryString = queryString + " where ";
							}
							queryString = queryString
									+ " (estimate.wantedDate < :pastdate or estimate.wantedDate is null)";
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							if (checkFlag) {
								queryString = queryString
										+ " and charge.productionLocation in (:locations)";
							} else {
								checkFlag = true;
								queryString = queryString
										+ " where charge.productionLocation in (:locations)";
							}
						}
						if (employee.getHideNonReleaseProduction()
								|| trackerConsole
										.getHideItemsNotReleasedToProd()) {
							if (checkFlag) {
								queryString = queryString + " and ";
							} else {
								checkFlag = true;
								queryString = queryString + " where ";
							}
							queryString = queryString
									+ " (estimate.releasedToProduction=true and estimate.releasedToProduction is not null)";
						} else {
							if (checkFlag) {
								queryString = queryString + " and ";
							} else {
								checkFlag = true;
								queryString = queryString + " where ";
							}
							queryString = queryString
									+ " ((estimate.releasedToProduction=true or estimate.releasedToProduction=false) and estimate.releasedToProduction is not null)";
						}
						if (checkFlag) {
							queryString = queryString + " and (estimate.completed=false and estimate.readyToPickup=false and estimate.onPendingList=true)";
						} else {
							checkFlag = true;
							queryString = queryString + " where (estimate.completed=false and estimate.readyToPickup=false and estimate.onPendingList=true)";
						}
						queryString = queryString
								+ " order by estimate.invoiceNumber asc";
						Query query = em.createQuery(queryString);
						if (!employee.getAllChargeTypes()) {
							chargeDefinitionsList = new ArrayList<String>();
							for (ChargeCommand chargeCommand : employee
									.getEmployeeCharges()) {
								chargeDefinitionsList.add(chargeCommand
										.getName());
							}
							query
									.setParameter("charges",
											chargeDefinitionsList);
						}
						if (employee.getOnlyShowProductionParents()
								|| trackerConsole.getShowEmployeeProdParents()) {
							query.setParameter("locations", employee
									.getProductionParents());
						}
						if (employee.getCustomerWant() != null
								|| employee.getAnyPastDue()) {
							if (employee.getCustomerWant() != null) {
								if (employee.getCustomerWant().equals(
										"Due_Today")) {
									query.setParameter("date", dateFormat
											.format(todayDate));
								} else if (employee.getCustomerWant().equals(
										"Due_Tomorrow")) {
									query
											.setParameter("date", dateFormat
													.format(tomorrowCalendar
															.getTime()));
								} else if (employee.getCustomerWant().equals(
										"Due_This_Week")) {
									query.setParameter("startdate",
											startDateOfThisWeek.getTime());
									query.setParameter("enddate",
											endDateOfThisWeek.getTime());
								} else if (employee.getCustomerWant().equals(
										"Due_Next")) {
									query.setParameter("startdate",
											startDateOfNextWeek.getTime());
									query.setParameter("enddate",
											endDateOfNextWeek.getTime());
								}
							}
							if (employee.getAnyPastDue()) {
								query.setParameter("pastdate", todayDate);
							}
						} else if (employee.getCustomerWant() == null
								&& employee.getAnyPastDue()) {
							query.setParameter("pastdate", todayDate);
						}
						List<Charge> chargesList = query.getResultList();
						for (Charge charge : chargesList) {
							if (charge != null) {
								/*
								 * if(!employee.getAllChargeTypes()) {
								 * if(charge.getChargeDefinition()!=null) {
								 * if(chargeDefinitionsList.contains(charge.getChargeDefinition().getName())) {
								 * Hibernate.initialize(charge.getParentInvoice());
								 * jobChargesList.add(charge); } } } else {
								 */
								Hibernate.initialize(charge.getParentInvoice());
								jobChargesList.add(charge);
								// }
							}
						}
					}
				}
			}
			if (jobChargesList != null)
				log.debug("** Found " + jobChargesList.size() + "records:");
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return jobChargesList;
	}

	/**
	 * This method retrieves incomplete/in-progress Tracker console jobs based
	 * on employee and Tracker Console Configuration
	 * 
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TrackerConsoleJobs> getActiveTrackerConsoleJobsBasedOnEmployeeAndTrackerConsole(
			Employee employee) throws Exception {
		log
				.debug("** getActiveTrackerConsoleJobsBasedOnEmployeeAndTrackerConsole called.");
		List<TrackerConsoleJobs> trackerConsoleJobList = new ArrayList<TrackerConsoleJobs>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query findQuery = em.createQuery("from TrackerConsole");
			TrackerConsole trackerConsole = (TrackerConsole) findQuery
					.getSingleResult();
			if (trackerConsole != null
					&& trackerConsole.getProductionFacilities() != null
					&& trackerConsole.getProductionStations() != null) {
				Hibernate.initialize(trackerConsole.getSelectedStations());
				boolean checkFlag = true;
				if (trackerConsole.getShowSelectedEmployee()
						&& employee == null) {
					checkFlag = false;
				}
				if (checkFlag) {
					String queryString = "from TrackerConsoleJobs where completed=false and canceled=false";
					if (trackerConsole.getShowSelectedEmployee()) {
						queryString = queryString + " and employee = :employee";
					}
					if (!trackerConsole.getShowAllFacilities()) {
						queryString = queryString
								+ " and productionFacilities = :productionFacilities";
					}
					if (!trackerConsole.getShowAllStations()) {
						queryString = queryString
								+ " and productionStations in (:selectedStations)";
					}
					queryString = queryString
							+ " order by employee.lastName,employee.firstName,id asc";
					Query query = em.createQuery(queryString);
					if (trackerConsole.getShowSelectedEmployee()) {
						query.setParameter("employee", employee);
					}
					if (!trackerConsole.getShowAllFacilities()) {
						query.setParameter("productionFacilities",
								trackerConsole.getProductionFacilities());
					}
					if (!trackerConsole.getShowAllStations()) {
						List<ProductionStations> selectedStations = new ArrayList<ProductionStations>();
						if (trackerConsole.getSelectedStations() != null) {
							selectedStations = trackerConsole
									.getSelectedStations();
						}
						selectedStations.add(trackerConsole
								.getProductionStations());
						query
								.setParameter("selectedStations",
										selectedStations);
					}
					trackerConsoleJobList = query.getResultList();
					for (TrackerConsoleJobs trackerConsoleJobs : trackerConsoleJobList) {
						Hibernate
								.initialize(trackerConsoleJobs.getPassesList());
						if (trackerConsoleJobs.getJob() != null) {
							Hibernate.initialize(trackerConsoleJobs.getJob()
									.getParentInvoice());
						} else if (trackerConsoleJobs.getCharge() != null) {
							Hibernate.initialize(trackerConsoleJobs.getCharge()
									.getParentInvoice());
							Hibernate.initialize(trackerConsoleJobs.getCharge()
									.getParentJob().getParentInvoice());
						}
					}
					if (trackerConsoleJobList != null)
						log.debug("** Found " + trackerConsoleJobList.size()
								+ "records:");
				}
			}
		} catch (NoResultException e) {
			log.warn("No result found for getActiveTrackerConsoleJobsBasedOnEmployeeAndTrackerConsole " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getActiveTrackerConsoleJobsBasedOnEmployeeAndTrackerConsole " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return trackerConsoleJobList;
	}

	/**
	 * This method retrieves incomplete/in-progress Tracker console jobs based
	 * on employee
	 * 
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TrackerConsoleJobs> getActiveTrackerConsoleJobsBasedOnEmployee(
			Employee employee) throws Exception {
		log.debug("** getActiveTrackerConsoleJobsBasedOnEmployee called.");
		List<TrackerConsoleJobs> trackerConsoleJobList = new ArrayList<TrackerConsoleJobs>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em
					.createQuery("from TrackerConsoleJobs where completed=false and canceled=false and employee=:employee");
			query.setParameter("employee", employee);
			trackerConsoleJobList = query.getResultList();
			for (TrackerConsoleJobs trackerConsoleJobs : trackerConsoleJobList) {
				Hibernate.initialize(trackerConsoleJobs.getPassesList());
				if (trackerConsoleJobs.getJob() != null) {
					Hibernate.initialize(trackerConsoleJobs.getJob()
							.getParentInvoice());
				} else if (trackerConsoleJobs.getCharge() != null) {
					Hibernate.initialize(trackerConsoleJobs.getCharge()
							.getParentInvoice());
					Hibernate.initialize(trackerConsoleJobs.getCharge()
							.getParentJob().getParentInvoice());
				}
			}
			if (trackerConsoleJobList != null)
				log.debug("** Found " + trackerConsoleJobList.size()
						+ "records:");
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return trackerConsoleJobList;
	}

	/**
	 * This method retrieves TrackerConsoleJobs Object based on Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public TrackerConsoleJobs getTrackerConsoleJobsById(Long id)
			throws Exception {
		log.debug("** getTrackerConsoleJobsById called.");
		TrackerConsoleJobs trackerConsoleJobs = new TrackerConsoleJobs();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("TrackerConsoleJobs" + ".byId");
			query.setParameter("id", id);
			trackerConsoleJobs = (TrackerConsoleJobs) query.getSingleResult();
			Hibernate.initialize(trackerConsoleJobs.getPassesList());
			if (trackerConsoleJobs.getJob() != null) {
				Hibernate.initialize(trackerConsoleJobs.getJob().getCharges());
				Hibernate.initialize(trackerConsoleJobs.getJob().getParentInvoice());
				Hibernate.initialize(trackerConsoleJobs.getJob().getPricingPress());
				Hibernate.initialize(trackerConsoleJobs.getJob().getCostingPress());
				Hibernate.initialize(trackerConsoleJobs.getJob().getStock());
				Hibernate.initialize(trackerConsoleJobs.getJob().getPricingCopier());
				Hibernate.initialize(trackerConsoleJobs.getJob().getCostingCopier());
			} else if (trackerConsoleJobs.getCharge() != null) {
				Hibernate.initialize(trackerConsoleJobs.getCharge()
						.getParentInvoice());
				Hibernate.initialize(trackerConsoleJobs.getCharge()
						.getParentJob().getParentInvoice());
			}
			if (trackerConsoleJobs != null)
				log.debug("** Found TrackerConsoleJJob for Id :"
						+ trackerConsoleJobs.getId());
		} catch (NoResultException e) {
			log.warn("No result found for getTrackerConsoleJobsById " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getTrackerConsoleJobsById " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return trackerConsoleJobs;
	}

	/**
	 * This method retrieves List of active jobs and charges based on
	 * TrackerManager configuration
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TrackerConsoleJobs> getActiveJobsForTrackerMgr()
			throws Exception {
		log.debug("** getActiveJobsForTrackerMgr called.");
		List<TrackerConsoleJobs> jobsList = new ArrayList<TrackerConsoleJobs>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query findQuery = em.createQuery("from TrackerManager");
			TrackerManager trackerManager = (TrackerManager) findQuery
					.getSingleResult();
			if (trackerManager != null) {
				String queryString = "from TrackerConsoleJobs where completed=false and canceled=false";
				if (!trackerManager.getShowAllFacilities()) {
					queryString = queryString
							+ " and productionFacilities = :productionFacilities";
				}
				if (!trackerManager.getShowAllStations()) {
					queryString = queryString
							+ " and productionStations in (:selectedStations)";
				}
				Query query = em.createQuery(queryString);
				if (!trackerManager.getShowAllFacilities()) {
					query.setParameter("productionFacilities", trackerManager
							.getProductionFacilities());
				}
				if (!trackerManager.getShowAllStations()) {
					List<ProductionStations> selectedStations = new ArrayList<ProductionStations>();
					if (trackerManager.getSelectedStations() != null) {
						selectedStations = trackerManager.getSelectedStations();
					}
					query.setParameter("selectedStations", selectedStations);
				}
				jobsList = query.getResultList();
				if (jobsList != null) {
					for (TrackerConsoleJobs trackerConsoleJobs : jobsList) {
						Hibernate
								.initialize(trackerConsoleJobs.getPassesList());
						if (trackerConsoleJobs.getJob() != null) {
							Hibernate.initialize(trackerConsoleJobs.getJob()
									.getParentInvoice());
						} else if (trackerConsoleJobs.getCharge() != null) {
							Hibernate.initialize(trackerConsoleJobs.getCharge()
									.getParentInvoice());
							Hibernate.initialize(trackerConsoleJobs.getCharge()
									.getParentJob().getParentInvoice());
						}
					}
				}
			}
			if (jobsList != null)
				log.debug("** Found " + jobsList.size() + "records:");
		} catch (NoResultException e) {
			log.warn("No result found for getActiveJobsForTrackerMgr " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getActiveJobsForTrackerMgr " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return jobsList;
	}

	/**
	 * Retrieves List of completed Jobs/Charges for Production and Employee
	 * Tracker Report
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TrackerConsoleJobs> getProductionEmployeeTrackerJobs(
			Date fromDate, Date toDate) throws Exception {
		log.debug("** getActiveJobsForTrackerMgr called.");
		List<TrackerConsoleJobs> jobsList = new ArrayList<TrackerConsoleJobs>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from TrackerConsoleJobs where completed=true and completedDate between :fromDate and :toDate order by completedDate desc";
			Query query = em.createQuery(queryString);
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
			jobsList = query.getResultList();
			if (jobsList != null) {
				for (TrackerConsoleJobs trackerConsoleJobs : jobsList) {
					Hibernate.initialize(trackerConsoleJobs.getPassesList());
					if (trackerConsoleJobs.getJob() != null) {
						Hibernate.initialize(trackerConsoleJobs.getJob()
								.getParentInvoice());
					} else if (trackerConsoleJobs.getCharge() != null) {
						Hibernate.initialize(trackerConsoleJobs.getCharge()
								.getParentInvoice());
						Hibernate.initialize(trackerConsoleJobs.getCharge()
								.getParentJob().getParentInvoice());
					}
				}
			}
			if (jobsList != null)
				log.debug("** Found " + jobsList.size() + "records:");
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return jobsList;
	}

	/**
	 * This method retrieves number of records in RouteStepSetUp table
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public Long getRouteStepSetUpCount(String className) throws Exception {
		log.debug("** getMaxRouteStepSetUpId called.");
		Long routeStepSetUpCount = 0L;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Session session = (Session) em.getDelegate();
			String queryString = "select count(*) from " + className
					+ " where routeData = true";
			org.hibernate.Query query = session.createQuery(queryString);
			ScrollableResults rs = query.scroll();
			if (rs.next()) {
				routeStepSetUpCount = rs.getLong(0);
			}
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return routeStepSetUpCount;
	}

	/**
	 * This method retrieves RoutingStepSetUp List which orders accordingly
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RoutingStepSetUp> getRoutingStepSetUpList() throws Exception {
		log.debug("** getRoutingStepSetUpList called.");
		List<RoutingStepSetUp> routingStepSetUpList = new ArrayList<RoutingStepSetUp>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from RoutingStepSetUp where routeData=true order by id asc";
			Query query = em.createQuery(queryString);
			List<RoutingStepSetUp> routingSetUpList = query.getResultList();
			if (routingSetUpList != null) {
				for (RoutingStepSetUp routingStepSetUp : routingSetUpList) {
					routingStepSetUpList.add(routingStepSetUp);
					queryString = "from RoutingStepSetUp where routeData=false and parentRoute=:parentRoute order by id asc";
					query = em.createQuery(queryString);
					query.setParameter("parentRoute", routingStepSetUp);
					List<RoutingStepSetUp> stepSetUpList = query
							.getResultList();
					if (stepSetUpList != null) {
						for (RoutingStepSetUp routingStepSetUpObj : stepSetUpList) {
							routingStepSetUpList.add(routingStepSetUpObj);
						}
					}
				}
			}
			if (routingStepSetUpList != null)
				log.debug("** Found " + routingStepSetUpList.size()
						+ "records:");
		} catch (Exception e) {
						log.error(e); 			throw e; 
		} finally {
			em.close();
		}
		return routingStepSetUpList;
	}

	/**
	 * This method retrieves TrackerConsoleJobsList for Tracker History screen
	 * for an Invoice
	 * 
	 * @param invoiceId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TrackerConsoleJobs> getTrackerJobsForTrackerStatus(
			Long invoiceId) throws Exception {
		log.debug("** getTrackerJobsForTrackerStatus called.");
		List<TrackerConsoleJobs> trackerConsoleJobsList = new ArrayList<TrackerConsoleJobs>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "select tcJobs from TrackerConsoleJobs as tcJobs inner join tcJobs.job as tcjob inner join tcjob.parentInvoice as invoice where invoice.id=:invoiceId";
			Query query = em.createQuery(queryString);
			query.setParameter("invoiceId", invoiceId);
			for (Object object : query.getResultList()) {
				TrackerConsoleJobs trackerConsoleJobs = (TrackerConsoleJobs) object;
				if (trackerConsoleJobs != null) {
					Hibernate.initialize(trackerConsoleJobs.getPassesList());
					Hibernate.initialize(trackerConsoleJobs.getJob()
							.getParentInvoice());
					trackerConsoleJobsList.add(trackerConsoleJobs);
				}
			}
			queryString = "select tcJobs from TrackerConsoleJobs as tcJobs inner join fetch tcJobs.charge as charge inner join charge.parentJob as chargeJob inner join chargeJob.parentInvoice as invoice where invoice.id=:invoiceId";
			query = em.createQuery(queryString);
			query.setParameter("invoiceId", invoiceId);
			for (Object object : query.getResultList()) {
				TrackerConsoleJobs trackerConsoleJobs = (TrackerConsoleJobs) object;
				if (trackerConsoleJobs != null) {
					Hibernate.initialize(trackerConsoleJobs.getPassesList());
					Hibernate.initialize(trackerConsoleJobs.getCharge()
							.getParentJob().getParentInvoice());
					trackerConsoleJobsList.add(trackerConsoleJobs);
				}
			}
			queryString = "select tcJobs from TrackerConsoleJobs as tcJobs inner join fetch tcJobs.charge as charge inner join charge.parentInvoice as invoice where invoice.id=:invoiceId";
			query = em.createQuery(queryString);
			query.setParameter("invoiceId", invoiceId);
			for (Object object : query.getResultList()) {
				TrackerConsoleJobs trackerConsoleJobs = (TrackerConsoleJobs) object;
				if (trackerConsoleJobs != null) {
					Hibernate.initialize(trackerConsoleJobs.getJob()
							.getParentInvoice());
					Hibernate.initialize(trackerConsoleJobs.getPassesList());
					trackerConsoleJobsList.add(trackerConsoleJobs);
				}
			}
			if (trackerConsoleJobsList != null)
				log.debug("** Found " + trackerConsoleJobsList.size()
						+ "records:");
		} catch (Exception e) {
						log.error(e); 			throw e; 
		} finally {
			em.close();
		}
		return trackerConsoleJobsList;
	}

	/**
	 * Retrieves Total Estimated Time based on Invoice
	 * 
	 * @param invoiceId
	 * @return
	 * @throws Exception
	 */
	public Double getTotalEstimatedTimeForInvoice(Long invoiceId)
			throws Exception {
		Double totalEstimatedTime = 0D;
		log.debug("** getTotalEstimatedTimeForInvoice called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from InvoiceBase where id=:invoiceId";
			Query query = em.createQuery(queryString);
			query.setParameter("invoiceId", invoiceId);
			InvoiceBase invoiceBase = (InvoiceBase) query.getSingleResult();
			if (invoiceBase != null) {
				if (invoiceBase.getJobs() != null
						&& invoiceBase.getJobs().size() > 0) {
					for (JobBase jobBase : invoiceBase.getJobs()) {
						if (jobBase.getSetupTime() != null) {
							totalEstimatedTime = totalEstimatedTime
									+ jobBase.getSetupTime();
						}
						if (jobBase.getRunTime() != null) {
							totalEstimatedTime = totalEstimatedTime
									+ jobBase.getRunTime();
						}
						if (jobBase.getWashupTime() != null) {
							totalEstimatedTime = totalEstimatedTime
									+ jobBase.getWashupTime();
						}
						if (jobBase.getCharges() != null
								&& jobBase.getCharges().size() > 0) {
							for (Charge charge : jobBase.getCharges()) {
								if (charge.getChargeCostingRecord() != null) {
									if (charge.getChargeCostingRecord()
											.getSetupTime() != null) {
										totalEstimatedTime = totalEstimatedTime
												+ charge
														.getChargeCostingRecord()
														.getSetupTime();
									}
									if (charge.getChargeCostingRecord()
											.getRunTime() != null) {
										totalEstimatedTime = totalEstimatedTime
												+ charge
														.getChargeCostingRecord()
														.getRunTime();
									}
								}
							}
						}
					}
				}
				if (invoiceBase.getCharges() != null
						&& invoiceBase.getCharges().size() > 0) {
					for (Charge charge : invoiceBase.getCharges()) {
						if (charge.getChargeCostingRecord() != null) {
							if (charge.getChargeCostingRecord().getSetupTime() != null) {
								totalEstimatedTime = totalEstimatedTime
										+ charge.getChargeCostingRecord()
												.getSetupTime();
							}
							if (charge.getChargeCostingRecord().getRunTime() != null) {
								totalEstimatedTime = totalEstimatedTime
										+ charge.getChargeCostingRecord()
												.getRunTime();
							}
						}
					}
				}
			}
		} catch (NoResultException e) {
			log.warn("No result found for getTotalEstimatedTimeForInvoice " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getTotalEstimatedTimeForInvoice " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return totalEstimatedTime;
	}

	@SuppressWarnings("unchecked")
	public void deleteItem(String className, Long id) throws Exception {
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
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			log.info("** Closing Entity Manager.");
			em.close();
		}
	}

	public List<?> criteriaQuery(String entityName,
			List<RemoteCriterion> criteria) throws Exception {
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
			throw e; 
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
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

	@SuppressWarnings("unchecked")
	public List<?> getPendingCreditCardTransations() throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Session session = (Session) em.getDelegate();
			List<CreditCardTransactions> ccTrans = null;
			ccTrans = session.createCriteria(CreditCardTransactions.class).add(
					Restrictions.eq("isCurrentTransaction", 1)).list();
			return ccTrans;
		} catch (Exception e) {
			log.error(e);
			throw e;
		} finally {
			em.close();
		}
	}

	public CreditCardTransactions getCCTbyReferenceNumber(String ref)
			throws Exception {
		log.debug("** getCCTbyReferenceNumber called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			/*
			 * The search is for a transaction which is for a CHARGE and its
			 * status is COMPLETE and the reference number is a match
			 */
			String queryString = "from CreditCardTransactions where TransactionType = 2 and TransactionStatus = 2 and referenceNumber = '"
					+ ref + "'";
			Query query = em.createQuery(queryString);
			CreditCardTransactions object = (CreditCardTransactions) query
					.getSingleResult();
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getCCTbyReferenceNumber " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getCCTbyReferenceNumber " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<?> getDimensionByWildcardName(String name) throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Session session = (Session) em.getDelegate();
			List <Dimension> objects = null;
			String localWildName = name + "%";		// wild card on end of search string
			objects = session.createCriteria(Dimension.class).add(
					Restrictions.ilike("name", localWildName)).list();		// no-case sensitivity
			return objects;
		} catch (Exception e) {
			log.error(e); 
			throw e;
		} finally {
			em.close();
		}
	}
	
	/**
	 * This method saves/updates DeliveryTicket data
	 * @param deliveryTicket
	 * @throws Exception
	 */
	public void saveDeliveryTicket(DeliveryTicket deliveryTicket) throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				/*if(deliveryTicket.getFromAddress()!=null && deliveryTicket.getFromAddress().getId()==0) {
					Address fromAddress = (Address) em.merge(deliveryTicket.getFromAddress());
					deliveryTicket.setFromAddress(fromAddress);
				}
				if(deliveryTicket.getToAddress()!=null && deliveryTicket.getToAddress().getId()==0) {
					Address toAddress = (Address) em.merge(deliveryTicket.getToAddress());
					deliveryTicket.setToAddress(toAddress);
				}
				if(deliveryTicket.getDeliveryContact()!=null && deliveryTicket.getDeliveryContact().getId()==0) {
					this.setContactId(deliveryTicket.getDeliveryContact());
					Contact deliveryContact = (Contact) em.merge(deliveryTicket.getDeliveryContact());
					deliveryTicket.setDeliveryContact(deliveryContact);
				}*/
				if(deliveryTicket.getId()==null || deliveryTicket.getId()==0) {
					setDeliveryTicketId(deliveryTicket);
				}
				for (DeliveryTicketJobs deliveryTicketJobs : deliveryTicket.getDeliveryJobs()) {
					deliveryTicketJobs.setParentDeliveryTicket(deliveryTicket);
				}
				deliveryTicket = (DeliveryTicket) em.merge(deliveryTicket);
				for (DeliveryTicketJobs deliveryTicketJobs : deliveryTicket.getDeliveryJobs()) {
					deliveryTicketJobs.setParentDeliveryTicket(deliveryTicket);
					em.merge(deliveryTicketJobs);
				}
				tx.commit();
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
		}
		catch (Exception e) {
			log.error("Exception caught");
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
		
	}
	
	/**
	 * 
	 * @param deliveryTicket
	 * @throws Exception
	 */
	private void setDeliveryTicketId(DeliveryTicket deliveryTicket) throws Exception {
		ModelBase modelBase = null;
		if (deliveryTicket.getTicketNumber() != null
				&& deliveryTicket.getTicketNumber() != 0) {
			modelBase = this.getQuery("DeliveryTicket",
					" where ticketNumber = " + deliveryTicket.getTicketNumber());
			if(modelBase==null) {
				return;
			}
		}
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getDeliveryTicket();
		if(value==null)
			value = new Long(0); 
		boolean goodId = false;
		while (goodId == false) {
			value++;
			modelBase = this.getQuery("DeliveryTicket",
					" where ticketNumber = " + value);
			if (modelBase == null)
				goodId = true;
		}
		deliveryTicket.setTicketNumber(Integer.parseInt(value.toString()));
		sequenceValues.setDeliveryTicket(value);
		this.addUpdate(sequenceValues);
		
	}
	
	/**
	 * 
	 * @param archive
	 * @return
	 * @throws Exception
	 */
	public List<DeliveryTicketJobs> getDeliveryTicketJobs(boolean archive) throws Exception {
		log.debug("** getDeliveryTicketJobs called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<DeliveryTicketJobs> ticketJobsList = new ArrayList<DeliveryTicketJobs>();
		try {
			String queryString = "select job from DeliveryTicketJobs as job inner join job.parentDeliveryTicket as ticket where ticket.archive="+archive+" order by ticket.ticketNumber asc";
			Query query = em.createQuery(queryString);
			ticketJobsList = query.getResultList();
		} catch (Exception e) {
						log.error(e); 			throw e; 
		} finally {
			em.close();
		}
		return ticketJobsList;
	}
	
	/**
	 * 
	 * @param deliveryTicketId
	 * @return
	 * @throws Exception
	 */
	public DeliveryTicket getDeliveryTicketById(Long deliveryTicketId) throws Exception {
		log.debug("** getDeliveryTicketById called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("DeliveryTicket" + ".byId");
			query.setParameter("id", deliveryTicketId);
			DeliveryTicket object = (DeliveryTicket) query.getSingleResult();
			for (Field field : object.getClass().getDeclaredFields()) {
				if (field.getType().getName().equals("java.util.List")
						|| field.getType().getName().equals(
								"java.util.ArrayList")) {
					String propertyName = field.getName().substring(0, 1)
							.toUpperCase()
							+ field.getName().substring(1,
									field.getName().length());
					try {
						Hibernate.initialize(object.getProperty(propertyName));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if(object.getDeliveryContact()!=null && object.getDeliveryContact().getComLinks()!=null) {
				Hibernate.initialize(object.getDeliveryContact().getComLinks());
			}
			if(object.getDeliveryJobs()!=null && !object.getDeliveryJobs().isEmpty()) {
				for (DeliveryTicketJobs deliveryTicketJobs : object.getDeliveryJobs()) {
					Hibernate.initialize(deliveryTicketJobs.getJobBase());
					Hibernate.initialize(deliveryTicketJobs.getJobBase().getPricingPress());
					Hibernate.initialize(deliveryTicketJobs.getJobBase().getCostingPress());
					Hibernate.initialize(deliveryTicketJobs.getJobBase().getStock());
					Hibernate.initialize(deliveryTicketJobs.getJobBase().getPricingCopier());
					Hibernate.initialize(deliveryTicketJobs.getJobBase().getCostingCopier());
				}
			}
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getDeliveryTicketById " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getDeliveryTicketById " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}
	
	/**
	 * 
	 * @param invoiceId
	 * @return
	 * @throws Exception
	 */
	public List<DeliveryTicketJobs> getDeliveryTicketJobsByInvoice(Long invoiceId) throws Exception {
		log.debug("** getDeliveryTicketJobsByInvoice called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<DeliveryTicketJobs> ticketJobsList = new ArrayList<DeliveryTicketJobs>();
		try {
			String queryString = "select job from DeliveryTicketJobs as job inner join job.parentDeliveryTicket as ticket where job.invoiceId="+invoiceId+" order by job.jobNumber,ticket.ticketNumber asc";
			Query query = em.createQuery(queryString);
			ticketJobsList = query.getResultList();
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
		return ticketJobsList;
	}
	
	
	/**
	 * 
	 * @param contactId
	 * @return
	 * @throws Exception
	 */
	public Contact getContactById(Long contactId) throws Exception {
		log.debug("** getContactById called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Contact" + ".byId");
			query.setParameter("id", contactId);
			Contact object = (Contact) query.getSingleResult();
			for (Field field : object.getClass().getDeclaredFields()) {
				if (field.getType().getName().equals("java.util.List")
						|| field.getType().getName().equals(
								"java.util.ArrayList")) {
					String propertyName = field.getName().substring(0, 1)
							.toUpperCase()
							+ field.getName().substring(1,
									field.getName().length());
					try {
						Hibernate.initialize(object.getProperty(propertyName));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			Hibernate.initialize(object.getComLinks());
			return object;
		} catch (NoResultException e) {
			log.warn("No result found for getContactById " + e);
			return null;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getContactById " + e);
			return null;
		} catch (Exception e) {
			log.error(e); 			
			throw e; 
		} finally {
			em.close();
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Broker> getBrokers() throws Exception {
		log.debug("** getBrokers called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Broker> resultList = new ArrayList<Broker>();
		try {

			Query findAllQuery = em.createQuery("from Broker fetch all properties order by orderby,id");
			resultList = findAllQuery.getResultList();
			for (Broker broker : resultList) {
				Hibernate.initialize(broker.getComLinks());
			}
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e); 		
			throw e; 
		} finally {
			em.close();
		}
		return resultList;
	}
	
	public TapeBatch getCurrentTapeBatch() throws Exception {
		TapeBatch object = null;
		
		log.debug("** getCurrentTapeBatch called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			/*
			 * 
			 */
			String queryString = "from TapeBatch where closed = false";
			Query query = em.createQuery(queryString);
			object = (TapeBatch) query.getSingleResult();
			
			List<TapeSessionBatch> batches = object.getSessionBatches();
			
			if (batches != null) {
				for (int i = 0; i < batches.size(); i++) {
					TapeSessionBatch batch = batches.get(i);
					
					if (batch != null) {
						List<com.efi.printsmith.data.Transaction> transactions = batch.getTransactions();
						for (int j = 0; j < transactions.size(); j++) {
							com.efi.printsmith.data.Transaction transaction = transactions.get(j);
							if (transaction == null) {
								log.error("null Transaction found");
							}
						}
					}
				}
			}
		} catch (NoResultException e) {
			ModelBase savedObject;
			//
			// no current tape batch, so create one
			//
		//	Tape tape = new Tape();
			
			List<TapeSessionBatch> resultList  = new ArrayList<TapeSessionBatch>();
			
			TapeBatch tapebatch = new TapeBatch();
			tapebatch.setAppVersion("v00.00.00");
			tapebatch.setOpenDate(new Date());
			tapebatch.setClosed(false);
			
			tapebatch.setSessionBatches(resultList);
		//	tape.addBatches(tapebatch);
			
			savedObject = this.addUpdate(tapebatch);
		//	this.addUpdate(tape);
			
			object = (TapeBatch) savedObject;
		} catch (NonUniqueResultException e) {
			log.warn("No result found for getCurrentTapeBatch " + e);
			return null;
		} catch (GenericJDBCException e) {
			log.error(e); 			
			log.error(e.getSQL());
			System.out.println(e.getSQL());
			throw e; 			
		} catch (Exception e) {
			log.error(e);

 			throw e; 
 		} finally {
			em.close();
		}
		return object;
	}
	
	public FoldTemplate getFoldTemplateByIndex(int i) throws Exception {
		List<FoldTemplate> templates = (List<FoldTemplate>) this.getAll("FoldTemplate");
		
		return (templates.get(i));
	}
}
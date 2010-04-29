package com.efi.printsmith.service;

import com.efi.printsmith.data.*;
import com.efi.printsmith.defaultdata.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.String;

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
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;

import com.efi.printsmith.messaging.MessageServiceAdapter;
import com.efi.printsmith.messaging.MessageTypes;
import com.efi.printsmith.query.RemoteCriterion;
import com.efi.printsmith.query.RemoteRestriction;

public class DataService extends HibernateService {

	protected static final String PERSISTENCE_UNIT = "printsmith_db";

	protected static Logger log = Logger.getLogger(DataService.class);

	protected static EntityManagerFactory entityManagerFactory = null;

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
						// DefaultDataFactory().getClass().getResource("DefaultDataFactory.class").getPath()});
						DefaultDataFactory df = new DefaultDataFactory();
						df.LoadDefaultData(this);
					} catch (Exception e) {
						log.error("** Exception: " + e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
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

	public List<?> getAllOrdeBy(String className, String orderBy) {
		log.debug("** getAll called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		try {
			Query findAllQuery = em.createQuery("from " + className
					+ " fetch all properties order by "+ orderBy);
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
		EntityManager em = entityManagerFactory.createEntityManager();

		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();

		columnstring = "a.id, a.name, a.weight, a.parentsize, a.color, a.genericColor, a.finish, a.thickness, a.grade, "
				+ "a.cwt1, a.vendor, a.stocknumber, a.onHand, a.committed, a.onOrder, a.shellItem, a.normalRunSize, "
				+ "a.stktype, a.stkgroup, a.coated, a.minorder, a.cost1, a.priceExpires, a.forestManagement, "
				+ "a.pcwRecycledPercent, a.fscCertified, a.sfiCertified, a.greenSealCertified";
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

	public List<?> getAccountPicker(String className) throws Exception {
		log.debug("** getAccountPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();

		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();

		columnstring = "a.id, a.title, a.accountId, a.externalRef, a.masterAcct, a.prospect";
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
	
	@SuppressWarnings("unchecked")
	public List<?> getPending(String className) throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<ModelBase> resultList = new ArrayList<ModelBase>();
		String columnstring = new String();

		columnstring = "a.id, a.invoiceNumber";
		try {

			String queryString = "select new Invoice" + "( "
					+ columnstring + ") from Invoice a where a.onPendingList = 'TRUE'";
			Query query = em.createQuery(queryString);

			resultList = query.getResultList();
			for (int i = 0; i < resultList.size(); i++) {
				Invoice listItem = (Invoice)resultList.get(i);
				Invoice invoice = (Invoice) this.getById("Invoice", ((ModelBase) listItem).getId());
				Invoice resultInvoice = new Invoice(invoice.getId(), invoice.getInvoiceNumber(), invoice.getAccount(),invoice.getContact(),
						invoice.getName(), invoice.getGrandTotal(), invoice.getOrderedDate(), invoice.getWantedDate(), invoice.getProofDate());
				resultList.set(i, resultInvoice);
			}
			
			List<ModelBase> estimateResultList = new ArrayList<ModelBase>();
			
			queryString = "select new Estimate" + "( "+ columnstring + ") from Estimate a where a.onPendingList = 'TRUE'";							
			
			query = em.createQuery(queryString);
			estimateResultList = query.getResultList();
			
			for (int i = 0; i < estimateResultList.size(); i++) {
				Estimate listItem = (Estimate)estimateResultList.get(i);
				Estimate invoice = (Estimate) this.getById("Estimate", ((ModelBase) listItem).getId());
				Estimate resultInvoice = new Estimate(invoice.getId(), invoice.getInvoiceNumber(), invoice.getAccount(),invoice.getContact(),
						invoice.getName(), invoice.getGrandTotal(), invoice.getOrderedDate(), invoice.getWantedDate(), invoice.getProofDate());
				resultList.add(resultInvoice);
			}
			
			
//			log.debug("** getPending .");
//			EntityManager em = entityManagerFactory.createEntityManager();
//
//			String queryString = "select new " + className + "( "
//					+ columnstring + ") from " + className + " a";
//			Query query = em.createQuery(queryString);
//
//			resultList = query.getResultList();
//			for (int i = 0; i < resultList.size(); i++) {
//				Object listItem = resultList.get(i);
//				if (listItem instanceof Invoice) {
//					Invoice invoice = (Invoice) this.getById("Invoice",
//							((ModelBase) listItem).getId());
//					Invoice resultInvoice = new Invoice(invoice.getId(),
//							invoice.getInvoiceNumber(), invoice.getAccount(),
//							invoice.getContact());
//					resultList.set(i, resultInvoice);
//				} else if (listItem instanceof Estimate) {
//					Estimate invoice = (Estimate) this.getById("Estimate",
//							((ModelBase) listItem).getId());
//					Estimate resultInvoice = new Estimate(invoice.getId(),
//							invoice.getInvoiceNumber(), invoice.getAccount(),
//							invoice.getContact());
//					resultList.set(i, resultInvoice);
//				} else {
//					InvoiceBase invoice = (InvoiceBase) this.getById(
//							"InvoiceBase", ((ModelBase) listItem).getId());
//					InvoiceBase resultInvoice = new InvoiceBase(
//							invoice.getId(), invoice.getInvoiceNumber(),
//							invoice.getAccount(), invoice.getContact());
//					resultList.set(i, resultInvoice);
//				}
//			}
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

	public List<?> getContactPicker(String className) throws Exception {
		log.debug("** getContactPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();

		columnstring = "a.id, a.firstName, a.lastName, a.contactId";
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

	public List<?> getPressPicker(String className) throws Exception {
		List<?> resultList = new ArrayList<Object>();
		String columnstring = new String();
		log.debug("** getPressPicker .");
		EntityManager em = entityManagerFactory.createEntityManager();

		columnstring = "a.id, a.name, a.machineID, a.machineName";
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
	public ModelBase getByLastFirstName(String className, String namelast, String namefirst, long id) {
		log.debug("** getByName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className + " where lastName = '" + namelast
					+ "' and " + "firstName = '" + namefirst + "' and " + "parentaccount_id = '" + id + "'";
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

	public Location getByLocationName(String name) throws Exception {
		log.debug("** getByLocationName called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from Location where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			Location object = (Location) query.getSingleResult();
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
	public PreferencesPricingMethod getByMethodType(String name) throws Exception {
		log.debug("** PreferencesPricingMethod called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from PreferencesPricingMethod where method = '" + name + "'";
			Query query = em.createQuery(queryString);
			PreferencesPricingMethod object = (PreferencesPricingMethod) query.getSingleResult();
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
			ChargeCommand chargeCommand = (ChargeCommand) query.getSingleResult();
			List<ChargeCategory> categories = chargeCommand.getChildren();
			for (int i=0; i<categories.size(); i++) {
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
			ChargeCategory chargeCategory = (ChargeCategory) query.getSingleResult();
			List<ChargeDefinition> chargeDefinitions = chargeCategory.getChildren();
			for (int i=0; i<chargeDefinitions.size(); i++) {
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
			sequenceValues.setJob(new Long(0));
			sequenceValues.setPressDefinition(new Long(0));
			sequenceValues.setStockDefinition(new Long(0));
			sequenceValues.setCampaign(new Long(0));
			sequenceValues.setGrade(new Long(0));
			sequenceValues.setCreditCard(new Long(0));
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
			ModelBase modelBase = this.getQuery("Account", " where accountId = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("Employee", " where employeeId = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("Contact", " where contactId = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("Broker", " where brokerId = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("StockDefinition", " where stockId = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("Invoice", " where invoiceNumber = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		invoice.setInvoiceNumber(value.toString());
		sequenceValues.setInvoice(value);
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
			ModelBase modelBase = this.getQuery("Job", " where jobNumber = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("PressDefinition", " where pressId = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("CopierDefinition", " where copierId = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("Campaigns", " where campaignId = '" + value.toString() + "'");
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
			ModelBase modelBase = this.getQuery("Grade", " where gradeId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		grade.setGradeId(value.toString());
		sequenceValues.setGrade(value);
		this.addUpdate(sequenceValues);
	}
	
	private void setCreditCardId(CreditCard creditcard) throws Exception {
		if (creditcard.getCreditCardID() != null && creditcard.getCreditCardID().length() > 0)
			return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getCreditCard();
		boolean goodId = false;
		while (goodId == false) {
			value++;
			ModelBase modelBase = this.getQuery("CreditCard", " where creditCardId = '" + value.toString() + "'");
			if (modelBase == null)
				goodId = true;
		}
		creditcard.setCreditCardID(value.toString());
		sequenceValues.setCreditCard(value);
		this.addUpdate(sequenceValues);
	}


	public ModelBase addUpdate(ModelBase object) throws Exception {
		log.debug("** addUpdateAccount called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			if (object.getId() == null || object.getId() == 0) {
				object.setId(null);
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
			}else if (object instanceof CreditCard) {
				this.setCreditCardId((CreditCard) object);
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
		} finally {
			em.close();
		}
		return object;
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
			Query findAllQuery = em.createQuery("from ChargeCommand fetch all properties order by id");
			resultList = findAllQuery.getResultList();
			
			if (resultList != null)
				for (ChargeCommand chargeCommand:resultList) {
					List<ChargeCategory> categories = chargeCommand.getChildren();
					for (ChargeCategory category:categories) {
						System.out.println(category.getName());
						List<ChargeDefinition> charges = category.getChildren();
						for (ChargeDefinition charge:charges) {
							System.out.println(charge.getName());
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
	public InvoiceBase getInvoice(Long id) throws Exception {
		log.debug("** getInvoice called.");
		InvoiceBase invoice = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("InvoiceBase.byId");
			query.setParameter("id", id);
			invoice = (InvoiceBase) query.getSingleResult();

			if (invoice != null){
					for (int i=0; i<invoice.getJobs().size(); i++) {
						Job job = invoice.getJobs().get(i);
						if (job != null) {
							for (int j=0; j<job.getCharges().size(); j++) {
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
			return object;
		} catch (Exception e) {
			log.error(e);
		} finally {
			em.close();
		}
		return null;
	}
	
	public ModelBase getMatrix(Long id) throws Exception {
		log.debug("** getById called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Matrix.byId");
			query.setParameter("id", id);
			Matrix matrix = (Matrix) query.getSingleResult();
			
			for (int i=0; i < matrix.getElements().size(); i++) {
				MatrixElement element = matrix.getElements().get(i);
				
				if (element == null) {
					log.error("Null matrix element found");
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
			DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();

			String queryString = "from " + className
					+ " where to_char(startdatetime,'YYYY-MM-DD') = '"
					+ dateFormat.format(date).toString()
					+ "' and employee = :employee and onClock = 1";
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

			String queryString = "from " + className
					+ " where to_char(created,'YYYY-MM-DD') = '"
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
	public List<Period> getByPeriodOpen(String className) throws Exception {
		log.debug("** getByEmployee Id called.");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			String queryString = "from " + className
					+ " where periodClosed = 0";
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
					session.close();

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

	static public Session getSession() {
		EntityManager em = entityManagerFactory.createEntityManager();
		return (Session) em.getDelegate();
	}

	public Object load(Class clazz, long id)
	{
       Session session = null;
       Object result;
       session = getSession();

       try
       {
           long tStart = new Date().getTime();
           result = session.get(clazz, id);
           long tEnd = new Date().getTime();
           log.debug("{load()}" +(tEnd-tStart) +"ms  class=" +clazz.getName() );
           
       }
       catch (HibernateException ex)
       {
           HibernateUtil.rollbackTransaction();
           ex.printStackTrace();
           throw ex;
       }
       catch (RuntimeException ex)
       {
           HibernateUtil.rollbackTransaction();
           ex.printStackTrace();
           throw ex;
       } finally {
    	   session.close();
       }

       return result;
	}

}
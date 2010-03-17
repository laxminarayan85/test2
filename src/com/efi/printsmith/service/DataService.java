package com.efi.printsmith.service;

import com.efi.printsmith.data.*;
import com.efi.printsmith.defaultdata.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;

import com.efi.printsmith.messaging.MessageServiceAdapter;
import com.efi.printsmith.messaging.MessageTypes;
import com.efi.printsmith.query.RemoteCriterion;
import com.efi.printsmith.query.RemoteRestriction;

public class DataService {

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
						log.debug("** Exception: " + e.getMessage());
					}
				}
			}
		} catch (RuntimeException e) {
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
		List<?> resultList = new ArrayList<Object>();
		try {
			log.debug("** getAll called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findAllQuery = em.createQuery("from " + className);
			resultList = findAllQuery.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
		} catch (Exception e) {
			log.error(e);
		}
		return resultList;
	}

	
	public List<?> getAllNameIDOnly(String className)
	throws Exception {
		List<?> resultList = new ArrayList<Object>();
		try {
			log.debug("** getAllNameIDOnly .");
			EntityManager em = entityManagerFactory.createEntityManager();
		
			String queryString = "select new " + className+ "( a.id, a.name) from " + className + " a";
			Query query = em.createQuery(queryString);
			
			resultList = query.getResultList();
			if (resultList != null)
				log.debug("** Found " + resultList.size() + "records:");
			return resultList;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public ModelBase getSingle(String className) {
		try {
			log.debug("** getSingle called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query findQuery = em.createQuery("from " + className);
			ModelBase result = (ModelBase) findQuery.getSingleResult();
			return result;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public ModelBase getByPrevId(String className, String prevId) {
		try {
			log.debug("** getByPrevId called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from " + className + " where prevId = '" + prevId + "'";
			Query query = em.createQuery(queryString);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public StockDefinition getByStockId(String stockId) {
		try {
			log.debug("** getByStockId called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from StockDefinition where stockId = '" + stockId + "'";
			Query query = em.createQuery(queryString);
			StockDefinition object = (StockDefinition) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	
	public StockType getByStockTypeID(String stocktypeId) {
		try {
			log.debug("** getByStocktypeId called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from StockType where viewableID = '" + stocktypeId + "'";
			Query query = em.createQuery(queryString);
			StockType object = (StockType) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	
	public PressDefinition getByPressId(String pressId) {
		try {
			log.debug("** getByPressId called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from PressDefinition where pressId = '" + pressId + "'";
			Query query = em.createQuery(queryString);
			PressDefinition object = (PressDefinition) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public Account getByAccountId(String accountId) {
		try {
			log.debug("** getByAccountId called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from Account where accountId = '" + accountId + "'";
			Query query = em.createQuery(queryString);
			Account object = (Account) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public ModelBase getByName(String className, String name) {
		try {
			log.debug("** getByName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from " + className + " where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	public List<?> getFromParent(String className, String parentName, Long id)
			throws Exception {
		try {
			log.debug("** getId called.");
			EntityManager em = entityManagerFactory.createEntityManager();
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
		}
		return null;
	}
	
	public StockColors getByStockColorName(String name) throws Exception {
		try {
			log.debug("** getBySockColorName called.");
			
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from StockColors where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockColors object = (StockColors) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	public StockClass getByStockClassName(String name) throws Exception {
		try {
			log.debug("** getBySockClassName called.");
			
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from StockClass where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockClass object = (StockClass) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	public SalesCategory getBySalesCategoryName(String name) throws Exception {
		try {
			log.debug("** getBySalesCategoryName called.");
			
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from SalesCategory where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			SalesCategory object = (SalesCategory) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	public StockFinish getByStockFinishName(String name) throws Exception {
		try {
			log.debug("** getBySockFinishName called.");
			
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from StockFinish where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockFinish object = (StockFinish) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	public StockGroup getByStockGroupName(String name) throws Exception {
		try {
			log.debug("** getBySockGroupName called.");
			
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from StockGroup where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockGroup object = (StockGroup) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public GenericColors getByGenericColorsName(String name) throws Exception {
		try {
			log.debug("** getByGenericColorsName called.");
			
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from GenericColors where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			GenericColors object = (GenericColors) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public StockGrade getByStockGradeName(String name) throws Exception {
		try {
			log.debug("** getByStockGradeName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from StockGrade where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			StockGrade object = (StockGrade) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public CostCenter getByCostCenterName(String name) throws Exception {
		try {
			log.debug("** getByCostCenterName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from CostCenter where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			CostCenter object = (CostCenter) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public Location getByLocationName(String name) throws Exception {
		try {
			log.debug("** getByLocationName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from Location where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			Location object = (Location) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public PriceList getByPirceListName(String name) throws Exception {
		try {
			log.debug("** getByPriceListName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from PriceList where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			PriceList object = (PriceList) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public ShippingMethod getByShippingMethodName(String name) throws Exception {
		try {
			log.debug("** getByShippingMethodName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from ShippingMethod where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			ShippingMethod object = (ShippingMethod) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public Substrate getBySubstrateName(String name) throws Exception {
		try {
			log.debug("** getBySubstrateName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from Substrate where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			Substrate object = (Substrate) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public TaxTable getByTaxTableName(String name) throws Exception {
		try {
			log.debug("** getByTaxTableName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from TaxTable where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			TaxTable object = (TaxTable) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public WasteChart getByWasteChartName(String name) throws Exception {
		try {
			log.debug("** getByWasteChartName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from WasteChart where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			WasteChart object = (WasteChart) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public ChargeCommand getByChargeCommandName(String name) throws Exception {
		try {
			log.debug("** getByChargeCommandName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from ChargeCommand where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			ChargeCommand object = (ChargeCommand) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public ChargeCategory getByChargeCategoryName(String name) throws Exception {
		try {
			log.debug("** getByChargeCategoryName called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "from ChargeCategory where name = '" + name + "'";
			Query query = em.createQuery(queryString);
			ChargeCategory object = (ChargeCategory) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> getByAccountsPartialName(String name) throws Exception {
		try {
			log.debug("** getAccountsByPartialName called.");

			EntityManager em = entityManagerFactory.createEntityManager();

			String queryString = "from Account where title like '" + name
					+ "%'";
			Query query = em.createQuery(queryString);
			List<Account> accounts = query.getResultList();

			if (accounts != null)
				log.debug("** Found " + accounts.size() + "records:");

			return accounts;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Account>();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getByEmployeesPartialName(String name)
			throws Exception {
		try {
			log.debug("** getByEmployeesPartialName called.");

			EntityManager em = entityManagerFactory.createEntityManager();

			String queryString = "from Employee where title like '" + name
					+ "%'";
			Query query = em.createQuery(queryString);
			List<Employee> employees = query.getResultList();

			if (employees != null)

				log.debug("** Found " + employees.size() + "records:");

			return employees;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Employee>();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getContactsByPartialName(String name) throws Exception {
		try {
			log.debug("** getCountactsByPartialName called.");

			EntityManager em = entityManagerFactory.createEntityManager();

			String queryString = "from Contact where title like '" + name
					+ "%'";
			Query query = em.createQuery(queryString);
			List<Contact> contacts = query.getResultList();

			if (contacts != null)

				log.debug("** Found " + contacts.size() + "records:");

			return contacts;
		} catch (Exception e) {
			log.error(e);
		}
		return new ArrayList<Contact>();
	}

	// The following Id generation code is a temporary placeholder for the real handlers, but should work for a few days in 
	// a single user environment. And yes it's ugly as snot...
	
	private PreferencesSequenceValues getSequenceValues() throws Exception {
		PreferencesSequenceValues sequenceValues = (PreferencesSequenceValues) this.getSingle("PreferencesSequenceValues");
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
		}
		return sequenceValues;
	}
	private void setAccountId(Account account) throws Exception {
		if (account.getAccountId() != null && account.getAccountId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getAccount()+1;
		account.setAccountId(value.toString());
		sequenceValues.setAccount(value);
		this.addUpdate(sequenceValues);
	}
	
	private void setEmployeeId(Employee employee) throws Exception {
		if (employee.getEmployeeId() != null && employee.getEmployeeId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getEmployee()+1;
		employee.setEmployeeId(value.toString());
		sequenceValues.setEmployee(value);
		this.addUpdate(sequenceValues);
	}
	
	private void setContactId(Contact contact) throws Exception {
		if (contact.getContactId() != null && contact.getContactId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getContact()+1;
		contact.setContactId(value.toString());
		sequenceValues.setContact(value);
		this.addUpdate(sequenceValues);
	}
	
	private void setBrokerId(Broker broker) throws Exception {
		if (broker.getBrokerId() != null && broker.getBrokerId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getBroker()+1;
		broker.setBrokerId(value.toString());
		sequenceValues.setBroker(value);
		this.addUpdate(sequenceValues);
	}

	private void setStockDefinitionId(StockDefinition stockDefinition) throws Exception {
		if (stockDefinition.getStockId() != null && stockDefinition.getStockId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getStockDefinition()+1;
		stockDefinition.setStockId(value.toString());
		sequenceValues.setStockDefinition(value);
		this.addUpdate(sequenceValues);
	}
	
	private void setInvoiceId(Invoice invoice) throws Exception {
		if (invoice.getInvoiceNumber() != null && invoice.getInvoiceNumber().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getInvoice()+1;
		invoice.setInvoiceNumber(value.toString());
		sequenceValues.setInvoice(value);
		this.addUpdate(sequenceValues);
	}
	
	private void setJobId(Job job) throws Exception {
		if (job.getJobNumber() != null && job.getJobNumber().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getJob()+1;
		job.setJobNumber(value.toString());
		sequenceValues.setJob(value);
		this.addUpdate(sequenceValues);
	}
	
	private void setPressDefinitionId(PressDefinition pressDefinition) throws Exception {
		if (pressDefinition.getPressId() != null && pressDefinition.getPressId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getPressDefinition()+1;
		pressDefinition.setPressId(value.toString());
		sequenceValues.setPressDefinition(value);
		this.addUpdate(sequenceValues);
	}
	
	private void setCopierDefinitionId(CopierDefinition copierDefinition) throws Exception {
		if (copierDefinition.getCopierId() != null && copierDefinition.getCopierId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getCopierDefinition()+1;
		copierDefinition.setCopierId(value.toString());
		sequenceValues.setCopierDefinition(value);
		this.addUpdate(sequenceValues);
	}
	private void setCampaignId(Campaigns campaign) throws Exception {
		if (campaign.getCampaignId() != null && campaign.getCampaignId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getCampaign()+1;
		campaign.setCampaignId(value.toString());
		sequenceValues.setCampaign(value);
		this.addUpdate(sequenceValues);
	}
	private void setGradeId(Grade grade) throws Exception {
		if (grade.getGradeId() != null && grade.getGradeId().length() > 0) return;
		PreferencesSequenceValues sequenceValues = getSequenceValues();
		Long value = sequenceValues.getGrade()+1;
		grade.setGradeId(value.toString());
		sequenceValues.setGrade(value);
		this.addUpdate(sequenceValues);
	}
	
	public ModelBase addUpdate(ModelBase object) throws Exception {
		log.debug("** addUpdateAccount called.");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();
			if (object.getId() == null || object.getId() == 0) {
				object.setId(null);
				object.setCreated(new Timestamp(new Date().getTime()));
				object.setModified(new Timestamp(new Date().getTime()));
			} else {
				// Existing object is updated - do nothing.
			}
			if (object instanceof Account) {
				this.setAccountId((Account)object);
			} else if (object instanceof Employee) {
				this.setEmployeeId((Employee)object);
			} else if (object instanceof Contact) {
				this.setContactId((Contact)object);
			} else if (object instanceof Broker) {
				this.setBrokerId((Broker)object);
			} else if (object instanceof StockDefinition) {
				this.setStockDefinitionId((StockDefinition)object);
			} else if (object instanceof Invoice) {
				this.setInvoiceId((Invoice)object);
			} else if (object instanceof Job) {
				this.setJobId((Job)object);			
			} else if (object instanceof PressDefinition) {
				this.setPressDefinitionId((PressDefinition)object);
			} else if (object instanceof CopierDefinition) {
				this.setCopierDefinitionId((CopierDefinition)object);
			}else if (object instanceof Campaigns) {
				this.setCampaignId((Campaigns)object);
			}else if (object instanceof Grade) {
				this.setGradeId((Grade)object);			
			}
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				object = em.merge(object);
				tx.commit();
				MessageServiceAdapter.sendNotification(MessageTypes.ADDUPDATE,
						object.getClass().getSimpleName(), object.getId());
			} catch (RollbackException e) {
				ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
				SQLException sqle = cve.getSQLException().getNextException();
				while (sqle != null) {
					sqle = sqle.getNextException();
				}
			} catch (Exception e) {
				log.error("** Error: " + e.getMessage());
				tx.rollback();
				throw new Exception(e.getMessage());
			} finally {
				log.info("** Closing Entity Manager.");
				em.close();
			}
		} catch (Exception e) {
			log.error("Exception caught");
		}
		return object;
	}

	public ChargeCategory addChargeCategoryToCommand(ChargeCategory category,
			ChargeCommand command) throws Exception {
		log.debug("** addChargeCategoryToCommand called.");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();

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
					category = command.getChildren().get(command.getChildren().size()-1);
					tx.commit();
					return category;
				} catch (Exception e) {
					log.error("** Error: " + e.getMessage());
					tx.rollback();
					throw new Exception(e.getMessage());

				} finally {
					log.info("** Closing Entity Manager.");
					em.close();
				}
			}
		} catch (Exception e) {
			log.error("Exception caught");
		}
		return null;
	}

	public ChargeDefinition addChargeToCategory(ChargeDefinition charge,
			ChargeCategory category) throws Exception {
		log.debug("** addChargeCategoryToCommand called.");
		try {
			EntityManager em;
			em = entityManagerFactory.createEntityManager();

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
					charge = category.getChildren().get(category.getChildren().size()-1);
					tx.commit();
					// MessageServiceAdapter.sendNotification("Object Created");
					return charge;
				} catch (Exception e) {
					log.error("** Error: " + e.getMessage());
					tx.rollback();
					throw new Exception(e.getMessage());

				} finally {
					log.info("** Closing Entity Manager.");
					em.close();
				}
			}
		} catch (Exception e) {
			log.error("Exception caught");
		}
		return null;
	}

	public ModelBase getById(String className, Long id) throws Exception {
		try {
			log.debug("** getById called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			Query query = em.createNamedQuery(className + ".byId");
			query.setParameter("id", id);
			ModelBase object = (ModelBase) query.getSingleResult();
			return object;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> getByAccountId(String className, Long id)
			throws Exception {
		try {
			log.debug("** getByaccountid Id called.");
			EntityManager em = entityManagerFactory.createEntityManager();

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
		}
		return null;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Contact> getContactsByAccountId(String className, Long id)
			throws Exception {
		try {
			log.debug("** getByaccountid Id called.");
			EntityManager em = entityManagerFactory.createEntityManager();

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
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TimeCard> getByClockInOut(String className, Employee employee)
			throws Exception {
		try {
			log.debug("** getByEmployee Id called.");
			EntityManager em = entityManagerFactory.createEntityManager();

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
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TimeCard> getByClockInOutBreak(String className,
			Employee employee) throws Exception {
		try {
			log.debug("** getByEmployee Id called.");
			EntityManager em = entityManagerFactory.createEntityManager();

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
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TimeCard> getByTimeCardByEmployee(String className,
			Employee employee) throws Exception {
		try {
			log.debug("** getByEmployee Id called.");
			EntityManager em = entityManagerFactory.createEntityManager();

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
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Period> getByPeriodOpen(String className) throws Exception {
		try {
			log.debug("** getByEmployee Id called.");
			EntityManager em = entityManagerFactory.createEntityManager();

			String queryString = "from " + className
					+ " where periodClosed = 0";
			Query query = em.createQuery(queryString);
			List<Period> periodlist = query.getResultList();
			if (periodlist != null)
				log.debug("** Found " + periodlist.size() + "records:");
			return periodlist;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<SecuritySetup> getByAccessGroup(String className,
			AccessGroup accessGroup) throws Exception {
		try {
			log.debug("** getByAccess called.");
			EntityManager em = entityManagerFactory.createEntityManager();
			String queryString = "select a from SecuritySetup a where a.accessGroup.id = :id";
			Query query = em.createQuery(queryString);
			query.setParameter("id", accessGroup.getId());
			List<SecuritySetup> securitySetups = query.getResultList();

			if (securitySetups != null)
				log.debug("** Found " + securitySetups.size() + "records:");
			return securitySetups;

		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void deleteItem(String className, Long id) {
		log.debug("** deleteObject called.");
		EntityManager em = entityManagerFactory.createEntityManager();
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
			} finally {
				log.info("** Closing Entity Manager.");
				em.close();
			}
		}
	}

	public List<?> criteriaQuery(String entityName,
			List<RemoteCriterion> criteria) {
		log.debug("** criteriaQuery called.");
		List<?> resultList = new ArrayList<Object>();
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
					EntityManager em = entityManagerFactory
							.createEntityManager();
					Session session = (Session) em.getDelegate();
					Transaction tx = session.beginTransaction();
					resultList = query.getExecutableCriteria(session)
							.list();
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
		}
		return resultList;
	}

}
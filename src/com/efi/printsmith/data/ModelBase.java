package com.efi.printsmith.data;

import com.efi.printsmith.exceptions.*;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.ListIterator;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.digitalprimates.persistence.hibernate.proxy.HibernateProxy;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="modelbase")
@SQLDelete(sql="update modelbase set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
abstract public class ModelBase extends HibernateProxy implements Comparable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	Long id;
	
	@Basic
	@Column(name = "created", nullable = true)
	Date created;
	
	@Basic
	@Column(name = "modified", nullable = true)
	Date modified;
	
	@Basic
	@Column(name = "previd", nullable = true)
	String prevId;
	
	@Basic
	@Column(name="isdeleted", nullable = false)
	Boolean isDeleted = false;
	
	@Basic
	@Column(name="orderby", nullable = true)
	Integer orderby;
	
	@Basic
	@Column(name="displayId", nullable = true)
	Long displayId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getPrevId() {
		return prevId;
	}
	public void setPrevId(String prevId) {
		this.prevId = prevId;
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	
	public Long getDisplayId() {
		return displayId;
	}
	public void setDisplayId(Long displayId) {
		this.displayId = displayId;
	}

//	public static final String GUID = "GUID";
//	protected String guid;
//	@Column(name = "guid", nullable = false, length = 36)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public String getGuid() {
//		return guid;
//	}
//
//	// this set was needed to satisfy hibernate's requirement that
//	// persisted get methods have a corresponding set method.
//	private void setGuid(String newVal) {
//		guid = newVal;
//	}
	
	/**
	 * 
	 * @param propertyName
	 * @param concrete
	 * @return Class[] for given property name. For example, if given property
	 *         is a string, then {String.class} is returned. If given property
	 *         is a list of strings, then {List.class, String.class} is
	 *         returned. If given property is a list of ranges of integer, then
	 *         {List.class, Range.class, Integer.class} is returned.
	 * @throws UnknownPropertyException
	 */
	@Transient
	public Class<?>[] getPropertyClass(String propertyName)
			throws UnknownPropertyException {
		if (propertyName == null)
			throw new IllegalArgumentException("propertyName must not be null");

		throw new UnknownPropertyException(this.getClass(), propertyName);
	}
	
	public boolean deepEquals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// If the classes are not the same then the objects are not the same.
		if (!getClass().equals(obj.getClass())) {
			// check to see if we are comparing proxy classes. if so, compare
			// the underlying classes
			Class<?> thisClass = org.hibernate.proxy.HibernateProxyHelper
					.getClassWithoutInitializingProxy(this);
			Class<?> objClass = org.hibernate.proxy.HibernateProxyHelper
					.getClassWithoutInitializingProxy(obj);
			if (!thisClass.equals(objClass))
				return false;
		}
		return true;
	}

	protected static boolean SmartEquals(double[] s1, double[] s2) {
		return java.util.Arrays.equals(s1, s2);
	}

	protected static boolean SmartEquals(Object s1, Object s2) {
		boolean rslt = false;

		if (s1 == s2) {
			return true;
		}

		if ((s1 == null) || (s2 == null)) {
			// TMOSES, for debugging
			// System.out.println("Objects not equal! s1: " + (s1 == null ? "s1
			// is null" : s1.toString()) + ", s2: " + (s2 == null ? "s2 is null"
			// : s2.toString()));
			return false;
		}

		if (s1 instanceof ModelBase && s2 instanceof ModelBase) {
			rslt = ((ModelBase) s1).deepEquals((ModelBase) s2);
			if (!rslt) {
				// TMOSES, for debugging
				// System.out.println("Objects not equal! s1: " + (s1 == null ?
				// "s1 is null" : s1.toString()) + ", s2: " + (s2 == null ? "s2
				// is null" : s2.toString()));
			}
			return rslt;
		}

		rslt = s1.equals(s2);
		if (!rslt) {
			// TMOSES, for debugging
			// System.out.println("Objects not equal! s1: " + (s1 == null ? "s1
			// is null" : s1.toString()) + ", s2: " + (s2 == null ? "s2 is null"
			// : s2.toString()));
		}

		return rslt;
	}

	protected static boolean SmartEquals(java.util.List<?> s1,
			java.util.List<?> s2) {
		if (s1 == s2) {
			return true;
		}
		if (s1 == null && s2 != null && s2.isEmpty()) {
			return true;
		}
		if (s1 != null && s1.isEmpty() && s2 == null) {
			return true;
		}
		if ((s1 == null) || (s2 == null)) {
			return false;
		}
		if (s1.size() <= 0 && s2.size() <= 0) { // Hibernate's PersistentList
			// returns a size of -1 when the
			// list is null
			return true;
		}
		if (s1.size() != s2.size()) {
			return false;
		}
		if (s1.size() == 0) {
			return true;
		}
		ListIterator<?> e1 = s1.listIterator();
		ListIterator<?> e2 = s2.listIterator();
		while (e1.hasNext() && e2.hasNext()) {
			Object o1 = e1.next();
			Object o2 = e2.next();
			if ((o1 instanceof ModelBase) && (o2 instanceof ModelBase)) {
				if (!SmartEquals((ModelBase) o1, (ModelBase) o2)) {
					return false;
				}
			} else if (!SmartEquals(o1, o2)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Override to allow correct comparison between detached persistent objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
//		if (getGuid() == null)
//			return false;
		if (!(obj instanceof ModelBase))
			return false;
		return true;
//		return this.getGuid().equals(((ModelBase) obj).getGuid());
	}
	
	/**
	 * @param propertyName
	 * @return Class containing given property. If not found in this class
	 *         parent class hierarchy is searched.
	 * @throws UnknownPropertyException
	 */
	@Transient
	public Class<?> getPropertyOwner(String propertyName)
			throws UnknownPropertyException {
		if (propertyName == null)
			throw new IllegalArgumentException("propertyName must not be null");
//		if (GUID.equals(propertyName))
//			return ModelBase.class;
//
		throw new UnknownPropertyException(this.getClass(), propertyName);
	}
	
	@Transient
	public Object getProperty(String propertyName)
			throws UnknownPropertyException {
		if (propertyName == null)
			throw new IllegalArgumentException("propertyName must not be null");
//		if (GUID.equals(propertyName))
//			return getGuid();
//
		throw new UnknownPropertyException(this.getClass(), propertyName);
	}

	public void setProperty(String propertyName, Object newValue)
			throws PropertyException {
		if (propertyName == null)
			throw new IllegalArgumentException("propertyName must not be null");
//		if (GUID.equals(propertyName))
//			throw new UnmodifiablePropertyException(this.getClass(),
//					propertyName);
		throw new UnknownPropertyException(this.getClass(), propertyName);
	}
	public int compareTo(Object compObject) throws ClassCastException {
		if (!(compObject instanceof ModelBase))
			throw new ClassCastException("Comparator expected to compare 2 ModelBase objects");
	    long compId = ((ModelBase) compObject).getId();  
	    long result = this.id - compId;
	    
	    if (result < 0) return -1;
	    if (result > 0) return 1;
	    return 0;
	}
}

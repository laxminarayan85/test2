
package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "DigitalAsset.findall", query = "from DigitalAsset"),
  @NamedQuery(name = "DigitalAsset.byId", query = "select a from DigitalAsset a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "digitalasset")
public class DigitalAsset extends ModelBase {
	/**
   * @generated
   */
  public static final String REPOSITORYPATH = "RepositoryPath";
	/**
   * @generated
   */
  public static final String JOB = "Job";
	/**
   * @generated
   */
  public static final String DATEADDED = "DateAdded";
	/**
   * @generated
   */
  public static final String ORIGINALFILENAME = "OriginalFilename";
	/**
   * @generated
   */
  public static final String FILETYPE = "FileType";
	/**
	 * @generated
	 */
	public DigitalAsset() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
   * @generated
   */	
 	@Basic
  private String repositoryPath;

	/**
   * @generated
 	 */
  public String getRepositoryPath(){
    return repositoryPath; 
  }


	/**
   * @generated
   */	
  public void setRepositoryPath(String newVal) {
    this.repositoryPath = newVal;
  }



	/**
   * @generated
   */	
    @ManyToOne
  private Job job;

	/**
   * @generated
 	 */
  public Job getJob(){
    return job; 
  }


	/**
   * @generated
   */	
  public void setJob(Job newVal) {
    this.job = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date dateAdded;

	/**
   * @generated
 	 */
  public Date getDateAdded(){
    return dateAdded; 
  }


	/**
   * @generated
   */	
  public void setDateAdded(Date newVal) {
    this.dateAdded = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String originalFilename;

	/**
   * @generated
 	 */
  public String getOriginalFilename(){
    return originalFilename; 
  }


	/**
   * @generated
   */	
  public void setOriginalFilename(String newVal) {
    this.originalFilename = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String fileType;

	/**
   * @generated
 	 */
  public String getFileType(){
    return fileType; 
  }


	/**
   * @generated
   */	
  public void setFileType(String newVal) {
    this.fileType = newVal;
  }



	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (REPOSITORYPATH.equals(propertyName)) return getRepositoryPath();
    if (JOB.equals(propertyName)) return getJob();
    if (DATEADDED.equals(propertyName)) return getDateAdded();
    if (ORIGINALFILENAME.equals(propertyName)) return getOriginalFilename();
    if (FILETYPE.equals(propertyName)) return getFileType();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (REPOSITORYPATH.equals(propertyName)) setRepositoryPath((String)newValue); else
    if (JOB.equals(propertyName)) setJob((Job)newValue); else
    if (DATEADDED.equals(propertyName)) setDateAdded((Date)newValue); else
    if (ORIGINALFILENAME.equals(propertyName)) setOriginalFilename((String)newValue); else
    if (FILETYPE.equals(propertyName)) setFileType((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (REPOSITORYPATH.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (JOB.equals(propertyName)) 
      return new Class<?>[] {Job.class};		
    if (DATEADDED.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (ORIGINALFILENAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FILETYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (REPOSITORYPATH.equals(propertyName)) return DigitalAsset.class;
    if (JOB.equals(propertyName)) return DigitalAsset.class;
    if (DATEADDED.equals(propertyName)) return DigitalAsset.class;
    if (ORIGINALFILENAME.equals(propertyName)) return DigitalAsset.class;
    if (FILETYPE.equals(propertyName)) return DigitalAsset.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    DigitalAsset objT = (DigitalAsset)obj;
    if (! SmartEquals(getRepositoryPath(), objT.getRepositoryPath()))
      return false;
    if (! SmartEquals(getJob(), objT.getJob()))
      return false;
    if (! SmartEquals(getDateAdded(), objT.getDateAdded()))
      return false;
    if (! SmartEquals(getOriginalFilename(), objT.getOriginalFilename()))
      return false;
    if (! SmartEquals(getFileType(), objT.getFileType()))
      return false;
    return true;
  }			
}

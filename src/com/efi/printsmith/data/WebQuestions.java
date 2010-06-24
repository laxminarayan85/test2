
package com.efi.printsmith.data;

import java.math.BigDecimal;
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
  @NamedQuery(name = "WebQuestions.findall", query = "from WebQuestions"),
  @NamedQuery(name = "WebQuestions.byId", query = "select a from WebQuestions a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "webquestions")
public class WebQuestions extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
	/**
	 * @generated
	 */
	public static final String PROMPT = "Prompt";
	/**
	 * @generated
	 */
	public static final String QUESTIONTYPE = "QuestionType";
	/**
	 * @generated
	 */
	public static final String CHOICES = "Choices";

	/**
	 * @generated
	 */
	public WebQuestions() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String name;
	
	/**
	 * @generated
 	 */
	public String getName(){
    return name; 
  }

	
	/**
	 * @generated
	 */	
	public void setName(String newVal) {
    this.name = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String status;
	
	/**
	 * @generated
 	 */
	public String getStatus(){
    return status; 
  }

	
	/**
	 * @generated
	 */	
	public void setStatus(String newVal) {
    this.status = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String prompt;
	
	/**
	 * @generated
 	 */
	public String getPrompt(){
    return prompt; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrompt(String newVal) {
    this.prompt = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String questionType;
	
	/**
	 * @generated
 	 */
	public String getQuestionType(){
    return questionType; 
  }

	
	/**
	 * @generated
	 */	
	public void setQuestionType(String newVal) {
    this.questionType = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @JoinTable( name = "webquestions_choices")
	private java.util.List<WebChoices> choices;
	
	/**
	 * @generated
 	 */
	public java.util.List<WebChoices> getChoices(){
    return choices; 
  }

	/**
	 * @generated
	 */	
	public void addChoices(WebChoices obj) {
    if (choices == null) {
      choices = new java.util.ArrayList<WebChoices>();
    }
    choices.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setChoices(java.util.List<WebChoices> newVal) {
    this.choices = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (STATUS.equals(propertyName)) return getStatus();
    if (PROMPT.equals(propertyName)) return getPrompt();
    if (QUESTIONTYPE.equals(propertyName)) return getQuestionType();
    if (CHOICES.equals(propertyName)) return getChoices();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (STATUS.equals(propertyName)) setStatus((String)newValue); else
    if (PROMPT.equals(propertyName)) setPrompt((String)newValue); else
    if (QUESTIONTYPE.equals(propertyName)) setQuestionType((String)newValue); else
    if (CHOICES.equals(propertyName)) setChoices((java.util.List<WebChoices>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PROMPT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (QUESTIONTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CHOICES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, WebChoices.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return WebQuestions.class;
    if (STATUS.equals(propertyName)) return WebQuestions.class;
    if (PROMPT.equals(propertyName)) return WebQuestions.class;
    if (QUESTIONTYPE.equals(propertyName)) return WebQuestions.class;
    if (CHOICES.equals(propertyName)) return WebQuestions.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    WebQuestions objT = (WebQuestions)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getStatus(), objT.getStatus()))
      return false;
    if (! SmartEquals(getPrompt(), objT.getPrompt()))
      return false;
    if (! SmartEquals(getQuestionType(), objT.getQuestionType()))
      return false;
    if (! SmartEquals(getChoices(), objT.getChoices()))
      return false;
    return true;
  }			
}

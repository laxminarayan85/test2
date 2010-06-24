
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
  @NamedQuery(name = "Job.findall", query = "from Job"),
  @NamedQuery(name = "Job.byId", query = "select a from Job a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "job")
public class Job extends JobBase {

	/**
	 * @generated
	 */
	public Job() {
    this.created = new Date();
    this.modified = new Date();
  }

}

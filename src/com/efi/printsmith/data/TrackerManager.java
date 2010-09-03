package com.efi.printsmith.data;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.efi.printsmith.exceptions.UnknownPropertyException;

/**
 * @author madhubha
 *
 */

/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "TrackerManager.findall", query = "from TrackerManager"),
  @NamedQuery(name = "TrackerManager.byId", query = "select a from TrackerManager a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "trackermanager")
public class TrackerManager extends ModelBase {
	
	public static final String ProductionFacilities = "ProductionFacilities";
	
	public static final String ShowAllFacilities = "ShowAllFacilities";
	
	public static final String ShowAllStations = "ShowAllStations";
	
	public static final String SelectedStations = "SelectedStations";
	
	@ManyToOne( cascade = {CascadeType.ALL}, optional=true)
	private ProductionFacilities productionFacilities;
	
	@Basic
	private Boolean showAllFacilities;
	
	@Basic
	private Boolean showAllStations;
	
	@OneToMany()
    @JoinTable( name = "trackermanager_selectedstations")
	private List<ProductionStations> selectedStations;

	/**
	 * @return the productionFacilities
	 */
	public ProductionFacilities getProductionFacilities() {
		return productionFacilities;
	}

	/**
	 * @param productionFacilities the productionFacilities to set
	 */
	public void setProductionFacilities(ProductionFacilities productionFacilities) {
		this.productionFacilities = productionFacilities;
	}

	/**
	 * @return the showAllFacilities
	 */
	public Boolean getShowAllFacilities() {
		return showAllFacilities;
	}

	/**
	 * @param showAllFacilities the showAllFacilities to set
	 */
	public void setShowAllFacilities(Boolean showAllFacilities) {
		this.showAllFacilities = showAllFacilities;
	}

	/**
	 * @return the showAllStations
	 */
	public Boolean getShowAllStations() {
		return showAllStations;
	}

	/**
	 * @param showAllStations the showAllStations to set
	 */
	public void setShowAllStations(Boolean showAllStations) {
		this.showAllStations = showAllStations;
	}

	/**
	 * @return the selectedStations
	 */
	public List<ProductionStations> getSelectedStations() {
		return selectedStations;
	}

	/**
	 * @param selectedStations the selectedStations to set
	 */
	public void setSelectedStations(List<ProductionStations> selectedStations) {
		this.selectedStations = selectedStations;
	}
	
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
	    if (ProductionFacilities.equals(propertyName)) return getProductionFacilities();
	    if (ShowAllFacilities.equals(propertyName)) return getShowAllFacilities();
	    if (ShowAllStations.equals(propertyName)) return getShowAllStations();
	    if (SelectedStations.equals(propertyName)) return getSelectedStations();
	    return super.getProperty(propertyName);
   }
	
}

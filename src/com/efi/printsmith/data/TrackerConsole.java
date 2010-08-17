/**
 * 
 */
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

/**
 * @author madhubha
 *
 */

/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "TrackerConsole.findall", query = "from TrackerConsole"),
  @NamedQuery(name = "TrackerConsole.byId", query = "select a from TrackerConsole a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "trackerconsole")
public class TrackerConsole extends ModelBase{
	
	@ManyToOne( cascade = {CascadeType.ALL}, optional=true)
	private ProductionFacilities productionFacilities;
	
	@ManyToOne( cascade = {CascadeType.ALL}, optional=true)
	private ProductionStations productionStations;
	
	@Basic
	private Boolean hideItemsNotReleasedToProd;
	
	@Basic
	private Boolean showEmployeeProdParents;
	
	@Basic
	private Boolean showSelectedEmployee;
	
	@Basic
	private Boolean showAllFacilities;
	
	@Basic
	private Boolean showAllStations;
	
	@OneToMany()
    @JoinTable( name = "tracker_selectedstations")
	private List<ProductionStations> selectedStations;
	
	@Basic
	private String pendingListSize;
	
	@Basic
	private String activeListSize;

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
	 * @return the productionStations
	 */
	public ProductionStations getProductionStations() {
		return productionStations;
	}

	/**
	 * @param productionStations the productionStations to set
	 */
	public void setProductionStations(ProductionStations productionStations) {
		this.productionStations = productionStations;
	}

	/**
	 * @return the hideItemsNotReleasedToProd
	 */
	public Boolean getHideItemsNotReleasedToProd() {
		return hideItemsNotReleasedToProd;
	}

	/**
	 * @param hideItemsNotReleasedToProd the hideItemsNotReleasedToProd to set
	 */
	public void setHideItemsNotReleasedToProd(Boolean hideItemsNotReleasedToProd) {
		this.hideItemsNotReleasedToProd = hideItemsNotReleasedToProd;
	}

	/**
	 * @return the showEmployeeProdParents
	 */
	public Boolean getShowEmployeeProdParents() {
		return showEmployeeProdParents;
	}

	/**
	 * @param showEmployeeProdParents the showEmployeeProdParents to set
	 */
	public void setShowEmployeeProdParents(Boolean showEmployeeProdParents) {
		this.showEmployeeProdParents = showEmployeeProdParents;
	}

	/**
	 * @return the showSelectedEmployee
	 */
	public Boolean getShowSelectedEmployee() {
		return showSelectedEmployee;
	}

	/**
	 * @param showSelectedEmployee the showSelectedEmployee to set
	 */
	public void setShowSelectedEmployee(Boolean showSelectedEmployee) {
		this.showSelectedEmployee = showSelectedEmployee;
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

	/**
	 * @return the pendingListSize
	 */
	public String getPendingListSize() {
		return pendingListSize;
	}

	/**
	 * @param pendingListSize the pendingListSize to set
	 */
	public void setPendingListSize(String pendingListSize) {
		this.pendingListSize = pendingListSize;
	}

	/**
	 * @return the activeListSize
	 */
	public String getActiveListSize() {
		return activeListSize;
	}

	/**
	 * @param activeListSize the activeListSize to set
	 */
	public void setActiveListSize(String activeListSize) {
		this.activeListSize = activeListSize;
	}
	
	

}

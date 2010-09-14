package com.efi.printsmith.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
  @NamedQuery(name = "RoutingStepSetUp.findall", query = "from RoutingStepSetUp"),
  @NamedQuery(name = "RoutingStepSetUp.byId", query = "select a from RoutingStepSetUp a where a.id= :id")
})



	
@Entity
@Table(name = "routingstepsetup")
public class RoutingStepSetUp extends ModelBase{
	
	private String title;
	
	private Boolean routeDisabled;
	
	private Boolean defaultRouteForNewJobs;
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
	private ProductionFacilities productionFacilities;
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
	private ProductionLocations productionLocations;
	
	private Boolean stepDisabled;
	
	private Boolean markInvReady;
	
	private Boolean treatAsNonProdStep;
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
	private ProductionDates productionDates;
	
	private int autoScheduleDaysFromOrdered;
	
	private int autoScheduleDaysFromWantedBy;
	
	private String hourOfDay;
	
	private Boolean routeData;
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
	private RoutingStepSetUp parentRoute;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the routeDisabled
	 */
	public Boolean getRouteDisabled() {
		return routeDisabled;
	}

	/**
	 * @param routeDisabled the routeDisabled to set
	 */
	public void setRouteDisabled(Boolean routeDisabled) {
		this.routeDisabled = routeDisabled;
	}

	/**
	 * @return the defaultRouteForNewJobs
	 */
	public Boolean getDefaultRouteForNewJobs() {
		return defaultRouteForNewJobs;
	}

	/**
	 * @param defaultRouteForNewJobs the defaultRouteForNewJobs to set
	 */
	public void setDefaultRouteForNewJobs(Boolean defaultRouteForNewJobs) {
		this.defaultRouteForNewJobs = defaultRouteForNewJobs;
	}

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
	 * @return the productionLocations
	 */
	public ProductionLocations getProductionLocations() {
		return productionLocations;
	}

	/**
	 * @param productionLocations the productionLocations to set
	 */
	public void setProductionLocations(ProductionLocations productionLocations) {
		this.productionLocations = productionLocations;
	}

	/**
	 * @return the stepDisabled
	 */
	public Boolean getStepDisabled() {
		return stepDisabled;
	}

	/**
	 * @param stepDisabled the stepDisabled to set
	 */
	public void setStepDisabled(Boolean stepDisabled) {
		this.stepDisabled = stepDisabled;
	}

	/**
	 * @return the markInvReady
	 */
	public Boolean getMarkInvReady() {
		return markInvReady;
	}

	/**
	 * @param markInvReady the markInvReady to set
	 */
	public void setMarkInvReady(Boolean markInvReady) {
		this.markInvReady = markInvReady;
	}

	/**
	 * @return the treatAsNonProdStep
	 */
	public Boolean getTreatAsNonProdStep() {
		return treatAsNonProdStep;
	}

	/**
	 * @param treatAsNonProdStep the treatAsNonProdStep to set
	 */
	public void setTreatAsNonProdStep(Boolean treatAsNonProdStep) {
		this.treatAsNonProdStep = treatAsNonProdStep;
	}

	/**
	 * @return the productionDates
	 */
	public ProductionDates getProductionDates() {
		return productionDates;
	}

	/**
	 * @param productionDates the productionDates to set
	 */
	public void setProductionDates(ProductionDates productionDates) {
		this.productionDates = productionDates;
	}

	/**
	 * @return the autoScheduleDaysFromOrdered
	 */
	public int getAutoScheduleDaysFromOrdered() {
		return autoScheduleDaysFromOrdered;
	}

	/**
	 * @param autoScheduleDaysFromOrdered the autoScheduleDaysFromOrdered to set
	 */
	public void setAutoScheduleDaysFromOrdered(int autoScheduleDaysFromOrdered) {
		this.autoScheduleDaysFromOrdered = autoScheduleDaysFromOrdered;
	}

	/**
	 * @return the autoScheduleDaysFromWantedBy
	 */
	public int getAutoScheduleDaysFromWantedBy() {
		return autoScheduleDaysFromWantedBy;
	}

	/**
	 * @param autoScheduleDaysFromWantedBy the autoScheduleDaysFromWantedBy to set
	 */
	public void setAutoScheduleDaysFromWantedBy(int autoScheduleDaysFromWantedBy) {
		this.autoScheduleDaysFromWantedBy = autoScheduleDaysFromWantedBy;
	}

	/**
	 * @return the hourOfDay
	 */
	public String getHourOfDay() {
		return hourOfDay;
	}

	/**
	 * @param hourOfDay the hourOfDay to set
	 */
	public void setHourOfDay(String hourOfDay) {
		this.hourOfDay = hourOfDay;
	}

	/**
	 * @return the routeData
	 */
	public Boolean getRouteData() {
		return routeData;
	}

	/**
	 * @param routeData the routeData to set
	 */
	public void setRouteData(Boolean routeData) {
		this.routeData = routeData;
	}

	/**
	 * @return the parentRoute
	 */
	public RoutingStepSetUp getParentRoute() {
		return parentRoute;
	}

	/**
	 * @param parentRoute the parentRoute to set
	 */
	public void setParentRoute(RoutingStepSetUp parentRoute) {
		this.parentRoute = parentRoute;
	}

}

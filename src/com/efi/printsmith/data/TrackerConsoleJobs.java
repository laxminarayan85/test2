package com.efi.printsmith.data;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "TrackerConsoleJobs.findall", query = "from TrackerConsoleJobs"),
  @NamedQuery(name = "TrackerConsoleJobs.byId", query = "select a from TrackerConsoleJobs a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "trackerconsolejobs")
public class TrackerConsoleJobs extends ModelBase{
	
	@ManyToOne( cascade = {CascadeType.ALL}, optional=true)
	private ProductionFacilities productionFacilities;
	
	@ManyToOne( cascade = {CascadeType.ALL}, optional=true)
	private ProductionStations productionStations;
	
	@ManyToOne( cascade = {CascadeType.ALL}, optional=true)
	private ProductionLocations productionLocations;
	
	@ManyToOne()
	private Employee employee; 
	
	@ManyToOne()
	private Job job;
	
	@ManyToOne()
	private Charge charge;
	
	private long actualSetUpTime;
	
	private long actualRunTime;
	
	private long actualWashTime;
	
	private long duration;
	
	private Date firstTrackerDate;
	
	private long firstTrackerTime;
	
	private Date firstSetUpDate;
	
	private long firstSetUpTime;
	
	private Date firstRunDate;
	
	private long firstRunTime;
	
	private Date firstWashDate;
	
	private long firstWashTime;
	
	private Date secondTrackerDate;
	
	private long secondTrackerTime;
	
	private Date secondSetUpDate; 
	
	private long secondSetUpTime;
	
	private Date secondRunDate;
	
	private long secondRunTime;
	
	private Date secondWashDate;
	
	private long secondWashTime;
	
	private long totalTime;
	
	private int noOfPasses;
	
	private Boolean paused;
	
	private int currentPass;
	
	private Boolean firstSetUpCompleted;
	
	private Boolean firstWashCompleted;
	
	private Boolean secondSetUpCompleted;
	
	private Boolean secondWashCompleted;
	
	private Boolean completed;

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
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * @return the charge
	 */
	public Charge getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	/**
	 * @return the actualSetUpTime
	 */
	public long getActualSetUpTime() {
		return actualSetUpTime;
	}

	/**
	 * @param actualSetUpTime the actualSetUpTime to set
	 */
	public void setActualSetUpTime(long actualSetUpTime) {
		this.actualSetUpTime = actualSetUpTime;
	}

	/**
	 * @return the actualRunTime
	 */
	public long getActualRunTime() {
		return actualRunTime;
	}

	/**
	 * @param actualRunTime the actualRunTime to set
	 */
	public void setActualRunTime(long actualRunTime) {
		this.actualRunTime = actualRunTime;
	}

	/**
	 * @return the actualWashTime
	 */
	public long getActualWashTime() {
		return actualWashTime;
	}

	/**
	 * @param actualWashTime the actualWashTime to set
	 */
	public void setActualWashTime(long actualWashTime) {
		this.actualWashTime = actualWashTime;
	}

	/**
	 * @return the duration
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(long duration) {
		this.duration = duration;
	}

	/**
	 * @return the firstTrackerDate
	 */
	public Date getFirstTrackerDate() {
		return firstTrackerDate;
	}

	/**
	 * @param firstTrackerDate the firstTrackerDate to set
	 */
	public void setFirstTrackerDate(Date firstTrackerDate) {
		this.firstTrackerDate = firstTrackerDate;
	}

	/**
	 * @return the firstSetUpDate
	 */
	public Date getFirstSetUpDate() {
		return firstSetUpDate;
	}

	/**
	 * @param firstSetUpDate the firstSetUpDate to set
	 */
	public void setFirstSetUpDate(Date firstSetUpDate) {
		this.firstSetUpDate = firstSetUpDate;
	}

	/**
	 * @return the firstSetUpTime
	 */
	public long getFirstSetUpTime() {
		return firstSetUpTime;
	}

	/**
	 * @param firstSetUpTime the firstSetUpTime to set
	 */
	public void setFirstSetUpTime(long firstSetUpTime) {
		this.firstSetUpTime = firstSetUpTime;
	}

	/**
	 * @return the firstRunDate
	 */
	public Date getFirstRunDate() {
		return firstRunDate;
	}

	/**
	 * @param firstRunDate the firstRunDate to set
	 */
	public void setFirstRunDate(Date firstRunDate) {
		this.firstRunDate = firstRunDate;
	}

	/**
	 * @return the firstRunTime
	 */
	public long getFirstRunTime() {
		return firstRunTime;
	}

	/**
	 * @param firstRunTime the firstRunTime to set
	 */
	public void setFirstRunTime(long firstRunTime) {
		this.firstRunTime = firstRunTime;
	}

	/**
	 * @return the firstWashDate
	 */
	public Date getFirstWashDate() {
		return firstWashDate;
	}

	/**
	 * @param firstWashDate the firstWashDate to set
	 */
	public void setFirstWashDate(Date firstWashDate) {
		this.firstWashDate = firstWashDate;
	}

	/**
	 * @return the firstWashTime
	 */
	public long getFirstWashTime() {
		return firstWashTime;
	}

	/**
	 * @param firstWashTime the firstWashTime to set
	 */
	public void setFirstWashTime(long firstWashTime) {
		this.firstWashTime = firstWashTime;
	}

	/**
	 * @return the secondTrackerDate
	 */
	public Date getSecondTrackerDate() {
		return secondTrackerDate;
	}

	/**
	 * @param secondTrackerDate the secondTrackerDate to set
	 */
	public void setSecondTrackerDate(Date secondTrackerDate) {
		this.secondTrackerDate = secondTrackerDate;
	}

	/**
	 * @return the secondSetUpDate
	 */
	public Date getSecondSetUpDate() {
		return secondSetUpDate;
	}

	/**
	 * @param secondSetUpDate the secondSetUpDate to set
	 */
	public void setSecondSetUpDate(Date secondSetUpDate) {
		this.secondSetUpDate = secondSetUpDate;
	}

	/**
	 * @return the secondSetUpTime
	 */
	public long getSecondSetUpTime() {
		return secondSetUpTime;
	}

	/**
	 * @param secondSetUpTime the secondSetUpTime to set
	 */
	public void setSecondSetUpTime(long secondSetUpTime) {
		this.secondSetUpTime = secondSetUpTime;
	}

	/**
	 * @return the secondRunDate
	 */
	public Date getSecondRunDate() {
		return secondRunDate;
	}

	/**
	 * @param secondRunDate the secondRunDate to set
	 */
	public void setSecondRunDate(Date secondRunDate) {
		this.secondRunDate = secondRunDate;
	}

	/**
	 * @return the secondRunTime
	 */
	public long getSecondRunTime() {
		return secondRunTime;
	}

	/**
	 * @param secondRunTime the secondRunTime to set
	 */
	public void setSecondRunTime(long secondRunTime) {
		this.secondRunTime = secondRunTime;
	}

	/**
	 * @return the secondWashDate
	 */
	public Date getSecondWashDate() {
		return secondWashDate;
	}

	/**
	 * @param secondWashDate the secondWashDate to set
	 */
	public void setSecondWashDate(Date secondWashDate) {
		this.secondWashDate = secondWashDate;
	}

	/**
	 * @return the secondWashTime
	 */
	public long getSecondWashTime() {
		return secondWashTime;
	}

	/**
	 * @param secondWashTime the secondWashTime to set
	 */
	public void setSecondWashTime(long secondWashTime) {
		this.secondWashTime = secondWashTime;
	}

	/**
	 * @return the totalTime
	 */
	public long getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	/**
	 * @return the noOfPasses
	 */
	public int getNoOfPasses() {
		return noOfPasses;
	}

	/**
	 * @param noOfPasses the noOfPasses to set
	 */
	public void setNoOfPasses(int noOfPasses) {
		this.noOfPasses = noOfPasses;
	}

	/**
	 * @return the paused
	 */
	public Boolean getPaused() {
		return paused;
	}

	/**
	 * @param paused the paused to set
	 */
	public void setPaused(Boolean paused) {
		this.paused = paused;
	}

	/**
	 * @return the currentPass
	 */
	public int getCurrentPass() {
		return currentPass;
	}

	/**
	 * @param currentPass the currentPass to set
	 */
	public void setCurrentPass(int currentPass) {
		this.currentPass = currentPass;
	}

	/**
	 * @return the firstSetUpCompleted
	 */
	public Boolean getFirstSetUpCompleted() {
		return firstSetUpCompleted;
	}

	/**
	 * @param firstSetUpCompleted the firstSetUpCompleted to set
	 */
	public void setFirstSetUpCompleted(Boolean firstSetUpCompleted) {
		this.firstSetUpCompleted = firstSetUpCompleted;
	}

	/**
	 * @return the firstWashCompleted
	 */
	public Boolean getFirstWashCompleted() {
		return firstWashCompleted;
	}

	/**
	 * @param firstWashCompleted the firstWashCompleted to set
	 */
	public void setFirstWashCompleted(Boolean firstWashCompleted) {
		this.firstWashCompleted = firstWashCompleted;
	}

	/**
	 * @return the secondSetUpCompleted
	 */
	public Boolean getSecondSetUpCompleted() {
		return secondSetUpCompleted;
	}

	/**
	 * @param secondSetUpCompleted the secondSetUpCompleted to set
	 */
	public void setSecondSetUpCompleted(Boolean secondSetUpCompleted) {
		this.secondSetUpCompleted = secondSetUpCompleted;
	}

	/**
	 * @return the secondWashCompleted
	 */
	public Boolean getSecondWashCompleted() {
		return secondWashCompleted;
	}

	/**
	 * @param secondWashCompleted the secondWashCompleted to set
	 */
	public void setSecondWashCompleted(Boolean secondWashCompleted) {
		this.secondWashCompleted = secondWashCompleted;
	}

	/**
	 * @return the completed
	 */
	public Boolean getCompleted() {
		return completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	/**
	 * @return the firstTrackerTime
	 */
	public long getFirstTrackerTime() {
		return firstTrackerTime;
	}

	/**
	 * @param firstTrackerTime the firstTrackerTime to set
	 */
	public void setFirstTrackerTime(long firstTrackerTime) {
		this.firstTrackerTime = firstTrackerTime;
	}

	/**
	 * @return the secondTrackerTime
	 */
	public long getSecondTrackerTime() {
		return secondTrackerTime;
	}

	/**
	 * @param secondTrackerTime the secondTrackerTime to set
	 */
	public void setSecondTrackerTime(long secondTrackerTime) {
		this.secondTrackerTime = secondTrackerTime;
	}

	
	

}
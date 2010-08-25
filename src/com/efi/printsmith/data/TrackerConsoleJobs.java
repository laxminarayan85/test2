package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
	private ProductionFacilities productionFacilities;
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
	private ProductionStations productionStations;
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
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
	
	private long totalTime;
	
	private int noOfPasses;
	
	private Boolean paused;
	
	private int currentPass;
	
	@OneToMany(mappedBy="trackerConsoleJobs", cascade = {CascadeType.ALL})
    @JoinTable( name = "trackerconsolepasses")
  	private List<TrackerConsolePasses> passesList;
	
	private Boolean completed;
	
	private Date completedDate;

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
	 * @return the passesList
	 */
	public List<TrackerConsolePasses> getPassesList() {
		return passesList;
	}

	/**
	 * @param passesList the passesList to set
	 */
	public void setPassesList(List<TrackerConsolePasses> passesList) {
		this.passesList = passesList;
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
	 * @return the completedDate
	 */
	public Date getCompletedDate() {
		return completedDate;
	}

	/**
	 * @param completedDate the completedDate to set
	 */
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	
}
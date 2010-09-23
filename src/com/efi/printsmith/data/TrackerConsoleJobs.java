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
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
	private ProductionLocations nextProductionLocation;
	
	@ManyToOne()
	private Employee employee; 
	
	@ManyToOne()
	private Job job;
	
	@ManyToOne()
	private Charge charge;
	
	private Long actualSetUpTime;
	
	private Long actualRunTime;
	
	private Long actualWashTime;
	
	private Long duration;
	
	private Long totalTime;
	
	private int noOfPasses;
	
	private Boolean paused;
	
	private Boolean clockBreak;
	
	private int currentPass;
	
	@OneToMany(mappedBy="trackerConsoleJobs", cascade = {CascadeType.ALL})
    @JoinTable( name = "trackerconsolepasses")
  	private List<TrackerConsolePasses> passesList;
	
	private Boolean completed;
	
	private Date completedDate;
	
	@ManyToOne( cascade = {CascadeType.MERGE}, optional=true)
	private ProductionExceptions productionExceptions;
	
	private String notes;
	
	private Boolean markStepComplete;
	
	private Boolean moveToNonProdStep;
	
	private Boolean treatAsNonProdStep;
	
	private Long actualTotalTime;
	
	private Boolean appendNotesToJobTicketNotes;
	
	private Long qtyOrdered;
	
	private Long impressions;
	
	private Long spoilage;
	
	private Long totalCost;
	
	private Long totalSetUpTime;
	
	private Long totalRunTime;
	
	private Long totalWashUpTime;
	
	private Long startSpoilage;
	
	private Long endSpoilage;
	
	private Long difference;
	
	private Boolean canceled;

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
	public Long getActualSetUpTime() {
		return actualSetUpTime;
	}

	/**
	 * @param actualSetUpTime the actualSetUpTime to set
	 */
	public void setActualSetUpTime(Long actualSetUpTime) {
		this.actualSetUpTime = actualSetUpTime;
	}

	/**
	 * @return the actualRunTime
	 */
	public Long getActualRunTime() {
		return actualRunTime;
	}

	/**
	 * @param actualRunTime the actualRunTime to set
	 */
	public void setActualRunTime(Long actualRunTime) {
		this.actualRunTime = actualRunTime;
	}

	/**
	 * @return the actualWashTime
	 */
	public Long getActualWashTime() {
		return actualWashTime;
	}

	/**
	 * @param actualWashTime the actualWashTime to set
	 */
	public void setActualWashTime(Long actualWashTime) {
		this.actualWashTime = actualWashTime;
	}

	/**
	 * @return the duration
	 */
	public Long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}

	/**
	 * @return the totalTime
	 */
	public Long getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(Long totalTime) {
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
	 * @return the clockBreak
	 */
	public Boolean getClockBreak() {
		return clockBreak;
	}

	/**
	 * @param clockBreak the clockBreak to set
	 */
	public void setClockBreak(Boolean clockBreak) {
		this.clockBreak = clockBreak;
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

	/**
	 * @return the productionExceptions
	 */
	public ProductionExceptions getProductionExceptions() {
		return productionExceptions;
	}

	/**
	 * @param productionExceptions the productionExceptions to set
	 */
	public void setProductionExceptions(ProductionExceptions productionExceptions) {
		this.productionExceptions = productionExceptions;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the markStepComplete
	 */
	public Boolean getMarkStepComplete() {
		return markStepComplete;
	}

	/**
	 * @param markStepComplete the markStepComplete to set
	 */
	public void setMarkStepComplete(Boolean markStepComplete) {
		this.markStepComplete = markStepComplete;
	}

	/**
	 * @return the moveToNonProdStep
	 */
	public Boolean getMoveToNonProdStep() {
		return moveToNonProdStep;
	}

	/**
	 * @param moveToNonProdStep the moveToNonProdStep to set
	 */
	public void setMoveToNonProdStep(Boolean moveToNonProdStep) {
		this.moveToNonProdStep = moveToNonProdStep;
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
	 * @return the actualTotalTime
	 */
	public Long getActualTotalTime() {
		return actualTotalTime;
	}

	/**
	 * @param actualTotalTime the actualTotalTime to set
	 */
	public void setActualTotalTime(Long actualTotalTime) {
		this.actualTotalTime = actualTotalTime;
	}

	/**
	 * @return the appendNotesToJobTicketNotes
	 */
	public Boolean getAppendNotesToJobTicketNotes() {
		return appendNotesToJobTicketNotes;
	}

	/**
	 * @param appendNotesToJobTicketNotes the appendNotesToJobTicketNotes to set
	 */
	public void setAppendNotesToJobTicketNotes(Boolean appendNotesToJobTicketNotes) {
		this.appendNotesToJobTicketNotes = appendNotesToJobTicketNotes;
	}

	/**
	 * @return the qtyOrdered
	 */
	public Long getQtyOrdered() {
		return qtyOrdered;
	}

	/**
	 * @param qtyOrdered the qtyOrdered to set
	 */
	public void setQtyOrdered(Long qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	/**
	 * @return the impressions
	 */
	public Long getImpressions() {
		return impressions;
	}

	/**
	 * @param impressions the impressions to set
	 */
	public void setImpressions(Long impressions) {
		this.impressions = impressions;
	}

	/**
	 * @return the spoilage
	 */
	public Long getSpoilage() {
		return spoilage;
	}

	/**
	 * @param spoilage the spoilage to set
	 */
	public void setSpoilage(Long spoilage) {
		this.spoilage = spoilage;
	}

	/**
	 * @return the totalCost
	 */
	public Long getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the totalSetUpTime
	 */
	public Long getTotalSetUpTime() {
		return totalSetUpTime;
	}

	/**
	 * @param totalSetUpTime the totalSetUpTime to set
	 */
	public void setTotalSetUpTime(Long totalSetUpTime) {
		this.totalSetUpTime = totalSetUpTime;
	}

	/**
	 * @return the totalRunTime
	 */
	public Long getTotalRunTime() {
		return totalRunTime;
	}

	/**
	 * @param totalRunTime the totalRunTime to set
	 */
	public void setTotalRunTime(Long totalRunTime) {
		this.totalRunTime = totalRunTime;
	}

	/**
	 * @return the totalWashUpTime
	 */
	public Long getTotalWashUpTime() {
		return totalWashUpTime;
	}

	/**
	 * @param totalWashUpTime the totalWashUpTime to set
	 */
	public void setTotalWashUpTime(Long totalWashUpTime) {
		this.totalWashUpTime = totalWashUpTime;
	}

	/**
	 * @return the nextProductionLocation
	 */
	public ProductionLocations getNextProductionLocation() {
		return nextProductionLocation;
	}

	/**
	 * @param nextProductionLocation the nextProductionLocation to set
	 */
	public void setNextProductionLocation(ProductionLocations nextProductionLocation) {
		this.nextProductionLocation = nextProductionLocation;
	}

	/**
	 * @return the startSpoilage
	 */
	public Long getStartSpoilage() {
		return startSpoilage;
	}

	/**
	 * @param startSpoilage the startSpoilage to set
	 */
	public void setStartSpoilage(Long startSpoilage) {
		this.startSpoilage = startSpoilage;
	}

	/**
	 * @return the endSpoilage
	 */
	public Long getEndSpoilage() {
		return endSpoilage;
	}

	/**
	 * @param endSpoilage the endSpoilage to set
	 */
	public void setEndSpoilage(Long endSpoilage) {
		this.endSpoilage = endSpoilage;
	}

	/**
	 * @return the difference
	 */
	public Long getDifference() {
		return difference;
	}

	/**
	 * @param difference the difference to set
	 */
	public void setDifference(Long difference) {
		this.difference = difference;
	}

	/**
	 * @return the canceled
	 */
	public Boolean getCanceled() {
		return canceled;
	}

	/**
	 * @param canceled the canceled to set
	 */
	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}
	
}
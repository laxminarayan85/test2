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
}
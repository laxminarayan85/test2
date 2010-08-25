package com.efi.printsmith.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "TrackerConsolePasses.findall", query = "from TrackerConsolePasses"),
  @NamedQuery(name = "TrackerConsolePasses.byId", query = "select a from TrackerConsolePasses a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "trackerconsolepasses")
public class TrackerConsolePasses extends ModelBase{ 
	
	private long trackTime;
	
	private Date trackDate;
	
	private long setUpTime;
	
	private Date setUpDate;
	
	private Boolean setUpCompleted;
	
	private long runTime;
	
	private Date runDate;
	
	private Boolean runCompleted;
	
	private long washUpTime;
	
	private Date washUpDate;
	
	private Boolean washUpCompleted;
	
	private int passNo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TrackerConsoleJobs trackerConsoleJobs;
	
	
	public TrackerConsolePasses() {
		
	}
	
	public TrackerConsolePasses(long id) {
		this.id = id;
	}

	/**
	 * @return the setUpTime
	 */
	public long getSetUpTime() {
		return setUpTime;
	}

	/**
	 * @param setUpTime the setUpTime to set
	 */
	public void setSetUpTime(long setUpTime) {
		this.setUpTime = setUpTime;
	}

	/**
	 * @return the setUpCompleted
	 */
	public Boolean getSetUpCompleted() {
		return setUpCompleted;
	}

	/**
	 * @param setUpCompleted the setUpCompleted to set
	 */
	public void setSetUpCompleted(Boolean setUpCompleted) {
		this.setUpCompleted = setUpCompleted;
	}

	/**
	 * @return the runTime
	 */
	public long getRunTime() {
		return runTime;
	}

	/**
	 * @param runTime the runTime to set
	 */
	public void setRunTime(long runTime) {
		this.runTime = runTime;
	}

	/**
	 * @return the runCompleted
	 */
	public Boolean getRunCompleted() {
		return runCompleted;
	}

	/**
	 * @param runCompleted the runCompleted to set
	 */
	public void setRunCompleted(Boolean runCompleted) {
		this.runCompleted = runCompleted;
	}

	/**
	 * @return the washUpTime
	 */
	public long getWashUpTime() {
		return washUpTime;
	}

	/**
	 * @param washUpTime the washUpTime to set
	 */
	public void setWashUpTime(long washUpTime) {
		this.washUpTime = washUpTime;
	}

	/**
	 * @return the washUpCompleted
	 */
	public Boolean getWashUpCompleted() {
		return washUpCompleted;
	}

	/**
	 * @param washUpCompleted the washUpCompleted to set
	 */
	public void setWashUpCompleted(Boolean washUpCompleted) {
		this.washUpCompleted = washUpCompleted;
	}

	/**
	 * @return the passNo
	 */
	public int getPassNo() {
		return passNo;
	}

	/**
	 * @param passNo the passNo to set
	 */
	public void setPassNo(int passNo) {
		this.passNo = passNo;
	}

	/**
	 * @return the trackerConsoleJobs
	 */
	public TrackerConsoleJobs getTrackerConsoleJobs() {
		return trackerConsoleJobs;
	}

	/**
	 * @param trackerConsoleJobs the trackerConsoleJobs to set
	 */
	public void setTrackerConsoleJobs(TrackerConsoleJobs trackerConsoleJobs) {
		this.trackerConsoleJobs = trackerConsoleJobs;
	}

	/**
	 * @return the trackTime
	 */
	public long getTrackTime() {
		return trackTime;
	}

	/**
	 * @param trackTime the trackTime to set
	 */
	public void setTrackTime(long trackTime) {
		this.trackTime = trackTime;
	}

	/**
	 * @return the trackDate
	 */
	public Date getTrackDate() {
		return trackDate;
	}

	/**
	 * @param trackDate the trackDate to set
	 */
	public void setTrackDate(Date trackDate) {
		this.trackDate = trackDate;
	}

	/**
	 * @return the setUpDate
	 */
	public Date getSetUpDate() {
		return setUpDate;
	}

	/**
	 * @param setUpDate the setUpDate to set
	 */
	public void setSetUpDate(Date setUpDate) {
		this.setUpDate = setUpDate;
	}

	/**
	 * @return the runDate
	 */
	public Date getRunDate() {
		return runDate;
	}

	/**
	 * @param runDate the runDate to set
	 */
	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	/**
	 * @return the washUpDate
	 */
	public Date getWashUpDate() {
		return washUpDate;
	}

	/**
	 * @param washUpDate the washUpDate to set
	 */
	public void setWashUpDate(Date washUpDate) {
		this.washUpDate = washUpDate;
	}
	
	

}

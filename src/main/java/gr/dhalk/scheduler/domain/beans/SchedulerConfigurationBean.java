package gr.dhalk.scheduler.domain.beans;

import gr.dhalk.scheduler.domain.enums.SchedulerStatusEnum;

/**
 * @author Dimitris Chalkos 
 * @date 26/04/2018
 */
public class SchedulerConfigurationBean {

	private Long id;
	private String schedulerName;
	private String schedulerDescription;
	private Long timeIntervalInSeconds;
	private String targetUrl;
	private SchedulerStatusEnum status;
	
	
	public SchedulerConfigurationBean() {
		super();
	}


	/**
	 * @param id
	 * @param schedulerName
	 * @param schedulerDescription
	 * @param timeIntervalInSeconds
	 * @param targetUrl
	 * @param status
	 */
	public SchedulerConfigurationBean(Long id, String schedulerName, String schedulerDescription,
			Long timeIntervalInSeconds, String targetUrl, SchedulerStatusEnum status) {
		super();
		this.id = id;
		this.schedulerName = schedulerName;
		this.schedulerDescription = schedulerDescription;
		this.timeIntervalInSeconds = timeIntervalInSeconds;
		this.targetUrl = targetUrl;
		this.status = status;
	}
	
	
	/**
	 * @return the timeIntervalInSeconds
	 */
	public Long getTimeIntervalInSeconds() {
		return timeIntervalInSeconds;
	}
	/**
	 * @param timeIntervalInSeconds the timeIntervalInSeconds to set
	 */
	public void setTimeIntervalInSeconds(Long timeIntervalInSeconds) {
		this.timeIntervalInSeconds = timeIntervalInSeconds;
	}
	
	/**
	 * @return the status
	 */
	public SchedulerStatusEnum getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(SchedulerStatusEnum status) {
		this.status = status;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the schedulerName
	 */
	public String getSchedulerName() {
		return schedulerName;
	}


	/**
	 * @param schedulerName the schedulerName to set
	 */
	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}


	/**
	 * @return the schedulerDescription
	 */
	public String getSchedulerDescription() {
		return schedulerDescription;
	}


	/**
	 * @param schedulerDescription the schedulerDescription to set
	 */
	public void setSchedulerDescription(String schedulerDescription) {
		this.schedulerDescription = schedulerDescription;
	}


	/**
	 * @return the targetUrl
	 */
	public String getTargetUrl() {
		return targetUrl;
	}


	/**
	 * @param targetUrl the targetUrl to set
	 */
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	
	
	
}

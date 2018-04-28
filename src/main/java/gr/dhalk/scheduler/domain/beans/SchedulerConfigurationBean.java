package gr.dhalk.scheduler.domain.beans;

import java.util.HashMap;

import gr.dhalk.scheduler.domain.enums.SchedulerStatusEnum;

/**
 * @author Dimitris Chalkos 
 * @date 26/04/2018
 */
public class SchedulerConfigurationBean {

	private Long id;
	private String schedulerName;
	private String schedulerBeanName;
	private String schedulerDescription;
	private Long timeIntervalInMinutes;
	private HashMap<String,String> schedulerParams;
	private SchedulerStatusEnum status;
	private String lastExectionTime;
	
	
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
	public SchedulerConfigurationBean(Long id, String schedulerName, String schedulerBeanName, String schedulerDescription,
			Long timeIntervalInMinutes, HashMap<String,String> schedulerParams, SchedulerStatusEnum status) {
		super();
		this.id = id;
		this.schedulerName = schedulerName;
		this.schedulerBeanName = schedulerBeanName;
		this.schedulerDescription = schedulerDescription;
		this.timeIntervalInMinutes = timeIntervalInMinutes;
		this.schedulerParams = schedulerParams;
		this.status = status;
	}
	
	
	/**
	 * @return the timeIntervalInMinutes
	 */
	public Long getTimeIntervalInMinutes() {
		return timeIntervalInMinutes;
	}


	/**
	 * @param timeIntervalInMinutes the timeIntervalInMinutes to set
	 */
	public void setTimeIntervalInMinutes(Long timeIntervalInMinutes) {
		this.timeIntervalInMinutes = timeIntervalInMinutes;
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
	 * @return the schedulerParams
	 */
	public HashMap<String, String> getSchedulerParams() {
		return schedulerParams;
	}


	/**
	 * @param schedulerParams the schedulerParams to set
	 */
	public void setSchedulerParams(HashMap<String, String> schedulerParams) {
		this.schedulerParams = schedulerParams;
	}


	/**
	 * @return the schedulerBeanName
	 */
	public String getSchedulerBeanName() {
		return schedulerBeanName;
	}


	/**
	 * @return the schedulerBean
	 */
	public String getschedulerBeanName() {
		return schedulerBeanName;
	}


	/**
	 * @param schedulerBean the schedulerBean to set
	 */
	public void setSchedulerBeanName(String schedulerBeanName) {
		this.schedulerBeanName = schedulerBeanName;
	}


	/**
	 * @return the lastExectionTime
	 */
	public String getLastExectionTime() {
		return lastExectionTime;
	}


	/**
	 * @param lastExectionTime the lastExectionTime to set
	 */
	public void setLastExectionTime(String lastExectionTime) {
		this.lastExectionTime = lastExectionTime;
	}
	
	
	
}

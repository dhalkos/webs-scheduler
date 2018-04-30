/**
 * 
 */
package gr.dhalk.scheduler.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.Parameter;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean;
import gr.dhalk.scheduler.service.SchedulerConfigurationService;

/**
 * @author Dimitris Chalkos 
 * @date 27/04/2018
 */

@Scope(value = "session")
@Component(value = "schedulerConfigurationController")
@ELBeanName(value = "schedulerConfigurationController")
@Join(path = "/schedulerConfiguration/{schedulerId}", to = "/schedulerConfiguration-form.xhtml")
public class SchedulerConfigurationController {
		
	 
	@Parameter
	@Deferred
	private Long schedulerId;
	
	@Autowired
	private SchedulerConfigurationService schedulerConfigurationService;
	
	private SchedulerConfigurationBean displayedSchedulerConfiguration;
	
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
	
		try {
			
			displayedSchedulerConfiguration = schedulerConfigurationService.getScheduler(schedulerId);
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public SchedulerConfigurationBean getDisplayedSchedulerConfiguration() { 
		return displayedSchedulerConfiguration;	
	}
	
	public String save() {
		
		try {
			
			if((displayedSchedulerConfiguration.getId()!=null && displayedSchedulerConfiguration.getId().intValue()!=schedulerId.intValue()) ||
			   (displayedSchedulerConfiguration.getId()==null && schedulerId.intValue()!=0)) {
				throw new Exception("Invalid state of data");
			}
				
			schedulerConfigurationService.saveScheduler(displayedSchedulerConfiguration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/schedulerConfiguration-list.xhtml?faces-redirect=true";
    }

	
	/**
	 * @return the schedulerId
	 */
	public Long getSchedulerId() {
		return schedulerId;
	}

	/**
	 * @param schedulerId the schedulerId to set
	 */
	public void setSchedulerId(Long schedulerId) {
		this.schedulerId = schedulerId;
	}

	
}

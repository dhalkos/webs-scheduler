/**
 * 
 */
package gr.dhalk.scheduler.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
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
@Component(value = "schedulerConfigurationSearchController")
@ELBeanName(value = "schedulerConfigurationSearchController")
@Join(path = "/schedulerConfiguration", to = "/schedulerConfiguration-list.jsf")
public class SchedulerConfigurationSearchController {
		
	@Autowired
	private SchedulerConfigurationService schedulerConfigurationService;
	
	private List<SchedulerConfigurationBean> schedulerConfigurationList;
	
	
	public List<SchedulerConfigurationBean> getSchedulerConfigurationList() {
		try {
			schedulerConfigurationList =  schedulerConfigurationService.getSchedulers();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return schedulerConfigurationList;
	}
	
}

/**
 * 
 */
package gr.dhalk.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface;
import gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean;
import gr.dhalk.scheduler.domain.enums.SchedulerStatusEnum;

/**
 * @author Dimitris Chalkos 
 * @date 26/04/2018
 */

@Service("schedulerConfigurationService")
public class SchedulerConfigurationService {
	
	@Autowired BeanFactory beans;

	@Autowired
	SchedulerConfigurationDAOInterface schedulerConfigurationDAO; 
	
	public List<SchedulerConfigurationBean> getSchedulers() throws Exception{
		return schedulerConfigurationDAO.getAllSchedulers();
	}

	public List<SchedulerConfigurationBean> getActiveSchedulers() throws Exception {
		return schedulerConfigurationDAO.getSchedulersByStatus(SchedulerStatusEnum.RUNNING);
	}
	
	public List<SchedulerConfigurationBean> getInactiveSchedulers() throws Exception {
		return schedulerConfigurationDAO.getSchedulersByStatus(SchedulerStatusEnum.STOPED);
	}
	
	public SchedulerConfigurationBean getScheduler(Long schedulerId) throws Exception {
		SchedulerConfigurationBean schedulerConfiguration =  schedulerConfigurationDAO.getSchedulersById(schedulerId);
		schedulerConfiguration.setLastExectionTime(beans.getBean(schedulerConfiguration.getschedulerBeanName(), AbstractScheduler.class).getLastExectionTime());
		return schedulerConfiguration;
	}
	
	public SchedulerConfigurationBean saveScheduler(SchedulerConfigurationBean schedulerConfiguration) throws Exception {
		
		if(schedulerConfiguration!=null && schedulerConfiguration.getId()!=null) {
			
			schedulerConfigurationDAO.updateSchedulerConfiguration(schedulerConfiguration);
			beans.getBean(schedulerConfiguration.getschedulerBeanName(), AbstractScheduler.class).loadConfiguration();
			return schedulerConfigurationDAO.getSchedulersById(schedulerConfiguration.getId());
			
		} else {
			throw new Exception("SchedulerConfiguration is null");
		}
	}
}

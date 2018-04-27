/**
 * 
 */
package gr.dhalk.scheduler.dao;

import java.util.List;

import gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean;
import gr.dhalk.scheduler.domain.enums.SchedulerStatusEnum;

/**
 * @author Dimitris Chalkos 
 * @date 26/04/2018
 */
public interface SchedulerConfigurationDAOInterface {

	List<SchedulerConfigurationBean> getAllSchedulers() throws Exception;
	List<SchedulerConfigurationBean> getSchedulersByStatus(SchedulerStatusEnum status) throws Exception;
	SchedulerConfigurationBean getSchedulersById(Long schedulerConfigurationId) throws Exception;
	SchedulerConfigurationBean updateSchedulerConfiguration(SchedulerConfigurationBean schedulerConfiguration) throws Exception;
	SchedulerConfigurationBean insertSchedulerConfiguration(SchedulerConfigurationBean schedulerConfiguration) throws Exception;
	
}

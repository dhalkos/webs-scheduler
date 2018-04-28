/**
 * 
 */
package gr.dhalk.scheduler.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface;
import gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean;
import gr.dhalk.scheduler.domain.enums.SchedulerStatusEnum;

/**
 * @author Dimitris Chalkos 
 * @date 27/04/2018
 */

@Repository("schedulerConfigurationDAO")
public class SchedulerConfigurationDAOMockImpl implements SchedulerConfigurationDAOInterface {

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface#getAllSchedulers()
	 */
	
	HashMap<Long, SchedulerConfigurationBean> repositoryById = new HashMap<Long, SchedulerConfigurationBean>();
	HashMap<String, SchedulerConfigurationBean> repositoryByName = new HashMap<String, SchedulerConfigurationBean>();
	int schedulerConfigurationSequenceId = 1;
	
	
	public SchedulerConfigurationDAOMockImpl() {
		super();
		
		SchedulerConfigurationBean scheduler1 = new SchedulerConfigurationBean(new Long(1), "Sceduler name!", "delosPosisionService", "Sceduler description!", new Long(1), null, SchedulerStatusEnum.RUNNING);
		
		repositoryById.put(scheduler1.getId(), scheduler1);
		repositoryByName.put(scheduler1.getschedulerBeanName(), scheduler1);
	}

	@Override
	public List<SchedulerConfigurationBean> getAllSchedulers() throws Exception {
		
		return new ArrayList<SchedulerConfigurationBean> (repositoryById.values());
	}

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface#getSchedulersByStatus(gr.dhalk.scheduler.domain.enums.SchedulerStatusEnum)
	 */
	@Override
	public List<SchedulerConfigurationBean> getSchedulersByStatus(SchedulerStatusEnum status) throws Exception {

		throw new Exception("Method not supported!");
	}

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface#getSchedulersById(int)
	 */
	@Override
	public SchedulerConfigurationBean getSchedulersById(Long schedulerConfigurationId) throws Exception {
		
		SchedulerConfigurationBean temp = repositoryById.get(schedulerConfigurationId);
		return new SchedulerConfigurationBean(temp.getId(), temp.getSchedulerName(), temp.getschedulerBeanName(), temp.getSchedulerDescription(),temp.getTimeIntervalInMinutes(),temp.getSchedulerParams(), temp.getStatus());
		//return new SchedulerConfigurationBean(schedulerId, "Sceduler " + schedulerId.intValue() + " name!", "Sceduler " + schedulerId.intValue() + " description!", new Long(10+schedulerId.intValue()), "url" + schedulerId.intValue(), SchedulerStatusEnum.RUNNING);
	}

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface#saveSchedulerConfiguration(gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean)
	 */
	@Override
	public SchedulerConfigurationBean updateSchedulerConfiguration(SchedulerConfigurationBean schedulerConfiguration) throws Exception {

		repositoryById.put(schedulerConfiguration.getId(), schedulerConfiguration);
		repositoryByName.put(schedulerConfiguration.getschedulerBeanName(), schedulerConfiguration);
		return schedulerConfiguration;
	}

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface#insertSchedulerConfiguration(gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean)
	 */
	/*@Override
	public SchedulerConfigurationBean insertSchedulerConfiguration(SchedulerConfigurationBean schedulerConfiguration) throws Exception {
		
		schedulerConfiguration.setId(new Long(schedulerConfigurationSequenceId++));
		repositoryById.put(schedulerConfiguration.getId(), schedulerConfiguration);		
		return schedulerConfiguration;
		
	}*/

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface#getSchedulersServiceName(java.lang.String)
	 */
	@Override
	public SchedulerConfigurationBean getSchedulersByServiceName(String serviceBeanName) throws Exception {
		SchedulerConfigurationBean temp = repositoryByName.get(serviceBeanName);
		return new SchedulerConfigurationBean(temp.getId(), temp.getSchedulerName(), temp.getschedulerBeanName(), temp.getSchedulerDescription(),temp.getTimeIntervalInMinutes(),temp.getSchedulerParams(), temp.getStatus());	}

}

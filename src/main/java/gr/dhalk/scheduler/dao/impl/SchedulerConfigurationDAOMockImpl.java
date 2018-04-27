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
	
	HashMap<Long, SchedulerConfigurationBean> repository = new HashMap<Long, SchedulerConfigurationBean>();
	int schedulerConfigurationSequenceId = 1;
	
	@Override
	public List<SchedulerConfigurationBean> getAllSchedulers() throws Exception {
		
		if(repository.size()==0) {
			repository.put(new Long(1), new SchedulerConfigurationBean(new Long(1), "Sceduler name!", "Sceduler description!", new Long(10), "url", SchedulerStatusEnum.RUNNING));
		}
		return new ArrayList<SchedulerConfigurationBean> (repository.values());
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
		
		SchedulerConfigurationBean temp = repository.get(schedulerConfigurationId);
		return new SchedulerConfigurationBean(temp.getId(), temp.getSchedulerName(), temp.getSchedulerDescription(),temp.getTimeIntervalInSeconds(),temp.getTargetUrl(), temp.getStatus());
		//return new SchedulerConfigurationBean(schedulerId, "Sceduler " + schedulerId.intValue() + " name!", "Sceduler " + schedulerId.intValue() + " description!", new Long(10+schedulerId.intValue()), "url" + schedulerId.intValue(), SchedulerStatusEnum.RUNNING);
	}

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface#saveSchedulerConfiguration(gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean)
	 */
	@Override
	public SchedulerConfigurationBean updateSchedulerConfiguration(SchedulerConfigurationBean schedulerConfiguration) throws Exception {

		repository.put(schedulerConfiguration.getId(), schedulerConfiguration);
		return schedulerConfiguration;
	}

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface#insertSchedulerConfiguration(gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean)
	 */
	@Override
	public SchedulerConfigurationBean insertSchedulerConfiguration(SchedulerConfigurationBean schedulerConfiguration) throws Exception {
		
		schedulerConfiguration.setId(new Long(schedulerConfigurationSequenceId++));
		repository.put(schedulerConfiguration.getId(), schedulerConfiguration);		
		return schedulerConfiguration;
		
	}

}

/**
 * 
 */
package gr.dhalk.scheduler.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import gr.dhalk.scheduler.dao.SchedulerConfigurationDAOInterface;
import gr.dhalk.scheduler.domain.beans.SchedulerConfigurationBean;
import gr.dhalk.scheduler.domain.enums.SchedulerStatusEnum;

/**
 * @author Dimitris Chalkos 
 * @date 28/04/2018
 */
public abstract class AbstractScheduler {

	
	private static final Logger log = LoggerFactory.getLogger(DelosPosisionService.class);

	@Autowired
	SchedulerConfigurationDAOInterface schedulerConfigurationDAO; 
	
	String lastExectionTime = null;
	SchedulerConfigurationBean schedulerConfiguration;
	
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");	
	public abstract void doTheJob();
	public abstract String getServiceBeanName();

	int minutesFromPreviusExecution = 0;
	
	public void loadConfiguration() throws Exception {
		log.info("Reload Configuration for scheduler {}", getServiceBeanName());		
		schedulerConfiguration = schedulerConfigurationDAO.getSchedulersByServiceName(getServiceBeanName());
	}
	
	/**
	 * @return the lastExectionTime
	 */
	public String getLastExectionTime() {
		return lastExectionTime;
	}
	
	
	@Scheduled(fixedRate = 60000)
	public void runScheduler() throws Exception{
		
		minutesFromPreviusExecution++;
		
		if(schedulerConfiguration==null) {
			loadConfiguration();
		}
		
		if(schedulerConfiguration.getStatus().equals(SchedulerStatusEnum.RUNNING)) {
			
			if(minutesFromPreviusExecution>=schedulerConfiguration.getTimeIntervalInMinutes()) {
				
				minutesFromPreviusExecution = 0;
				lastExectionTime = dateFormat.format(new Date());
				log.info("Start Execution at {}", lastExectionTime);				
				doTheJob();			
				log.info("Finish Execution at {}", dateFormat.format(new Date()));
				
				
			}
		}
		
	}
	
	
}

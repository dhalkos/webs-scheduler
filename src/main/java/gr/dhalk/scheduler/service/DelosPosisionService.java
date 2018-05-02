package gr.dhalk.scheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Dimitris Chalkos 
 * @date 28/04/2018
 */

@Component(value = "delosPosisionService")
@Service("delosPosisionService")
public class DelosPosisionService extends AbstractScheduler {

	private static final Logger log = LoggerFactory.getLogger(DelosPosisionService.class);
	
	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.service.AbstractScheduler#runScheduler()
	 */
	public void doTheJob() {
		
		log.info("Executing DelosPosisionService");
			
	}

	/* (non-Javadoc)
	 * @see gr.dhalk.scheduler.service.AbstractScheduler#doServiceBeanName()
	 */
	@Override
	public String getServiceBeanName() {
		
		return "delosPosisionService";
		
	}
	
}

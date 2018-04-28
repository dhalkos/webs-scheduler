/**
 * 
 */
package gr.dhalk.scheduler.controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import gr.dhalk.scheduler.domain.enums.SchedulerStatusEnum;

/**
 * @author Dimitris Chalkos 
 * @date 28/04/2018
 */
@ManagedBean (name="referenceData")
@ApplicationScoped
public class ReferenceDataController {

	public SchedulerStatusEnum[] getSchedulerStatuses() {
		return SchedulerStatusEnum.values();
	}
}

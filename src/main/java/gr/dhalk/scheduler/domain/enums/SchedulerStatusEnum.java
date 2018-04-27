/**
 * 
 */
package gr.dhalk.scheduler.domain.enums;

/**
 * @author Dimitris Chalkos 
 * @date 26/04/2018
 */
public enum SchedulerStatusEnum {
	
	RUNNING ("scheduler_runing_msg"),
	STOPED ("scheduler_stoped_msg"),
	UNKNOWN ("scheduler_unknown_msg");

	private String schedulerStatusMsgId;

	/**
	 * @param schedulerStatusMsgId
	 */
	private SchedulerStatusEnum(String schedulerStatusMsgId) {
		this.schedulerStatusMsgId = schedulerStatusMsgId;
	}

	/**
	 * @return the schedulerStatusMsgId
	 */
	public String getSchedulerStatusMsgId() {
		return schedulerStatusMsgId;
	}
	
	
}

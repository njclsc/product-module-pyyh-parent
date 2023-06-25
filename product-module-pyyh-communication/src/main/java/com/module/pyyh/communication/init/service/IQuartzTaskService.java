package com.module.pyyh.communication.init.service;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;

public interface IQuartzTaskService<T, E> {

	public T loadJobBean(E e)throws Exception;
	public <P extends Trigger> P loadTrigger()throws Exception;
	public void registTask()throws Exception;
}

package com.module.pyyh.communication.init.service;

import org.quartz.JobDetail;
import org.quartz.Scheduler;

import com.module.pyyh.communication.pojo.QuartzConfigPojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AQuartzTaskOperate<T, E> implements IQuartzTaskService<T, E>{
	private QuartzConfigPojo qcp;
	private Scheduler scheduler;
	public AQuartzTaskOperate(T t, E e){
		this.scheduler = (Scheduler)e;
		this.qcp = (QuartzConfigPojo)t;
	}
	@Override
	public void registTask() throws  Exception {
		// TODO Auto-generated method stub
		scheduler.scheduleJob((JobDetail)loadJobBean(null), loadTrigger());
	}

}

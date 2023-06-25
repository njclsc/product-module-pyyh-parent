package com.module.pyyh.communication.init.serviceimp;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.module.pyyh.communication.init.service.AQuartzTaskOperate;
import com.module.pyyh.communication.pojo.QuartzConfigPojo;

public class QuartzTaskImp<T, E> extends AQuartzTaskOperate<T, E>{

	public QuartzTaskImp(T t, E e){
		super(t, e);
	}
	@SuppressWarnings("unchecked")
	@Override
	public T loadJobBean(E e) throws Exception {
		// TODO Auto-generated method stub
		String jobGroup = this.getQcp().getGroupJobName();
		String jobName = this.getQcp().getJobName();
		String jobClassName = this.getQcp().getJobClassName();
		System.out.println(jobGroup + "  " + jobName + "  " + jobClassName);
		Class<? extends QuartzJobBean> jobClass = (Class<? extends QuartzJobBean>)Class.forName(jobClassName);
		JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();
		return (T)jobDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <P extends Trigger> P loadTrigger() throws Exception {
		// TODO Auto-generated method stub
		String triggerGroupName = this.getQcp().getGroupTriggerName();
		String triggerName = this.getQcp().getTriggerName();
		String cron = this.getQcp().getCron();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
		return (P)trigger;
	}

}

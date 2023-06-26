package com.module.pyyh.communication.init;

import java.io.File;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.module.pyyh.communication.init.serviceimp.QuartzTaskImp;
import com.module.pyyh.communication.pojo.QuartzConfigPojo;
import com.module.pyyh.communication.util.BaseUtil;
import com.module.pyyh.communication.util.ContainerUtil;

@Component
public class InitStatusListener implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private Scheduler scheduler;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		loadQuartz(scheduler);
	}
	
	private void loadQuartz(Scheduler scheduler){
		try {
			for(File f : BaseUtil.listFile(ContainerUtil.getAPPLICATION_ROOT_PATH() + "/source-config/", "quartz-task")){
				for(QuartzConfigPojo qcp : BaseUtil.dataToJson(1, BaseUtil.loadFile(f.getPath()), QuartzConfigPojo.class).getJobs()){
					if(qcp.isUsed()){
						new QuartzTaskImp<QuartzConfigPojo, Scheduler>(qcp, scheduler).registTask();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

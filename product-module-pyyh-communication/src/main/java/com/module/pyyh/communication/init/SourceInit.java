package com.module.pyyh.communication.init;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.module.pyyh.communication.init.service.ACommunicationOperate;
import com.module.pyyh.communication.init.service.ICommunicationService;
import com.module.pyyh.communication.pojo.CommunicationConfigPojo;
import com.module.pyyh.communication.util.BaseUtil;
import com.module.pyyh.communication.util.ContainerUtil;

@Component
public class SourceInit {
	
	@Bean
	public static String initSource(){
		try{
			staticSource();
			communicationSource();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	private static void staticSource(){
		ContainerUtil.setAPPLICATION_ROOT_PATH(System.getProperty("user.dir"));
	}
	private static void communicationSource() throws Exception{
		File[] fs = BaseUtil.listFile(ContainerUtil.getAPPLICATION_ROOT_PATH() + "/source-config/", "communication");
		for(File f : fs){
			byte[] b = BaseUtil.loadFile(f.getPath());
			StringBuffer sb = new StringBuffer();
			for(byte _b : b){
				sb.append((char)_b);
			}
			CommunicationConfigPojo commPojo = JSONObject.parseObject(sb.toString(), CommunicationConfigPojo.class);
			if(commPojo.isUsed()){
				Class<?>[] parameterTypes = {Object.class};
				Object[] parameters = {commPojo};
				ICommunicationService<?, ?> commService = (ICommunicationService<?, ?>)Class.forName(commPojo.getImpClass()).getConstructor(parameterTypes).newInstance(parameters);
				commService.operate();
			}
			
		}
	}
}

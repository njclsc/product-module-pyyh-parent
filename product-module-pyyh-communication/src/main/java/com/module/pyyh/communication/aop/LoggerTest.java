package com.module.pyyh.communication.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
public class LoggerTest {

	@Bean
	public void test() throws InterruptedException{
		Logger log = LoggerFactory.getLogger("console");
//		System.out.println(log.getName() + "  " + log.getClass());
		for(int i = 0; i < 1000; i++){
			log.info("111111111111111");
		}
		Logger log1 = LoggerFactory.getLogger("rolling");
		for(int i = 0; i < 5000; i++){
			log1.info("111111111111111");
			Thread.sleep(100);
		}
		for(int i = 0; i < 100; i++){
			System.out.println("333333333333333333333");
			
		}
	}
}

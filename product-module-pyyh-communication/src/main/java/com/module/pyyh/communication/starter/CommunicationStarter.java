package com.module.pyyh.communication.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.module.pyyh.communication"})
@SpringBootApplication
public class CommunicationStarter {

	public static void main(String[] args){
		SpringApplication.run(CommunicationStarter.class, args);
	}
}

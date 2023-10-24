package com.module.pyyh.login.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.module.pyyh.login"})
@SpringBootApplication
public class LoginStarter {

	public static void main(String[] args){
		SpringApplication.run(LoginStarter.class, args);
	}
}

package com.venky.interview;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;

import com.venky.interview.Pages.TestPage;
import com.venky.interview.seleniumframework.AbstractPage;

@SpringBootApplication
public class TechnicalHandsonApplication {


	
	@Autowired
	private ConfigMgr testProperties;
	 
	 
	@Autowired
	TestPage testPage;
	
	public static void main(String[] args) {
		SpringApplication.run(TechnicalHandsonApplication.class, args);
	}
	
	@PostConstruct
	public void driver()
	{
		System.out.println(testProperties.getConfig().get("environment"));
	}

}

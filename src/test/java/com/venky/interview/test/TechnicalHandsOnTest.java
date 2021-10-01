package com.venky.interview.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.venky.interview.ConfigMgr;
import com.venky.interview.WebDriverMgr;
import com.venky.interview.Pages.TestPage;

@SpringBootTest
public class TechnicalHandsOnTest {

	@Autowired
	ConfigMgr config;
	
	@Autowired
	WebDriverMgr driverMgr;
	
	@Autowired
	TestPage testPage;
	
	@Test
	public void TestStaticPage()
	{
		assertEquals("Amazon.com. Spend less. Smile more.",testPage.getTitle());
	}
	
	@PostConstruct
	public void TestPage()
	{
		//testPage.testPage();
		driverMgr.setupDriver();
	}
}

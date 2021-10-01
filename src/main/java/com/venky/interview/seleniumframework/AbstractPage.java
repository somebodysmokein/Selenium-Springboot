package com.venky.interview.seleniumframework;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.venky.interview.WebDriverMgr;

@Component
/*@Primary
@ConfigurationProperties(prefix = "selenium")*/
public class AbstractPage {

	/*@Value("${app.url}")
	protected String url;
	
	@Value("${test.environment}")
	protected String environment;
	
	@Qualifier("${}")
	Hashtable<String, String> capsHashtable;*/
	
	/*protected Map<String,String> application;
	protected Map<String,Hashtable<String, String>> config;
	protected Map<String,String> users; */
	
	@Autowired
	WebDriverMgr driverMgr;
	
	
	WebDriver Driver;
	
	@PostConstruct
	public void initElts()
	{
		PageFactory.initElements(Driver, this);
	}
	
	
	public void navigatetoUrl(String url)
	{
		this.Driver.navigate().to(url);
	}
	
	
	public String getTitle()
	{
		System.out.println(this.Driver.getTitle());
		return this.Driver.getTitle();
	}
}

package com.venky.interview;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class WebDriverMgr {

	protected WebDriver driver;

	@Autowired
	protected ConfigMgr mgr;

	// protected Environments env;

	private boolean latestVersion = true;
	private String browserVersion;
	private Hashtable<String, String> capabilities;

	/*
	 * public void setupDriver() { String envrionment =
	 * mgr.getConfig().get("environment").get("testenv").toUpperCase(); switch
	 * (envrionment) { case "CHROME": browserVersion =
	 * mgr.getConfig().get("chrome").get("version"); if
	 * (ifspecificVersion("chrome")) {
	 * WebDriverManager.chromedriver().driverVersion(browserVersion).setup(); } else
	 * { WebDriverManager.chromedriver().setup(); } driver = new ChromeDriver();
	 * break;
	 * 
	 * case "IE": browserVersion = mgr.getConfig().get("ie").get("version"); if
	 * (ifspecificVersion("ie")) {
	 * WebDriverManager.iedriver().driverVersion(browserVersion).setup(); } else {
	 * WebDriverManager.iedriver().setup(); } driver = new InternetExplorerDriver();
	 * break;
	 * 
	 * case "FIREFOX": browserVersion =
	 * mgr.getConfig().get("firefox").get("version"); if
	 * (ifspecificVersion("firefox")) {
	 * WebDriverManager.firefoxdriver().driverVersion(browserVersion).setup(); }
	 * else { WebDriverManager.firefoxdriver().setup(); } driver = new
	 * FirefoxDriver(); break;
	 * 
	 * case "EDGE": browserVersion = mgr.getConfig().get("edge").get("version"); if
	 * (ifspecificVersion("edge")) {
	 * WebDriverManager.edgedriver().driverVersion(browserVersion).setup(); } else {
	 * WebDriverManager.edgedriver().setup(); } driver = new EdgeDriver(); break;
	 * 
	 * case "BROWSERSTACK": capabilities=mgr.getConfig().get("browserstack"); String
	 * key; DesiredCapabilities caps = new DesiredCapabilities(); // Iterate over
	 * the hashtable and set the capabilities Set<String> keys =
	 * capabilities.keySet(); Iterator<String> itr = keys.iterator(); while
	 * (itr.hasNext()) { key = itr.next(); caps.setCapability(key,
	 * capabilities.get(key)); }
	 * 
	 * 
	 * try { driver = new RemoteWebDriver(new URL(mgr.getApplication().get("url")),
	 * caps); } catch (MalformedURLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } }
	 * 
	 * public boolean ifspecificVersion(String browser) { if
	 * (!mgr.getConfig().get(browser).get("version").equalsIgnoreCase("latest")) {
	 * latestVersion = false; } return latestVersion; }
	 */

	@Bean
	@ConditionalOnProperty(name = "${selenium.config.environment.testenv}", havingValue = "Chrome")
	public WebDriver getChrome() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

	@Bean
	public WebDriver getFirefox() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	@Bean
	public WebDriver getBrowserStack()
	{
		capabilities=mgr.getConfig().get("browserstack"); 
		String key; 
		DesiredCapabilities caps = new DesiredCapabilities();
		 Set<String> keys = capabilities.keySet(); 
		 Iterator<String> itr = keys.iterator(); 
		 while(itr.hasNext()) 
		 { 
			 key = itr.next(); 
			 caps.setCapability(key,capabilities.get(key));
			 try { 
				 driver = new RemoteWebDriver(new URL(mgr.getApplication().get("url")),caps); 
				 } catch (MalformedURLException e) { 
					  e.printStackTrace(); 
					  }
		 }
		 return driver;
		}
				   
	
}

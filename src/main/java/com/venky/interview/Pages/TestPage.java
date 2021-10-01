package com.venky.interview.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.venky.interview.seleniumframework.AbstractPage;

@Component
public class TestPage extends AbstractPage {

	@FindBy(id="twotabsearchtextbox")
	WebElement twotabsearchtextbox;
	
	@FindBy(xpath="//*[@id=\"nav-search-submit-button\"]")
	WebElement submitBtn;
	
	public String testPage()
	{
		return submitBtn.getTagName();
	}
	
//	public void performTest()
//	{
//		for()
//	}
	
}

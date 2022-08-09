package com.proj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCases {
	
	private WebDriver driver;
	
	@BeforeClass
	public void setupDriver() {
		
		driver = BrowserFactory.getChromeDriver();
	}

	@BeforeTest
	public void initPageFactory() {
		Login loginPage = PageFactory.initElements(driver, Login.class);
	}
	
	@Test
	public void gmailTest() {
	
		// Perform Login
		Assert.assertEquals(new Login(driver).performLogin(), true);	
	}
}

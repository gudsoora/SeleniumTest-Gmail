package com.proj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

	WebDriver driver;
	 
	public Login(WebDriver driver){
	this.driver=driver;
	}
	
	@FindBy(how=How.ID,using="identifierId")
	@CacheLookup
	WebElement emailId;
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement password;
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Next')]/parent::button")
	@CacheLookup
	WebElement button1;
	
	public boolean performLogin() {

		boolean isLoginDone;
		driver.get("https://mail.google.com/mail/");
		emailId.sendKeys("test@gmail.com");
		WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Next')]/parent::button"));
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		if (button.isEnabled()) {
				button.click();
		} else {
			System.out.println("Not Enabled");
		}
		
		password.sendKeys("1234");
		if (button1.isEnabled()) {
			button1.click();
	} else {
		System.out.println("Not Enabled");
	}
		isLoginDone  = true;
		
		return isLoginDone;
	}
}

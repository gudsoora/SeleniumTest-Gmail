package com.proj;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	private static WebDriver driver;

	private static WebDriver getDriver(String driverName) {

		if (driver == null) {

			switch (driverName) {
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver",
						new TestHelper().getProperty("/driver.properties", "chrome.driver.location"));
				options.addArguments("--disable-notifications");
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				driver = new ChromeDriver(options);
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				options.addArguments("--disable-blink-features=AutomationControlled");
				options.addArguments(
						"user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");

				break;

			default:
				break;
			}
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		}

		return driver;
	}

	public static WebDriver getChromeDriver() {

		return getDriver("chrome");
	}

}

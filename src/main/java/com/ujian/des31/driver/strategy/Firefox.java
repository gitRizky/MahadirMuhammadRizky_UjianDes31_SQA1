package com.ujian.des31.driver.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{

	public WebDriver setStrategy() {
		System.setProperty("webdriver.gecko.driver", "C:\\chromedriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}

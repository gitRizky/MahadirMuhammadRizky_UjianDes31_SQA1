package com.ujian.des31.driver;

import org.openqa.selenium.WebDriver;

import com.ujian.des31.driver.strategy.DriverStrategy;
import com.ujian.des31.driver.strategy.DriverStrategyImplementer;

public class DriverSingleton {
	private static DriverSingleton instance = null;
	private static WebDriver driver;

	private DriverSingleton(String driver) {
		instantiate(driver);
	}

	private WebDriver instantiate(String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().window().maximize();
		return driver;

	}

	public static DriverSingleton getInstance(String driver) {
		if (instance == null) {
			instance = new DriverSingleton(driver);
		}
		return instance;
	}

	public static void closeObjectInstance() {
		instance = null;
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}

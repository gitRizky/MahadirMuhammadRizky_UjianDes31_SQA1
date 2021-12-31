package com.ujian.des31.driver.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.des31.driver.DriverSingleton;


public class HomePage {
	private WebDriver driver;

	public HomePage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(css = "body > p > a")
	private WebElement dismiss;
	
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li")
	private List<WebElement> menuTopbar;
	
	
	public void toMyAccount() {
		dismiss.click();
		menuTopbar.get(1).click();
		
	}
	
}

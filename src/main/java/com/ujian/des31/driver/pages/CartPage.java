package com.ujian.des31.driver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.des31.driver.DriverSingleton;

public class CartPage {
	private WebDriver driver;

	public CartPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")
	private WebElement btnCheckout;
	
	public void toCheckout() {
		btnCheckout.click();
	}
	
}

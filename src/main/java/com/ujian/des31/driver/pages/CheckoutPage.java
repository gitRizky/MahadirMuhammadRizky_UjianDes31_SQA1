package com.ujian.des31.driver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.des31.driver.DriverSingleton;

public class CheckoutPage {
	private WebDriver driver;

	public CheckoutPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "#post-7 > div > div > div > p.woocommerce-thankyou-order-received")
	private WebElement txtConfimation;

	@FindBy(id = "billing_first_name")
	private WebElement billing_first_name;

	@FindBy(id = "billing_last_name")
	private WebElement billing_last_name;

	@FindBy(id = "select2-billing_country-container")
	private WebElement billing_country;

	@FindBy(id = "billing_address_1")
	private WebElement billing_address_1;

	@FindBy(id = "billing_city")
	private WebElement billing_city;

	@FindBy(id = "select2-billing_state-container")
	private WebElement billing_state;

	@FindBy(id = "billing_postcode")
	private WebElement billing_postcode;

	@FindBy(id = "billing_phone")
	private WebElement billing_phone;

	@FindBy(xpath = "//*[@id=\"payment\"]/div/div/p/label/span[1]")
	private WebElement terms;

	@FindBy(id = "place_order")
	private WebElement place_order;

	public String getTxtConfimation() {
		return txtConfimation.getText();
	}

	public void fillForms(String fName, String lName, String address, String city, String postCode, String phone) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billing_first_name.sendKeys(fName);
		billing_last_name.sendKeys(lName);
		driver.findElement(By.id("select2-billing_country-container")).click();
		driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys("indonesia");
		driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys(Keys.ENTER);
		billing_address_1.sendKeys(address);
		billing_city.sendKeys(city);
		driver.findElement(By.id("select2-billing_state-container")).click();
		driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys("jawa barat");
		driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys(Keys.ENTER);
		billing_postcode.sendKeys(postCode);
		billing_phone.sendKeys(phone);
	}
	
	public void confirmData() {
		terms.click();
		place_order.click();
	}

}

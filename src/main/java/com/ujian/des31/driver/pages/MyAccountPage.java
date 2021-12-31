package com.ujian.des31.driver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.des31.driver.DriverSingleton;

public class MyAccountPage {
	private WebDriver driver;

	public MyAccountPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "#post-8 > div > div > div > p:nth-child(2) > strong:nth-child(1)")
	private WebElement txtUsername;

	@FindBy(id = "reg_username")
	private WebElement usernameForm;

	@FindBy(id = "reg_email")
	private WebElement emailForm;

	@FindBy(id = "reg_password")
	private WebElement passwordForm;

	@FindBy(css = "#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button")
	private WebElement regisBtn;

	@FindBy(css = "#post-8 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--orders > a")
	private WebElement lstContent;

	@FindBy(css = "#post-8 > div > div > div > div.woocommerce-message.woocommerce-message--info.woocommerce-Message.woocommerce-Message--info.woocommerce-info > a")
	private WebElement browserBtn;

	public void toOrders() {
		lstContent.click();
		browserBtn.click();
	}

	public String getTxtName() {
		return txtUsername.getText();

	}

	public void fillForm(String name, String email, String password) {
		usernameForm.sendKeys(name);
		emailForm.sendKeys(email);
		passwordForm.sendKeys(password);

	}

	public void clickRegis() {
		regisBtn.click();

	}

}

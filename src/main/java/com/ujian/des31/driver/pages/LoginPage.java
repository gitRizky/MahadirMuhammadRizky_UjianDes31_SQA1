package com.ujian.des31.driver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.des31.driver.DriverSingleton;

public class LoginPage {
	private WebDriver driver;

	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(css = "#login > p.login.message")
	private WebElement loginMessage;
	
	@FindBy(id= "user_login")
	private WebElement userEmail;
	
	@FindBy(id = "user_pass")
	private WebElement userPsswrd;
	
	@FindBy(id = "wp-submit")
	private WebElement loginBtn;
	
	public void login(String email, String password) {
		userEmail.sendKeys(email);
		userPsswrd.sendKeys(password);
		loginBtn.click();
		
	}
	
	public String getTxtMessage() {
		return loginMessage.getText();
	}
	
}

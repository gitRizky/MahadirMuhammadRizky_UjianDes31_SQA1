package com.ujian.des31.driver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.des31.driver.DriverSingleton;

public class ShopPage {
	private WebDriver driver;
	private Actions act;

	public ShopPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		act = new Actions(driver);

	}

	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[3]/div/div[1]/div[2]/div[1]/div/div[1]/a/img")
	private WebElement shoes;

	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[3]/div/div[1]/div[1]/div[1]/a")
	private WebElement compareTo;

	@FindBy(css = "#DataTables_Table_0 > tbody > tr.add-to-cart.odd > td > a")
	private WebElement selectOptions;
	
	@FindBy(xpath = "//*[@id=\"cboxLoadedContent\"]/iframe")
	private WebElement frame;
	
	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/a/img")
	private WebElement glass;

	public void chooseProduct1() {
		act.moveToElement(shoes).perform();
		compareTo.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(frame);
		selectOptions.click();

	}
	
	public void chooseProduct2() {
		act.moveToElement(glass).click().perform();

	}

}

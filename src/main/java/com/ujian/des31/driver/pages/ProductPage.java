package com.ujian.des31.driver.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.des31.driver.DriverSingleton;

public class ProductPage {
	private WebDriver driver;

	public ProductPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "pa_color")
	private WebElement color;

	@FindBy(id = "pa_size")
	private WebElement size;

	@FindBy(css = "#product-1281 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement addToCart;

	@FindBy(css = "#noo-site > div.noo-container-shop.noo-shop-wrap.noo-shop-single-fullwidth > div > div > div.woocommerce-notices-wrapper > div")
	private WebElement txtConfirm;

	@FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[2]/div/div/div/a")
	private WebElement _search;

	@FindBy(css = "#noo-site > header > div.search-header.search-header-eff > div.noo-container > form > input.form-control")
	private WebElement _inputSearch;

	@FindBy(css = "#product-1348 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement addToCart2;
	
	@FindBy(xpath = "//*[@id=\"nav-menu-item-cart\"]/a")
	private WebElement cart;
	
	public void toCart() {
		cart.click();
	}

	public void searchItem(String item) {
		_search.click();
		_inputSearch.sendKeys(item);
		_inputSearch.sendKeys(Keys.ENTER);
	}

	public String getConfirmTxt() {
		return txtConfirm.getText();
	}

	public void addItem1() {
		color.click();
		chooseOption(color);
		size.click();
		chooseOption(size);
		addToCart.click();

	}

	public void addItem2() {
		color.click();
		chooseOption(color);
		size.click();
		chooseOption(size);
		addToCart2.click();

	}

	public void chooseOption(WebElement webElement) {
		webElement.sendKeys(Keys.DOWN);
		webElement.sendKeys(Keys.ENTER);
	}

}

package com.ujian.des31.glue;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ujian.des31.config.AutomationFrameworkConfigJava;
import com.ujian.des31.driver.DriverSingleton;
import com.ujian.des31.driver.pages.CartPage;
import com.ujian.des31.driver.pages.CheckoutPage;
import com.ujian.des31.driver.pages.HomePage;
import com.ujian.des31.driver.pages.LoginPage;
import com.ujian.des31.driver.pages.MyAccountPage;
import com.ujian.des31.driver.pages.ProductPage;
import com.ujian.des31.driver.pages.ShopPage;
import com.ujian.des31.driver.utils.ConfigurationProperties;
import com.ujian.des31.driver.utils.Constans;
import com.ujian.des31.driver.utils.TestCases;
import com.ujian.des31.driver.utils.Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfigJava.class)
public class StepDefinition {
	private WebDriver driver;
	private HomePage homePage;
	private MyAccountPage myAccountPage;
	private LoginPage loginPage;
	private ShopPage shopPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	TestCases[] testCases;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");

	@Autowired
	ConfigurationProperties configProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configProperties.getBrowser());
		driver = DriverSingleton.getDriver();
		homePage = new HomePage();
		myAccountPage = new MyAccountPage();
		loginPage = new LoginPage();
		shopPage = new ShopPage();
		productPage = new ProductPage();
		cartPage = new CartPage();
		checkoutPage = new CheckoutPage();
		testCases = TestCases.values();
		this.extentTest = report.startTest(testCases[Utility.testCount].getTestName());
		Utility.testCount++;
	}

	@Given("^User go to website")
	public void toWebsite() {
		driver.get(Constans.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constans.URL);

	}

	@When("^User click my account")
	public void gotoMyAccount() {
		homePage.toMyAccount();
		extentTest.log(LogStatus.PASS, "User click my account");
	}

	@When("^User fill register form and click register")
	public void toLogin() {
		myAccountPage.fillForm(configProperties.getName(), configProperties.getEmail(), Constans.PASSWORD);
		myAccountPage.clickRegis();
		extentTest.log(LogStatus.PASS, "User fill register form and click register");
	}

	@Then("^New account already created")
	public void successCreate() {
		assertThat(loginPage.getTxtMessage(), containsString("Please log back in to continue."));
		extentTest.log(LogStatus.PASS, "New account already created");

	}

	@When("^User fill login form and click login")
	public void toAccount() {
		loginPage.login(configProperties.getEmail(), Constans.PASSWORD);
		extentTest.log(LogStatus.PASS, "User fill login form and click login");

	}

	@Then("^User able to access his account")
	public void verifiedSuccess() {
		assertThat(myAccountPage.getTxtName(), containsString(configProperties.getName()));
		extentTest.log(LogStatus.PASS, "User able to access his account");

	}

	@When("^User go to product")
	public void toProduct() {
		myAccountPage.toOrders();
		extentTest.log(LogStatus.PASS, "User go to product");

	}

	@When("^User choose shoes and select options")
	public void chooseOption() {
		shopPage.chooseProduct1();
		extentTest.log(LogStatus.PASS, "User choose shoes and select options");

	}

	@When("^User select options and add to cart")
	public void addToCart() {
		productPage.addItem1();
		extentTest.log(LogStatus.PASS, "User select options and add to cart");

	}

	@Then("^Item add to cart")
	public void addSuccess() {
		assertThat(productPage.getConfirmTxt(), containsString("has been added to your cart"));
		extentTest.log(LogStatus.PASS, "Item add to cart");

	}

	@When("^User search product and enter")
	public void searchProduct() {
		productPage.searchItem(configProperties.getSearch());
		extentTest.log(LogStatus.PASS, "User search product and enter");

	}

	@When("^Choose product in the shop page")
	public void chooseGlass() {
		shopPage.chooseProduct2();
		extentTest.log(LogStatus.PASS, "Choose product in the shop page");

	}

	@When("^select option in the product page and add to cart")
	public void addToCart2() {
		productPage.addItem2();
		extentTest.log(LogStatus.PASS, "select option in the product page and add to cart");

	}

	@Then("^Glass add to cart")
	public void addGlassSuccess() {
		assertThat(productPage.getConfirmTxt(), containsString("has been added to your cart"));
		extentTest.log(LogStatus.PASS, "Glass add to cart");

	}

	@When("^User go to the cart page")
	public void gotoCartPage() {
		productPage.toCart();
		extentTest.log(LogStatus.PASS, "User go to the cart page");

	}

	@When("^Click proceed to checkout")
	public void toCheckout() {
		cartPage.toCheckout();
		extentTest.log(LogStatus.PASS, "Click proceed to checkout");

	}

	@When("^fill all form data and agree terms and order")
	public void fillFormOrder() {
		checkoutPage.fillForms(configProperties.getFname(), configProperties.getFname(), configProperties.getAddress(),
				configProperties.getCity(), configProperties.getPostcode(), configProperties.getPhone());
		checkoutPage.confirmData();
		extentTest.log(LogStatus.PASS, "fill all form data and agree terms and order");

	}

	@Then("^Get confirmation")
	public void confirmationOrder() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat(checkoutPage.getTxtConfimation(), containsString("Thank you. Your order has been received."));
		extentTest.log(LogStatus.PASS, "Get confirmation");
		DriverSingleton.closeObjectInstance();

	}

	@After
	public void closeObjects() {
		report.endTest(this.extentTest);
		report.flush();

	}

}

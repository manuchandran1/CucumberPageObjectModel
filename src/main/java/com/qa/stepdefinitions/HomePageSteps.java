package com.qa.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomePageSteps extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	@Given("^user opens the browser$")
	public void user_opens_the_browser() {

		TestBase.initilization();
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() {
		loginPage = new LoginPage();
		String loginTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", loginTitle);
	}

	@Then("^user logs in to the application$")
	public void user_logs_in_to_the_application() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^validate home page title$")
	public void validate_home_page_title() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homePageTitle);
	}
	
	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}


}

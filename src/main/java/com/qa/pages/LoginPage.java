package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase {

	//Initialize the Page Factory

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Objects
	@FindBy(name = "username")
	WebElement usernmae;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginButton;

	@FindBy(xpath = "//a[@contains(text(),'Sign Up')]")
	WebElement signUpButton;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement imageCRMLogo;
	
	//Actions:
	
	public String validateLoginPageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() 
	{
		return imageCRMLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd) 
	{
		usernmae.sendKeys(uname);
		password.sendKeys(pwd);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginButton);
		
		return new HomePage();
		
	}
	
	
}

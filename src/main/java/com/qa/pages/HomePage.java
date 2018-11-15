package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase
{
	
	// Constructor
	
	HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//	Page Objects - Use Frames
	@FindBy(xpath = "//*[@contains(text(),'Manu Chandran')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[@contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath = "//a[@contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	//	Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContactsLink() 
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(contactLink).build().perform();
		newContactLink.click();
	}
	
	
}

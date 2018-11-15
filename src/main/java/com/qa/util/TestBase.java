package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	// Constructor for reading Properties 
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	// Initialize base class
	public static void initilization() {
		
		String browserName = prop.getProperty("browser");

		
		if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
		}
		
		if(browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
			driver = new FirefoxDriver();

		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	} 

}

package com.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.ProductPage;
import com.qa.pages.SearchPage;

public class BaseTest {
	
	WebDriver driver;
	Properties prop;
	BaseClass bc;
	HomePage homePage;
	SearchPage searchPage;
	ProductPage productPage;
	
	
	@BeforeTest
	public void setUp()
	{
		bc = new BaseClass();
		prop = bc.init_prop();
		driver = bc.init_driver(prop);
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
		productPage = new ProductPage(driver);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}

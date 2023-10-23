package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	private WebDriver driver;
	
	private By HeadTailsSearchBar = By.xpath("(//input[@name='q'])[2]");
	
	public HomePage(WebDriver driver)
	{
		
		this.driver = driver ;
	    PageFactory.initElements(driver, this);
		//this.driver=driver;
	}
	
	public String homePageTitle()
	{
		return driver.getTitle().trim();
	}
	
	public SearchPage searchProduct(String search)
	{
		driver.findElement(HeadTailsSearchBar).sendKeys(search,Keys.ENTER);
		return new SearchPage(driver);
		
	}
	
	
	

}

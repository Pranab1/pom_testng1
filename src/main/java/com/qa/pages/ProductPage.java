package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	private WebDriver driver;
	
	private By headTailsSize = By.xpath("//label[@data-value='2.8 kg']");
	
	private By headTailsPrice = By.xpath("(//span[contains(text(),'₹652.50')])[2]");
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getPrice()
	{
		driver.findElement(headTailsSize).click();
		String price = driver.findElement(headTailsPrice).getText();
		
		return price;
		
		
		
		
	}
	
	

}

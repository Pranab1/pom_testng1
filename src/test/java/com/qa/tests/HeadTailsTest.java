package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.util.Constants;

public class HeadTailsTest extends BaseTest
{
	@Test(priority=1)
	public void headTailsTitleValidation()
	{
		String actualTitle = homePage.homePageTitle();
		System.out.println("Actual Title: "+actualTitle);
		
		Assert.assertEquals(actualTitle,Constants.HEAD_TAILS_TITLE);
	}
	
	
	@Test(priority=2)
	public void getPriceValidation() {
		homePage.searchProduct("pedigree adult food");
		searchPage.selectProduct();
		String headTailsPrice = productPage.getPrice();
	    System.out.println(headTailsPrice);
	    
	    String originalHeadTailsPrice = headTailsPrice.replace('₹',' ').trim();
	    
	    Assert.assertEquals(originalHeadTailsPrice, "652.50");
	}
	
	

}

package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public WebDriver driver;
	
	public Properties prop;
	
	public WebDriver init_driver(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager wdm = WebDriverManager.chromedriver().setup();
			
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Programs1\\PageObjectModel_TestNG_Framework\\src\\main\\java\\com\\qa\\util\\chromedriver1\\chromedriver.exe");
		    // WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(op);
			
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Eclipse Programs1\\PageObjectModel_TestNG_Framework\\src\\main\\java\\com\\qa\\util\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Incorrect Browser: "+browserName);
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url1"));	
		return driver;
		
	}
	
	public Properties init_prop()
	{
		prop = new Properties();
		
		try
		{
			FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop.load(ip);
			
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		return prop;
	}
	
	

}

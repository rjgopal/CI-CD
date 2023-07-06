package com.drivermanager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends BaseClass {
	
	public void selectBrowser() throws Throwable{
		
		
		String browser = PropertyFile("Browser", TestData);
		String url = PropertyFile("Url", TestData);

		if (browser.equalsIgnoreCase("Chrome")) {
			System.out.println("selecting chrome test");
			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--incognito");

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.get(url);

		
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Test Firefox method");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			driver.get(url);
		
		}

		else if (browser.equalsIgnoreCase("ie")) {

			System.out.println("selecting IE test");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);

			
		}
		
	}

}

package com.drivermanager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public class BaseClass {

	public static  WebDriver driver;
	public static String properties;
	public static File Location;
	public static String TestData = System.getProperty("user.dir") + "//TestData.properties";

	public static String PropertyFile(String TestData, String locatorfile) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		return Prop.getProperty(TestData);
	}

	public static void TypeDataInTheField(By Locator, String Data) throws Throwable {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(Locator));
			Element.sendKeys(Data);
			
		} catch (Exception e) {
			
			throw new Exception("unable to send the data" + Locator);
		}
	}

	public static void Click(By Locator) throws Throwable {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
		
		} catch (Exception e) {
			
			throw new Exception("unable to click the element1" + Locator);
		}

	}

	public static void SwitchWindow() throws Throwable {
		try {
			
			String mainwindow = driver.getWindowHandle();
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				String ChildWindow = i1.next();
				if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
				}
			}
			
		} catch (Exception e) {
			throw new Exception("unable to switch window");
			
		}
	}

	public static void ScrollDown() throws Throwable {

		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;
		scrolldown.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
	}

	public static String GetText(By Locator) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		return Element.getText();
		
	}

	public static void ScrollDownToElement(By Locator) throws Throwable {
		WebElement element = driver.findElement(Locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}

	public static boolean IsElementDisplayed(By Locator) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement ElementDisplay = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		return ElementDisplay.isDisplayed();
		
	}

	public static void SelectFromDropdown(By Locator, String value) throws Throwable {

		Select drpquantity = new Select(driver.findElement(Locator));
		drpquantity.selectByValue(value);
		
	}

	public static void waitUntil(long milliSec) {
		Uninterruptibles.sleepUninterruptibly(milliSec, TimeUnit.MILLISECONDS);
		
	}

	public static String captureScreenshot(){
 
		return((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

	}
	
}

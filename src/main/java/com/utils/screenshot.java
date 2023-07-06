package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.drivermanager.BaseClass;

public class screenshot extends BaseClass {

	public static String captureScreenshot(){
		 
		return((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

	}
}

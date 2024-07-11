package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class DriverUtils extends BaseClass{

	
	public static String captureScreenshot(String name) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir")+"/src/test/resourses/screenshots/"+name+".jpg";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}
	// all  webelelment wait method
//	public static void waitForElement(WebDriver driver, WebElement element)
//{
//		WebDriverWait wait = new WebDriverWait(driver, 30); 
//		wait.until(ExpectedConditions.visibilityOf(element));
//		
//		}
	
	public static void waitForElement(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOf(element));
	}

}

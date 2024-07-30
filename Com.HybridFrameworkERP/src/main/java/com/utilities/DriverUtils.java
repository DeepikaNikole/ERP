package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class DriverUtils extends BaseClass {

    public static String captureScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/src/test/resourses/screenshots/" + name + ".jpg";
        File dest = new File(path);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    // Wait for element to be visible
    public static void waitForElement(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 500).until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for element located by By to be visible
    public static WebElement waitForElementLocated(WebDriver driver, By by) {
        return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Wait for element located by By with timeout
    public static void waitForElementLocated(WebDriver driver, By locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for element with timeout
    public static void waitForElement(WebDriver driver, WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }
}

package com.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.Login;
import com.utilities.DriverUtils;

public class HomePageTest extends BaseClass {
    HomePage hp;
    Login lp;

    @BeforeMethod
    public void setup() throws Exception {
        initialization(); // Initialize WebDriver from BaseClass
        lp = new Login(driver); // Initialize Login page object
        hp = new HomePage(driver); // Initialize HomePage page object
    }

    @Test(priority = 1)
    public void testLogin() {
        System.out.println("Starting login test");
        lp.loginToApplication("admin", "password");
        System.out.println("Login submitted");
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title after login: " + actualTitle);
        String expectedTitle = "webERP - Main Menu";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match after login!");
    }

    @Test(priority = 2)
    public void testModuleDetails() {
        System.out.println("Starting module details test");
        ArrayList<String> modules = hp.getModules();
        Assert.assertFalse(modules.isEmpty(), "Module details are empty!");
        for (String moduleDetail : modules) {
            System.out.println(moduleDetail);
        }
    }

//    @Test(priority = 3)
//    public void testClickModule() {
//        System.out.println("Starting click module test");
//        hp.clickModuleByName("Sales"); // Example method from HomePage
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Expected Title After Click";
//        Assert.assertEquals(actualTitle, expectedTitle, "Title after clicking module does not match!");
//    }

    
    
    @Test(priority = 3)
    public void testClickModule() {
        System.out.println("Starting click module test");
        hp.clickModuleByName("Sales"); // Assuming this method navigates to a new page

        // Wait for the expected title to be visible
        DriverUtils.waitForElement(driver.findElement(By.xpath("//title[contains(text(),'Expected Title After Click')]")));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Expected Title After Click";
        Assert.assertEquals(actualTitle, expectedTitle, "Title after clicking module does not match!");
    }
    @Test(priority = 4)
    public void testSkipExample() {
        System.out.println("Starting skip example test");
        throw new SkipException("Skipping test case");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
}

package com.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.Login;

public class HomePageTest extends BaseClass{
	
HomePage hp=null;
Login lp=null;
	
	@BeforeSuite
	public void setup()throws Exception {
		initialization();
		reportInit();
		hp= new HomePage(driver);
	}
	
	

	@Test
	public void test01() {
	    System.out.println("Starting login test");
	    lp.loginToApplication("admin", "password");
	    System.out.println("Login submitted");
	    String actualTitle = driver.getTitle();
	    System.out.println("Actual Title after login: " + actualTitle);
	    String expectedTitle = "webERP - Main Menu"; 
	    Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	}

    @Test(priority = 2)
    public void testModuleDetails() {
        System.out.println("Starting module details test");
        ArrayList<String> modules = hp.getModules();
        for (String moduleDetail : modules) {
            System.out.println(moduleDetail);
        }
        Assert.assertFalse(modules.isEmpty(), "Module details are empty!");
    }

    @Test(priority = 3)
    public void testClickModule() {
        System.out.println("Starting click module test");
        hp.clickModuleByName("Sales"); //
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
        driver.quit();
    }
}
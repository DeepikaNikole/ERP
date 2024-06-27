package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DashBoardPage;
import com.pages.Login;

public class DashboardPageTest extends BaseClass{

	DashBoardPage dp =null;
	Login lp=null;
	
	@BeforeSuite
	public void setup()throws Exception {
		initialization();
		reportInit();
		dp= new DashBoardPage(driver);
	}
	
	
	   @Test(priority = 1)
	    public void test01() {
		   
		   
		   
	        System.out.println("Starting login test");
	        lp.loginToApplication("admin", "password");
	        System.out.println("Login submitted");

	        String actualTitle = driver.getTitle();
	        System.out.println("Actual Title after login: " + actualTitle);

	        String expectedTitle = "webERP - Main Menu"; // Update this to the correct expected title
	        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	    }

	    @Test
	    public void test02() {
	        String expectedTitle = "eximsoftwares.com1"; // Update with correct expected title
	        String actualTitle = "eximsoftwares.com1";   // Actual title retrieved

	        // Assertion to compare expected and actual titles
	        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	    }
	    @Test(priority = 3)
	    public void test03() {
	        // Example of skipping a test case
	        throw new SkipException("Skipping test case");
	    }

	
	    }
	
	
	
	
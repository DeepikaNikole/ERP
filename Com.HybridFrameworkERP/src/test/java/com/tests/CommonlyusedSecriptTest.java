package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.DashBoardPage;
import com.pages.Login;
import com.pages.LogoutPage;
import com.pages.ComonlyusedScriptPage;
import com.pages.Customerpage;

public class CommonlyusedSecriptTest  extends BaseClass{
	

	    Login lp = null;
	    DashBoardPage dp = null;
	    ComonlyusedScriptPage commonPage = null;
	    LogoutPage logoutPage = null; 
	    Customerpage cp = null;

	    @BeforeSuite
	    public void setup() throws Exception {
	        initialization();
	        reportInit();
	        lp = new Login(driver);
	        logoutPage = new LogoutPage(driver); // Initialize LogoutPage
	        cp=new Customerpage(driver);
	        commonPage= new  ComonlyusedScriptPage(driver);
	        
	        
	        
	       }
//
//	    @Test(priority = 1)
//	    public void testValidLogin() {
//	        dp = lp.validLogin();
//	        Assert.assertEquals(driver.getTitle(), "webERP - Main Menu");
//	    }

	    

	    @Test(priority = 1)
	    public void testValidLogin() {
	        dp = lp.validLogin();
	        Assert.assertEquals(driver.getTitle(), "webERP - Main Menu", "Incorrect page title after login.");
	    }

	    @Test(priority = 2)
	    public void testNavigateToCommonScripts() {
	        commonPage = new ComonlyusedScriptPage(driver);
	        commonPage.selectOptionFromDropdown("Assignment of Cash to Petty Cash Tab");
	        commonPage.navigateToSelectedPage();
	        Assert.assertEquals(driver.getTitle(), "Expected Title of the Script Page");
	       
	    }

	    @Test(priority = 3)
	    public void testAddCustomer() {
	        dp = lp.validLogin();
	        Assert.assertEquals(driver.getTitle(), "webERP - Main Menu");

	        // Assuming dp.clickAddCustomer() returns Customerpage object
	        // Update as per your actual implementation
	        // cp = dp.clickAddCustomer();
	        // Assert.assertEquals(driver.getTitle(), "webERP - Customer Maintenance");

	        // Perform actions on Customerpage and assertions
	        // cp.addCustomer();
	        // Assert.assertTrue(cp.verifySuccessMsg());
	    }
	}




package com.tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Customerpage;
import com.pages.DashBoardPage;
import com.pages.HomePage;
import com.pages.Login;
import com.pages.LogoutPage;

public class LogoutTest  extends BaseClass{
	
	Login lp = null;
    DashBoardPage dp = null;
    Customerpage cp = null;
    LogoutPage logoutPage = null; // Initialize LogoutPage

    @BeforeSuite
    public void setup() throws Exception {
        initialization();
        reportInit();
        lp = new Login(driver);
        logoutPage = new LogoutPage(driver); // Initialize LogoutPage
        cp=new Customerpage(driver);
    }

    @Test
    public void test01() {
        dp = lp.validLogin();
        Assert.assertEquals(driver.getTitle(), "webERP - Main Menu");
    }

//    @Test
//    public void test02() {
//        cp = dp.clickAddCustomer();
//        Assert.assertEquals(driver.getTitle(), "webERP - Customer Maintenance");
//    }
//
//    @Test
//    public void test03() throws Exception {
//        cp.addCustomer();
//        Assert.assertTrue(cp.verifySuccessMsg());
//    }

    @AfterMethod
    public void logoutAfterTest() {
        // Perform logout after each test method
        logoutPage.performLogout();
        
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
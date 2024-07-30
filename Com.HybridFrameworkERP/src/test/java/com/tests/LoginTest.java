package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.Customerpage;
import com.pages.DashBoardPage;
import com.pages.Login;
import com.utilities.DriverUtils;

public class LoginTest extends BaseClass {
    private Login lp;
    private DashBoardPage dp;
    private Customerpage cp;

    @BeforeClass
    public void setup() throws Exception {
        initialization();  // Initialize WebDriver
        reportInit();      // Initialize reporting (if necessary)
        lp = new Login(driver);  // Initialize the Login page
        dp = lp.validLogin();    // Perform login and navigate to DashboardPage
        cp = new Customerpage(driver);  // Initialize Customerpage (if required)
    }

    @Test
    public void test01() {
        //DriverUtils.waitForElementLocated(driver, By.xpath("//title[contains(text(),'webERP - Main Menu')]"));
        Assert.assertEquals(driver.getTitle(), "webERP - Main Menu");
    }
//
    @Test
    public void test02() {
//        cp = dp.clickAddCustomer();
//        //WebElement titleElement = DriverUtils.waitForElementLocated(driver, By.xpath("//title[contains(text(),'webERP - Customer Maintenance')]"));
//        Assert.assertEquals(driver.getTitle(), "webERP - Customer Maintenance");
        
        cp = dp.clickAddCustomer();
        Assert.assertEquals(driver.getTitle(), "webERP - Customer Maintenance");
    }

    @Test(priority = 3)
    public void testAddCustomer() throws Exception {
        cp.addCustomer();
        Assert.assertTrue(cp.verifySuccessMsg());
    }

    @Test(priority = 4)
    public void testSelectTheme() {
        lp.selectTheme("arc-dark");
    }

    @AfterClass 
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

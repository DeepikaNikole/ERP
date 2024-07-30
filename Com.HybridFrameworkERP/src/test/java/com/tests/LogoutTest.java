package com.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Customerpage;
import com.pages.DashBoardPage;
import com.pages.HomePage;
import com.pages.Login;
import com.pages.LogoutPage;

public class LogoutTest extends BaseClass {

    Login lp = null;
    DashBoardPage dp = null;
    Customerpage cp = null;
    LogoutPage logoutPage = null;

    @BeforeSuite
    public void setup() throws Exception {
        initialization();
        reportInit();
        lp = new Login(driver);
        logoutPage = new LogoutPage(driver);
        cp = new Customerpage(driver);
    }

    @Test
    public void test01() {
        dp = lp.validLogin();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try {
            boolean isTitleCorrect = wait.until(ExpectedConditions.titleIs("webERP - Main Menu"));
            assert isTitleCorrect : "Expected title 'webERP - Main Menu' but found " + driver.getTitle();
        } catch (Exception e) {
            System.err.println("Title did not match: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void logoutAfterTest() {
        if (logoutPage != null) {
            logoutPage.performLogout();

            try {
                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='/Projects/WEBERP/css/aguapop/images/quit.png']")));

                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (Exception e) {
                System.out.println("No alert present or element not found: " + e.getMessage());
            }
        } else {
            System.out.println("LogoutPage is not initialized");
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

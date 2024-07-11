package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver;

    // WebElements using @FindBy annotation
    @FindBy(xpath = "//img[@src='/Projects/WEBERP/css/aguapop/images/quit.png']")
    WebElement logoutButton;

    // Constructor to initialize the WebDriver and PageFactory
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to perform logout action
    public void performLogout() {
        logoutButton.click();
        
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

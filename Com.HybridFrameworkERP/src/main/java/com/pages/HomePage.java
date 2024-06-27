package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    // Constructor to initialize the driver and page elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locate the navigation bar
    @FindBy(css = "nav.ModuleList ul")
    private WebElement nav;

    // Locate all list items within the navigation bar
    @FindBy(css = "nav.ModuleList ul li")
    private List<WebElement> modules;

    // Method to extract module names and URLs
    public ArrayList<String> getModules() {
        ArrayList<String> moduleDetails = new ArrayList<>();
        for (WebElement module : modules) {
            WebElement link = module.findElement(By.tagName("a"));
            String moduleName = link.getText();
            String moduleUrl = link.getAttribute("href");
            moduleDetails.add("Module Name: " + moduleName + " | URL: " + moduleUrl);
        }
        return moduleDetails;
    }

    // Method to print the module names and URLs
    public void printModules() {
        for (String moduleDetail : getModules()) {
            System.out.println(moduleDetail);
        }
    }

    // Method to click a module based on its name
    public void clickModuleByName(String moduleName) {
        for (WebElement module : modules) {
            WebElement link = module.findElement(By.tagName("a"));
            if (link.getText().equalsIgnoreCase(moduleName)) {
                link.click();
                break;
            }
        }
    }
}

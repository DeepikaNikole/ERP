package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize the driver and page elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30); // 30 seconds wait
        PageFactory.initElements(driver, this);
    }

    // Locate the navigation bar
    @FindBy(css = "nav.ModuleList ul")
    private WebElement nav;

    // Locate all list items within the navigation bar
    @FindBy(css = "nav.ModuleList ul li")
    private List<WebElement> modules;

    // Use By locator for flexibility
    private By navLocator = By.xpath("//nav[contains(@class, 'ModuleList')]//ul");

    // Method to extract module names and URLs
    public ArrayList<String> getModules() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(navLocator)); // Wait until nav is visible
        ArrayList<String> moduleDetails = new ArrayList<>();

        // Debug: print number of modules found
        System.out.println("Number of modules found: " + modules.size());

        for (WebElement module : modules) {
            WebElement link = module.findElement(By.tagName("a"));
            String moduleName = link.getText();
            String moduleUrl = link.getAttribute("href");
            moduleDetails.add("Module Name: " + moduleName + " | URL: " + moduleUrl);
        }

        // Debug: print module details
        System.out.println("Module details: " + moduleDetails);

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(navLocator)); // Ensure nav is visible before clicking
        for (WebElement module : modules) {
            WebElement link = module.findElement(By.tagName("a"));
            if (link.getText().equalsIgnoreCase(moduleName)) {
                link.click();
                break;
            }
        }
    }

    public WebElement getNav() {
        return nav;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}

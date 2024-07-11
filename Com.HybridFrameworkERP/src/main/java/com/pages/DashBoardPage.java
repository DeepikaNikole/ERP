package com.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.utilities.DriverUtils;

import java.util.List;

public class DashBoardPage {
	
	
	 
	WebDriver driver = null;
    public DashBoardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	 this.driver = driver;
         PageFactory.initElements(driver, this);
     }

    @FindBy(linkText = "Receivables") // recivable module 
    
    WebElement Receivables;
    
 @FindBy(xpath = "//a[@href='/Projects/WEBERP/Customers.php']")
    
    WebElement addCustomer;
 
 public Customerpage  clickAddCustomer() {
//	 DriverUtils.waitForElement(Receivables);// wait foe recivable
//	 Receivables.click();
//	 DriverUtils.waitForElement(addCustomer);
//	 addCustomer.click();
	 
	 WebElement Receivables = driver.findElement(By.id("receivablesId"));
     WebElement addCustomer = driver.findElement(By.id("addCustomerId"));

     // Wait for Receivables to be visible and then click it
     DriverUtils.waitForElement(driver, Receivables);
     Receivables.click();
     
     DriverUtils.waitForElement(driver, addCustomer);
     addCustomer.click();
	 return new Customerpage(driver);
 }
    
}

	
//
//	public static void main(String[] args) {
//        // Set the path to chromedriver.exe (adjust based on your local setup)
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//
//        // Initialize ChromeDriver instance
//        WebDriver driver = new ChromeDriver();
//
//        // Open the dashboard page
//        driver.get("https://eximsoftwares.com/Projects/WEBERP/Dashboard.php");
//
//        try {
//            // Print page title
//            System.out.println("Page Title: " + driver.getTitle());
//
//            // Example 1: Extract module names and URLs
////            WebElement nav = driver.findElement(By.cssSelector("nav.ModuleList ul"));
//
//            
//
//WebDriverWait wait = new WebDriverWait(driver, 50); // Adjust timeout as needed
//WebElement nav = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.ModuleList ul")));
//
//List<WebElement> modules = nav.findElements(By.cssSelector("li"));
//
//
//            System.out.println("Modules:");
//            for (WebElement module : modules) {
//                WebElement link = module.findElement(By.tagName("a"));
//                String moduleName = link.getText();
//                String moduleUrl = link.getAttribute("href");
//                System.out.println("Module Name: " + moduleName + " | URL: " + moduleUrl);
//            }
//
//            // Example 2: Select a script from dropdown and click
//            WebElement favouritesDropdown = driver.findElement(By.id("favourites"));
//            Select select = new Select(favouritesDropdown);
//            select.selectByVisibleText("Dashboard"); // Select "Dashboard" script
//            Thread.sleep(2000); // Adding a small delay for demonstration
//
//            // Example 3: Click on a link within the table
//            WebElement customerLink = driver.findElement(By.linkText("AM123 - Ra.One"));
//            customerLink.click();
//            Thread.sleep(2000); // Adding a small delay for demonstration
//
//            // Example 4: Handle logout confirmation
//            WebElement logoutLink = driver.findElement(By.xpath("//a[contains(@href, '/Projects/WEBERP/Logout.php')]"));
//            logoutLink.click();
//            driver.switchTo().alert().accept(); // Confirm logout
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the browser
//            driver.quit();
//        }
//    }
//
//	
//		
//	}



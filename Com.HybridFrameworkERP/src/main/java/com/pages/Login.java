package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.DriverUtils;
import com.utilities.PropertyUtils;

public class Login {
    WebDriver driver = null;

    // Constructor for LoginPage class
    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


	@FindBy(xpath="//input[@type='text']")
	WebElement username;
	
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	
	
	@FindBy(id = "favourites")
    WebElement themeDropdown;
	
	public DashBoardPage validLogin() {
	    // Ensure the username and password fields are visible and interactable
	    DriverUtils.waitForElement(driver, username);
	    DriverUtils.waitForElement(driver, password);
	    
	    try {
	    	
	    	 DriverUtils.waitForElement(driver, username);
	 	    DriverUtils.waitForElement(driver, password);
	        // Read the username and password from properties and enter them
	        username.sendKeys(PropertyUtils.readProperty("username"));
	        password.sendKeys(PropertyUtils.readProperty("password"));
	    } catch (Exception e) {
	        // Log the exception with a meaningful message
	        System.err.println("Error reading properties: " + e.getMessage());
	        e.printStackTrace();
	    }
	    
	    // Ensure the login button is visible and interactable
	    DriverUtils.waitForElement(driver, loginBtn);
	    loginBtn.click();
	    
	    // Return the next page object after successful login
	    return new DashBoardPage(driver);
	}

	
	
	
	public void loginToApplication(String uname, String pass){
//		try {
//			username.sendKeys(PropertyUtils.readProperty("username"));// ideoe framwork use try catch
//			
//			username.sendKeys(PropertyUtils.readProperty("password"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
//		//loginBtn.click();
		//DriverUtils.waitForElement(driver, loginBtn);

username.sendKeys(uname);
password.sendKeys(pass);
loginBtn.click();


	}
// Method to select a theme using JavaScript

public void selectTheme(String theme) {
	DriverUtils.waitForElement(driver, themeDropdown);
	//DriverUtils.waitForElement(driver, loginBtn);
    String script = "arguments[0].value='" + theme + "';";
    ((JavascriptExecutor) driver).executeScript(script, themeDropdown);
    themeDropdown.sendKeys(Keys.ENTER);
}

// Usage example
public void testThemeSelection() {
	//DriverUtils.waitForElement(driver, loginBtn);
    Login loginPage = new Login(driver);
    loginPage.selectTheme("arc-dark");
   
}
}


package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
//		username.sendKeys("admin");
//		password.sendKeys("password");
//		loginBtn.click();
//		return new DashBoardPage(driver);
		
		
		try {
			username.sendKeys(PropertyUtils.readProperty("username"));// idl framwork use try catch
			
			password.sendKeys(PropertyUtils.readProperty("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginBtn.click();
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

username.sendKeys(uname);
password.sendKeys(pass);
loginBtn.click();


	}
// Method to select a theme using JavaScript

public void selectTheme(String theme) {
    String script = "arguments[0].value='" + theme + "';";
    ((JavascriptExecutor) driver).executeScript(script, themeDropdown);
    themeDropdown.sendKeys(Keys.ENTER);
}

// Usage example
public void testThemeSelection() {
    Login loginPage = new Login(driver);
    loginPage.selectTheme("arc-dark");
    // Proceed with other actions/assertions
}
}


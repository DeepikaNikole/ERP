//package com.pages;
//
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//
//
//
//public class ComonlyusedScriptPage {
//	
//	    WebDriver driver = null;
//
//	    // Constructor for LoginPage class
//	    public ComonlyusedScriptPage(WebDriver driver) {
//	        this.driver = driver;
//	        PageFactory.initElements(driver, this);
//	    }
//
//	    @FindBy(id = "favourites") // Assuming id attribute of <select> element is "favourites"
//	    WebElement favouritesDropdown;
//
//	    public void selectOptionFromDropdown(String optionText) {
//	        // Initialize Select object with the dropdown WebElement
//	        Select dropdown = new Select(favouritesDropdown);
//
//	        // Select option by visible text
//	        dropdown.selectByVisibleText(optionText);
//	    }
//
//	    public void selectOptionFromDropdownByValue(String optionValue) {
//	        // Initialize Select object with the dropdown WebElement
//	        Select dropdown = new Select(favouritesDropdown);
//
//	        // Select option by value attribute
//	        dropdown.selectByValue(optionValue);
//	    }
//
//	    public void selectOptionFromDropdownByIndex(int index) {
//	        // Initialize Select object with the dropdown WebElement
//	        Select dropdown = new Select(favouritesDropdown);
//
//	        // Select option by index (index starts from 0)
//	        dropdown.selectByIndex(index);
//	    }
//
//	    public void navigateToSelectedPage() {
//	        // Assuming the dropdown is designed to navigate to a URL onchange
//	        favouritesDropdown.submit(); // Submit the form to navigate to the selected URL
//	    }
//	}
package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComonlyusedScriptPage {

    WebDriver driver;
    WebDriverWait wait;

    public ComonlyusedScriptPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30); // 30 seconds wait
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "favourites")
    WebElement favouritesDropdown;

    public void selectOptionFromDropdown(String optionText) {
        wait.until(ExpectedConditions.visibilityOf(favouritesDropdown));
        Select dropdown = new Select(favouritesDropdown);
        dropdown.selectByVisibleText(optionText);
    }

    public void navigateToSelectedPage() {
        wait.until(ExpectedConditions.elementToBeClickable(favouritesDropdown));
        favouritesDropdown.click();
    }
}

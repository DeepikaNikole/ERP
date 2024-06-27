package com.pages;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utilities.DriverUtils;
import com.utilities.ExcelUtils;

public class Customerpage extends BaseClass{

public Customerpage(WebDriver driver){ // constructor
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(name="DebtorNo")// custCode mentetory filds only we used
WebElement custCode;


@FindBy(name="CustName")
WebElement custName;



@FindBy(name="Address1")
WebElement custAddress;



@FindBy(name="BrName")
WebElement branchName;;


@FindBy(name="ContectName")
WebElement branchcontect;


@FindBy(xpath="//input[@value='Add New Customer']")
WebElement submitBtn;

@FindBy(xpath="//input[@value='Enter Or Update Branch']")
WebElement updateBtn;


@FindBy(id="MessageContainerFoot")
WebElement sucessMsg;



public void addCustomer() throws Exception {
	DriverUtils.waitForElement(custCode);
	custCode.sendKeys(ExcelUtils.readCelData(2, 0));
	
	custName.sendKeys(ExcelUtils.readCelData(2, 1));
	custAddress.sendKeys(ExcelUtils.readCelData(2, 2));
	submitBtn.click();

	
	DriverUtils.waitForElement(branchName);
	branchName.clear();
	branchName.sendKeys(ExcelUtils.readCelData(2, 3));;
	branchcontect.sendKeys(ExcelUtils.readCelData(2, 4));;
	updateBtn.click();
}



public boolean  verifySuccessMsg() {
	
	if (sucessMsg.isDisplayed()) 
		return true;
		else
			return false;
		
	}

	
}

package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Customerpage;
import com.pages.DashBoardPage;
import com.pages.Login;


public class LoginTest extends BaseClass{

	Login lp=null;
	DashBoardPage dp = null;
	Customerpage cp = null ;
	
	@BeforeSuite
	public void setup()throws Exception {
		initialization();
		reportInit();
		lp= new Login(driver);
	}

	
	
	
	
	@Test
	public void test01() {
//	    System.out.println("Starting login test");
//	    lp.loginToApplication("admin", "password");
//	    
//	    
//	    
//	    System.out.println("Login submitted");
//	    String actualTitle = driver.getTitle();
//	    System.out.println("Actual Title after login: " + actualTitle);
//	    String expectedTitle = "webERP - Main Menu"; // Update this to the correct expected title
//	    Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
		
		dp=lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "webERP - Main Menu");
		
	}

  
//    public void test01() {
//        lp.loginToApplication("admin", "password");
//        String actualTitle = driver.getTitle();
//        
//        String expectedString = "webERP - Main Menu";
//        Assert.assertEquals(actualTitle, "Expected Title");  
//    }
	//@Test

//    public void test02() {
//        String actualTitle = driver.getTitle();
//       // String expectedTitle = "webERP - Main Menu";
//        
//        String expectedTitle = "eximsoftwares.com1";
//        System.out.println("Actual Title in test02: " + actualTitle);
//       Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
//       
       
      
	
	@Test
	public void test02() {
		cp=dp.clickAddCustomer();
		
		Assert.assertEquals(driver.getTitle(), "webERP - Customer Maintenance");
		
  }
////	
//	@Test
//	public void test03() {
//		 throw new SkipException("Skiping testcase");
//	}
	
	
	@Test
	public void test03 ()throws Exception {
		cp.addCustomer();
		Assert.assertTrue(cp.verifySuccessMsg());
	}
}

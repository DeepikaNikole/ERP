package com.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utilities.DriverUtils;

public class MyListeners extends BaseClass implements ITestListener {

    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>(); // ThreadLocal to manage ExtentTest instance per thread

//    @Override
//    public void onTestStart(ITestResult result) {
//        extentTest.set(report.createTest(result.getName())); // Create a new ExtentTest for each test method
//    }
    @Override
    public void onTestStart(ITestResult result) {
        extentTest.set(report.createTest(result.getName())); // Create a new ExtentTest for each test method
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Testcase success with name: " + result.getName());
    }

    //@Override
   // public void onTestFailure(ITestResult result) {
//        extentTest.get().log(Status.FAIL, "Testcase failed with name: " + result.getName());
//        String path = DriverUtils.captureScreenshot(result.getName());
//        try {
//            extentTest.get().addScreenCaptureFromPath(path); // Add screenshot to the extent report
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    	
//    	@Override
//    	public void onTestFailure(ITestResult result) {
//    	    extentTest.get().log(Status.FAIL, "Testcase failed with name: " + result.getName());
//    	    String path = DriverUtils.captureScreenshot(result.getName());
//    	    try {
//    	        extentTest.get().addScreenCaptureFromPath(path); // Add screenshot to the extent report
//    	    } catch (Exception e) {
//    	        extentTest.get().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
//    	    }
//    	}

    	
    	
    	@Override
    	public void onTestFailure(ITestResult result) {
    	    ExtentTest test = extentTest.get();
    	    if (test != null) {
    	        test.log(Status.FAIL, "Testcase failed with name: " + result.getName());
    	        String path = DriverUtils.captureScreenshot(result.getName());
    	        try {
    	            test.addScreenCaptureFromPath(path); // Add screenshot to the extent report
    	        } catch (Exception e) {
    	            test.log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
    	        }
    	    } else {
    	        // Handle case where extentTest.get() returns null
    	        // Log a warning or take appropriate action
    	    }
    	}


    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Testcase skipped with name: " + result.getName());
    }

    
    @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
    
    @Override
    public void onStart(ITestContext context) {
        // Initialization if needed
    }

    @Override
    public void onFinish(ITestContext context) {
        if (report != null) {
            report.flush(); // Flush ExtentReports instance to save the report
        }
    }

	
}

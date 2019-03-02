package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
 public WebDriver driver;
 public  ExcelDataProvider excel ;
 public ConfigDataProvider config;
 public ExtentReports report;
 public ExtentTest logger;
 
 @BeforeSuite
 public void setUpSuit()
 {
 Reporter.log("Setting Up Tests and Reports ready",true);	 
 excel = new ExcelDataProvider();
 config = new ConfigDataProvider();
 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/OrangeHRM_"+Helper.getCurretDateTime()+".html"));
 report = new ExtentReports();
 report.attachReporter(extent);
 Reporter.log("Setting Done-Test can be Started", true);
 }
 @Parameters({"browser","urlToBeTested"})
 @BeforeClass
 public void setup(String browser,String url)
 {
 Reporter.log("Trying to Start Browser and Getting Application ready",true);	 
 //driver=BrowserFactory.startApplication(driver,"chrome","https://opensource-demo.orangehrmlive.com/index.php/auth/login");
// driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStringURL());
 driver=BrowserFactory.startApplication(driver,browser,url);
 
 Reporter.log("Browser and Application can be up and running",true);
 
 }
	 
  @AfterClass
 public void tearDown()
 {
 BrowserFactory.quitBrowser(driver);	
 }

  @AfterMethod
 public void tearDownMethod(ITestResult result) throws IOException
 {
 Reporter.log("Test is about to end",true);	  
 if (result.getStatus()==ITestResult.FAILURE)
 {
 //Helper.captureScreenshots(driver);
 logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build()); 
}	
 else if (result.getStatus()==ITestResult.SUCCESS)
 {
 logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());	
} 
 

 report.flush();
 Reporter.log("Test Completed>>>Reports Generated", true);
 }
  
	
	
	
	
	
	
}

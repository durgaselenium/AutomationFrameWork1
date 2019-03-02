package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.Helper;

public class LoginTestHRM extends BaseClass {
 

 @Test	
 public void loginTest()
 {
    logger=report.createTest("Login To OrageHRM");
  
  LoginPage loginpage = PageFactory.initElements(driver,LoginPage.class);
  
   logger.info("Starting Application");
  
  loginpage.loginToHRM(excel.getStringData("Login",0 ,0),excel.getStringData("Login",0,1));
   
   logger.pass("Login Successfully");
  
  Helper.captureScreenshots(driver);
 }
 
	
}

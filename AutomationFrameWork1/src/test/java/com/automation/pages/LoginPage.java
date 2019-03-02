package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
 WebDriver driver;
	//constructor
 public LoginPage(WebDriver ldriver)
 {
 this.driver=ldriver;	 	 
 }
	
@FindBy(xpath="//input[@id='txtUsername']")WebElement uname;
@FindBy(xpath="//input[@id='txtPassword']")WebElement pass;
@FindBy(xpath="//input[@type='submit']")WebElement btnLogin;
//@FindBy(xpath="//a[text()='Welcome Admin']")WebElement lnkWelcomeToAdmin;
//@FindBy(xpath="//a[contains(text(),'Logout')]")WebElement btnLoginOut;


public void loginToHRM(String userName, String Password)
{
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	
}	
uname.sendKeys(userName);
pass.sendKeys(Password);
btnLogin.click();
//lnkWelcomeToAdmin.click();
//btnLoginOut.click();
}
	
}

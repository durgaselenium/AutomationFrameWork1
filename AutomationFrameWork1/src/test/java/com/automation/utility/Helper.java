package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//alerts,screenshots,windows,sys issues,javascript explorer
 public static String captureScreenshots(WebDriver driver)	
 {
 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
 String screenshotpath = System.getProperty("user.dir")+"./Screenshots/OrangeHRM_"+getCurretDateTime()+".png";
 try {
	FileHandler.copy(src, new File(screenshotpath));
	System.out.println("Screenshot Captured");
} 
 catch (IOException e)
 {
 System.out.println("Unable to captured Screenshot>>"+e.getMessage());	
}
return screenshotpath;	 
 }
 
 public static String getCurretDateTime()
 {
 DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
 Date currentdate = new Date();
 return customformat.format(currentdate);
 }
	
	
}

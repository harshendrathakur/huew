package com.huew.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.huew.base.Base;

public class Utilities extends Base {
	
	public Utilities() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	public void switchToPopup(){
		
		driver.switchTo().alert();
		
	}
	
	public void uploadfiles() throws IOException {
		System.out.println("AutoIt");
		Runtime.getRuntime().exec("C:\\Users\\thakur\\eclipse-workspace\\huew\\AutoIt\\fileupload-ff.exe");
	}
	
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	            

	    }
	
	

}

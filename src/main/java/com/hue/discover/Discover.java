package com.hue.discover;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.huew.base.Base;
import com.huew.utilities.*;

public class Discover extends Base{
	
	public Discover() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	Utilities utility=new Utilities();
	JavascriptExecutor jse = (JavascriptExecutor)driver;

	/*here not identifying all the elements on the page,
	but only those which are specific to this test activity.
	In real project, we should identify all the elements on
	the page and add them here to the keep the repository up to date.
	*/
	
	
	
	
	public void uploadImage() throws IOException, InterruptedException {
		
		try {
			
		    WebElement uploadfile = driver.findElement(By.xpath("//form[@name=\"discoverPhotoUploadForm\"]"));
		    uploadfile.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement uploadfile = driver.findElement(By.xpath("//form[@name=\"discoverPhotoUploadForm\"]"));
		    uploadfile.click();
		}
		utility.uploadfiles();
		
		try 
		{
			WebElement submit_img=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"desktop-photo-submit desktop-photo-submit-highlight ng-scope\"]")));
		    submit_img.click();
		    
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			
			WebElement submit_img=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"desktop-photo-submit desktop-photo-submit-highlight ng-scope\"]")));
		    submit_img.click();
		}
		
		try 
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"desktop-photo-submit desktop-photo-submit-highlight\"]")));
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"desktop-photo-submit desktop-photo-submit-highlight\"]")));
		}
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	}
	
	
	
	public void saveUpload() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"desktop-photo-submit desktop-photo-submit-highlight ng-scope\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"huew-link ng-scope\" and contains(text(),'here')]"))).click();
	}
	
	
}

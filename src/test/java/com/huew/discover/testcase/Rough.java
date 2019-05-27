package com.huew.discover.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Rough {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(5000);
	  WebElement a=driver.findElement(By.xpath("//form[@name=\"discoverPhotoUploadForm\"]"));
	  System.out.println(a.isDisplayed());
	  a.click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\thakur\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://huew.co/discover/");
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}

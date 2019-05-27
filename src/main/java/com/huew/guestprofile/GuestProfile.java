package com.huew.guestprofile;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.huew.loggedprofile.*;

import com.huew.base.Base;

public class GuestProfile extends Base {
	
	public GuestProfile() throws Throwable {
		PageFactory.initElements(driver, this);
	}
	
	/*here not identifying all the elements on the page,
	but only those which are specific to this test activity.
	In real project, we should identify all the elements on
	the page and add them here to the keep the repository up to date.
	*/
	
	@FindBy(xpath="//img[@ng-click=\"login('google')\"]")
	WebElement googleLogin;

	@FindBy(xpath="//input[@type=\"email\"]")
	WebElement enterEmail;
	
	@FindBy(xpath="//div[@id=\"identifierNext\"]")
	WebElement clickNext;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement enterPassword;
	
	@FindBy(xpath="//div[@id=\"passwordNext\"]")
	WebElement clickNextToLogin;
	public void clickOnGoogleLoginButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@ng-click=\"login('google')\"]")));
		googleLogin.click();
	}
	
	public LoggedProfile googleLogin() throws Throwable {
		
		 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		 Set<String> windowhandles = driver.getWindowHandles();
		 Iterator<String> itr = windowhandles.iterator();
		 while(itr.hasNext())
		 {
		     String next_tab = itr.next();
		     if (!parentWindow.equalsIgnoreCase(next_tab))
	        {
		    	driver.switchTo().window(next_tab);
		    	enterEmail.sendKeys(prop.getProperty("username"));
				clickNext.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"password\"]")));
				enterPassword.sendKeys(prop.getProperty("password"));
				clickNextToLogin.click();
		     }
		   }
		 
		 driver.switchTo().window(parentWindow);
		
		
		
		
		return new LoggedProfile();
	}
	
}

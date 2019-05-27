package com.huew.loggedprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.huew.base.Base;
import com.hue.discover.*;

public class LoggedProfile extends Base {

	public LoggedProfile() throws Throwable {
		PageFactory.initElements(driver, this);
	}
	
	
	/*here not identifying all the elements on the page,
	but only those which are specific to this test activity.
	In real project, we should identify all the elements on
	the page and add them here to the keep the repository up to date.
	*/

	//@FindBy(xpath="//a[@class=\"desktop-menu-container ng-scope\"][1]")
	@FindBy(xpath="//div[contains(text(), 'DISCOVER')]")
	WebElement discover;
	
	
	
	public Discover clickDiscover() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'DISCOVER')]")));
		discover.click();
		return new Discover();
	}
}

package com.huew.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.huew.guestprofile.*;

import com.huew.base.Base;

public class Homepage extends Base{

	public Homepage() throws Throwable {
		PageFactory.initElements(driver, this);
	}
	
	/*here not identifying all the elements on the page,
	but only those which are specific to this test activity.
	In real project, we should identify all the elements on
	the page and add them here to the keep the repository up to date.
	*/
	
	//@FindBy(xpath="//a[@ui-sref=\"unrestricted.profile\"]")
	@FindBy(xpath="//div[@class='desktop-public-header']/*[@ui-sref='unrestricted.profile']")
	WebElement loginlink;

	public GuestProfile clickonloginlink() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(loginlink));
		loginlink.click();
		return new GuestProfile();
	}

}

package com.huew.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	//public static WebDriverWait ajaxwait;
	public static String parentWindow;
	public static String thepdffile;
	
	//Constructor to fetch and load configuration file
	public Base() throws Throwable {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\thakur\\eclipse-workspace\\huew\\src\\main\\java\\com\\huew\\config\\config.properties");
		prop.load(fis);
	}
	
	
	//Initialization method to load browser and the url based on the value configured in config file
	public static void initialization() {
		
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		}
		else {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriver"));
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, 50);
		//ajaxwait= new WebDriverWait(driver, 50);
		parentWindow=driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		final String pdffile=prop.getProperty("pdffile")+(new Random().nextInt())+".pdf";
		thepdffile=pdffile;
	}

}

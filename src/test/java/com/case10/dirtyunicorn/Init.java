package com.case10.dirtyunicorn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Init {
	WebDriver driver;

	public WebDriver initFirefox() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		return driver;
	}
	
	public WebDriver initChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
}




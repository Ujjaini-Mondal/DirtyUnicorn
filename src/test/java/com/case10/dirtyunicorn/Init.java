package com.case10.dirtyunicorn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Init {

	public static WebDriver initFirefox() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		return driver;
		
	}
	
	public static WebDriver initChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
}




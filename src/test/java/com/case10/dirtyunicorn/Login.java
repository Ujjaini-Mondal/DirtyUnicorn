package com.case10.dirtyunicorn;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends Init{
	
	WebDriver driver;
	
	@BeforeTest
	public void browser() {
		
		driver=initFirefox();	
		
	}
	
	
	@Test
	public void case10login() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Ujjaini\\Documents\\MyProject\\dirtyunicorn\\details.properties");
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		String username = prop.getProperty("username");
		String password= prop.getProperty("password");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header-button']")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		WebDriverWait time=new WebDriverWait(driver,20);
		time.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header-button']")));
		String text=driver.findElement(By.xpath("//div[@class='header-button']")).getText();
		Assert.assertTrue(text.equalsIgnoreCase("MY ACCOUNT"));
	}
	
}

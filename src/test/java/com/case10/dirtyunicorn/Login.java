package com.case10.dirtyunicorn;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login extends Init{
	
	@Test
	public void case10login() throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=initFirefox();
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
		
		
	}
	
}

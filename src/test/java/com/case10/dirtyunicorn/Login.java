package com.case10.dirtyunicorn;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Login extends Init{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=initChrome();
		driver.get("https://www.case10.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header-button']")).click();
		
	}
	
}

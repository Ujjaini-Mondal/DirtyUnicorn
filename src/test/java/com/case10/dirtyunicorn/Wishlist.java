package com.case10.dirtyunicorn;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Wishlist extends Init {
	
	Login login;
	@Test(dataProvider="getData")
	public void wishlist(String product) throws IOException, InterruptedException {
		login = new Login();
		login.browser();
		login.case10login();
		// TODO Auto-generated method stub
		WebDriverWait time=new WebDriverWait(login.driver,30);
		time.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='login-form-popup']")));
		login.driver.findElement(By.xpath("//li[@id='menu-item-5321']")).click();
		 SearchforProduct xyz= new SearchforProduct();
		 xyz.searchforproduct(product, login.driver);
		 //WebDriverWait time1=new WebDriverWait(login.driver,40);
		// time1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Add to Wishlist')]")));
		 Thread.sleep(4000);
		 //login.driver.findElement(By.xpath("//a[@class='add_to_wishlist']")).click();
		 login.driver.findElement(By.xpath("//div[@class='product-info summary col-fit col entry-summary product-summary']//a[@class='add_to_wishlist'][contains(text(),'Add to Wishlist')]")).click();
		 Thread.sleep(3000);
		 login.driver.findElement(By.xpath("//h1[@class='product-title entry-title']")).click();
		 Actions account= new Actions(login.driver);
		 account.moveToElement(login.driver.findElement(By.xpath("//div[@class='header-button']"))).build().perform();
		 //account.moveToElement(login.driver.findElement(By.xpath("//div[@class='header-button']//span[@class='header-account-title'][contains(text(),'My account')]"))).build().perform();
		 Thread.sleep(3000);
		 login.driver.findElement(By.xpath("//li[@class='wishlist-account-element ']")).click();
		////ul[@class='nav-dropdown  nav-dropdown-default']//li[@class='wishlist-account-element'][contains(text(),'Wishlist')]	
	}
	@DataProvider
	public Object[] getData()
	{
	
	Object[] product = new Object[1];
	 
	
	product[0]= "3D Love Heart Cute Phone Case";
	return product;
	}
	
}

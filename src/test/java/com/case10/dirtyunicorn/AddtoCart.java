package com.case10.dirtyunicorn;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By; 
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AddtoCart extends Init{
	
	Login login;
	//@Parameters ({ "product" })
	@Test(dataProvider="getData")
	public void addtocart(String product) throws InterruptedException, IOException {
		
		login = new Login();
		login.browser();
		Reporter.log("Browser Opened");
		login.case10login();
		// TODO Auto-generated method stub
		WebDriverWait time=new WebDriverWait(login.driver,40);
		time.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='login-form-popup']")));
		clearcart();
		login.driver.findElement(By.xpath("//li[@id='menu-item-5321']")).click();
		Assert.assertTrue(login.driver.findElement(By.xpath("//span[@class='prdctfltr_woocommerce_filter_title']")).isDisplayed());
		
		String xyz=searchforproduct(product);
		
		
		login.driver.findElement(By.id("color")).sendKeys(Keys.ARROW_DOWN);
		login.driver.findElement(By.id("color")).sendKeys(Keys.ENTER);
		login.driver.findElement(By.id("material")).sendKeys(Keys.ARROW_DOWN);
		login.driver.findElement(By.id("material")).sendKeys(Keys.ENTER);
		Select dropdown= new Select(login.driver.findElement(By.id("wpeae_to_country_field")));
		dropdown.selectByValue("US");
		//login.driver.findElement(By.id("wpeae_shipping_field")).click();
		Select option= new Select(login.driver.findElement(By.id("wpeae_shipping_field")));
		option.selectByValue("EMS_ZX_ZX_US");
		//login.driver.findElement(By.id("wpeae_shipping_field")).sendKeys(Keys.ARROW_DOWN);
		//login.driver.findElement(By.id("wpeae_shipping_field")).sendKeys(Keys.ARROW_DOWN);
		//login.driver.findElement(By.id("wpeae_shipping_field")).sendKeys(Keys.ENTER);
		login.driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
		WebDriverWait d=new WebDriverWait(login.driver,20);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='header-cart-title']")));
		Actions cart= new Actions(login.driver);
		cart.moveToElement(login.driver.findElement(By.xpath("//span[@class='header-cart-title']"))).build().perform();
		WebDriverWait t=new WebDriverWait(login.driver,20);
		t.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget_shopping_cart_content']")));
		Assert.assertTrue(login.driver.findElement(By.xpath("//div[@class='widget_shopping_cart_content']")).getText().contains(product));
		
		login.driver.findElement(By.xpath("//div[@class='widget_shopping_cart_content']//p[@class='woocommerce-mini-cart__buttons buttons']//a[@class='button checkout wc-forward']")).click();
		  
		
	}
	
	
		public String searchforproduct(String abc) throws InterruptedException {
			
			int count=1;
			while(login.driver.findElement(By.xpath("//i[@class='icon-angle-right']")).isDisplayed())
			{
				count++;	
				//page starts from here
					List<WebElement> pageProducts=login.driver.findElements(By.xpath("//p[@class='name product-title']"));
					int number=pageProducts.size();
					System.out.println(abc);
					for(int i=0;i<number;i++) {
						WebElement selectedProduct=pageProducts.get(i);
						//
						if (selectedProduct.getText().equals(abc)){
							selectedProduct.click();
							return "Product found"; 
						}
				
					}
					//page ends here
					//System.out.printf("Not found in page %i", count);
				login.driver.findElement(By.xpath("//i[@class='icon-angle-right']")).click();
			}
			List<WebElement> pageProducts=login.driver.findElements(By.className("product-small.col"));
			int number=pageProducts.size();
			for(int i=0;i<number;i++) {
				WebElement selectedProduct=pageProducts.get(i);
				//
				System.out.println(selectedProduct.getText());
				if (selectedProduct.getText().equals(abc)){
					selectedProduct.click();
					return "Product found";
				}
				
				WebDriverWait time=new WebDriverWait(login.driver,40);
				time.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='product-title entry-title']")));
				String pass=login.driver.findElement(By.xpath("//h1[@class='product-title entry-title']")).getText();
				Assert.assertTrue(pass.equalsIgnoreCase(abc));	
			}
			return "Not found";
		}
		
		
		public void clearcart() throws InterruptedException
		
		{
			Actions cart= new Actions(login.driver);
			cart.moveToElement(login.driver.findElement(By.xpath("//span[@class='header-cart-title']"))).build().perform();
			
			String variable=login.driver.findElement(By.xpath("//div[@class='widget_shopping_cart_content']")).getText();
			WebElement wait = login.driver.findElement(By.xpath("//div[@class='widget_shopping_cart_content']"));
			
			while(!variable.equalsIgnoreCase("No products in the cart."))
			{	
				Thread.sleep(2000);
				cart.moveToElement(login.driver.findElement(By.xpath("//span[@class='header-cart-title']"))).build().perform();
				WebDriverWait unit=new WebDriverWait(login.driver,30);
				unit.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='remove remove_from_cart_button']")));
				
				login.driver.findElement(By.xpath("//a[@class='remove remove_from_cart_button']")).click();
				WebDriverWait timeunit=new WebDriverWait(login.driver,40);
				timeunit.until(ExpectedConditions.invisibilityOf(wait));
				variable=login.driver.findElement(By.xpath("//div[@class='widget_shopping_cart_content']")).getText();
				wait = login.driver.findElement(By.xpath("//div[@class='widget_shopping_cart_content']"));
			
			}
		}
		
		
		@DataProvider
		public Object[] getData()
		{
		
		Object[] product = new Object[1];
		 
		// 1st product
		product[0]= "Candy Color Geometry Pattern Retro Marble Case";
		 
		// 2nd product
		
		/*product[1]= "Luxury Flip Leather Case";
		 
		// 3rd product
		
		product[2]= "Luxury Mirror Phone Case";
		
		product[3]="Shell Pattern Glitter Phone Case";
		
		product[4]="Ultra Thin Soft Silicon case";
		
		product[5]="Stylish Silicon Marble Texture case";*/
		 
		return product;
		}
		
		
	}



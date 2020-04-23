package com.case10.dirtyunicorn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchforProduct {
	
	
	
	public String searchforproduct(String abc, WebDriver driver) throws InterruptedException {
			int count=1;
			while(driver.findElement(By.xpath("//i[@class='icon-angle-right']")).isDisplayed())
			{
				count++;	
				//page starts from here
					List<WebElement> pageProducts=driver.findElements(By.xpath("//p[@class='name product-title']"));
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
					
				driver.findElement(By.xpath("//i[@class='icon-angle-right']")).click();
			}
			List<WebElement> pageProducts=driver.findElements(By.className("product-small.col"));
			int number=pageProducts.size();
			for(int i=0;i<number;i++) {
				WebElement selectedProduct=pageProducts.get(i);
				//
				System.out.println(selectedProduct.getText());
				if (selectedProduct.getText().equals(abc)){
					selectedProduct.click();
					return "Product found";
				}
				
				WebDriverWait time=new WebDriverWait(driver,40);
				time.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='product-title entry-title']")));
				String pass=driver.findElement(By.xpath("//h1[@class='product-title entry-title']")).getText();
				Assert.assertTrue(pass.equalsIgnoreCase(abc));	
			}
			return "Not found";
	}

}

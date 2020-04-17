package com.case10.dirtyunicorn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Giveaway {
	
	
	@Test
		public void main() {
		
		// TODO Auto-generated method stub
		Init firefox = new Init();
		firefox.initFirefox();
		firefox.driver.findElement(By.id("menu-item-5330")).click();
	}

}

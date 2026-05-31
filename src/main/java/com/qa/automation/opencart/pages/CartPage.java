package com.qa.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	public int i=10;
	static WebDriver driver;
	private By id=By.id("input-email");
	public static void m1()
	{
		System.out.println("Cart Page");
		driver.findElement(By.id("input-email")).sendKeys("Hi");
		
	}
	
	
}

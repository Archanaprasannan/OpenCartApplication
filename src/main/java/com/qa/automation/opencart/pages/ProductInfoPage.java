package com.qa.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.qa.automation.opencart.constants.AppConstants.*;

import com.qa.automation.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	// private by locators of Login Page
	private final By productheader = By.tagName("h1");
	private final By productimages = By.cssSelector("ul.thumbnails img");
	

	// public constructor of Login Page
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// public methods/actions of login page
	
	public String getProductHeader() {
		String header = eleUtil.waitForElementVisible(productheader,DEFAULT_TIMEOUT).getText();
		System.out.println("Product header is: " + header);
		return header;
	}	
	
	public int getProductImagesCount() {
		int count = eleUtil.waitForAllElementsVisible(productimages, DEFAULT_TIMEOUT).size();
		System.out.println("Total product images count is: " + count);
		return count;
}
}

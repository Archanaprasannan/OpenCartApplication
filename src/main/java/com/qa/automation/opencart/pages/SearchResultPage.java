package com.qa.automation.opencart.pages;

import static com.qa.automation.opencart.constants.AppConstants.MEDIUM_TIMEOUT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automation.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class SearchResultPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// private by locators of Login Page
	
	private final By searchResultProducts=By.cssSelector("div.product-thumb");
	
	// public constructor of Login Page
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// public methods/actions of login page
	@Step("Getting the search result products count")
	public int getSearchResultProductsCount()
	{
		int count= eleUtil.waitForAllElementsVisible(searchResultProducts,MEDIUM_TIMEOUT).size();
		System.out.println("Search result products count is: "+count);
		return count;
	}
	@Step("Selecting the product: {0} from search result page")
	public ProductInfoPage selectproduct(String productName)
	{
		System.out.println("Selecting the product: "+productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
	
}

package com.qa.automation.opencart.pages;

import static com.qa.automation.opencart.constants.AppConstants.*;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.automation.opencart.utils.ElementUtil;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	// private by locators of Login Page
	private final By headers = By.cssSelector("div#content>h2");
	private final By searchButton=By.xpath("//div[@id='search']//input");
	private final By searchIcon=By.xpath("//span[@class='input-group-btn']//button");

	// public constructor of Login Page
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// public methods/actions of login page
	public String getAccountPageTitle() {
		String accountpageTitle = eleUtil.waitForTitleIs(DEFAULT_TIMEOUT, ACCOUNT_PAGE_TITLE);
		System.out.println("Account page title :" + accountpageTitle);
		return accountpageTitle;
	}
	
	public String getAccountPageUrl() {
		String url = eleUtil.waitForURLContains(DEFAULT_TIMEOUT, ACCOUNTPAGE_FRACTION_URL);
		System.out.println("Account Page URL is: " + url);
		return url;
		
	}

	public List<String> getAccountPageHeaders() {
		List<WebElement> header = eleUtil.getElements(headers);
		List<String> hearderList = new ArrayList<String>();
		for (WebElement e : header) {
			String text = e.getText();
			System.out.println(text);
			hearderList.add(text);
		}
		System.out.println("Account page headers are: " + hearderList);
		return hearderList;
		
	}

	public SearchResultPage doSearch(String productName) {
		System.out.println("Searching the product: " + productName);
		eleUtil.doSendkeys(searchButton, productName);
		eleUtil.doClick(searchIcon);
		return new SearchResultPage(driver);
		
		
		
		
	}

}

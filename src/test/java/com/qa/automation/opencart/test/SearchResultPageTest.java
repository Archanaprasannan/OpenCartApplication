package com.qa.automation.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automation.opencart.base.BaseTest;

public class SearchResultPageTest extends BaseTest {

	@BeforeClass
	public void searchPageSetUp() {
		accountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void getSearchResultProductsCountTest() {
		searchresultpage = accountpage.doSearch("Macbook");
		int actCount = searchresultpage.getSearchResultProductsCount();
		Assert.assertEquals(actCount, 3);
	}
}

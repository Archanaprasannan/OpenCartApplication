package com.qa.automation.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automation.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Feature("Feature 4:Search Result page features for open cart application")
@Epic("EPIC 105: Search Result page features for open cart application")
@Story("US 105.1: Implement Search Result page test cases for open cart application")
public class SearchResultPageTest extends BaseTest {

	@BeforeClass
	public void searchPageSetUp() {
		accountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Description("verify the search result page Product count")
	@Owner("Archana")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void getSearchResultProductsCountTest() {
		searchresultpage = accountpage.doSearch("Macbook");
		int actCount = searchresultpage.getSearchResultProductsCount();
		Assert.assertEquals(actCount, 3);
	}
}

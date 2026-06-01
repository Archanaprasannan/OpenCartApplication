package com.qa.automation.opencart.test;

import static com.qa.automation.opencart.constants.AppConstants.ACCOUNTPAGE_FRACTION_URL;
import static com.qa.automation.opencart.constants.AppConstants.ACCOUNTPAGE_HEADERS;
import static com.qa.automation.opencart.constants.AppConstants.ACCOUNT_PAGE_TITLE;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automation.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Feature("Feature 2: Account page features for open cart application")
@Epic("EPIC 101: Account page features for open cart application")
@Story("US 101.1: Implement Account page test cases for open cart application")
public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accountPageSetUp() {
		accountpage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Description("Verify the account page title")
	@Owner("Archana")
	@Severity(SeverityLevel.NORMAL)
	@Issue("OPENCART-102")
	@Test(description="verify the title of the account page")
	public void getAccountPageTitleTest()
	{
		String actualTitle= accountpage.getAccountPageTitle();
		Assert.assertEquals(actualTitle, ACCOUNT_PAGE_TITLE);
	}
	@Description("Verify the account page URL")
	@Owner("Archana")
	@Severity(SeverityLevel.NORMAL)
	@Test(description="verify the URL of the account page")
	public void getAccountPageURLTest()
	{
		String actualUrl= accountpage.getAccountPageUrl();
		Assert.assertTrue(actualUrl.contains(ACCOUNTPAGE_FRACTION_URL));
	}
	@Description("Verify the account page headers")
	@Owner("Archana")
	@Severity(SeverityLevel.NORMAL)
	@Test(description="verify the headers of the account page")
	public void getAccountPageHeadersListTest()
	{
		List<String> list= accountpage.getAccountPageHeaders();
		Assert.assertEquals(list,ACCOUNTPAGE_HEADERS);
	}

}

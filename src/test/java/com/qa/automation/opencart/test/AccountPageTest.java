package com.qa.automation.opencart.test;

import static com.qa.automation.opencart.constants.AppConstants.*;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automation.opencart.base.BaseTest;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accountPageSetUp() {
		accountpage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void getAccountPageTitleTest()
	{
		String actualTitle= accountpage.getAccountPageTitle();
		Assert.assertEquals(actualTitle, ACCOUNT_PAGE_TITLE);
	}
	@Test
	public void getAccountPageURLTest()
	{
		String actualUrl= accountpage.getAccountPageUrl();
		Assert.assertTrue(actualUrl.contains(ACCOUNTPAGE_FRACTION_URL));
	}
	@Test
	public void getAccountPageHeadersListTest()
	{
		List<String> list= accountpage.getAccountPageHeaders();
		Assert.assertEquals(list,ACCOUNTPAGE_HEADERS);
	}

}

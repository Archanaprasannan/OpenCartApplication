package com.qa.automation.opencart.test;

import static com.qa.automation.opencart.constants.AppConstants.ACCOUNT_PAGE_TITLE;
import static com.qa.automation.opencart.constants.AppConstants.LOGINPAGE_FRACTION_URL;
import static com.qa.automation.opencart.constants.AppConstants.LOGINPAGE_TITLE;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.automation.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
/*
 * This is the LoginPageTest class which will contain the test methods for the
 * LoginPage class. It will extend the BaseTest class which will contain the
 * common setup and teardown methods for all the test classes.
 */
@Feature("Feature 1: Login page features for open cart application")
@Epic("EPIC 100: login page features for open cart application")
@Story("US 100.1: Implement login page test cases for open cart application")
public class LoginPageTest extends BaseTest {
	@Description("verify the login page header")
	@Owner("Archana")
	@Severity(SeverityLevel.NORMAL)
	@Test(description="verify the title of the login page")
	//any defect related to the login page title should be logged with the issue id OPENCART-101 in the JIRA
	@Issue("OPENCART-101")
	public void getLoginPageTitleTest()
	{
		String actualTitle= loginpage.getLoginpageTitle();
		ChainTestListener.log("LoginPage title: "+actualTitle);
		Assert.assertEquals(actualTitle, LOGINPAGE_TITLE);
	}
	@Description("verify the URL of the login page")
	@Owner("Archana")
	@Severity(SeverityLevel.NORMAL)
	//any defect related to the login page title should be logged with the issue id OPENCART-101 in the JIRA
	@Issue("OPENCART-102")
	@Test(description="verify the url of the login page")
	public void getLoginPageURLTest()
	{
		String actualUrl= loginpage.getLoginpageUrl();
		ChainTestListener.log("LoginPage url: "+actualUrl);
		Assert.assertTrue(actualUrl.contains(LOGINPAGE_FRACTION_URL));
	}
	@Test(description="verify the forgot password link exist on the login page")
	public void getForgotPasswordLinkTest()
	{
		Boolean flag=loginpage.isForgotPasswordLinkExist();
		Assert.assertTrue(flag);
	}
	@Description("verify login using valid credentials")
	@Owner("Archana")
	@Severity(SeverityLevel.NORMAL)
	//any defect related to the login page title should be logged with the issue id OPENCART-101 in the JIRA
	@Issue("OPENCART-103")
	@Test(priority=Short.MAX_VALUE,description="verify the login functionality with valid credentials")
	public void doLoginTest()
	{
		accountpage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String actTitle=accountpage.getAccountPageTitle();
		Assert.assertEquals(actTitle, ACCOUNT_PAGE_TITLE);
	}
	
	
	
}

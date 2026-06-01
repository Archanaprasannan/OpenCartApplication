package com.qa.automation.opencart.pages;

import static com.qa.automation.opencart.constants.AppConstants.ACCOUNTPAGE_FRACTION_URL;
import static com.qa.automation.opencart.constants.AppConstants.DEFAULT_TIMEOUT;
import static com.qa.automation.opencart.constants.AppConstants.LOGINPAGE_FRACTION_URL;
import static com.qa.automation.opencart.constants.AppConstants.LOGINPAGE_TITLE;
import static com.qa.automation.opencart.constants.AppConstants.MEDIUM_TIMEOUT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automation.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// private by locators of Login Page
	private final By emailId = By.id("input-emaill");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@value='Login']");
	private final By forgotpassword = By.linkText("Forgotten Password");
	private final By registerLink = By.linkText("Register");

	// public constructor of Login Page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// public methods/actions of login page
	@Step("Getting the login page title")
	public String getLoginpageTitle() {
		return eleUtil.waitForTitleIs(DEFAULT_TIMEOUT, LOGINPAGE_TITLE);
	}

	@Step("Getting the login page URL")
	public String getLoginpageUrl() {
		String url = eleUtil.waitForURLContains(DEFAULT_TIMEOUT, LOGINPAGE_FRACTION_URL);
		System.out.println("Login Page URL is: " + url);
		return url;
	}

	@Step("Checking the forgot password link exist on login page")
	public Boolean isForgotPasswordLinkExist() {
		return eleUtil.waitForElementPresence(forgotpassword, DEFAULT_TIMEOUT).isDisplayed();
	}

//login with 0th username and 1st password from the data provider in the test class
	@Step("Login with username: {0} and password: {1}")
	public AccountPage doLogin(String userName, String passWord) {
		System.out.println("Login with: " + userName + " and " + passWord);
		// eleUtil.waitForTitleIs(DEFAULT_TIMEOUT, LOGINPAGE_TITLE);
		eleUtil.waitForElementVisible(emailId, DEFAULT_TIMEOUT).sendKeys(userName);
		eleUtil.doSendkeys(password, passWord);
		eleUtil.doClick(loginBtn);
		eleUtil.waitForURLContains(MEDIUM_TIMEOUT, ACCOUNTPAGE_FRACTION_URL);
		return new AccountPage(driver);

	}
@Step("Navigating to register page from login page")
	public RegisterPage navigateToRegisterPage() {
		eleUtil.clickWhenready(registerLink, DEFAULT_TIMEOUT);
		return new RegisterPage(driver);
	}
}

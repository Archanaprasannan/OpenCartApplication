package com.qa.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automation.opencart.utils.ElementUtil;
import com.qa.automation.opencart.utils.StringUtil;

import static com.qa.automation.opencart.constants.AppConstants.*;
import static com.qa.automation.opencart.utils.StringUtil.*;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private by locators of Login Page
	private final By firstname = By.id("input-firstname");
	private final By lastname = By.id("input-lastname");
	private final By email = By.id("input-email");
	private final By telephone = By.id("input-telephone");
	private final By password = By.id("input-password");
	private final By confirmpassword = By.id("input-confirm");

	private final By subscribeYes = By.xpath("//div[@class='form-group']//input[@value='1']");
	private final By subscribeNo = By.xpath("//div[@class='form-group']//input[@value='0']");
	private final By agreeCheckbox = By.name("agree");
	private final By continueButton = By.xpath("//input[@type='submit']");

	private final By successMsg = By.xpath("//div[@id='content']/h1");

	private final By logoutLink = By.linkText("Logout");
	private final By registerLink = By.linkText("Register");

	// public constructor of Login Page
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// public methods/actions of login page
	public String getRegisterPageTitle() {
		String title = eleUtil.waitForTitleIs(DEFAULT_TIMEOUT, REGISTERPAGE_TITLE);
		System.out.println("Register Page Title is: " + title);
		return title;
	}

	public String doUserRegistration(String firstname, String lastname,  String telephone, String password,
			String subscribe) {
		eleUtil.waitForElementVisible(this.firstname, DEFAULT_TIMEOUT).sendKeys(firstname);
		eleUtil.doSendkeys(this.lastname, lastname);
		eleUtil.doSendkeys(this.email,getRandomEmailId());
		eleUtil.doSendkeys(this.telephone, telephone);
		eleUtil.doSendkeys(this.password, password);
		eleUtil.doSendkeys(this.confirmpassword, password);
		if (subscribe.equals("Yes")) {
			eleUtil.doClick(subscribeYes);
		} else {
			eleUtil.doClick(subscribeNo);
		}
		eleUtil.waitForElementVisible(agreeCheckbox, DEFAULT_TIMEOUT);
		eleUtil.doClick(agreeCheckbox);
		eleUtil.doClick(continueButton);
		eleUtil.waitForElementVisible(successMsg, MEDIUM_TIMEOUT);
		String text= eleUtil.doElementGetText(successMsg);
		System.out.println("Account Registration Success Message: " + text);
		eleUtil.doClick(logoutLink);
		eleUtil.doClick(registerLink);
		return text;

	}
}

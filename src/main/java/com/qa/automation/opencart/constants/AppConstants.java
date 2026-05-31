package com.qa.automation.opencart.constants;

import java.util.List;

public class AppConstants {
	public static final String LOGINPAGE_TITLE="Account Login";
	public static final String LOGINPAGE_FRACTION_URL="route=account/login";
	
	public static final String ACCOUNT_PAGE_TITLE="My Account";
	public static final String ACCOUNTPAGE_URL="https://naveenautomationlabs.com/opencart/index.php?route=account/account";
	public static final String ACCOUNTPAGE_FRACTION_URL="route=account/account";
	
	public static final List<String> ACCOUNTPAGE_HEADERS=List.of("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	
	
	public static final String REGISTERPAGE_TITLE="Register Account";
	public static final String REGISTERPAGE_URL="https://naveenautomationlabs.com/opencart/index.php?route=account/register";
	public static final String REGISTERPAGE_FRACTION_URL="route=account/register";
	
	public static final String REGISTER_SUCCESS_MSG="Your Account Has Been Created!";
	
	public static final int DEFAULT_TIMEOUT=5;
	public static final int MEDIUM_TIMEOUT=10;
	public static final int LONG_TIMEOUT=15;
	
	//****************Excel sheet name*****************
	public static final String SHEETNAME="Register";
	
	
}

package com.qa.automation.opencart.test;

import static com.qa.automation.opencart.constants.AppConstants.*;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.automation.opencart.base.BaseTest;
import com.qa.automation.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void registerPageSetup() {
		registerpage = loginpage.navigateToRegisterPage();
	}

	@Test
	public void getRegisterPageTitleTest() {
		String actualTitle = registerpage.getRegisterPageTitle();
		Assert.assertEquals(actualTitle, REGISTERPAGE_TITLE);
	}

	@DataProvider
	public Object[][] getUserRegistrationData() {
		return new Object[][] { { "Naveen", "Automation", "9876543210", "test@123", "Yes" },
				{ "Ram", "ban", "9876543237", "testing@123", "No" },
				{ "Archana", "Sam",  "9876903210", "test@90", "Yes" } };
	}
	
	
	@DataProvider
	public Object[][] getUserRegData()
	{
		Object[][] data= ExcelUtil.getTestDataFromExcel(SHEETNAME);
		return data;
	}

//	@Test(dataProvider = "getUserRegistrationData")
//	public void doUserRegistrationTest(String firstname, String lastname,  String telephone,
//			String password, String subscribe) {
//		String successMsg = registerpage.doUserRegistration(firstname, lastname, telephone, password, subscribe);
//
//		Assert.assertEquals(successMsg, REGISTER_SUCCESS_MSG);
//
//	}
	
	@Test(dataProvider = "getUserRegData")
	public void doUserRegistrationTest(String firstname, String lastname,  String telephone,
			String password, String subscribe) {
		String successMsg = registerpage.doUserRegistration(firstname, lastname, telephone, password, subscribe);

		Assert.assertEquals(successMsg, REGISTER_SUCCESS_MSG);

	}
	// This is the test method which is not inclueded in the \executionbeacuse used the parameter: enabled=false
	@Test(enabled=false,description="This is the test method which is not inclueded in the execution because used the parameter: enabled=false")
	public void registerDetails()
	{
		String path="./src/test/resources/testdata/OpenCartTestData.xlsx";
		String sheetname="register";
		Object[][] data= ExcelUtil.getTestDataFromExcel(sheetname);
		
		for(Object[] e: data)
		{
			System.out.println(e[0]+"  "+e[1]+"  "+e[2]+"  "+e[3]+"  "+e[4]);
		}
	}
}

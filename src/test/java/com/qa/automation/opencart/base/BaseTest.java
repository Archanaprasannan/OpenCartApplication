package com.qa.automation.opencart.base;

import static com.qa.automation.opencart.basefactory.DriverFactory.getScreenshotFile;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.automation.opencart.basefactory.DriverFactory;
import com.qa.automation.opencart.pages.AccountPage;
import com.qa.automation.opencart.pages.LoginPage;
import com.qa.automation.opencart.pages.ProductInfoPage;
import com.qa.automation.opencart.pages.RegisterPage;
import com.qa.automation.opencart.pages.SearchResultPage;

/**
 * This is the BaseTest class which will be extended by all the test classes. It
 * will contain the common setup and teardown methods for all the test classes.
 */
/*
 * if you dont want to add the @Listeners in the base test class, you can add it
 * in the xml file as well
 */
//@Listeners(ChainTestListener.class)
public class BaseTest {
	/*
	 * protected LoginPage loginpage; - This is the reference variable of LoginPage
	 * class which will be used to access the methods of LoginPage class in the test
	 * It is declared as protected so that it can be only accessed by the child
	 * classes which are in the same package or in the different package. if it is
	 * default: it can be accessed by the child classes which are in the same
	 * package but not in the different package. if it is public,it can be
	 * accessible by all classes in all packages. if it is private, it can be
	 * accessed only within the class and not by any
	 */
	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginpage;
	protected AccountPage accountpage;
	protected SearchResultPage searchresultpage;
	protected ProductInfoPage productinfopage;
	protected RegisterPage registerpage;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {
		df = new DriverFactory();
		prop = df.initProp();
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	// This method will be running after each @Test method and it will be used to
	// attach the screenshot in the report if the test case is failed.
	// ITestResult: testng class which describes the result of a test method, it
	// contains the details about the test method, its status,
	// and any exception thrown during the execution of the test method.
	@AfterMethod
	public void attachScreenshot(ITestResult result) {
		if (!result.isSuccess())// only for failed test cases, it will attach the screenshot in the report.
		{
			ChainTestListener.embed(getScreenshotFile(), "image/png");
		}
		// if you want to attach the screenshot for all the test cases, you can remove
		// the if condition and it will attach the screenshot for all the test cases.
		// ChainTestListener.embed(getScreenshotFile(), "image/png");
	}
}

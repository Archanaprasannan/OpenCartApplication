package com.qa.automation.opencart.basefactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.automation.opencart.exception.BrowserException;

/*
 * This is the DriverFactory class which will be used to initialize the WebDriver based on the browser 
 * name passed as a parameter. It will also contain the properties file which will be used to read the
 *  data from the properties file.
 */

public class DriverFactory {

	/*
	 * WebDriver driver; Properties prop;- This is the reference variable of
	 * WebDriver interface and Properties class, which will be used to initialize
	 * the driver and read the data from the properties file respectively. making
	 * them as instance variables so that they can be accessed by all the methods in
	 * the class.
	 */
	// intitialize the ThreadLocal and add the generics as webdriver

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	Properties prop;

	/**
	 * This method is used to initialize the WebDriver based on the browser name
	 * passed as a parameter.
	 * 
	 * @param browserName
	 */
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("Browser is: " + browserName);
		switch (browserName.trim().toLowerCase()) {
		case "chrome": {
			tldriver.set(new ChromeDriver());
			break;
		}
		case "edge": {
			tldriver.set(new EdgeDriver());
			break;
		}
		case "firefox": {
			tldriver.set(new FirefoxDriver());
			break;
		}
		case "safari": {
			tldriver.set(new SafariDriver());
			break;
		}
		default: {
			System.out.println("Please pass the valid browser name: " + browserName);
			throw new BrowserException("Invalid browserName: " + browserName);
		}
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}

//get the local copy of the driver from thread local variable
	public static WebDriver getDriver() {
		return tldriver.get();
	}

	/*
	 * * This method is used to initialize the Properties object and read the data
	 * from the properties file. It will return the Properties object which will be
	 * used to read the data
	 * 
	 */
	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/*********************** Screenshot *******************/
	public static File getScreenshotFile() {

//			TakesScreenshot ts= (TakesScreenshot)getDriver();
//			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
//			return screenshotAs;

		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
		return srcFile;
	}

	public static byte[] getScreenshotByte() {
		// want to take the screenshot in Byte format
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);// temp dir

	}

	public static String getScreenshotBase64() {
		// want to take the screenshot in encoded format/can be used in CI/CD pipeline
		// best way to take screenshot..smaller size
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);// temp dir

	}
}

package com.qa.automation.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.automation.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	@BeforeClass
	public void productInfoPageSetup() {
		accountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
//better to write dataprovider inside the same class where the method is present which is using the dataprovider,
	//if we write dataprovider in the different class then we have to create the object of that class to access the dataprovider method and it will create the unnecessary object and it will increase the memory consumption. if we write dataprovider in the same class then we can directly access the dataprovider method without creating the object of that class and it will reduce the memory consumption.
	/*
	 * better to use dataprovider instaed of excel sheet because dataprovider is faster than excel sheet and it is also 
	 * easy to maintain. if we use excel sheet then we have to write the code to read the data from excel sheet and 
	 * it will increase the complexity of the code and it will also increase the maintenance of the code. 
	 * if we use dataprovider then we can directly write the data in the code and it will reduce the complexity of the code
	 *  and it will also reduce the maintenance of the code.
	 */
	@DataProvider
	public Object[][] getproductData() {
		return new Object[][] { { "macbook", "macbook pro" }, { "macbook", "macbook air" },
				{ "samsung", "samsung galaxy" } };
	}
//3 times this method will get executed because we have 3 sets of data in the dataprovider and each set of data will be passed 
	//to the method as parameters and the method will be executed for each set of data and it will return the result for 
	//each set of data and we can compare the result with the expected result using assert statement.
	@Test(dataProvider="getproductData")
	public void getProductHeaderTest(String searchKey, String productName) {
		searchresultpage = accountpage.doSearch(searchKey);
		productinfopage = searchresultpage.selectproduct(productName);
		String actheader = productinfopage.getProductHeader();
		Assert.assertEquals(actheader, productName);

	}

	@Test
	public void getProductImagesCountTest() {
		searchresultpage = accountpage.doSearch("Macbook");
		productinfopage = searchresultpage.selectproduct("MacBook Pro");
		int actimageCount = productinfopage.getProductImagesCount();
		Assert.assertEquals(actimageCount, 4);
	}

}

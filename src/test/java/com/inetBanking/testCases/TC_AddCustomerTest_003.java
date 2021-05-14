package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickaddNewCustomer();
		
		log.info("Providing Customer Details");
		addcust.custname("Pritam");
		addcust.custgender("male");
		addcust.custdob("27", "05", "1992");
		
		Thread.sleep(3000);
		
		addcust.custaddress("India");
		addcust.custcity("Mu");
		addcust.custstate("Mah");
		addcust.custpinno("400223");
		addcust.custtelephoneno("9845758485");
		addcust.custemailid(randomString()+"@gmail.com");
		addcust.custpassword("gfyufgjhhkg");
		
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res) {
			Assert.assertTrue(true);
			log.info("TestCase is Passed");
		}
		else {
			log.info("TestCase is Failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			
		}
	}
}

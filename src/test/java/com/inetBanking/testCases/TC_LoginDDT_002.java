package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC_LoginDDT_002 extends BaseClass {

	
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname,String pwd) {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		log.info("Username provided");
		lp.setPassword(pwd);
		log.info("Password provided");
		lp.clickSubmit();
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
	
	public boolean isAlertPresent() {
		
		try{
			driver.switchTo().alert();
			return true;
		}
		
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name ="LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rowCount = ExcelUtils.getRowCount(path, "Data");
		int colCount= ExcelUtils.getCellCount(path, "Data", 1);
		
		String loginData[][] = new String [rowCount][colCount];
		
		
		for(int i =1; i<= rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				loginData[i-1][j]= ExcelUtils.getCellData(path, "Data", i, j);
			}
		}
		
		return  loginData;
	}
	
	
}

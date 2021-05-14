package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig config = new ReadConfig();
	public String baseURL=config.getApplicationUrl();
	public String username=config.getUsername();
	public String password=config.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {	
		log = LogManager.getLogger(BaseClass.class.getName());
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",config.getChromePath());
		driver = new ChromeDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);	
		String destination = System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source,finalDestination);	
		
	}
	
	public String randomString() {		
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
	}

}

package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
WebDriver ldriver;
	
	public  AddCustomerPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//*[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(name="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtaddress;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;

	@FindBy(name="pinno")
	WebElement txtpinno;
	
	@FindBy(name="telephoneno")
	WebElement txttelephoneno;
	
	@FindBy(name="emailid")
	WebElement txtemailid;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	public void clickaddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void custname(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custgender(String cgender) {
		rdGender.sendKeys(cgender);
	}
	
	public void custdob(String dd,String mm,String yyyy) {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yyyy);
	}
	
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno) {
		txtpinno.sendKeys(cpinno);
	}
	
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
	
	

}

package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement btn_checkout;
	
	@FindBy(id="first-name")
	WebElement txt_firstname;
	
	@FindBy(id="last-name")
	WebElement txt_lastname;
	
	@FindBy(id="postal-code")
	WebElement txt_zipcode;
	
	@FindBy(id="continue")
	WebElement btn_continue;
	
	@FindBy(id="finish")
	WebElement btn_finish;
	
	public void setClickCheckout() {
		btn_checkout.click();
	}
	
	public void setCredentials(String first, String last, String zip) {
		txt_firstname.sendKeys(first);
		txt_lastname.sendKeys(last);
		txt_zipcode.sendKeys(zip);
	}
	
	public void setClickContinue() {
		btn_continue.click();
	}
	
	public void setClickFinish() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",btn_finish);
		btn_finish.click();
	}
	

}

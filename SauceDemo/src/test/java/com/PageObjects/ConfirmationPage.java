package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage {
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	WebElement txt_message;
	
	public void setCheckConfirmationMessage()throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-800)");
		Thread.sleep(2000);
		boolean status = txt_message.isDisplayed();
		Assert.assertEquals(status, true,"Values dont Match!");
	}

}

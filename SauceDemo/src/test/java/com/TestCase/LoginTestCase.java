package com.TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.CheckOutPage;
import com.PageObjects.ConfirmationPage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;

public class LoginTestCase extends Base {
	
	@Test(priority=1)
	public void validLoginTest1()throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(validUsername);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		//Thread.sleep(2000);
		
		
		HomePage homePage = new HomePage(driver);
		homePage.setFilter();
		//Thread.sleep(2000);
		homePage.setProduct();
		
		CheckOutPage checkOut = new CheckOutPage(driver);
		checkOut.setClickCheckout();
		checkOut.setCredentials(readConfig.getFirstname(), readConfig.getLastname(), readConfig.getZipcode());
		//Thread.sleep(2000);
		checkOut.setClickContinue();
		checkOut.setClickFinish();
		//Thread.sleep(2000);
		
		ConfirmationPage confirm = new ConfirmationPage(driver);
		confirm.setCheckConfirmationMessage();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(inValidUsername);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		
		boolean status = driver.findElement(By.xpath("//h3[contains(@data-test,'error')]")).isDisplayed();
		Assert.assertEquals(status, true,"Failed Test Case");
		
	}

}

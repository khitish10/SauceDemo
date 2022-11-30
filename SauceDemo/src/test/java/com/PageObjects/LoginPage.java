package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement txt_username;

	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(id = "login-button")
	WebElement btn_click;

	public void setUsername(String uname) {
		txt_username.sendKeys(uname);
	}

	public void setPassword(String pword) {
		txt_password.sendKeys(pword);
	}

	public void clickLogin() {
		btn_click.click();
	}
	
	public boolean verifyLogin() {
		return driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
	}

}

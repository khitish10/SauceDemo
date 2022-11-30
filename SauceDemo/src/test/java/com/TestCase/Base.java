package com.TestCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.ReadConfig;

public class Base {
	
	ReadConfig readConfig = new ReadConfig();
	public WebDriver driver;
	public String validUsername = readConfig.getValidUsername();
	public String inValidUsername = readConfig.getInValidUsername();
	public String password = readConfig.getPassword();
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(readConfig.getUrl());
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
}

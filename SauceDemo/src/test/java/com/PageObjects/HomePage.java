package com.PageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setFilter() {
		Select filter = new Select(driver.findElement(By.className("product_sort_container")));
		filter.selectByVisibleText("Price (low to high)");
	}
	
	public void setProduct()throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_label']/following-sibling::div/descendant::button")).click();
		
		//Thread.sleep(2000);
		element = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		jse.executeScript("window.scrollBy(0,-900);");
		
		element.click();
		//Thread.sleep(2000);
	}
	
	
}

package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.TestCase.Base;

public class Screenshot extends Base {
	
//	WebDriver driver;
//	public Screenshot(WebDriver driver) {
//		this.driver=driver;
//	}
	
	public  void takeScreenshot() throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		TakesScreenshot shot = (TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File trg = new File("./screenshot/"+timeStamp+"_Image.png");
		FileHandler.copy(src,trg);
	}

}

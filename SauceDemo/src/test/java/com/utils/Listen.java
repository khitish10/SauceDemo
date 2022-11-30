package com.utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestCase.Base;

public class Listen implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		Screenshot obj = new Screenshot();
		try {
			obj.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	

}

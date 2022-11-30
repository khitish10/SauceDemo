package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig() {
		try {
			File file = new File("C:\\Users\\khitish\\eclipse-workspace_slave\\SauceDemo\\config.properties");
			FileInputStream inputStream = new FileInputStream(file);
			prop = new Properties();
			prop.load(inputStream);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public  String getValidUsername() {
		String valid_username= prop.getProperty("validLogin");
		return valid_username;
	}
	
	public  String getInValidUsername() {
		String invalid_username= prop.getProperty("invalidLogin");
		return invalid_username;
	}
	
	public  String getPassword() {
		String password= prop.getProperty("password"); 
		return password; 
	}
	
	public  String getUrl() {
		String url= prop.getProperty("url"); 
		return url; 
	}
	
	public  String getFirstname() {
		String firstname= prop.getProperty("firstname"); 
		return firstname; 
	}
	
	public  String getLastname() {
		String lastname= prop.getProperty("lastname"); 
		return lastname; 
	}
	
	public  String getZipcode() {
		String zipcode= prop.getProperty("zipcode"); 
		return zipcode; 
	}

}

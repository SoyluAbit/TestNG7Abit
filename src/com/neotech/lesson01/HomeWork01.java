package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HomeWork01 extends CommonMethods {

	/*
	 * Homework 1: HRMS Application Negative Login:
	 * 
	 * 1. Open chrome browser 2. Go to "https://hrm.neotechacademy.com/" 3. Enter
	 * valid username 4. Leave password field empty 5. Verify error message with
	 * text "Password cannot be empty" is displayed.
	 */

	@BeforeMethod
	public void openNavigate() {
		setUp();

	}

	@AfterMethod
	public void close() {
		tearDown();

	}

	@Test
	public void negativeLoginValidation() throws Exception {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.xpath("//button")));

		WebElement actual = driver.findElement(By.id("txtPassword-error"));

		String expected = "Password cannot be empty";

		if (actual.getText().equals(expected)) {
			System.out.println("Test Passed. passowor field left empty");

		} else {
			System.out.println("Test Failed");
			
		}

	}
	
	@Test
	public void loginValidation()
	{
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.xpath("//button")));
//		
//		WebElement userImg = driver.findElement(By.xpath("//div[@id='menu-profile']/img"));
//		
//		if(userImg.isDisplayed())
//		{
//			System.out.println("Login Validation Passed!");
//		}
//		else
//		{
//			System.out.println("Login Validation Failed!");
//		}
		
	}
}

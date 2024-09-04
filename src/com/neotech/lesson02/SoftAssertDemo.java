package com.neotech.lesson02;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class SoftAssertDemo extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();

	}

	@Test
	public void LogoAndLoginValidation() {

		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));

		boolean logoExist = logo.isDisplayed();
		logoExist = false;

		// logo validation 
		SoftAssert soft = new SoftAssert();
		AssertJUnit.assertTrue("Logo is not displayed", logoExist);
		
		//login validation 
		
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.xpath("//button")));
		
		
		wait(2);
		
		String expected = "Jacqueline White";
		String actual = driver.findElement(By.id("account-name")).getText();
		
		AssertJUnit.assertEquals(actual, expected, "Account name is not Jacqueline White");
		
		
		// this will let all soft seesrtion
		//and will decide whetger the test passess or fails

		soft.assertAll();
		
		
		// if test fails, execution will stop after assertAll();
		System.out.println("after AssertAll() code");
	}

}

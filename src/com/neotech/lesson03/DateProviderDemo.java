package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class DateProviderDemo extends CommonMethods {
	
	
	@Test
	public void loginFunctionality(String username, String password)
	{
	
	sendText(driver.findElement(By.id("txtUsername")), username);
	sendText(driver.findElement(By.id("txtPassword")), password);
	click(driver.findElement(By.xpath("//button")));

	wait(2);
	
	
	// to create data driven test in TestNG we use @DataProvider annotation

	}
	
	

	@DataProvider (name = "userData")
	public Object [][] getData()
	
{
		Object[][] credentials = 
			{
				{"Admin", "Admin123"},
				{"Mona", "Mone123"},
				{"Nazli", "Nazli123"}
				
 	     	};
		
		return credentials;
		
	}

}

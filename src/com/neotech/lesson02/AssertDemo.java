package com.neotech.lesson02;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AssertDemo extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();

	}

	@Test (enabled = false)
	public void titleValidation() throws Exception {
		String expectedTitle = "OrangeHRM..."; // intentially failing this test (it should be OrangeHRM)
		String actualTitle = driver.getTitle();
		
		// first way of checking 
	    //	Assert.assertEquals(actualTitle, expectedTitle); // no need to add if else condition
		
		
		// second way of checking   -----   order have to be the back way
		
				AssertJUnit.assertEquals(expectedTitle , actualTitle , "Title does not match "); // no need to add if else condition
				
		// 
				// if assestion fails anything after will not run
				System.out.println("This is the end og tittle validation test");
		
		
	}
	@Test
	public void logoValidation()
	{
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		
		
		boolean logoExist = logo.isDisplayed();
		
		// set it false on purpuse failing the test 
		logoExist = false;  // 
		
		
		// first way 
	//	Assert.assertEquals(logoExist , true);
		
		
		// second way of checking   -----   order have to be the back way
		
	//	Assert.assertEquals(logoExist , true , " Logo is not displayed"); // no need to add if else condition
		
		//third way
		AssertJUnit.assertTrue(" Logo is not displayed" , logoExist); //  logo is set to true here it will fail
		

		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



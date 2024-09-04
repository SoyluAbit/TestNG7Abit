package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.LoginPageUsingPageFactory;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class AddEmployeeWithDataProvider extends CommonMethods{
	
	
	
	@Test (dataProvider = "employees")
	public void addEmployee(String firstName, String lastName, String location)
	{
		// first name last name location
		System.out.println(firstName + " " + lastName + " " +location);
		
		
	
		
	
	
//		login
		LoginPageUsingPageFactory login = new LoginPageUsingPageFactory();
		Actions action = new Actions(driver);
		
		
			sendText(login.username, ConfigsReader.getProperty("username"));
			sendText(login.password, ConfigsReader.getProperty("password"));
			click(login.loginBtn);
			

			wait(2);
	
	
//	navigate to pim 
	
			WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
			click(pimButton);

			// click Add an employee
			WebElement addEmpButton = driver.findElement(By.id("menu_pim_addEmployee"));
			click(addEmpButton);
			
			
//			send employee
			
			wait(10);
			sendText(driver.findElement(By.id("first-name-box")), firstName);
			sendText(driver.findElement(By.id("last-name-box")), lastName);
			
			selectDropdown(driver.findElement(By.id("location")), location);
			wait(2);

			// click save button
			WebElement saveBtn = driver.findElement(By.id("modal-save-button"));
			action.moveToElement(saveBtn).click().perform();

			// wait for personal detailes to be visiable

			
			waitForVisibility(driver.findElement(By.xpath("//label[text()='First Name']")));

		
	
		
	
		
	//	validate employee 
	
		String actual = firstName;
		String expected = driver.findElement(By.id("firstName")).getText();
		Assert.assertEquals(actual, expected);
			
	
	
	}
	
	
	
    @DataProvider (name = "employees")
	public Object[][] employeeData()
	{
		
		Object [][] data = {
		                	{"Hakan", "Yavas","New York Sales Office" },
				           {"Abbas", "Guclu","Texas R&D"},
		                   {"Hamdi", "Gelgit","Sheffield Office"}
							};
		
		return data;
		
	}
}

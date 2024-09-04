package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class Task02 extends CommonMethods {

	/*
	 * HW2: OrangeHRM Add Employee:
	 * 
	 * Open chrome browser Go to "https://hrm.neotechacademy.com/" Login into the
	 * application Click on Add Employee Verify labels: Employee Full Name*,
	 * Employee Id, Location* are displayed Provide Employee First and Last Name
	 * Select a Location Verify Employee has been added successfully Close the
	 * browser
	 * 
	 */

	@BeforeClass
	public void navigate() {
		setUp();
	}

	@AfterClass
	public void close() {
		tearDown();

	}

	@Test(priority = 0)
	public void login() {
		sendText(driver.findElement(By.id("txtUsername")), "Admin");
		sendText(driver.findElement(By.id("txtPassword")), "Neotech@123");
		click(driver.findElement(By.xpath("//button")));

		wait(2);

	}

	// Click on Add Employee

	@Test(dependsOnMethods = "login")
	public void clickEmp() {
		// Go to PIM menu
		WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
		click(pimButton);

		// click Add an employee
		WebElement addEmpButton = driver.findElement(By.id("menu_pim_addEmployee"));
		click(addEmpButton);

	}

	// Verify labels: Employee Full Name*, Employee Id, Location* are displayed

	@Test(priority = 1)
	public void verify() {
		wait(15);
		// Employee full name
		String expectedEmp = "Employee Full Name*";
		String actualEmp = driver.findElement(By.xpath("//label[text()='Employee Full Name']")).getText();
		Assert.assertEquals(actualEmp, expectedEmp);

		// empLocation

		String expectedlocation = "Location*";
		String actualLocation = driver.findElement(By.xpath("//label[text()='Location']")).getText();
		Assert.assertEquals(actualLocation, expectedlocation);

		// emp ID
		String expectedID = "Employee Id";
		String actualID = driver.findElement(By.xpath("//label[text()='Employee Id']")).getText();
		Assert.assertEquals(actualLocation, expectedlocation);

	}

	// wait for modal to be visiable to add employee
	@Test(priority = 2)
	public void addEmp() {

		// Provide Employee First and Last Name, Select a Location
		Actions action = new Actions(driver);
		wait(10);
		sendText(driver.findElement(By.id("first-name-box")), "Hakan");
		sendText(driver.findElement(By.id("last-name-box")), "Yavas");
		click(driver.findElement(By.xpath("//div[@class='filter-option']")));
		click(driver.findElement(By.id("bs-select-1-24")));
		wait(2);

		// click save button
		WebElement saveBtn = driver.findElement(By.id("modal-save-button"));
		action.moveToElement(saveBtn).click().perform();

		// wait for personal detailes to be visiable

		// WebElement personalDetailes =
		// driver.findElement(By.id("personal_details_tab"));
		waitForVisibility(driver.findElement(By.id("personal_details_tab")));

		TakeFullScreenShot(driver.findElement(By.id("pimPersonalDetailsForm")));

		wait(2);

	}

}

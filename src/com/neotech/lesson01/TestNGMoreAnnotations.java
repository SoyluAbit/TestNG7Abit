package com.neotech.lesson01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGMoreAnnotations {
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test!");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test!");
	}
	
	
	@Test
	public void testOne()
	{
		System.out.println("Test case 1....");
	}
	
	
	@Test
	public void testTwo()
	{
		System.out.println("Test case 2....");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class!");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class!");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method!");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method!");
	}
	
/*

Before Test! ---> this does not mean before Test method!!! It means before TEST BATCH
	Before Class!
		BeforeMethod!
			Test Case 1....
		AfterMethod!
		BeforeMethod!
			Test Case 2....
		AfterMethod!
	After Class!
	.
	.
	.
	.
After Test! 

 
 
 */
	
	
}

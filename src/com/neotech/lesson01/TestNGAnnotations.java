package com.neotech.lesson01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@Test
	public void test1()
	{
		System.out.println("This is test 1!");
	}
	
	@Test
	public void test2()
	{
		System.out.println("This is test 2!");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This method runs before the test methods!!!");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This method runs after the test methods!!!");
	}
	
	
	@Test
	public void test3()
	{
		System.out.println("This is test 3!");
	}
	
	
/* Expectation: (WRONG)

	BeforeMethod
		Test1
		Test2
	AfterMethod


 
 	Correct Flow: 
 	BeforeMethod
 		Test1
 	AfterMethod
 	BeforeMethod
 		Test2
 	AfterMethod
 	
 
 */
	
	
	
	
	
}

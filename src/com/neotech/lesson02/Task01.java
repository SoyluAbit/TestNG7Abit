package com.neotech.lesson02;

import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;



public class Task01 extends CommonMethods {
	
	/*
	 * HW1: Executing tests using priority and enable attributes

	Create a class TaskOne that has 5 test methods named:
	
	firstMethod
	firstMethod1
	secondMethod
	thirdMethod
	fourthMethod
	
	And each of them printing the method name
	Run and observe results

	Then, add the needed attributes to print the following result:
	fourthMethod
	thirdMethod
	secondMethod
	firstMethod
	
	 */
	
	@Test (dependsOnMethods = "thirdMethod")
	public void firstMethod()
	{
		System.out.println("This is 1st method");
	}
	
	@Test(enabled = false)
	public void firstMethod1()
	{
		System.out.println("This is 1st method--1");
	}

	@Test(priority = 2)
	public void secondMethod()
	{
		System.out.println("This is 2nd Method");
	}
	
	@Test (priority = 1)
	public void thirdMethod()
	{
		System.out.println("This is 3rd Method");
	}
	
	@Test (priority = 0)
	public void fourthMethod()
	{
		System.out.println("This is 4th Method");
	}
	
	
	
	
	
}

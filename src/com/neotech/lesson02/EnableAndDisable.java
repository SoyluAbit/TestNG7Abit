package com.neotech.lesson02;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class EnableAndDisable {
	
	@Test(priority=1)
	public void firstTest() {
		System.out.println("firstTest");
	}
	
	@Test(priority=2, enabled = false)
	public void secondTest()
	{
		System.out.println("secondTest");
	}

	@Test(priority=3)
	public void thirdTest()
	{
		System.out.println("thirdTest");
	}
	
	@Test(priority=4)
	public void forthTest()
	{
		System.out.println("forthTest");
	}

}

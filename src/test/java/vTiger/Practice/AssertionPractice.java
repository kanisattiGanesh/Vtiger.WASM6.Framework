package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void demo() 
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-");
		sa.assertTrue(false);
		System.out.println("step-4");
		sa.assertAll();
	}
	@Test
	public void demoTest() 
	{
		
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals(true, false);
		System.out.println("step-3");
		Assert.assertTrue(true);
		System.out.println("step-4");
	}
}

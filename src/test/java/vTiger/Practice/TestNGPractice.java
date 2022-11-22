package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGPractice {

	@Test(groups = "smokeSuite")
	public void createCustomer()
	{
	
		System.out.println("customer created");
	}
	
	@Test(enabled = false)
	public void modifyCustomer()
	{
		
		System.out.println("customer modified");
		//Assert.fail();//will purposefully fail the test script
	}
	
	@Test(groups = "regressionSuite")
	public void deleteCustomer()
	{
	System.out.println("customer deleted");	
	}
}

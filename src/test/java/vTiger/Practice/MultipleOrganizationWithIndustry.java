package vTiger.Practice;

	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class MultipleOrganizationWithIndustry {

	@Test(dataProvider = "Org",priority = 2)//method name or names 
	public void addProductToCartTest(String orgname,String type)//parameterize the columns 
	{
		System.out.println("org name " + orgname + " type" + type);
	}

	@DataProvider(name="Org")
	public Object[][] getData()
	{
		Object[][] data = new Object[4][2];
		data[0][0] = "Qspiders"; //first[0]-Row, Second[0]-column
		data[0][1] = "Healthcare";
		
		data[1][0] = "allstates";
		data[1][1] = "eductaion";
		
		data[2][0] = "wipro";
		data[2][1] = "Education";
		
		data[3][0] = "infosys";
		data[3][1] = "Education";
		
		return data;
	}
		@Test(dataProvider = "or",priority = 2)//method name or names 
		public void addProductToCartTests(String orgname,String type)//parameterize the columns 
		{
			System.out.println("org name " + orgname + " type" + type);
		}
		
		@DataProvider(name="or")
		public Object[][] getDatas()
		{
			Object[][] data = new Object[4][2];
			data[0][0] = "Qspiders"; //first[0]-Row, Second[0]-column
			data[0][1] = "Healthcare";
			
			data[1][0] = "allstates";
			data[1][1] = "eductaion";
			
			data[2][0] = "wipro";
			data[2][1] = "Education";
			
			data[3][0] = "infosys";
			data[3][1] = "Education";
			
			return data;
	}

}

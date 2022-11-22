package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class CreateOrganizationWithHealthCare {

	@Test(dataProvider = "HealthCare")
	public void OrganizationWithType(String orgname)
	{
		String type = "Healthcare";
		System.out.println("organization name " + orgname + "Industry type " + type);
	}
	@DataProvider(name = "HealthCare")
	public String[] getData()
	{
		String[] data = new String[4];
		
		data[0] = "Qspiders"; //first[0]-Row, Second[0]-column
		
		
		data[1]= "all states"; 

		
		data[2]= "wipro"; 
		
		
		data[3] = "infosys"; 
		
		
		return data;
	}
}

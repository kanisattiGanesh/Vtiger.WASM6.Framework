package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

@Test(dataProvider = "Mobiles")//method name or names 
public void addProductToCartTest(String Name,String model , int price , int qty)//parameterize the columns 
{
	System.out.println("phone name:" + Name + " Model:" + model + " price:" + price + " qty" + qty);
}

@DataProvider(name="Phones")
public Object[][] getData()
{
	Object[][] data = new Object[3][4];
	data[0][0] = "samsung"; //first[0]-Row, Second[0]-column
	data[0][1] = "A80";
	data [0][2] = 25000;
	data [0][3] = 10;
	
	data[1][0] = "Iphone";
	data[1][1]= "11Pro";
	data[1][2] = 5000;
	data[1][3] = 5;
	
	data[2][0] = "Vivo";
	data[2][1]= "Y21";
	data[2][2] = 10000;
	data[2][3] = 15;
	
	return data;
	
}
@DataProvider(name="Mobiles")
public Object[][] getData1()
{
	Object[][] data = new Object[3][4];
	data[0][0] = "samsungs"; //first[0]-Row, Second[0]-column
	data[0][1] = "A80";
	data [0][2] = 25000;
	data [0][3] = 10;
	
	data[1][0] = "Iphone";
	data[1][1]= "11Pro";
	data[1][2] = 5000;
	data[1][3] = 5;
	
	data[2][0] = "Vivo";
	data[2][1]= "Y21";
	data[2][2] = 10000;
	data[2][3] = 15;
	
	return data;
	
}
}

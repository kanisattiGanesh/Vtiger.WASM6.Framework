package vTiger.Practice;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;

public class Geneicutilitypractise {
 
	public static int add(int a,int b)//called
	{
	int c = a+b;
	return c;
	
}
	public static void main(String[] args) throws Exception//calling or caller
	{
		//for random number
		JavaLibrary jlib = new JavaLibrary();
		int value = jlib.getRandomNumber();
		System.out.println(value);
		
		//for date and time
		String date = jlib.getSystemDate();
		System.out.println(date);
		
		//for data & time in particular format
		String d= jlib.getSystemDateInFormat();
		System.out.println(d);
		
		//for retrieve data from properties file
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		String value1 = pLib.readDataFromPropertyFile("browser");
		System.out.println(value1);
		String value2= pLib.readDataFromPropertyFile("username");
		System.out.println(value2);
		
		//to read data from excel and write data into excel
		ExcelFileLibrary elib = new ExcelFileLibrary();
		String val = elib.readDataFromExcel("Organization",1,2);
		System.out.println(val);
		int row = elib.getRowCount("Contacts");
		System.out.println(row);
		elib.writeDataIntoExcel("Organization",7,8,"Ganesh");
		
	}
}
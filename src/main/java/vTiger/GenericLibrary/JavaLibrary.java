package vTiger.GenericLibrary;

import java.util.Date;
import java.util.Random;

//single line comment
/* multi-line comments */
/**
 * This class will contain the generic methods of java
 * @author GANESH
 *
 */
public class JavaLibrary {
	/**
	 * This method will generate random number for execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;
	}
	/**
	 * This method will generate system date
	 * @return 
	 * 
	 */
public String getSystemDate() 
{
	Date d = new Date();
	String date = d.toString();
	return date;
}
/**
 * This method will return current system date in specific format
 * @return
 */
public String getSystemDateInFormat()
{
	Date d = new Date();
	String[] dArr = d.toString().split(" ");
	String month  = dArr[1];
	String date = dArr[2];
	String year = dArr[5];
	String time = dArr[3].replace(":","-");
	String dateInFormat = date + "-" + month + "-" + year + " " + time ;
	return dateInFormat;
	
}

}

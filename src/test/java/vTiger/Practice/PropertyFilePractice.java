package vTiger.Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFilePractice {

	public String getData(String data) throws Exception {
		
		// Load the file into java
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//create object of properties
		Properties pobj = new Properties();
		
		//Load the file input stream to properties
		pobj.load(fis);
		
		//use the keys to read the value
		
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		return pobj.getProperty(data);
		
	}
	}

package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains generic methods related to property file
 * @author GANESH
 *
 */
public class PropertyFileLibrary {
	/**
	 * This method will read the value from property file for the key given by user
	 * @param key
	 * @return
	 */
	public String readDataFromPropertyFile(String key) throws Exception
	{
	FileInputStream fis = new FileInputStream(IConstantsLibrary.propertyFilePath);
		Properties pobj =new Properties();	
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}

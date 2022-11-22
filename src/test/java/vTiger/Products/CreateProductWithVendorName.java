package vTiger.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateProductWithVendorName 
{
	public static void main(String[] args) throws Exception 
	{
		// Step 1: Create Object of all the libraries
				JavaLibrary jLib = new JavaLibrary();
				PropertyFileLibrary pLib = new PropertyFileLibrary();
				ExcelFileLibrary eLib = new ExcelFileLibrary();
				WebDriverLibrary wLib = new WebDriverLibrary();
				
				
				// Step 2: read all the required data
				String BROWSER = pLib.readDataFromPropertyFile("browser");
				String URL = pLib.readDataFromPropertyFile("url");
				String USERNAME = pLib.readDataFromPropertyFile("username");
				String PASSWORD = pLib.readDataFromPropertyFile("password");
				String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
				String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jLib.getRandomNumber();
				WebDriver driver = null;
				
				// Step 3: launch the browser
				if (BROWSER.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) 
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} 
				else 
				{
					System.out.println("invalid browser name");
				}

				wLib.maximizeWindow(driver);
				wLib.waitForPageLoad(driver);
				driver.get(URL);
				wLib.waitForPageLoad(driver);
				// Step 4: Login to Application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				//Navigate to more and click on vendor and create vendor name
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
				wLib.mouseHoverOn(driver ,element);
				driver.findElement(By.name("Vendors")).click();
				driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
				driver.findElement(By.name("vendorname")).sendKeys(ORGNAME);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				//click on products and create product with vendor name
				driver.findElement(By.linkText("Products")).click();
				driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
				driver.findElement(By.name("productname")).sendKeys(ORGNAME);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	}
		
	}

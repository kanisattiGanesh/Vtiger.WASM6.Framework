package vTiger.Practice;

import java.io.FileInputStream;
//import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDDT {

	public static void main(String[] args) throws Exception {
	//STEP1:Read the required data
		
FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Contacts");
		
		Row r = sh.getRow(1);
		
		Cell ce = r.getCell(2);
		
		String Lastname = ce.getStringCellValue();
		
		
	WebDriver driver = null;
	// Step-2:Launch The Browser- Run time polymorphism
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(browser + "is launched");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			 WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(browser + "is launched");
		}
		else
		{
			System.out.println("invalid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys((password));
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lastname);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			Thread.sleep(3000);
		WebElement element =driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
				Actions act = new Actions(driver);
				act.moveToElement(element);
				act.perform();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
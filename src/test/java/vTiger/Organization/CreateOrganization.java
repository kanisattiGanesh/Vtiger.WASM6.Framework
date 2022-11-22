package vTiger.Organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

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
				Sheet sh = wb.getSheet("Organization");
				
				Row r = sh.getRow(1);
				
				Cell ce = r.getCell(2);
				
				String orgname = ce.getStringCellValue();
				Random ran = new Random();
				int value = ran.nextInt(500);
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
					driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
					driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
					driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname + value);
					driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();

	}

}

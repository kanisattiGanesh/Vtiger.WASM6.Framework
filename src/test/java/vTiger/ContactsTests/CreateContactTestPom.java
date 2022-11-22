package vTiger.ContactsTests;
	//import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
//	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

	public class CreateContactTestPom {

		public static void main(String[] args) throws Exception {
			
					//Step 1: Create Object of all the libraries
					JavaLibrary jLib = new JavaLibrary();
					PropertyFileLibrary pLib = new PropertyFileLibrary();
					ExcelFileLibrary eLib = new ExcelFileLibrary();
					WebDriverLibrary wLib = new WebDriverLibrary();

					//Step 2: read all the required data
					String BROWSER = pLib.readDataFromPropertyFile("browser");
					String URL = pLib.readDataFromPropertyFile("url");
					String USERNAME = pLib.readDataFromPropertyFile("username");
					String PASSWORD = pLib.readDataFromPropertyFile("password");
					
					String LASTNAME = eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
					
					WebDriver driver = null;
					
					//Step 3: launch the browser
					if(BROWSER.equalsIgnoreCase("Chrome"))
					{
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
					}
					else if(BROWSER.equalsIgnoreCase("firefox"))
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
					
					//Step 4: Login to Application
					LoginPage lp = new LoginPage(driver);
					lp.LoginToApp(USERNAME, PASSWORD);
					
					//Step 5: Navigate to Contacts Link
					HomePage hp = new HomePage(driver);
					hp.clickContactsLnk();
					
					//Step 6: Navigate to create Contact Look up image
					ContactsPage cp = new ContactsPage(driver);
					cp.clickOnCreateContactImg();
					
					//Step 7: create contact with mandatory details and save
					CreateNewContactPage   ccp = new CreateNewContactPage(driver);
					ccp.CreateNewContact(LASTNAME);
					
					//Step 8: Validate
					
					ContactsInfoPage cip = new ContactsInfoPage(driver);
					String contactHeader = cip.getContactHeader();

					System.out.println(contactHeader);
					
					if(contactHeader.contains(LASTNAME))
					{
						System.out.println("PASS");
					}
					else
					{
						System.out.println("FAIL");
					}
					
					//Step 9: Logout of Application
					hp.signOutOfApp(driver);
		}

	}
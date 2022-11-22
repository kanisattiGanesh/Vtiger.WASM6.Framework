package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizations {

	public static void main(String[] args) throws Exception {

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
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser name");
		}

		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);

		// Step 4: Login to Application
				LoginPage lp = new LoginPage(driver);
				lp.LoginToApp(USERNAME, PASSWORD);
				
				//Step 5: Navigate to Organizations link
				HomePage hp = new HomePage(driver);
				hp.clickOrganizatonsLnk();
				
				//Step 6: Navigate to create Organizations look up image
				OrganizationsPage op = new OrganizationsPage(driver);
				op.ClickOnCreateOrgImg();
				
				//Step 7: Create new organization and save
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.CreateNewOrg(ORGNAME);
				
				//Step 8: Validate for Organization
				OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
				String orgHeader = oip.getOrgHeader();
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println(orgHeader);
					System.out.println("Organization created successfully");
				}
				else
				{
					System.out.println("Organization not created");
				}
				
				//Step 9: Navigate to contacts link
				hp.clickContactsLnk();

				// Step 10: Navigate to create Contact Look up image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactImg();

				// Step 11: create contact with mandatory details
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.CreateNewContact(LASTNAME, ORGNAME, driver);
				
		        //Step 12: Validate for Contact
				ContactsInfoPage cip = new ContactsInfoPage(driver);
				String contactHeader = cip.getContactHeader();
				if(contactHeader.contains(LASTNAME))
				{
					System.out.println(contactHeader);
					System.out.println("Pass");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 14: logout of Application
				hp.signOutOfApp(driver);
				
				
			}
}

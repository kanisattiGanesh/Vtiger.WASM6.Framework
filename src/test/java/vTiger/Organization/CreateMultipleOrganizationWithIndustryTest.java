package vTiger.Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

/**
 * @author GANESH
 *
 */

public class CreateMultipleOrganizationWithIndustryTest {
	
	
	// Step 1: Create Object of all the libraries and make it global
				JavaLibrary jLib = new JavaLibrary();
				PropertyFileLibrary pLib = new PropertyFileLibrary();
				ExcelFileLibrary eLib = new ExcelFileLibrary();
				WebDriverLibrary wLib = new WebDriverLibrary();
				
@Test(dataProvider = "MultipleOrganizations")				
public void MultipleOrganizationWithIndustryTest(String orgname,String indType) throws Exception {
				
	String org = orgname+jLib.getRandomNumber();
				// Step 2: read all the required data
				String BROWSER = pLib.readDataFromPropertyFile("browser");
				String URL = pLib.readDataFromPropertyFile("url");
				String USERNAME = pLib.readDataFromPropertyFile("username");
				String PASSWORD = pLib.readDataFromPropertyFile("password");

			//	String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
			//	String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();

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
						cnop.CreateNewOrg(org,indType);
						
						//step 8 :validate
						OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
						String orgHeader =oip.getOrgHeader();
						if(orgHeader.contains(org))
						{
							System.out.println(orgHeader);
							System.out.println("pass");
						}
						else
						{
							System.out.println("Fail");
						}
						//Step 9: Logout
						hp.signOutOfApp(driver);
}

@DataProvider(name="MultipleOrganizations")
public Object[][] getData() throws EncryptedDocumentException, IOException
{
	Object[][] data = eLib.readMultipleData("MultipleOrganization");
	return data;
}
}
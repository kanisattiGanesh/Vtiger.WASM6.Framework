package vTiger.ContactsTests;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactWithOrganizationsTest extends BaseClass {
	
			@Test(groups = "regressionSuite")
			public void createOrgnizationTest() throws Exception {


			// Step 2: read all the required data
	
			String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
			String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jLib.getRandomNumber();
					
					//Step 5: Navigate to Organizations link
					HomePage hp = new HomePage(driver);
					hp.clickOrganizatonsLnk();
					Reporter.log("orgnization link clicked", true);
					
					//Step 6: Navigate to create Organizations look up image
					OrganizationsPage op = new OrganizationsPage(driver);
					op.ClickOnCreateOrgImg();
					Reporter.log("create organization lookup clicked", true);
			
					
					//Step 7: Create new organization and save
					CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
					cnop.CreateNewOrg(ORGNAME);
					Reporter.log("Organization saved", true);
					
					//Step 8: Validate for Organization
					OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
					String orgHeader = oip.getOrgHeader();
					Assert.assertTrue(orgHeader.contains(ORGNAME), "Organization created");
					Reporter.log("organization created", true);
					
					//Step 9: Navigate to contacts link
					hp.clickContactsLnk();
					Reporter.log("contact link clicked", true);

					// Step 10: Navigate to create Contact Look up image
					ContactsPage cp = new ContactsPage(driver);
					cp.clickOnCreateContactImg();
					Reporter.log("create contact lookup clicked", true);

					// Step 11: create contact with mandatory details
					CreateNewContactPage cncp = new CreateNewContactPage(driver);
					cncp.CreateNewContact(LASTNAME, ORGNAME, driver);
					
			        //Step 12: Validate for Contact
					ContactsInfoPage cip = new ContactsInfoPage(driver);
					String contactHeader = cip.getContactHeader();
					Assert.assertTrue(contactHeader.contains(LASTNAME), "contact created");
						Reporter.log("contact created with org", true);
				}
		/*	@Test
			public void createwithLead1()
			{
				System.out.println("ganesh");
				Assert.fail();
		
			}
			@Test
			public void createwithLead52()
			{
				System.out.println("ramesh");
				Assert.fail();
			
			}*/
	}


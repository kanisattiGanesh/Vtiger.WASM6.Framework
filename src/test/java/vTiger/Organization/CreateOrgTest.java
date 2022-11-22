package vTiger.Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateOrgTest extends BaseClass
{
	@Test(groups = "regressionSuite")
	public void createOrg() throws EncryptedDocumentException, IOException 
	{
		//read data from excel
	String ORGNAME = 	eLib.readDataFromExcel("Organization", 1, 2) + jLib.getRandomNumber();
		
		//step 4:navigate organization link
		HomePage hp =new HomePage(driver);
		hp.clickOrganizatonsLnk();

		
		//enter mandatory fields and save
		OrganizationsPage op = new OrganizationsPage(driver);
		op.ClickOnCreateOrgImg();
		
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.CreateNewOrg(ORGNAME);
	
	}
	
	/*	@Test
		public void createwithLead1()
		{
			System.out.println("ganesh");
		}
		@Test
		public void createwithLead52()
		{
			System.out.println("ramesh");
		} */
	}


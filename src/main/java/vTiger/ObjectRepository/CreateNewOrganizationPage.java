package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganizationPage extends WebDriverLibrary {

	//Declaration
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy (name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Library
	/**
	 * This method will create new organization
	 * @param OrgName
	 */
	public void CreateNewOrg(String OrgName)
	{
		orgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with industry type
	 * @param OrgName
	 * @param indType
	 */
	public void CreateNewOrg(String OrgName,String indType)
	{
		orgNameEdt.sendKeys(OrgName);
		handleDropDown(indType, industryDropDown);
		saveBtn.click();
	}
	/**
	 * This method will create organization with industry and type
	 * @param OrgName
	 * @param indType
	 * @param type
	 */
	public void CreateNewOrg(String OrgName,String indType,String type)
	{
		orgNameEdt.sendKeys(OrgName);
		handleDropDown(indType, industryDropDown);
		handleDropDown(type, typeDropDown);
		saveBtn.click();
	}
}

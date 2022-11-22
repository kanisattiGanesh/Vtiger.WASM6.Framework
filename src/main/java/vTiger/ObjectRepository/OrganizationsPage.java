package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class OrganizationsPage extends WebDriverLibrary{

	//Declaration
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	//initialization
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	//Business Library
	/**
	 * This metjod will click on Create organization
	 */
	public void ClickOnCreateOrgImg()
	{
		createOrgImg.click();
	}
	
}

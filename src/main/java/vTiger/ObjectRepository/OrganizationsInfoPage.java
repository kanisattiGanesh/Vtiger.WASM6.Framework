package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class OrganizationsInfoPage extends WebDriverLibrary {

	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement Orgheader;
	
	//Initialization
	
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//	Utilization
	public WebElement getOrgheader() {
		return Orgheader;
	}
	
	
	//Business Library
	/**
	 * This method will get header text
	 * @return
	 */
	public String getOrgHeader()
	{
		return Orgheader.getText();
	}
	
}

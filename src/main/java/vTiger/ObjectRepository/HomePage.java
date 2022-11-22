package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary {
		
	//Declaration
	@FindBy(linkText = "Organizations")
	private  WebElement organizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private  WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private  WebElement productsLnk;
	
	@FindBy(linkText = "Opportunities")
	private  WebElement opportunitiesLnk;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private  WebElement signoutLnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//utilization
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	//Business Library
	/**
	 * This method click on organization link
	 */
	public void clickOrganizatonsLnk()
	{
		organizationsLnk.click();
	}
	/**
	 * This will click on contacts link
	 */
	public void clickContactsLnk()
	{
		contactsLnk.click();
	}
	/**
	 * This method will click on products link
	 */
	public void clickProductsLnk()
	{
		productsLnk.click();
	}
	/**
	 * This method will click on opportunities link
	 */
	public void OpportuniesLnk()
	{
		opportunitiesLnk.click();
	}
	/**
	 * This method will perform sign out of application
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver)
	{
	mouseHoverOn(driver,administratorImg);
	signoutLnk.click();
	}
	}
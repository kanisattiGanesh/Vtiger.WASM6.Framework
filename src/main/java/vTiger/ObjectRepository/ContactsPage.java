package vTiger.ObjectRepository;

//import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	//Initialization
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	//BusinessLibrary
/**
 * This method is used to click on create lookup image
 */
	public void clickOnCreateContactImg()
	{
		createContactLookUpImg.click();
	}
	
	
}

package vTiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1:create separate java class for every web page 

	//rule 2 : Identify the elements using @FindBy, @FindBys and @FindByAll
	@FindBy(name = "user_name")
	private WebElement usernameEdt;
	
	@FindAll({@FindBy(name = "user_password"),@FindBy (xpath= "//input[@type='password']")})
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//Rule 3: create a constructor to initialize these variables 
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	//Rule 4 : provide getter methods to access these variables

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Business Library
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void LoginToApp(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}

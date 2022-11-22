package vTiger.Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationwithIndustry {
	public static void main(String[] args) throws Exception {
		//launch the browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				PropertyFilePractice p = new PropertyFilePractice();
				driver.get(p.getData("url"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys(p.getData("username"));
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys(p.getData("password"));
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("ganeshh131212");
				driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ganeshhhhhhhh");
				driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
				String parentID = driver.getWindowHandle();
				Set<String> childId = driver.getWindowHandles();
				for(String allid : childId)
				{
					if(!parentID.equals(childId))
					{
						driver.switchTo().window(allid);
					}
				}
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("ganeshh131212");
				driver.findElement(By.xpath("//input[@value='  Search Now  ']")).click();
				driver.findElement(By.xpath("//a[text()='ganeshh131212']")).click();
				Thread.sleep(4000);
				driver.switchTo().window(parentID);
				driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
				WebElement element =driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
				Actions act = new Actions(driver);
				act.moveToElement(element);
				act.perform();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
package vTiger.Practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrganization {
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
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("ganeshhhhaaaa");
				
				driver.findElement(By.xpath("//select[@name='industry']")).click();
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
				WebElement element =driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
				Actions act = new Actions(driver);
				act.moveToElement(element);
				act.perform();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
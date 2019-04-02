package PraticePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shikha.f.gupta\\Documents\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		//by.name
		driver.findElement(By.name("firstname")).sendKeys("Shikha");
		System.out.println("entered name successfully");
		Thread.sleep(5000);
		//by.partiallinktext
		driver.findElement(By.partialLinkText("Partial")).click();
		System.out.println("partial link text");
		//by.linktext
		driver.findElement(By.linkText("Link Test")).click();
		System.out.println(" link text");
		
		driver.findElement(By.id(id))
		driver.findElement(By.id(id))
		driver.findElement(By.id(id))
		

	}

}

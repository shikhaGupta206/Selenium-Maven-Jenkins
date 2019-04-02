package PraticePackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenshotConcept {

	static WebDriver driver;
	
	public static void main(String args[]) throws IOException
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shikha.f.gupta\\Documents\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://www.google.com");
	
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src,new File("C:\\Users\\shikha.f.gupta\\Downloads\\drivers\\google.png"));
	

	}
	
	public static void ClickOn(WebDriver driver,WebElement locator, int timeout)
	{
		
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		
	}
}

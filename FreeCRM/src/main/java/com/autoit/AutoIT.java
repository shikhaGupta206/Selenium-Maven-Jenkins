package com.autoit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIT {
	
		static WebDriver driver;
		
	public static void main(String[] args) throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream ip1 = new FileInputStream("C:\\Users\\shikha gupta\\eclipse-workspace\\FreeCRM\\src\\main\\java\\com\\autoit\\objects.properties");
		prop.load(ip1);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shikha gupta\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		String parent = driver.getWindowHandle();
		Set<String> popups = driver.getWindowHandles();
		{
		Iterator<String> it = popups.iterator();
		while(it.hasNext())
		  {
			String popuphandle = it.next().toString();
			if(!popuphandle.contains(parent))
			{
				driver.switchTo().window(popuphandle);
				driver.close();	
			}
		 }
	   }
		driver.switchTo().window(parent);
		//Thread.sleep(5000);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"block\"]")).click();
		driver.findElement(By.xpath(prop.getProperty("Loginbutton"))).click();
		driver.findElement(By.xpath(prop.getProperty("UserName"))).sendKeys(prop.getProperty("User"));
		driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("Pass"));
		driver.findElement(By.xpath(prop.getProperty("Submitbtn"))).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("updateprofile"))).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2200)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"attachCV\"]")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\shikha gupta\\Documents\\AutoIT\\FileUpload.exe");
		System.out.println("Resume uploaded successfully");
		//driver.quit();
}}

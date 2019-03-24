package com.pratice.task;

//import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Action;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shikha gupta\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver(); //launch chrome
		
//		driver.manage().window().maximize(); //maximize window
//		driver.manage().deleteAllCookies(); //delete all the cookies
//		
//		//dynamic wait
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/"); //enter URL
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"highlight-addons\"]"))).build().perform();
	
		driver.findElement(By.xpath("//*[@id=\"header-addons\"]/ul/li[2]/a")).click();

	}

}

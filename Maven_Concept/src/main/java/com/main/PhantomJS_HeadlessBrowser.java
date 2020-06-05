package com.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJS_HeadlessBrowser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("phantomjs.binary.path",
				"C:\\Users\\Shubhada\\Documents\\Selenium jars\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

		WebDriver driver = new PhantomJSDriver();

		driver.get("https://ui.freecrm.com/");

		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Enter username and password");

		driver.findElement(By.name("email")).sendKeys("otari.shubhada@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.name("password")).sendKeys("Test@123");
		Thread.sleep(2000);

		WebElement loginbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[3]"));
		loginbtn.click();

		System.out.println("Login successfully");
	}

}

/*
 * also called as ghost driver it is very fast directly interact with HTML DOM
 */
